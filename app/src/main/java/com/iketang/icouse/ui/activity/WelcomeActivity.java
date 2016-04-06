package com.iketang.icouse.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.iketang.icouse.R;

import butterknife.ButterKnife;

/**
 * 项目名称 icouse
 * <p/>
 * Created by hexiaomin on 2016/4/6.
 */
public class WelcomeActivity extends BaseActivity {

    private final long SPLASH_LENGTH = 2000;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_welcome;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
}
