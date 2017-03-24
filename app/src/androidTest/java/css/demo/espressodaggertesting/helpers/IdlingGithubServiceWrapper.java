package css.demo.espressodaggertesting.helpers;

import android.os.Handler;
import android.os.Looper;
import android.support.test.espresso.IdlingResource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import css.demo.espressodaggertesting.GithubService;
import css.demo.espressodaggertesting.data.User;
import rx.Observable;
import rx.functions.Action0;

public class IdlingGithubServiceWrapper implements GithubService, IdlingResource {

    private final GithubService api;
    private final AtomicInteger counter;
    private final List<ResourceCallback> callbacks;

    public IdlingGithubServiceWrapper(GithubService api) {
        this.api = api;
        this.callbacks = new ArrayList<>();
        this.counter = new AtomicInteger(0);
    }

    public Observable<User> getRepos(){
        counter.incrementAndGet();
        return api.getRepos().finallyDo(new Action0() {
            @Override
            public void call() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        counter.decrementAndGet();
                        notifyIdle();
                    }
                });
            }
        });
    }

    @Override public String getName() {
        return this.getClass().getName();
    }

    @Override public boolean isIdleNow() {
        return counter.get() == 0;
    }

    @Override public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        callbacks.add(resourceCallback);
    }

    private void notifyIdle() {
        if (counter.get() == 0) {
            for (ResourceCallback cb : callbacks) {
                cb.onTransitionToIdle();
            }
        }
    }
}
