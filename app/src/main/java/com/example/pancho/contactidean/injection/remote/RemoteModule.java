package com.example.pancho.contactidean.injection.remote;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.pancho.contactidean.util.CONSTANTS.BASE_URL;

/**
 * Created by Francisco on 10/18/2017.
 */

@Module
public class RemoteModule {

    @Provides
    @Singleton
    Retrofit providesRetrofit() {
        //create a custom client to add the interceptor
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }
}
