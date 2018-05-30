package com.mobil.gtu.gtumobil.AnaMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.mobil.gtu.gtumobil.MainActivity;
import com.mobil.gtu.gtumobil.R;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity
{

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamenu_list_adapter);

        ListView listView = findViewById(R.id.menuListView);

        final Button saveButton = findViewById(R.id.shortWaySaveButton);

        final List<MenuClass> users = new ArrayList<>();

        Veritabani vt = new Veritabani(MenuActivity.this);

        List<MenuClass> veriler ;
        veriler=vt.VeriListele();

        for(int i = 0 ;i<veriler.size();i++)
        {
            users.add(veriler.get(i));
        }

        final CustomAdapter adapter = new CustomAdapter(this,users);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MenuClass model = users.get(position);

                if(model.isSelected)
                {
                    model.setSelected(false);
                }
                else
                    model.setSelected(true);

                users.set(position,model);
                adapter.updateRecord(users);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Veritabani vt = new Veritabani(MenuActivity.this);
                ArrayList value = new ArrayList();

                for(int i =0;i<users.size();i++)
                {
                    Log.d("adasd", String.valueOf(users.get(i).isSelected));
                    value.add(String.valueOf(users.get(i).isSelected));
                }

                vt.VeriEkle(String.valueOf(value.get(0)),
                        String.valueOf(value.get(1)),
                        String.valueOf(value.get(2)),
                        String.valueOf(value.get(3)),
                        String.valueOf(value.get(4)),
                        String.valueOf(value.get(5)),
                        String.valueOf(value.get(6)),
                        String.valueOf(value.get(7)),
                        String.valueOf(value.get(8)),
                        String.valueOf(value.get(9)),
                        String.valueOf(value.get(10)),
                        String.valueOf(value.get(11)));

                Intent u = new Intent(getBaseContext(),MainActivity.class);
                startActivityForResult(u, 1);

            }
        });

    }
}
