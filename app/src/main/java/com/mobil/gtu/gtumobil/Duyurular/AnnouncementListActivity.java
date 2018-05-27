package com.mobil.gtu.gtumobil.Duyurular;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.mobil.gtu.gtumobil.Haberler.NewContentActivity;
import com.mobil.gtu.gtumobil.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class AnnouncementListActivity extends AppCompatActivity
{

    private String newsListUrl="";
    private WebView wbNewList;
    String data="";
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_announcement_list_layout);

        pb = findViewById(R.id.announcementsListProgressBar);

        wbNewList = findViewById(R.id.wbAnnouncement);
        newsListUrl="http://www.gtu.edu.tr/kategori/9/0/display.aspx?languageId=1";
        wbNewList.getSettings().setJavaScriptEnabled(true);
        wbNewList.getSettings().setDefaultTextEncodingName("utf-8");
        wbNewList.setBackgroundColor(Color.TRANSPARENT);

        wbNewList.setWebViewClient(new WebViewClient()   {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Intent myIntent = new Intent(getBaseContext(), AnnouncementContentActivity.class);
                myIntent.putExtra("nameUrl", url);
                startActivity(myIntent);
                return true;
            }

        });

        new fetchNewsList().execute();
    }


    public class fetchNewsList extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            wbNewList.loadDataWithBaseURL(null,data,"text/html","UTF-8",null);
            pb.setVisibility(View.GONE);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Document newsListContent = Jsoup.connect(newsListUrl).get();

                Element style = newsListContent.head();
                Elements newList = newsListContent.select("div#more-news");
                Elements hhh = newList.select("li");

                data+=style;
                data+="<ul>";

                for(int i = 0; i < 20; i++) {
                    data += hhh.get(i).toString();
                    data+="<br>";
                }

                data+="</ul>";

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

    }

}
