package com.mobil.gtu.gtumobil;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mobil.gtu.gtumobil.AnaMenu.AnaMenuSortWayListActiviy;
import com.mobil.gtu.gtumobil.AnaMenu.MenuActivity;
import com.mobil.gtu.gtumobil.AnaMenu.MenuClass;
import com.mobil.gtu.gtumobil.AnaMenu.Veritabani;
import com.mobil.gtu.gtumobil.Etkinlik.EtkinlikMainActivity;
import com.mobil.gtu.gtumobil.Haberler.NewsListActivity;
import com.mobil.gtu.gtumobil.Rehber.RehberActivity;
import com.mobil.gtu.gtumobil.Ulasim.UlasimTasarim;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setIcon(R.drawable.iiicon);

        CardView cardViewUlasim = (CardView) findViewById(R.id.ulasim);
        CardView cardViewHaberler = (CardView) findViewById(R.id.haberler);
        //CardView cardViewLogin = (CardView) findViewById(R.id.login);
        CardView cardViewKisayolEkleCikar = (CardView) findViewById(R.id.kisayolekle);
        CardView cardViewEtkinlik = (CardView) findViewById(R.id.etkinlikler);
        CardView cardViewAcilTelefonlar = (CardView) findViewById(R.id.aciltelefonlar);

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
        cardViewHaberler.setOnClickListener(this);
        cardViewAcilTelefonlar.setOnClickListener(this);
        //cardViewLogin.setOnClickListener(this);
        cardViewKisayolEkleCikar.setOnClickListener(this);
        cardViewEtkinlik.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        /*Haber activity diğer projeden alınacak*/
        switch (view.getId()) {

            case R.id.aciltelefonlar : i = new Intent(this,RehberActivity.class);startActivity(i); break;
            case R.id.ulasim : i = new Intent(this,UlasimTasarim.class);startActivity(i); break ;
            case R.id.haberler : i = new Intent(this,NewsListActivity.class);startActivity(i); break ;
            case R.id.etkinlikler : i = new Intent(this,EtkinlikMainActivity.class);startActivity(i); break;
            case R.id.kisayolekle : i = new Intent(this,MenuActivity.class);startActivity(i); break;
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_notlar) {
            //Intent i = new Intent(this,RehberActivity.class);startActivity(i);
        } else if (id == R.id.nav_transkript) {
            //Intent i = new Intent(this,RehberActivity.class);startActivity(i);
        } else if (id == R.id.nav_yemekbakiye) {
            //Intent i = new Intent(this,RehberActivity.class);startActivity(i);
        } else if (id == R.id.nav_dersprogrami) {
            //Intent i = new Intent(this,RehberActivity.class);startActivity(i);
        } else if (id == R.id.nav_ulasim) {
            Intent i = new Intent(this,UlasimTasarim.class);startActivity(i);
        } else if (id == R.id.nav_haberler) {
            Intent i = new Intent(this,NewsListActivity.class);startActivity(i);
        } else if (id == R.id.nav_telefonlar) {
            Intent i = new Intent(this,RehberActivity.class);startActivity(i);
        } else if (id == R.id.nav_etkinlikler) {
            Intent i = new Intent(this,EtkinlikMainActivity.class);startActivity(i);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
