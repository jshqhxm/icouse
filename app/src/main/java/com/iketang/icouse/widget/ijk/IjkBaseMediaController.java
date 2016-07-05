package com.iketang.icouse.widget.ijk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by xiaomin on 2016/6/23.
 */
public abstract class IjkBaseMediaController  extends FrameLayout {
    private static final String TAG = IjkBaseMediaController.class.getSimpleName();

    public IjkBaseMediaController(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IjkBaseMediaController(Context context) {
        super(context);
    }

    protected abstract View makeControllerView();

    protected abstract void initControllerView(View paramView);

    public abstract void show();

    public abstract void show(int paramInt);

    public abstract void hide();

    public abstract boolean isShowing();

    public abstract void setMediaPlayer(MediaPlayerControl paramMediaPlayerControl);

    public abstract void setAnchorView(View paramView);

    public abstract void setViewBitRate(String paramString, int paramInt);

    public static abstract interface MediaPlayerControl {
        public abstract void start();

        public abstract void pause();

        public abstract int getDuration();

        public abstract int getCurrentPosition();

        public abstract void seekTo(long paramLong);

        public abstract boolean isPlaying();

        public abstract int getBufferPercentage();

        public abstract boolean canPause();

        public abstract boolean canSeekBackward();

        public abstract boolean canSeekForward();
    }


}
