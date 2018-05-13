package com.mobil.gtu.gtumobil.AnaMenu;

import android.app.Activity;
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

        ListView listView = (ListView) findViewById(R.id.menuListView);

        final Button saveButton = (Button) findViewById(R.id.shortWaySaveButton);

        final List<MenuClass> users = new ArrayList<>();

        Veritabani vt = new Veritabani(MenuActivity.this);

        List<MenuClass> veriler = new ArrayList<MenuClass>();
        veriler=vt.VeriListele();

        for(int i = 0 ;i<veriler.size();i++)
        {
            users.add(veriler.get(i));
        }

        for(int i = 0 ;i<veriler.size();i++)
        {
            Log.d("adasd", vt.VeriListele().get(i).toString());
        }

        /*users.add(new MenuClass(false,"Ulasim"));
        users.add(new MenuClass(false,"Haberler"));
        users.add(new MenuClass(false,"Rehber"));
        users.add(new MenuClass(false,"Duyurular"));
        users.add(new MenuClass(false,"Etkinlikler"));*/

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
                        String.valueOf(value.get(4)));

                for(int k =0;k<1;k++)
                {
                    Log.d("adasd", String.valueOf(vt.VeriListele().get(k).toString()));
                }


                Intent u = new Intent(getBaseContext(),MainActivity.class);
                startActivityForResult(u, 1);


            }
        });


    }
}
