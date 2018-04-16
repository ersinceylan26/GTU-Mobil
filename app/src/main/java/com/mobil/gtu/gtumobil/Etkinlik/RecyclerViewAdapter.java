package com.mobil.gtu.gtumobil.Etkinlik;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.mobil.gtu.gtumobil.R;

import java.util.List;

/**
 * Created by ersin on 15.04.2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<EtkinlikNoMoreClass> mData;

    public RecyclerViewAdapter(Context mContext, List<EtkinlikNoMoreClass> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.activity_etkinlik_layout,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.eBaslik.setText(mData.get(position).getEtkinlikBasligi());
        holder.eTarih.setText(mData.get(position).getEtkinlikTarihi());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView eBaslik;
        private TextView eTarih;

        public MyViewHolder(View itemView) {
            super(itemView);

            eBaslik = (TextView) itemView.findViewById(R.id.txtName);
            eTarih = (TextView) itemView.findViewById(R.id.txtTarih);

        }
    }










}









