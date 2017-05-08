package hu.bme.iemqra.mobsoft.mobsoft.mock;

/**
 * Created by mobsoft on 2017. 05. 08..
 */

import java.io.IOException;

import javax.inject.Singleton;

import hu.bme.iemqra.mobsoft.mobsoft.network.NetworkModule;
import hu.bme.iemqra.mobsoft.mobsoft.network.api.ExamAppApi;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import dagger.Module;
import dagger.Provides;

public class MockNetworkModule {
    private NetworkModule networkModule = new NetworkModule();

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return networkModule.provideOkHttpClientBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {

        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                return MockHttpServer.call(request);
            }
        });

        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return networkModule.provideRetrofit(client);
    }

    @Provides
    @Singleton
    public ExamAppApi provideAuthApi(Retrofit retrofit) {
        return networkModule.provideATodoApi(retrofit);
    }
}
