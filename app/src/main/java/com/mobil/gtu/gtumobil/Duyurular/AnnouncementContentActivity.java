package com.mobil.gtu.gtumobil.Duyurular;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.mobil.gtu.gtumobil.R;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class AnnouncementContentActivity extends AppCompatActivity
{
    private WebView webviev;
    private String newUrl="";
    String data="";
    ProgressBar progressBar;

    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement_content_layout);

        progressBar = findViewById(R.id.announcementContentProgressbar);
        webviev = findViewById(R.id.wbAnnouncementContent);

        webviev.getSettings().setJavaScriptEnabled(true);
        webviev.getSettings().setDefaultTextEncodingName("utf-8");
        webviev.setBackgroundColor(Color.TRANSPARENT);

        Intent intent = getIntent();
        newUrl = intent.getStringExtra("nameUrl");

        new fetchData().execute();
    }

    public class fetchData extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            webviev.loadDataWithBaseURL(null,data,"text/html","UTF-8",null);
            progressBar.setVisibility(View.GONE);
        }

        @Override
        protected Void doInBackground(Void... voids) {


            try {
                Document newContent = Jsoup.connect(newUrl).get();
                Element style =newContent.head();
                Elements content_H2 = newContent.select("h2");
                Elements content_P = newContent.select("p");

                data+=style;
                data+=content_H2.outerHtml();
                data+="<br>";

                for(int i=0;i<content_P.size()-1;i++)
                {
                    data += content_P.get(i).outerHtml();
                    data+="<br>";
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

}
