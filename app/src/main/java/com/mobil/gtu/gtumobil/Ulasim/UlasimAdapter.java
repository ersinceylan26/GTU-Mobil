package com.mobil.gtu.gtumobil.Ulasim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.mobil.gtu.gtumobil.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;
import java.util.Random;

public class UlasimAdapter extends ExpandableRecyclerViewAdapter<ParentViewHolder,ChilddViewHolder>
{
    private Context mContext;


    public UlasimAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public ParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_ulasim_list_parent,parent,false);

        return new ParentViewHolder(view);
    }

    @Override
    public ChilddViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_ulasim_list_child,parent,false);

        return new ChilddViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ChilddViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {

        Child child = (Child) group.getItems().get(childIndex);

        holder.setArtistname(child.getName());
        setAnimation(holder.itemView, flatPosition);

    }

    @Override
    public void onBindGroupViewHolder(ParentViewHolder holder, int flatPosition, ExpandableGroup group) {

        holder.setGenreName(group.getTitle());
    }

    protected int mLastPosition = -1;

    protected void setAnimation(View viewToAnimate, int position) {
        if (position > mLastPosition) {
            ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(new Random().nextInt(501));//to make duration random number between [0,501)
            viewToAnimate.startAnimation(anim);
            mLastPosition = position;
        }
    }
}
