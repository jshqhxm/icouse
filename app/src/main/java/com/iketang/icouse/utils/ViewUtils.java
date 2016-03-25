package com.iketang.icouse.utils;

import android.support.v4.widget.SwipeRefreshLayout;

/**
 * 项目名称 icouse
 * <p/>
 * Created by hexiaomin on 2016/3/25.
 */
public class ViewUtils {

    /**
     * 下拉刷新组件颜色设置
     */
    public static void setSwipeRefreshLayoutColor(SwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    /**
     * 下拉刷新成功
     */
    public static void setSwipeRefreshOk(SwipeRefreshLayout swipeRefreshLayout) {
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
            swipeRefreshLayout.setEnabled(false);
        }
    }

    /**
     * 下拉刷新失败
     */
    public static void setSwipeRefreshFailed(SwipeRefreshLayout swipeRefreshLayout) {
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

}
