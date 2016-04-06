package com.iketang.icouse.ui.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;
import com.iketang.icouse.R;

import butterknife.Bind;

/**
 * 项目名称 icouse
 * <p/>
 * Created by hexiaomin on 2016/4/6.
 */
public class WelcomeActivity extends BaseActivity {

    private final long SPLASH_LENGTH = 2000;
    @Bind(R.id.my_image_view)
    SimpleDraweeView myImageView;

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

        Uri uri = Uri.parse("http://demo.bw-xt.com/files/system/mobis-1439292036.png");
        myImageView.setImageURI(uri);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
