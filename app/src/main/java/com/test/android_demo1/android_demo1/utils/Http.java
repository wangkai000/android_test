package com.test.android_demo1.android_demo1.utils;

import android.content.Context;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator on 2018/10/16.
 */

public class Http {
    private static final String TAG = Http.class.getName();

    private static Retrofit singleton;

    public static <T> T createRetrofit(Context context, Class<T> clazz) {
        if (singleton == null) {
            synchronized (Http.class) {
                if (singleton == null) {
                    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                    OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
                    okHttpClientBuilder.addInterceptor(new HeaderInterceptor());
                    okHttpClientBuilder.addInterceptor(logging);
                    okHttpClientBuilder.readTimeout(30L, TimeUnit.SECONDS);
                    OkHttpClient client = okHttpClientBuilder.build();
                    Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
                    retrofitBuilder.baseUrl("http://nodedemo.tianmiao.xyz");
                    retrofitBuilder.addConverterFactory(ScalarsConverterFactory.create());
                    retrofitBuilder.addConverterFactory(GsonConverterFactory.create());
                    retrofitBuilder.client(client);
                    singleton = retrofitBuilder.build();
                }
            }
        }

        return singleton.create(clazz);
    }

    public static void resetRetrofit() {
        if (singleton != null) {
            synchronized (Http.class) {
                if (singleton != null) {
                    singleton = null;
                }
            }
        }
    }

    private static class HeaderInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            String token = "";
//            if (!StringUtils.isEmpty(App.TOKEN)) {
//                token = App.TOKEN;
//            }
            Request request = chain.request();
            Request.Builder requestBuilder = request.newBuilder();
            request = requestBuilder
                    .addHeader("Authorization", token)
                    .build();
            return chain.proceed(request);
        }
    }
}
