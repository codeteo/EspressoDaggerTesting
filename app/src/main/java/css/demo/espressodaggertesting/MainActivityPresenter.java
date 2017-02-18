package css.demo.espressodaggertesting;

import javax.inject.Inject;

import css.demo.espressodaggertesting.data.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Presenter for {@link MainActivity}. Contains View logic and network calls.
 */

public class MainActivityPresenter implements MainMVP.Presenter {

    private MainMVP.View view;
    private GithubService githubService;

    @Inject
    MainActivityPresenter(MainMVP.View view, GithubService githubService) {
        this.view = view;
        this.githubService = githubService;
    }

    @Override
    public void getData() {
        githubService.getRepos().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    if (view != null) {
                        view.showData(response.body());
                    }
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
