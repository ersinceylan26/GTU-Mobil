package com.mobil.gtu.gtumobil.Haberler;

import android.os.AsyncTask;
import android.os.CountDownTimer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 *
 * Created by yasinacikgoz on 25.02.2018.
 */



public class WebViewParser extends AsyncTask<String,Void,Void> {
    private PageDownloaded listener;
    private boolean parceSuccess = false;
    private Document document;
    public WebViewParser(PageDownloaded listener){
        this.listener=listener;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Void doInBackground(String... strings) {
        try {
            if(strings[0].contains("gtu.edu.tr")) {

                System.out.println("---------------");
                document = Jsoup.connect(strings[0]).get();
                Element e1, e2, e3;
                Elements e4, e5;
                if(strings[1].equals("announcement")){


                    e1 = document.getElementById("header");
                    e2 = document.getElementById("social-icons");
                    e3 = document.getElementById("mainmenu");
                    e4 = document.getElementsByClass("col-sm-9");
                    e5 = document.getElementsByClass("footer");
                    Elements e6, e7, e8;
                    e6 = document.getElementsByClass("container  margin-bottom-20");
                    e7 = document.getElementsByClass("sosyalYasam");
                    e8 = document.getElementsByClass("tweet-live-stream");
                    if(e1 == null || e2 == null || e3 == null ||e4 == null || e5 == null || e6 == null || e7 == null || e8 == null){
                        parceSuccess = false;
                    } else{
                        e1.remove(); e2.remove(); e3.remove(); e4.remove(); e5.remove(); e6.remove(); e7.remove(); e8.remove();
                        parceSuccess = true;
                    }

                } else{
                    e1 = document.getElementById("header");
                    e2 = document.getElementById("sidebar-first");
                    e3 = document.getElementById("mainmenu");
                   // Element e6 = document.getElementById("footer");
                    e4 = document.getElementsByClass("footer");
                    e5 = document.getElementsByClass("breadcrumb");

                    if(e1 == null || e2 == null ||e3 == null ||e4 == null || e5 == null){
                        parceSuccess = false;
                    } else{
                        e1.remove(); e2.remove(); e3.remove(); e4.remove(); e5.remove();
                        parceSuccess = true;
                    }

                }

            } else
                parceSuccess = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.downloadCompleted(parceSuccess, document);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        new CountDownTimer(5000, 5000) {
            public void onTick(long millisUntilFinished) {
                // You can monitor the progress here as well by changing the onTick() time
            }
            public void onFinish() {
                // stop async task if not in progress
                if(document !=null){
                    //if(listener!=null)
                    listener.downloadCompleted(parceSuccess,document);
                    this.cancel();
                } else
                    listener.downloadCompleted(false,null);
            }
        }.start();
    }

}