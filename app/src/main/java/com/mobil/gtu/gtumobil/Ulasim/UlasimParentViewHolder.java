package com.mobil.gtu.gtumobil.Ulasim;

import android.view.View;
import android.widget.TextView;
import com.mobil.gtu.gtumobil.R;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class UlasimParentViewHolder extends GroupViewHolder {

    private TextView genreTitle;

    public UlasimParentViewHolder(View itemView) {
        super(itemView);
        genreTitle = itemView.findViewById(R.id.parentTitle);
    }

    public void setGenreName(String name)
    {
        genreTitle.setText(name);
    }

}
