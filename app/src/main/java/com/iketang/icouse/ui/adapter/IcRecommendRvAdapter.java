package com.iketang.icouse.ui.adapter;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iketang.icouse.R;
import com.iketang.icouse.utils.GlobalUtils;

import butterknife.ButterKnife;

/**
 * Created by xiaomin on 2016/3/25.
 */
public class IcRecommendRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_VIEW_PAGER = 0;
    private static final int TYPE_NAVIGATION_TITLE = 1;
    private static final int TYPE_CARD_VIEW = 2;
    private static final int TYPE_CARD_VIEW_OTHER = 3;



    private SwipeRefreshLayout mSwipeRefreshLayout;

    public void setSwipeRefreshLayout(SwipeRefreshLayout mSwipeRefreshLayout) {
        this.mSwipeRefreshLayout = mSwipeRefreshLayout;
    }




    public interface OnClickListener {
        void onClick(View view, String partitionType, String contentId);
    }


    private OnClickListener mOnClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    //处理cardView中间的margin
    public static class MyDecoration extends RecyclerView.ItemDecoration {

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDraw(c, parent, state);
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();

            int marginRight = GlobalUtils.dip2px(parent.getContext(), 7);
            if (position == 2 | position == 4 | position == 7 | position == 10 | position == 13
                    | position == 16 | position == 19 | position == 22 | position == 25) {
                outRect.set(0, 0, marginRight, 0);
            }

        }
    }


    //首页横幅
    public class ViewPagerVH extends  RecyclerView.ViewHolder{



        public ViewPagerVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View viewPage
                = LayoutInflater.from(parent.getContext()).inflate(R.layout.ic_rv_recommend_viewpager, parent, false);

        View title
                = LayoutInflater.from(parent.getContext()).inflate(R.layout.ic_rv_title_with_button, parent, false);

        if (viewType == TYPE_VIEW_PAGER) {
            return new ViewPagerVH(viewPage);
        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
