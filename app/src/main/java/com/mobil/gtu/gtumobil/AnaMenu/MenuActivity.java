package com.mobil.gtu.gtumobil.AnaMenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mobil.gtu.gtumobil.R;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity
{

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamenu_list_adapter);

        ListView listView = (ListView) findViewById(R.id.menuListView);

        final List<MenuClass> users = new ArrayList<>();

        users.add(new MenuClass(false,"Ulasim"));
        users.add(new MenuClass(false,"Haberler"));
        users.add(new MenuClass(false,"Acil Telefonlar"));
        users.add(new MenuClass(false,"Duyurular"));
        users.add(new MenuClass(false,"Etkinlikler"));

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


    }
}
