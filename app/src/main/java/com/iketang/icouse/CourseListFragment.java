package com.iketang.icouse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/3/10.
 */
public class CourseListFragment extends BaseFragment {


    private CourseListRvAdapter mAdapter;

    @Bind(R.id.fragment_course_list_recycler_view)
    RecyclerView mRecyclerView;

    @Bind(R.id.swipe_fresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    public static CourseListFragment newInstance() {

        CourseListFragment fragment = new CourseListFragment();
        Bundle bundle = new Bundle();

        fragment.setArguments(bundle);

        return fragment;
    }


    private boolean mIsPrepared;

    private LinearLayoutManager mManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cousre_list, container, false);
        ButterKnife.bind(this, view);

        mManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new CourseListRvAdapter();

        mAdapter.setOnClickListener(new CourseListRvAdapter.OnClickListener() {
            @Override
            public void onClick(View view,  final int position,  final String contentId) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), "position  == " + position + "  contentId == " + contentId, Toast.LENGTH_LONG);

                    }
                });

            }
        });

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });


        isVisible =true;
        mIsPrepared = true;
        lazyLoad();

        return view;


    }

    @Override
    protected void lazyLoad() {
        if (!mIsPrepared || !isVisible) {
            return;
        } else{
            if(mAdapter.getCourseSet() == null){
                mSwipeRefreshLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        getHttpResult();
//                        mSwipeRefreshLayout.setRefreshing(true);
//                        mSwipeRefreshLayout.setEnabled(false);
                    }
                });

            }
        }
    }

    private void getHttpResult(){


        List<Course> list = new ArrayList<>();

        for (int i = 0;i <100;i++){
            Course item = new Course();
            item.setTitle("我是课程标题  " + i + " 学习");
            item.setContentId( ""+i);
            list.add(item);
        }

        mAdapter.setCourseList(list);

//        getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                if (mSwipeRefreshLayout != null) {
//                    mSwipeRefreshLayout.setRefreshing(false);
//                    mSwipeRefreshLayout.setEnabled(true);
//                }
//            }
//        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
