package com.mobil.gtu.gtumobil;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.mobil.gtu.gtumobil.AcademicCalendar.AcademicCalendarActivity;
import com.mobil.gtu.gtumobil.AnaMenu.MenuActivity;
import com.mobil.gtu.gtumobil.AnaMenu.MenuClass;
import com.mobil.gtu.gtumobil.AnaMenu.Veritabani;
import com.mobil.gtu.gtumobil.Balance.BalanceActivity;
import com.mobil.gtu.gtumobil.BolumDuyurlari.FacultyAcitivity;
import com.mobil.gtu.gtumobil.Duyurular.AnnouncementListActivity;
import com.mobil.gtu.gtumobil.Etkinlik.EtkinlikMainActivity;
import com.mobil.gtu.gtumobil.FoodMenu.FoodMenuActivity;
import com.mobil.gtu.gtumobil.Haberler.NewsListActivity;
import com.mobil.gtu.gtumobil.HarcDurumu.HarcActivity;
import com.mobil.gtu.gtumobil.Login.LoginActivity;
import com.mobil.gtu.gtumobil.Rehber.GuideActivity;
import com.mobil.gtu.gtumobil.Ulasim.UlasimActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<CardView> allCardView = new ArrayList<>();

        CardView cardViewUlasim = findViewById(R.id.ulasim);
        allCardView.add(cardViewUlasim);
        CardView cardViewHaberler = findViewById(R.id.haberler);
        allCardView.add(cardViewHaberler);
        CardView cardViewAcilTelefonlar = findViewById(R.id.aciltelefonlar);
        allCardView.add(cardViewAcilTelefonlar);
        CardView cardViewGtuDuyurular = findViewById(R.id.gtuDuyurular);
        allCardView.add(cardViewGtuDuyurular);
        CardView cardViewEtkinlik = findViewById(R.id.etkinlikler);
        allCardView.add(cardViewEtkinlik);
        CardView cardViewTranskript = findViewById(R.id.transkript);
        allCardView.add(cardViewTranskript);
        CardView cardViewFoodBalance = findViewById(R.id.yemekBakiye);
        allCardView.add(cardViewFoodBalance);
        CardView cardViewBolumDuyulari = findViewById(R.id.bolumduyulari);
        allCardView.add(cardViewBolumDuyulari);
        CardView cardViewFoodMenu = findViewById(R.id.foodMenu);
        allCardView.add(cardViewFoodMenu);
        CardView cardViewAcademicCalendar = findViewById(R.id.academicCalendar);
        allCardView.add(cardViewAcademicCalendar);
        CardView cardViewLogin = findViewById(R.id.login);
        allCardView.add(cardViewLogin);
        CardView cardViewHarcDurumu = findViewById(R.id.harcDurumu);
        allCardView.add(cardViewHarcDurumu);
        CardView cardViewAboutUs = findViewById(R.id.aboutUs);
        allCardView.add(cardViewAboutUs);

        Veritabani vt = new Veritabani(MainActivity.this);
        List<MenuClass> veriler =vt.VeriListele();

        CardView leftCornerCv=null;
        CardView rightCornerCv=null;
        CardView centerCv=null;
        int count=0;
        int index;

        for(index=0;index<veriler.size();index++)
        {
            if(veriler.get(index).isSelected()) {
                count++;
                if (count == 1) {
                    leftCornerCv = allCardView.get(index);
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)leftCornerCv.getLayoutParams();
                    params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                    leftCornerCv.setLayoutParams(params);

                }
                else if (count == 2) {
                    rightCornerCv = allCardView.get(index);
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)rightCornerCv.getLayoutParams();
                    params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                    rightCornerCv.setLayoutParams(params);
                }
                else if (count == 3) {
                    centerCv = allCardView.get(index);
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)centerCv.getLayoutParams();
                    params.addRule(RelativeLayout.CENTER_HORIZONTAL,RelativeLayout.TRUE);
                    centerCv.setLayoutParams(params);
                    count=0;
                    break;

                }
            }
        }

        for(int i=index+1;i<veriler.size();i++)
        {
            if(veriler.get(i).isSelected())
            {
                count++;
                if(count==1){
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)allCardView.get(i).getLayoutParams();
                    params.addRule(RelativeLayout.BELOW, rightCornerCv.getId());
                    params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                    allCardView.get(i).setLayoutParams(params);
                    rightCornerCv=allCardView.get(i);
                }
                else if(count==2){
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)allCardView.get(i).getLayoutParams();
                    params.addRule(RelativeLayout.BELOW, centerCv.getId());
                    params.addRule(RelativeLayout.CENTER_HORIZONTAL,RelativeLayout.TRUE);
                    allCardView.get(i).setLayoutParams(params);
                    centerCv=allCardView.get(i);
                }
                else if(count==3){
                    count=0;
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)allCardView.get(i).getLayoutParams();
                    params.addRule(RelativeLayout.BELOW, leftCornerCv.getId());
                    allCardView.get(i).setLayoutParams(params);
                    leftCornerCv=allCardView.get(i);
                }
            }
            else
                allCardView.get(i).setVisibility(View.GONE);
        }

        cardViewUlasim.setOnClickListener(this);
        cardViewBolumDuyulari.setOnClickListener(this);
        cardViewHaberler.setOnClickListener(this);
        cardViewAcilTelefonlar.setOnClickListener(this);
        cardViewLogin.setOnClickListener(this);
        cardViewEtkinlik.setOnClickListener(this);
        cardViewGtuDuyurular.setOnClickListener(this);
        cardViewAcademicCalendar.setOnClickListener(this);
        cardViewFoodBalance.setOnClickListener(this);
        cardViewHarcDurumu.setOnClickListener(this);
        cardViewFoodMenu.setOnClickListener(this);
        cardViewAboutUs.setOnClickListener(this);

        FloatingActionButton fab = findViewById(R.id.fab);
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
            case R.id.aciltelefonlar : i = new Intent(this,GuideActivity.class);startActivity(i); break;
            case R.id.ulasim : i = new Intent(this,UlasimActivity.class);startActivity(i); break ;
            case R.id.haberler : i = new Intent(this,NewsListActivity.class);startActivity(i); break ;
            case R.id.etkinlikler : i = new Intent(this,EtkinlikMainActivity.class);startActivity(i); break;
            case R.id.bolumduyulari : i = new Intent(this,FacultyAcitivity.class);startActivity(i); break;
            case R.id.login : i = new Intent(this,LoginActivity.class);startActivity(i); break;
            case R.id.gtuDuyurular : i = new Intent(this,AnnouncementListActivity.class);startActivity(i); break;
            case R.id.academicCalendar : i = new Intent(this,AcademicCalendarActivity.class);startActivity(i); break;
            case R.id.yemekBakiye : i = new Intent(this,BalanceActivity.class);startActivity(i); break;
            case R.id.harcDurumu : i = new Intent(this,HarcActivity.class);startActivity(i); break;
            case R.id.foodMenu : i = new Intent(this,FoodMenuActivity.class);startActivity(i); break;
            default:break;
        }
    }

    @Override
    public void onRestart() { super.onRestart(); }
    @Override
    protected void onPause() { super.onPause(); }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
