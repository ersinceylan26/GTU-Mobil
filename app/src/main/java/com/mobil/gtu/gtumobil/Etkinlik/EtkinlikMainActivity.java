package com.mobil.gtu.gtumobil.Etkinlik;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mobil.gtu.gtumobil.R;


/**
 * Created by ersin on 15.04.2018.
 */

public class EtkinlikMainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etkinlik);

        tabLayout = (TabLayout) findViewById(R.id.etkinlikTabLayout);
        viewPager = (ViewPager) findViewById(R.id.myViewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new FragmentGoster(),"");
        viewPagerAdapter.addFragment(new FragmentEkleme(),"");
        viewPagerAdapter.addFragment(new FragmentDuzenleme(),"");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.searchgeniswhite);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_add_circle_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.edit);

    }

}
