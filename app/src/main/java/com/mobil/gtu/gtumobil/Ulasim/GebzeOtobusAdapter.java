package com.mobil.gtu.gtumobil.Ulasim;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobil.gtu.gtumobil.AnaMenu.MenuClass;
import com.mobil.gtu.gtumobil.R;

import java.util.List;

public class GebzeOtobusAdapter extends BaseAdapter
{
    Activity activity;
    List<GebzeOtobusClass>  times;
    LayoutInflater inflater;

    public GebzeOtobusAdapter(Activity activity)
    {
        this.activity=activity;
    }


    public GebzeOtobusAdapter(Activity activity, List<GebzeOtobusClass> times)
    {
        this.activity=activity;
        this.times=times;
        inflater = activity.getLayoutInflater();
    }


    @Override
    public int getCount() {
        return times.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if(convertView==null)
        {
            convertView = inflater.inflate(R.layout.activity_ulasim_490_table,parent,false);

            holder = new ViewHolder();
            holder.first = (TextView)convertView.findViewById(R.id.SecondText);
            holder.second = (TextView)convertView.findViewById(R.id.ThirdText);
            holder.third = (TextView)convertView.findViewById(R.id.FourthText);

            convertView.setTag(holder);
        }
        else

        holder = (ViewHolder) convertView.getTag();

        GebzeOtobusClass model = times.get(position);

        holder.first.setText(model.getFirst());
        holder.second.setText(model.getSecond());
        holder.third.setText(model.getThird());

        return convertView;

    }

    public void updateRecord(List<MenuClass> user)
    {
        this.times=times;
        notifyDataSetChanged();
    }



    class ViewHolder
    {
        TextView first;
        TextView second;
        TextView third;

    }


}
