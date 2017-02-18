package css.demo.espressodaggertesting;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import static org.mockito.Mockito.mock;

/**
 * Created by css on 2/18/17.
 */

@Module
public class MockNetworkModule {

    private static final HttpUrl MOCK_API_BASE_URL = HttpUrl.parse("mockito");

    @Provides
    @Singleton
    protected Gson providesGson() {
        return mock(Gson.class);
    }

    @Provides
    @Singleton
    protected OkHttpClient providesOkHttpClient(){
        return mock(OkHttpClient.class);
    }


    @Provides
    @Singleton
    protected HttpUrl providesBaseUrl() {
        return MOCK_API_BASE_URL;
    }

    @Provides
    @Singleton
    protected Retrofit providesRetrofit(HttpUrl baseUrl, OkHttpClient client) {
        return mock(Retrofit.class);
    }

}
