package css.demo.espressodaggertesting.dagger;

import css.demo.espressodaggertesting.GithubService;
import css.demo.espressodaggertesting.MainActivityPresenter;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Dagger module to provide {@link GithubService} to {@link MainActivityPresenter}
 */

@Module
public class GithubServiceModule {

    @Provides
    @ActivityScope
    GithubService providesGithubService(Retrofit retrofit) {
        return retrofit.create(GithubService.class);
    }

}
