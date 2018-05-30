package com.mobil.gtu.gtumobil.AcademicCalendar;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.mobil.gtu.gtumobil.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class AcademicCalendarActivity extends AppCompatActivity
{
    private WebView webView;
    private String newUrl="";
    String data="";
    ProgressBar progressDialog;

    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_calendar_layout);
        progressDialog = findViewById(R.id.academicCalendarProgressBar);
        webView = findViewById(R.id.wbAcademicCalendarContent);

        webView.getSettings().setDefaultTextEncodingName("utf-8");
        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.setInitialScale(1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);
        newUrl = "http://www.gtu.edu.tr/icerik/1318/436/akademik-takvim.aspx";
        progressDialog.setVisibility(View.VISIBLE);
        new fetchData().execute();

    }

    @SuppressLint("StaticFieldLeak")
    public class fetchData extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            webView.loadDataWithBaseURL(null,data,"text/html","UTF-8",null);
            progressDialog.setVisibility(View.GONE);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Document newContent = Jsoup.connect(newUrl).get();
                Element style = newContent.head();
                Elements content_P = newContent.select("div#main-content.col-md-9.col-md-push-3");

                data+=style;
                data+="<br>";

                for(int i=0;i<content_P.size();i++)
                {
                    data += content_P.get(i).outerHtml();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

}
