package com.mobil.gtu.gtumobil.BolumDuyurlari;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mobil.gtu.gtumobil.R;

import java.util.ArrayList;
import java.util.List;

public class FacultyAcitivity extends AppCompatActivity
{

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_list_adapter);

        ListView listView = (ListView) findViewById(R.id.facultyListView);

        final List<FacultyClass> users = new ArrayList<>();

        users.add(new FacultyClass("Mühendislik Fakültesi"));
        users.add(new FacultyClass("Temel Bilimler Fakültesi"));
        users.add(new FacultyClass("İşletme Fakültesi"));
        users.add(new FacultyClass("Mimarlık Fakültesi"));

        final FacultyAdapter adapter = new FacultyAdapter(this,users);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FacultyClass model = users.get(position);

                Intent intent = new Intent(FacultyAcitivity.this, DepartmentAcitivity.class);
                intent.putExtra("number",String.valueOf(position));
                startActivity(intent);


            }
        });



    }
}
