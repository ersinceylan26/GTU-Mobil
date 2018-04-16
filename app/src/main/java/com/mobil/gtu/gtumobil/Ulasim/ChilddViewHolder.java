package com.mobil.gtu.gtumobil.Ulasim;

import android.view.View;
import android.widget.TextView;

import com.mobil.gtu.gtumobil.R;

public class ChilddViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder {

    private TextView artistname;

    public ChilddViewHolder(View itemView) {
        super(itemView);
        artistname = (TextView) itemView.findViewById(R.id.option1);
    }

    public void setArtistname(String artistname) {
        this.artistname.setText(artistname);
    }
}
