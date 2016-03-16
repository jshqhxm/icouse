package com.iketang.icouse.ui.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iketang.icouse.R;
import com.iketang.icouse.model.Course;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/3/11.
 */
public class CourseListRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<Course> mEntityList = new ArrayList<>();


    public Course getCourseSet() {
        return null;
    }

    private OnClickListener mOnClickListener;

    public void setCourseList(List<Course> list) {

        //下拉时保证重新填充
        mEntityList.clear();
        mEntityList.addAll(list);
        notifyDataSetChanged();

    }

    public void addData(List<Course> list){
        mEntityList.addAll(list);
        notifyItemInserted(getItemCount());
    }

    public interface OnClickListener {
        void onClick(View view, int position, String contentId);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.rv_course_cv_title)
        TextView rvCourseCvTitle;

        @Bind(R.id.rv_course_cv)
        CardView cardView;

        public CardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View cardView
                = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_cardview_course, parent, false);
        return new CardViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if(mEntityList.size() != 0 ){
            final  Course entity = mEntityList.get(position);
            if (holder instanceof CardViewHolder) {
                ((CardViewHolder) holder).rvCourseCvTitle
                        .setText(entity.getTitle());

            }

            if(mOnClickListener!=null){
                ((CardViewHolder) holder).cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnClickListener.onClick(v, position, entity.getContentId());
                    }
                });
        }


    }}

    @Override
    public int getItemCount() {
        return mEntityList.size();
    }
}
