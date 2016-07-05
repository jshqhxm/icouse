package com.iketang.icouse.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iketang.icouse.R;
import com.iketang.icouse.widget.IcMediaController;
import com.iketang.icouse.widget.ijk.IjkVideoView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiaomin on 2016/6/23.
 */
public class VideoViewFragment extends BaseFragment {


    @Bind(R.id.videoView)
    IjkVideoView videoView;


    IcMediaController mediaController;

    private static final String VIDEO_PATH = "videoPath";

    private String mVideoPath;


    public static VideoViewFragment newInstance(String videoPath) {

        VideoViewFragment fragment = new VideoViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString(VIDEO_PATH,videoPath);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_videoview, container, false);
        ButterKnife.bind(this, view);

//        mVideoPath = getArguments().getString(VIDEO_PATH);

        mediaController =new IcMediaController(getActivity());

        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);


        return view;
    }

    @Override
    protected void lazyLoad() {

    }


    @Override
    public void onStart() {
        super.onStart();

        videoStart();
    }

    private void videoStart()
    {

        mVideoPath ="http://demo.bw-xt.com:8085/private_play/13TFHYO0945/22WUF4/409LAGXQCPRR.mp4";

        if(null != videoView)
            videoView.setVideoPath(mVideoPath);
    }

    public void startPlayer(){
        if(null != videoView)
            videoView.start();
    }

    public void  pausePlayer(){
        if(null  != videoView)
            videoView.pause();
    }

    public void  stopPlayer(){
        if(null != videoView)
            videoView.setVideoPath(null);

        videoView.clearFocus();
        videoView.pause();
        videoView.stopPlayback();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
