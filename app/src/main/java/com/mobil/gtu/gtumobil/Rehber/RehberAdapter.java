package com.mobil.gtu.gtumobil.Rehber;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mobil.gtu.gtumobil.Etkinlik.EtkinlikNoMoreClass;
import com.mobil.gtu.gtumobil.Etkinlik.RecyclerViewAdapter;
import com.mobil.gtu.gtumobil.R;

import java.util.List;
import java.util.zip.Inflater;

public class RehberAdapter extends RecyclerView.Adapter<RehberAdapter.UlasimViewHolder>
{

    Context mContext;
    List<Contact> mData;
    Dialog myDialog;

    public RehberAdapter(Context mContext, List<Contact> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public UlasimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View w;

        w = LayoutInflater.from(mContext).inflate(R.layout.activity_rehber_layout,parent,false);
        final UlasimViewHolder vHolder = new UlasimViewHolder(w);

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.activity_rehber_popup);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        vHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("adasd", "Sayac " );
                TextView dialogName = (TextView) myDialog.findViewById(R.id.popupContacName);
                TextView dialogPhone = (TextView) myDialog.findViewById(R.id.popupPhone);
                TextView dialogUnvan = (TextView) myDialog.findViewById(R.id.popupUnvan);

                dialogName.setText(mData.get(vHolder.getAdapterPosition()).getName());
                dialogPhone.setText(mData.get(vHolder.getAdapterPosition()).getTel());
                dialogPhone.setText(mData.get(vHolder.getAdapterPosition()).getUnvan());

                Toast.makeText(mContext,"asdasd " +String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_LONG);
                myDialog.show();
            }
        });

        return vHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull UlasimViewHolder holder, int position) {

        holder.rehberisim.setText(mData.get(position).getName());
        holder.rehberunvan.setText(mData.get(position).getUnvan());
        holder.rehbernumara.setText(mData.get(position).getTel());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class UlasimViewHolder extends RecyclerView.ViewHolder{

        LinearLayout item_contact;
        TextView rehberisim;
        TextView rehberunvan;
        TextView rehbernumara;

        public UlasimViewHolder(View itemView) {
            super(itemView);
            item_contact = (LinearLayout) itemView.findViewById(R.id.rehberLinearLayout);
            rehberisim = (TextView) itemView.findViewById(R.id.rehberisim);
            rehberunvan = (TextView) itemView.findViewById(R.id.rehberunvan);
            rehbernumara = (TextView) itemView.findViewById(R.id.rehbernumara);



        }
    }

}
