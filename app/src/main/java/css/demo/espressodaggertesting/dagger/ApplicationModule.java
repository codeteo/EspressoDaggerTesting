package css.demo.espressodaggertesting.dagger;

import android.app.Application;
import android.support.test.espresso.idling.CountingIdlingResource;

import javax.inject.Singleton;

import css.demo.espressodaggertesting.Constants;
import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;

/**
 * Dagger Module provides Application context.
 */

@Module
public class ApplicationModule {

    private static final HttpUrl PRODUCTION_API_BASE_URL = HttpUrl.parse(Constants.BASE_URL);

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }

    @Provides
    @Singleton
    public static CountingIdlingResource providesCountingIdlingResource() {
        return new CountingIdlingResource("CountingIdlingResource");
    }

    @Provides
    @Singleton
    protected HttpUrl providesBaseUrl() {
        return PRODUCTION_API_BASE_URL;
    }

}
