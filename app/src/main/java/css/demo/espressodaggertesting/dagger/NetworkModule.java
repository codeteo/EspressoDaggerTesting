package css.demo.espressodaggertesting.dagger;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Dagger Module which provides OkHttp and Retrofit dependencies.
 */

@Module
public class NetworkModule {

    private static final long CONNECTION_TIMEOUT = 30L;
    private static final HttpUrl PRODUCTION_API_BASE_URL = HttpUrl.parse("https://api.github.com/");

    @Singleton
    @Provides
    protected Gson providesGson() {
        return new Gson();
    }

    @Singleton
    @Provides
    protected OkHttpClient providesOkHttpClient(){
        final OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.retryOnConnectionFailure(true);
        client.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);

        return client.build();
    }

    @Provides
    @Singleton
    HttpUrl providesBaseUrl() {
        return PRODUCTION_API_BASE_URL;
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(HttpUrl baseUrl, OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
