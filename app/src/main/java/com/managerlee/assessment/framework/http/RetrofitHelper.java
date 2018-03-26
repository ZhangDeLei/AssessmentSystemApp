package com.managerlee.assessment.framework.http;

import com.managerlee.assessment.constant.URLConstant;
import com.managerlee.assessment.update.service.UpdateService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anins on 2018/3/23.
 */

public class RetrofitHelper {

    private static final int TIMEOUT_DEFAULT = 10;
    private OkHttpClient httpClient;
    private Retrofit retrofit;

    private static final class Singleton {
        public static final RetrofitHelper INSTANCE = new RetrofitHelper();
    }

    public static RetrofitHelper init() {
        return Singleton.INSTANCE;
    }

    private RetrofitHelper() {
        httpClient = new OkHttpClient
                .Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request req = chain.request();
                        Request request = req.newBuilder()
                                .header("Content-Type", "application/json;charset=UTF-8")
                                .header("Access-Control-Allow-Origin", "*")
                                .header("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE,PUT")
                                .header("Access-Control-Allow-Headers", "Content-Type,Authorization,version")
                                .header("version", "1")
                                .build();
                        return chain.proceed(request);
                    }
                })
                .connectTimeout(TIMEOUT_DEFAULT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_DEFAULT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_DEFAULT, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit
                .Builder()
                .baseUrl(URLConstant.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
