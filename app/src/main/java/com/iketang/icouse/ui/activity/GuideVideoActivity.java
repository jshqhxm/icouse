package com.iketang.icouse.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.VideoView;

import com.iketang.icouse.R;
import com.iketang.icouse.widget.MyVideoView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xiaomin on 2016/5/12.
 */
public class GuideVideoActivity extends BaseActivity {

    @Bind(R.id.videoView)
    MyVideoView videoView;
    @Bind(R.id.btnGo)
    Button btnGo;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_guidevideo;
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

    }

    @OnClick(R.id.btnGo)
    public void onClick() {
        stop();

        Intent intent = new Intent(GuideVideoActivity.this, WebMainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        play();
    }



    @Override
    protected void onStop() {
        super.onStop();
        stop();
    }

    private void play() {
        String str = "android.resource://" + getPackageName() + "/" + R.raw.mobile_live_guide;
        this.videoView.setVideoURI(Uri.parse(str));
        this.videoView.start();

    }

    private  void stop() {
        videoView.stopPlayback();
    }
}
