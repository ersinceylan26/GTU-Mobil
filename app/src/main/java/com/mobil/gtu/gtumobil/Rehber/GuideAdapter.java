package com.mobil.gtu.gtumobil.Rehber;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mobil.gtu.gtumobil.R;
import java.util.List;

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.UlasimViewHolder>
{
    Context mContext;
    List<Contact> mData;

    public GuideAdapter(Context mContext, List<Contact> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public UlasimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View w;

        w = LayoutInflater.from(mContext).inflate(R.layout.activity_guide_layout,parent,false);
        final UlasimViewHolder vHolder = new UlasimViewHolder(w);

        vHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dialContactPhone(mData.get(vHolder.getAdapterPosition()).getTel());
            }
        });

        return vHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull UlasimViewHolder holder, int position) {

        holder.rehberisim.setText(mData.get(position).getName());
        holder.rehberunvan.setText(mData.get(position).getUnvan());
        holder.rehbernumara.setText(mData.get(position).getTel());
        holder.rehbermail.setText(mData.get(position).getMail());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class UlasimViewHolder extends RecyclerView.ViewHolder{

        LinearLayout item_contact;
        TextView rehberisim,rehberunvan,rehbernumara,rehbermail;

        public UlasimViewHolder(View itemView) {
            super(itemView);
            item_contact =  itemView.findViewById(R.id.rehberLinearLayout);
            rehberisim =  itemView.findViewById(R.id.rehberisim);
            rehberunvan =  itemView.findViewById(R.id.rehberunvan);
            rehbernumara = itemView.findViewById(R.id.rehbernumara);
            rehbermail = itemView.findViewById(R.id.rehbermail);

        }
    }

    private void dialContactPhone(final String phoneNumber) {
        mContext.startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }

}
