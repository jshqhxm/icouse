package com.iketang.icouse.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iketang.icouse.R;
import com.iketang.icouse.ui.adapter.IcRecommendRvAdapter;
import com.iketang.icouse.utils.ViewUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 项目名称 icouse
 * <p/>
 * Created by hexiaomin on 2016/3/25.
 */
public class IcRecommendFragment extends BaseFragment {

    private boolean mIsPrepared;

    private IcRecommendRvAdapter mAdapter;


//    public IcRecommendFragment() {
//    }

    @Bind(R.id.ic_fragment_recommend_recycler_view)
    RecyclerView mRecyclerView;

    @Bind(R.id.swipe_fresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ic_fragment_main_recommend, container, false);
        ButterKnife.bind(this, view);

        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0 | position == 1 | position == 6 | position == 9 | position == 12
                        | position == 15 | position == 18 | position == 21 | position == 24) {
                    return 2;
                }
                return 1;
            }
        });
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new IcRecommendRvAdapter.MyDecoration());
        mAdapter = new IcRecommendRvAdapter();

        //解决viewpager里滑动导致swipeReFreshLayout的出现
        mAdapter.setSwipeRefreshLayout(mSwipeRefreshLayout);
        mAdapter.setOnClickListener(new IcRecommendRvAdapter.OnClickListener(){

            @Override
            public void onClick(View view, String partitionType, String contentId) {


            }
        });
        mRecyclerView.setAdapter(mAdapter);


        ViewUtils.setSwipeRefreshLayoutColor(mSwipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            @Override
            public void onRefresh() {
                //TODO 获取数据




                mSwipeRefreshLayout.setEnabled(false);

            }
        });


        return  view;
    }

    @Override
    protected void lazyLoad() {

        if (!mIsPrepared || !isVisible) {
            return;
        }else {


        }

    }
}
