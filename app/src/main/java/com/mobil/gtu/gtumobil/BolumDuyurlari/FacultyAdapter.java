package com.mobil.gtu.gtumobil.BolumDuyurlari;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mobil.gtu.gtumobil.R;

import java.util.List;


public class FacultyAdapter extends BaseAdapter
{
    Activity activity;
    List<FacultyClass> facultyClassList;
    LayoutInflater inflater;

    public FacultyAdapter(Activity activity)
    {
        this.activity=activity;
    }

    public FacultyAdapter(Activity activity, List<FacultyClass> facultyClassList) {
        this.activity = activity;
        this.facultyClassList = facultyClassList;
        inflater = activity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return facultyClassList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FacultyiewHolder holder = null;

        if(convertView==null)
        {
            convertView = inflater.inflate(R.layout.activity_faculty_list_layout,parent,false);

            holder = new  FacultyiewHolder();
            holder.facultyName = (TextView)convertView.findViewById(R.id.facultyName);

            convertView.setTag(holder);
        }
        else

        holder = (FacultyiewHolder) convertView.getTag();

        FacultyClass model = facultyClassList.get(position);

        holder.facultyName.setText(model.getFacultyName());
        return convertView;
    }

    class FacultyiewHolder
    {
        TextView facultyName;
    }
}