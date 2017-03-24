package css.demo.espressodaggertesting.dagger;

import android.app.Application;
import android.support.test.espresso.idling.CountingIdlingResource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by css on 2/18/17.
 */

@Module
public class ApplicationModule {

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

}
