package css.demo.espressodaggertesting;

import javax.inject.Inject;

import css.demo.espressodaggertesting.data.User;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Presenter for {@link MainActivity}. Contains View logic and network calls.
 */

public class MainActivityPresenter implements MainMVP.Presenter {

    private MainMVP.View view;
    private GithubService githubService;
//    private final RxSchedulers rxSchedulers;

    @Inject
    MainActivityPresenter(MainMVP.View view, GithubService githubService) {
        this.view = view;
        this.githubService = githubService;
    }

    @Override
    public void loadData() {
        githubService.getRepos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(User user) {
                        view.showData(user);
                    }
                });
    }

}
