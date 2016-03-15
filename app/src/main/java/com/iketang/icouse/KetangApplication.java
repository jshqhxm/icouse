package com.iketang.icouse;

import android.app.Application;
import android.content.Context;

import com.tendcloud.tenddata.TCAgent;

/**
 * 项目名称 icouse
 * <p/>
 * Created by hexiaomin on 2016/3/14.
 */
public class KetangApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TCAgent.init(this.getApplicationContext());
        TCAgent.setReportUncaughtExceptions(false);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
