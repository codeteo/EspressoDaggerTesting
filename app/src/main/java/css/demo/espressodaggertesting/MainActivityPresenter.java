package css.demo.espressodaggertesting;

import android.util.Log;

import javax.inject.Inject;

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
        githubService.getRepos().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.i("PRESENTER", "onResponse SUCCESS");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
