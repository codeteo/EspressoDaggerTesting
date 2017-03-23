package css.demo.espressodaggertesting;

import android.util.Log;

import java.net.UnknownHostException;

import javax.inject.Inject;

import css.demo.espressodaggertesting.data.User;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static css.demo.espressodaggertesting.network.ErrorCode.CODE_401_UNAUTHORIZED;
import static css.demo.espressodaggertesting.network.ErrorCode.CODE_404_PAGE_NOT_FOUND;
import static css.demo.espressodaggertesting.network.ErrorCode.CODE_UNKNOWNHOST_EXCEPTION;

/**
 * Presenter for {@link MainActivity}. Contains View logic and network calls.
 */

public class MainActivityPresenter implements MainMVP.Presenter {

    private static final String TAG = "MAiN-PRESENTER";

    private MainMVP.View view;
    private GithubService githubService;
    private Subscription subscription;

    @Inject
    MainActivityPresenter(MainMVP.View view, GithubService githubService) {
        this.view = view;
        this.githubService = githubService;
    }

    @Override
    public void loadData() {
        subscription = githubService.getRepos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof HttpException) {
                            int code = ((HttpException) e).code();

                            Log.i(TAG, "onError : " + code);

                            switch (code) {
                                case 404 :
                                    handleError(CODE_404_PAGE_NOT_FOUND);
                                    break;
                                case 401 :
                                    handleError(CODE_401_UNAUTHORIZED);
                                    break;
                            }

                        }

                        if (e instanceof UnknownHostException) {
                            handleError(CODE_UNKNOWNHOST_EXCEPTION);
                        }

                    }

                    @Override
                    public void onNext(User user) {
                        view.showData(user);
                    }
                });

    }

    private void handleError(String errorCode) {
        switch (errorCode) {
            case CODE_404_PAGE_NOT_FOUND:
                view.showError("Page Not Found error");
                break;
            case CODE_401_UNAUTHORIZED:
                view.showError("UnAuthorized Request. Login and try again.");
                break;
            case CODE_UNKNOWNHOST_EXCEPTION:
                view.showError("Network error. Maybe your internet connection is off?");
                break;
            default:
                view.showError("Generic error");
                break;
        }
    }

    void unSubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}
