package com.wyyy.corelibrary.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by haohaibin .（dagaozi@163.com）
 * 创建时间：2016/7/27 15:14
 * 类描述：
 */
public class ApiClient {
    public static final String PRODUCT_URL = "http://www.weather.com.cn/";
    public static final String DEBUG_URL = "http://www.weather.com.cn/";
    private static final int DEFAULT_TIMEOUT = 10;
    private Retrofit retrofit;
    private ApiClient(){
        //OKhttp的日志系统
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //手动创建一个OkHttpClient并设置超时时间，网络判断拦截器、日志拦截器
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
         retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .baseUrl(DEBUG_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final ApiClient INSTANCE = new ApiClient();
    }

    //获取单例
    public static ApiClient getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
