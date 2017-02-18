package css.demo.espressodaggertesting.dagger;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by css on 2/18/17.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface MainComponent {

    OkHttpClient getOkHttpClient();

    Retrofit getRetrofit();

}
