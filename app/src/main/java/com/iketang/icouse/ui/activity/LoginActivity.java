package com.iketang.icouse.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.iketang.icouse.R;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 项目名称 icouse
 * <p/>
 * Created by hexiaomin on 2016/3/16.
 */
public class LoginActivity extends BaseActivity implements Handler.Callback {


    @Bind(R.id.login_img_backgroud)
    ImageView mImgBackgroud;
    @Bind(R.id.btn_reg)
    Button btnReg;
    @Bind(R.id.btn_login)
    Button btnLogin;
    private Handler mHandler;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        //传入的参数

        mHandler = new Handler(this);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.translate_anim);
                mImgBackgroud.startAnimation(animation);
            }
        }, 1000);


    }

    @Override
    public boolean handleMessage(Message msg) {

        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
