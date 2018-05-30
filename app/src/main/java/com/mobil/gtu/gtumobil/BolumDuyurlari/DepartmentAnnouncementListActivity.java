package com.mobil.gtu.gtumobil.BolumDuyurlari;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.mobil.gtu.gtumobil.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DepartmentAnnouncementListActivity extends AppCompatActivity
{

    private String newsListUrl="";
    private WebView wbNewList;
    String data="";
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_departments_list_layout);
        pb = findViewById(R.id.departmentsAnnouListProgressBar);

        Intent intent = this.getIntent();
        String facultyNumber = intent.getStringExtra("facultyNumber");
        String departmentName = intent.getStringExtra("departmentNumber");

        if(facultyNumber.equals("3"))
        {
            if(departmentName.equals("0"))
            {
                newsListUrl="http://www.gtu.edu.tr/kategori/8/0/display.aspx?languageId=1";
            }
            else if(departmentName.equals("1"))
            {
                newsListUrl="http://www.gtu.edu.tr/kategori/755/0/display.aspx?languageId=1";
            }
        }
        else if(facultyNumber.equals("2"))
        {
            if(departmentName.equals("0"))
            {
                newsListUrl="http://www.gtu.edu.tr/kategori/850/0/display.aspx?languageId=1";
            }
            else if(departmentName.equals("1"))
            {
                newsListUrl="http://www.gtu.edu.tr/kategori/849/0/display.aspx?languageId=1";
            }
        }
        else if(facultyNumber.equals("1"))
        {
            if(departmentName.equals("0"))
            {
                newsListUrl="http://www.gtu.edu.tr/kategori/627/0/display.aspx?languageId=1";
            }
            else if(departmentName.equals("1"))
            {
                newsListUrl="http://www.gtu.edu.tr/kategori/626/0/display.aspx?languageId=1";
            }
            else if(departmentName.equals("2"))
            {
                newsListUrl="http://www.gtu.edu.tr/kategori/578/0/display.aspx?languageId=1";
            }
            else if(departmentName.equals("3"))
            {
                newsListUrl="http://www.gtu.edu.tr/kategori/628/0/display.aspx?languageId=1";
            }
        }
        else if(facultyNumber.equals("0"))
        {
            if(departmentName.equals("0"))
            {
                newsListUrl="http://www.gtu.edu.tr/kategori/120/0/display.aspx?languageId=1";
            }
            else if(departmentName.equals("1"))
            {
                newsListUrl="http://www.gtu.edu.tr/kategori/2298/0/display.aspx?languageId=1";
            }
            else if(departmentName.equals("2"))
            {
                newsListUrl="http://www.gtu.edu.tr/kategori/420/0/display.aspx?languageId=1";
            }
            else if(departmentName.equals("3"))
            {
                newsListUrl="http://www.gtu.edu.tr/kategori/2404/0/display.aspx?languageId=1";
            }
            else if(departmentName.equals("4"))
            {
                newsListUrl="hhttp://www.gtu.edu.tr/kategori/422/0/display.aspx?languageId=1";
            }
            else if(departmentName.equals("5"))
            {
                newsListUrl="http://www.gtu.edu.tr/kategori/425/0/display.aspx?languageId=1";
            }
            else if(departmentName.equals("6"))
            {
                newsListUrl="http://www.gtu.edu.tr/kategori/421/0/display.aspx?languageId=1";
            }
            else if(departmentName.equals("7"))
            {
                newsListUrl="http://www.gtu.edu.tr/kategori/423/0/display.aspx?languageId=1";
            }
            else if(departmentName.equals("8"))
            {
                newsListUrl="http://www.gtu.edu.tr/kategori/424/0/display.aspx?languageId=1";
            }
        }

        wbNewList = findViewById(R.id.wbDepartmentsAnnouncment);
        wbNewList.getSettings().setJavaScriptEnabled(true);
        wbNewList.getSettings().setDefaultTextEncodingName("utf-8");
        wbNewList.setBackgroundColor(Color.TRANSPARENT);
        wbNewList.setWebViewClient(new WebViewClient()   {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Intent myIntent = new Intent(getBaseContext(), ContentActivity.class);
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

                for(int i = 0; hhh.size()> i && i < 20; i++) {
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
