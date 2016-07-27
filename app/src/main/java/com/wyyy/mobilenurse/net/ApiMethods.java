package com.wyyy.mobilenurse.net;

import com.wyyy.corelibrary.net.ApiFactory;
import com.wyyy.mobilenurse.base.MnApp;
import com.wyyy.mobilenurse.model.TestModel;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by dagaozi on 2016/3/30.
 * 网络返回数据加工处理类
 */
public class ApiMethods extends ApiFactory {
    public  ApiStores apiStores;
    private ApiMethods(){
        apiStores=MnApp.getApiStores();
    }
      private static class SingletonHolder {
        private static final ApiMethods INSTANCE = new ApiMethods();
    }
    public static ApiMethods getInstance()
    {
        return  SingletonHolder.INSTANCE;
    }


    public Subscription getTaoboData(Subscriber<TestModel> subscriber, String ip) {
        Observable observable = apiStores.getTaobaoData(ip);
        return toSubscribe(observable, subscriber);
    }
    public ApiStores getApiStores(){
        if(null==apiStores)
            apiStores=MnApp.getApiStores();
        return apiStores;
    }
}