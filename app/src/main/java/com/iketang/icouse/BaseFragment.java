package com.iketang.icouse;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2016/3/9.
 */
public abstract class  BaseFragment extends Fragment {

    public String TAG = getClass().getSimpleName();
    protected boolean isVisible;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
        lazyLoad();
    }

    protected void onInvisible() {

    }

    protected abstract void lazyLoad();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

    }
}
