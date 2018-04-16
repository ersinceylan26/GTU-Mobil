package com.mobil.gtu.gtumobil.Rehber;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mobil.gtu.gtumobil.R;

import java.util.ArrayList;
import java.util.List;

public class RehberActivity extends AppCompatActivity
{
    RecyclerView myRecycler;
    List<Contact> lstContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehber);

        lstContact = new ArrayList<>();

        lstContact.add(new Contact("Yusuf Sinan Akgül","Öğretim Üyesi","0(212)333 22 11"));
        lstContact.add(new Contact("Mehmet Göktürk","Öğretim Üyesi","0(212)333 22 11"));
        lstContact.add(new Contact("Hasari Çelebi","Öğretim Üyesi","0(212)333 22 11"));
        lstContact.add(new Contact("Meral Şahin","Bil. Müh. Sekreterlik","0(212)333 22 11"));

        myRecycler = (RecyclerView) findViewById(R.id.rehberRecycler);
        RehberAdapter mAdapter = new RehberAdapter(this,lstContact);
        myRecycler.setLayoutManager(new LinearLayoutManager(this));
        myRecycler.setAdapter(mAdapter);



    }



}
