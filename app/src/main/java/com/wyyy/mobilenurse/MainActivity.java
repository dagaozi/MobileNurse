package com.wyyy.mobilenurse;

import android.util.Log;

import com.wyyy.corelibrary.base.BaseActivity;
import com.wyyy.corelibrary.base.BaseSubscriber;
import com.wyyy.corelibrary.base.IBaseSubscriber;
import com.wyyy.corelibrary.utils.ToastUtil;
import com.wyyy.mobilenurse.model.TestModel;
import com.wyyy.mobilenurse.net.ApiMethods;

import rx.Subscription;

public class MainActivity extends BaseActivity implements IBaseSubscriber{


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_main);
        setTitleName("hhhhh");
        Log.d("DAGA","hhhhh");
        ToastUtil.showToast(this,"出来吧");
        getTaobaodata2("21.22.11.33");
    }

    @Override
    protected void initEvents() {

    }
    //使用BaseSubscriber访问网络
    private void getTaobaodata2(String ip) {
        Subscription sn = ApiMethods.getInstance().getTaoboData(new BaseSubscriber<TestModel>(this, 1), ip);
        addSubscription(sn);

    /*    Observable observable = ApiMethods.getInstance().apiStores.getTaobaoData(ip);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new HttpResultFunc<TestModel>())
                .subscribe(new BaseSubscriber<TestModel>(this, 4));*/

    }

    @Override
    public void onNext(Object o, int flag) {
        switch (flag) {
            case 1:
                ToastUtil.showToast(MainActivity.this,((TestModel) o).getCountry());
                break;
            case 4:
                ToastUtil.showToast(MainActivity.this,((TestModel) o).getCountry());
                break;
            default:

        }
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        ToastUtil.showToast(MainActivity.this,e.getMessage());
    }
}
