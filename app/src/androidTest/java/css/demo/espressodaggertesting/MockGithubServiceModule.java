package css.demo.espressodaggertesting;

import css.demo.espressodaggertesting.dagger.ActivityScope;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import static org.mockito.Mockito.mock;

/**
 * Created by css on 2/18/17.
 */

@Module
public class MockGithubServiceModule {

    @Provides
    @ActivityScope
    GithubService providesMockGithubService(Retrofit retrofit) {
        return mock(GithubService.class);
    }

}

