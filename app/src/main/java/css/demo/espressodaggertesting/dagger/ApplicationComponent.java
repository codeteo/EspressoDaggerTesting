package css.demo.espressodaggertesting.dagger;

import javax.inject.Singleton;

import css.demo.espressodaggertesting.utils.BaseUrlInterceptor;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * Dagger Component. This is the main Component of the app, build in
 * {@link css.demo.espressodaggertesting.MyApplication} class.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    Retrofit retrofit();

    BaseUrlInterceptor baseUrlInterceptor();

}
