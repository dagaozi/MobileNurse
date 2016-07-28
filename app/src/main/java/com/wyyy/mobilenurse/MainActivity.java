package com.wyyy.mobilenurse;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wyyy.corelibrary.base.BaseActivity;
import com.wyyy.corelibrary.base.BaseSubscriber;
import com.wyyy.corelibrary.base.IBaseSubscriber;
import com.wyyy.corelibrary.net.HttpResultFunc;
import com.wyyy.corelibrary.utils.LogUtils;
import com.wyyy.corelibrary.utils.NetUtils;
import com.wyyy.corelibrary.utils.ToastUtil;
import com.wyyy.mobilenurse.model.TestModel;
import com.wyyy.mobilenurse.net.ApiMethods;

import butterknife.Bind;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements IBaseSubscriber {


    @Bind(R.id.tvTest)
    TextView tvTest;
    @Bind(R.id.btnTest)
    Button btnTest;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_main);
        setTitleName("测试页面1");
        LogUtils.d("测试");

    }

    @Override
    protected void initEvents() {
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTaobaodata2("21.22.11.33");
            }
        });

    }

    //使用BaseSubscriber访问网络
    private void getTaobaodata2(String ip) {
       /* Subscription sn = ApiMethods.getInstance().getTaoboData(new BaseSubscriber<TestModel>(this, 1), ip);
        addSubscription(sn);*/
        //ApiStores apiStores= ApiClient.create(ApiStores.class);

        Observable observable = ApiMethods.getInstance().getApiStores().getTaobaoData(ip);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new HttpResultFunc<TestModel>())
                .subscribe(new BaseSubscriber<TestModel>(this, 4));

    }

    @Override
    public void onNext(Object o, int flag) {
        switch (flag) {
            case 1:
                ToastUtil.showToast(MainActivity.this, ((TestModel) o).getCountry());
                break;
            case 4:
                ToastUtil.showToast(MainActivity.this, ((TestModel) o).getCountry());
                break;
            default:

        }
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        ToastUtil.showToast(MainActivity.this, NetUtils.checkApiException(e));
    }

}
