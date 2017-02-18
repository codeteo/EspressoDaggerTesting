package css.demo.espressodaggertesting;

import css.demo.espressodaggertesting.data.User;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Retrofit interface to get repos for octokit from Github
 */

public interface GithubService {

    @GET("users/square")
    Call<User> getRepos();

}
