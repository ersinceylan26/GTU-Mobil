package com.mobil.gtu.gtumobil.BolumDuyurlari;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mobil.gtu.gtumobil.R;

import java.util.List;


public class DepartmanAdapter extends BaseAdapter
{
    Activity activity;
    List<DepartmentClass> departmentClassList;
    LayoutInflater inflater;

    public DepartmanAdapter(Activity activity)
    {
        this.activity=activity;
    }

    public DepartmanAdapter(Activity activity, List<DepartmentClass> departmentClassList) {
        this.activity = activity;
        this.departmentClassList = departmentClassList;
        inflater = activity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return departmentClassList.size();
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
            convertView = inflater.inflate(R.layout.activity_department_list_layout,parent,false);

            holder = new  FacultyiewHolder();
            holder.departmentName = (TextView)convertView.findViewById(R.id.departmentName);

            convertView.setTag(holder);
        }
        else

        holder = (FacultyiewHolder) convertView.getTag();

        DepartmentClass model = departmentClassList.get(position);

        holder.departmentName.setText(model.getDepartmentName());
        return convertView;
    }

    class FacultyiewHolder
    {
        TextView departmentName;
    }
}