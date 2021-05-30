/*
 * Copyright (c) 2021. rogergcc
 */

package com.appsnipp.education.ui.menucourses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.education.databinding.ItemCardBinding;
import com.appsnipp.education.ui.listeners.CoursesItemClickListener;
import com.appsnipp.education.ui.model.CourseCard;

import java.util.List;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter._ViewHolder> {

    Context mContext;
    private List<CourseCard> mData;
    private CoursesItemClickListener coursesItemClickListener;

    public CourseRecyclerAdapter(Context mContext, List<CourseCard> couresesList, CoursesItemClickListener listener) {
        this.mContext = mContext;
        this.mData = couresesList;
        this.coursesItemClickListener = listener;
    }

    @NonNull
    @Override
    public CourseRecyclerAdapter._ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater= LayoutInflater.from(viewGroup.getContext());
        ItemCardBinding itemCardBinding = ItemCardBinding.inflate(layoutInflater,viewGroup,false);
        return new _ViewHolder(itemCardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull final CourseRecyclerAdapter._ViewHolder viewHolder, final int i) {
        final int pos = viewHolder.getAdapterPosition();
        viewHolder.itemView.setTag(pos);

        viewHolder.setPostImage(mData.get(i));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coursesItemClickListener.onDashboardCourseClick(mData.get(i), viewHolder.itemCardBinding.cardViewImage);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        CourseCard courseCard = mData.get(position);
        return courseCard.getId();
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class _ViewHolder extends RecyclerView.ViewHolder{
        ItemCardBinding itemCardBinding;
        public _ViewHolder(@NonNull ItemCardBinding cardBinding) {
            super(cardBinding.getRoot());
            this.itemCardBinding = cardBinding;
        }

        void setPostImage(CourseCard courseCard){
            this.itemCardBinding.cardViewImage.setImageResource(courseCard.getImageCourse());
            this.itemCardBinding.stagItemCourse.setText(courseCard.getCourseTitle());
            this.itemCardBinding.stagItemQuantityCourse.setText(courseCard.getQuantityCourses());
        }
    }
}
