package com.mobil.gtu.gtumobil.Ulasim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobil.gtu.gtumobil.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

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

    }

    @Override
    public void onBindGroupViewHolder(ParentViewHolder holder, int flatPosition, ExpandableGroup group) {

        holder.setGenreName(group.getTitle());
    }
}
