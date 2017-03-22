package css.demo.espressodaggertesting;

import css.demo.espressodaggertesting.data.User;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Retrofit interface to get repos for octokit from Github
 */

public interface GithubService {

    @GET("users/square")
    Observable<User> getRepos();

}
