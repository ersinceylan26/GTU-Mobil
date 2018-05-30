package com.mobil.gtu.gtumobil.AnaMenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mobil.gtu.gtumobil.R;

/**
 * Created by ersin on 26.03.2018.
 */

public class AnaMenuSortWayListActiviy extends AppCompatActivity
{
    String[] activities = {"Ulasim","Haberler","Rehber","Etkinlikler","Transkript","YemekBakiye","BolumDuyurulari",
            "YemekMenusu","Duyurular","AkademikTakvim","Login","Hakkimizda"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shortway_list_activities);

        ListView listView = findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return activities.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view=getLayoutInflater().inflate(R.layout.activity_shortway_custom_adapter,null);
            TextView textView = view.findViewById(R.id.textView);

            textView.setText(activities[i]);

            return view;
        }
    }

}
