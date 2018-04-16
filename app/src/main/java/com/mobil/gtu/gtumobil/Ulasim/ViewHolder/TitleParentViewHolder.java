package com.mobil.gtu.gtumobil.Ulasim.ViewHolder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.mobil.gtu.gtumobil.R;

/**
 * Created by ersin on 14.04.2018.
 */

public class TitleParentViewHolder extends ParentViewHolder {

    public TextView _texview;
    public ImageButton _imageButton;

    public TitleParentViewHolder(View itemView) {
        super(itemView);
        _texview = (TextView) itemView.findViewById(R.id.parentTitle);
        _imageButton = (ImageButton) itemView.findViewById(R.id.expandSearch);

    }

}

















