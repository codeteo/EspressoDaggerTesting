package css.demo.espressodaggertesting.dagger;

import android.support.test.espresso.idling.CountingIdlingResource;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.HttpUrl;
import retrofit2.Retrofit;

/**
 * Dagger Component. This is the main Component of the app, build in
 * {@link css.demo.espressodaggertesting.MyApplication} class.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    Retrofit retrofit();

    CountingIdlingResource countingIdlingResource();

    HttpUrl baseHttpUrl();

}
