package css.demo.espressodaggertesting;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Retrofit interface to get repos for octokit from Github
 */

public interface GithubService {

    @GET("/orgs/octokit/repos")
    Call<Void> getRepos();

}
