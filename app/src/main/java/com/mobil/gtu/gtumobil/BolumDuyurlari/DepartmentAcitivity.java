package com.mobil.gtu.gtumobil.BolumDuyurlari;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mobil.gtu.gtumobil.R;

import java.util.ArrayList;
import java.util.List;

public class DepartmentAcitivity extends AppCompatActivity
{

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_list_adapter);

        Intent intent = this.getIntent();
        final String number = intent.getStringExtra("number");

        ListView listView = findViewById(R.id.departmentListView);

        final List<DepartmentClass> users = new ArrayList<>();

        if(number.equals("0"))
        {
            users.add(new DepartmentClass("Bilgisayar Mühendisliği"));
            users.add(new DepartmentClass("Biyomühendislik"));
            users.add(new DepartmentClass("Elektronik Mühendisliği" ));
            users.add(new DepartmentClass("İnşaat Mühendisliği"));
            users.add(new DepartmentClass("Harita Mühendisliği"));
            users.add(new DepartmentClass("Kimya Mühendisliği"));
            users.add(new DepartmentClass("Makina Mühendisliği" ));
            users.add(new DepartmentClass("Malzeme ve Bilimi Mühendisliği"));
            users.add(new DepartmentClass("Çevre Mühendisliği"));
        }
        else if(number.equals("1"))
        {
            users.add(new DepartmentClass("Fizik"));
            users.add(new DepartmentClass("Kimya"));
            users.add(new DepartmentClass("Matematik"));
            users.add(new DepartmentClass("Moleküler Biyoloji ve Genetik"));
        }
        else if(number.equals("2"))
        {
            users.add(new DepartmentClass("İktisat"));
            users.add(new DepartmentClass("İşletme"));
        }
        else if(number.equals("3"))
        {
            users.add(new DepartmentClass("Mimarlık" ));
            users.add(new DepartmentClass("Şehir ve Bölge Planlama"));
        }

        final DepartmanAdapter adapter = new DepartmanAdapter(this,users);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DepartmentClass model = users.get(position);

                Intent intent = new Intent(DepartmentAcitivity.this, AnnouncementListActivity.class);
                intent.putExtra("facultyNumber",String.valueOf(number));
                intent.putExtra("departmentNumber",String.valueOf(position));
                startActivity(intent);


            }
        });



    }
}
