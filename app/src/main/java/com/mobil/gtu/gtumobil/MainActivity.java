package com.mobil.gtu.gtumobil;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.mobil.gtu.gtumobil.AnaMenu.MenuActivity;
import com.mobil.gtu.gtumobil.AnaMenu.MenuClass;
import com.mobil.gtu.gtumobil.AnaMenu.Veritabani;
import com.mobil.gtu.gtumobil.BolumDuyurlari.DepartmentAcitivity;
import com.mobil.gtu.gtumobil.BolumDuyurlari.FacultyAcitivity;
import com.mobil.gtu.gtumobil.Etkinlik.EtkinlikMainActivity;
import com.mobil.gtu.gtumobil.Haberler.NewsListActivity;
import com.mobil.gtu.gtumobil.Login.LoginActivity;
import com.mobil.gtu.gtumobil.Rehber.RehberActivity;
import com.mobil.gtu.gtumobil.Ulasim.UlasimActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cardViewUlasim = (CardView) findViewById(R.id.ulasim);
        CardView cardViewHaberler = (CardView) findViewById(R.id.haberler);
        CardView cardViewLogin = (CardView) findViewById(R.id.login);
        CardView cardViewEtkinlik = (CardView) findViewById(R.id.etkinlikler);
        CardView cardViewAcilTelefonlar = (CardView) findViewById(R.id.aciltelefonlar);
        CardView cardViewBolumDuyulari = (CardView) findViewById(R.id.bolumduyulari);

        TextView aa = (TextView) findViewById(R.id.Title);

        Veritabani vt = new Veritabani(MainActivity.this);
        List<MenuClass> veriler = new ArrayList<MenuClass>();
        veriler=vt.VeriListele();

        for(int i =0;i<veriler.size();i++)
        {
            if(i==0)
            {
                if(!veriler.get(0).isSelected())
                {
                    cardViewUlasim.setVisibility(View.GONE);
                }

            }
            if(i==1)
            {
                if(!veriler.get(1).isSelected())
                {
                    cardViewHaberler.setVisibility(View.GONE);
                }
            }
            if(i==2)
            {
                if(!veriler.get(2).isSelected())
                {
                    cardViewAcilTelefonlar.setVisibility(View.GONE);
                }
            }
            if(i==3)
            {
                if(!veriler.get(3).isSelected())
                {

                }
            }
            if(i==4)
            {
                if(!veriler.get(4).isSelected())
                {
                    cardViewEtkinlik.setVisibility(View.GONE);
                }
            }
        }

        cardViewUlasim.setOnClickListener(this);
        cardViewBolumDuyulari.setOnClickListener(this);
        cardViewHaberler.setOnClickListener(this);
        cardViewAcilTelefonlar.setOnClickListener(this);
        cardViewLogin.setOnClickListener(this);
        cardViewEtkinlik.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;

                i = new Intent(MainActivity.this,MenuActivity.class);startActivity(i);


            }
        });

    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()) {

            case R.id.aciltelefonlar : i = new Intent(this,RehberActivity.class);startActivity(i); break;
            case R.id.ulasim : i = new Intent(this,UlasimActivity.class);startActivity(i); break ;
            case R.id.haberler : i = new Intent(this,NewsListActivity.class);startActivity(i); break ;
            case R.id.etkinlikler : i = new Intent(this,EtkinlikMainActivity.class);startActivity(i); break;
            case R.id.bolumduyulari : i = new Intent(this,FacultyAcitivity.class);startActivity(i); break;
            case R.id.login : i = new Intent(this,LoginActivity.class);startActivity(i); break;
            default:break;

        }

    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        // do some stuff here
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
