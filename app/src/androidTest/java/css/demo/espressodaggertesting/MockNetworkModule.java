package css.demo.espressodaggertesting;

import com.google.gson.Gson;

import css.demo.espressodaggertesting.dagger.NetworkModule;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import static org.mockito.Mockito.mock;

/**
 * Created by css on 2/18/17.
 */

public class MockNetworkModule extends NetworkModule {

    private static final HttpUrl MOCK_API_BASE_URL = HttpUrl.parse("mockito");

    @Override
    protected Gson providesGson() {
        return mock(Gson.class);
    }

    @Override
    protected OkHttpClient providesOkHttpClient(){
        return mock(OkHttpClient.class);
    }

    @Override
    protected HttpUrl providesBaseUrl() {
        return MOCK_API_BASE_URL;
    }

    @Override
    protected Retrofit providesRetrofit(HttpUrl baseUrl, OkHttpClient client) {
        return mock(Retrofit.class);
    }

}
