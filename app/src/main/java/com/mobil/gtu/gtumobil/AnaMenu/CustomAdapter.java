package com.mobil.gtu.gtumobil.AnaMenu;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobil.gtu.gtumobil.R;

import java.util.List;

public class CustomAdapter extends BaseAdapter
{
    Activity activity;
    List<MenuClass>  users;
    LayoutInflater inflater;

    public CustomAdapter(Activity activity)
    {
        this.activity=activity;
    }


    public CustomAdapter(Activity activity,List<MenuClass> users)
    {
        this.activity=activity;
        this.users=users;
        inflater = activity.getLayoutInflater();
    }


    @Override
    public int getCount() {
        return users.size();
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
            convertView = inflater.inflate(R.layout.activity_anamenu_list_layout,parent,false);

            holder = new ViewHolder();
            holder.menuName = (TextView)convertView.findViewById(R.id.menuName);
            holder.menuCheck = (ImageView)convertView.findViewById(R.id.menuCheck);

            convertView.setTag(holder);
        }
        else

        holder = (ViewHolder) convertView.getTag();

        MenuClass model = users.get(position);

        holder.menuName.setText(model.getMenuName());

        if(model.isSelected()) {
            holder.menuCheck.setBackgroundResource(R.drawable.checked);
        }
        else
            holder.menuCheck.setBackgroundResource(R.drawable.check);


        return convertView;

    }

    public void updateRecord(List<MenuClass> user)
    {
        this.users=user;
        notifyDataSetChanged();
    }



    class ViewHolder
    {
        TextView menuName;
        ImageView menuCheck;
    }


}
