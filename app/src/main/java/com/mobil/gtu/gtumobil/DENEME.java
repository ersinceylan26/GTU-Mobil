package com.mobil.gtu.gtumobil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.RelativeLayout;

public class DENEME extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deneme);

        CardView b= findViewById(R.id.denemehaberler);
        CardView x= findViewById(R.id.denemeulasim2);
        CardView a= findViewById(R.id.transkript);

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)b.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        b.setLayoutParams(params); //causes layout updat

        RelativeLayout.LayoutParams paramss = (RelativeLayout.LayoutParams)a.getLayoutParams();
        paramss.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        a.setLayoutParams(paramss); //causes layout updat

        RelativeLayout.LayoutParams paramsss = (RelativeLayout.LayoutParams)x.getLayoutParams();
        paramsss.addRule(RelativeLayout.CENTER_HORIZONTAL,RelativeLayout.TRUE);
        x.setLayoutParams(paramsss); //causes layout updat


    }
}
