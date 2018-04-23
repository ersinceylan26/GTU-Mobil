package com.mobil.gtu.gtumobil.Ulasim;

import android.view.View;
import android.widget.TextView;

import com.mobil.gtu.gtumobil.R;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class ParentViewHolder extends GroupViewHolder {

    private TextView genreTitle;

    public ParentViewHolder(View itemView) {
        super(itemView);
        genreTitle = (TextView) itemView.findViewById(R.id.parentTitle);
    }

    public void setGenreName(String name)
    {
        genreTitle.setText(name);
    }





}
