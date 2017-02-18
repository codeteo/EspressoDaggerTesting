package css.demo.espressodaggertesting;

import javax.inject.Inject;

/**
 * Presenter for {@link MainActivity}. Contains View logic and network calls.
 */

public class MainActivityPresenter implements MainMVP.Presenter {

    private MainMVP.View view;
    private GithubService githubService;

    @Inject
    public MainActivityPresenter(MainMVP.View view, GithubService githubService) {
        this.view = view;
        this.githubService = githubService;
    }

    @Override
    public void getData() {

    }
}
