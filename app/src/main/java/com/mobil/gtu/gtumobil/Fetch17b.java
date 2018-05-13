package com.mobil.gtu.gtumobil;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Fetch17b extends AppCompatActivity
{
    private ProgressDialog progressDialog;
    private WebView webviev;
    private String url="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news_list_layout);

        webviev = (WebView) findViewById(R.id.wb);
        url="http://www.iett.istanbul/tr/main/duraklar/212091/BAYRAMO%C4%9ELU-%C4%B0ETT-Duraktan-Ge%C3%A7en-Hatlar-Durak-Bilgileri-Hatt%C4%B1n-Duraktan-Ge%C3%A7i%C5%9F-Saatleri#StaionLiveData";
        webviev.getSettings().setJavaScriptEnabled(true);
        webviev.getSettings().setDefaultTextEncodingName("utf-8");
        new veriCek().execute();


    }


    public class veriCek extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Document document = Jsoup.connect(url).get();
                Elements element = document.select("td.td_LineEstimated");

                Log.d("gtu yonu", "asdasd");


                Log.d("gtu yonu", element.get(0).text().toString());
                Log.d("asdsad", element.text().toString());



            } catch (IOException e) {
                e.printStackTrace();
            }



            return null;
        }
    }
}
