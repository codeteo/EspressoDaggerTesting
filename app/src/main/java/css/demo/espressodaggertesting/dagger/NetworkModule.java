package css.demo.espressodaggertesting.dagger;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import css.demo.espressodaggertesting.Constants;
import css.demo.espressodaggertesting.utils.BaseUrlInterceptor;
import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Dagger Module which provides OkHttp and Retrofit dependencies.
 */

@Module
public class NetworkModule {

    private static final long CONNECTION_TIMEOUT = 30L;

    @Singleton
    @Provides
    protected Gson providesGson() {
        return new Gson();
    }

    @Singleton
    @Provides
    protected OkHttpClient providesOkHttpClient(BaseUrlInterceptor baseUrlInterceptor){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(Level.BODY);

        final OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.retryOnConnectionFailure(true);
        client.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        client.addInterceptor(logging);
        client.addInterceptor(baseUrlInterceptor);

        return client.build();
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


    @Provides
    @Singleton
//    @ForTestingPurposes
    static BaseUrlInterceptor providesBaseUrlInterceptor() {
        return new BaseUrlInterceptor(Constants.BASE_URL);
    }


}
