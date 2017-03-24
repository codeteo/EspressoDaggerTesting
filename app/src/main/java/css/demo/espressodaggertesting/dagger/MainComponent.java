package css.demo.espressodaggertesting.dagger;

import android.support.test.espresso.idling.CountingIdlingResource;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Dagger Component. This is the main Component of the app, build in
 * {@link css.demo.espressodaggertesting.MyApplication} class.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface MainComponent {

    Retrofit retrofit();

    CountingIdlingResource countingIdlingResource();

}
