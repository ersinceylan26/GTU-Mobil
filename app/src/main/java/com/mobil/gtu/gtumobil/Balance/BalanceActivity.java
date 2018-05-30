package com.mobil.gtu.gtumobil.Balance;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.mobil.gtu.gtumobil.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class BalanceActivity extends AppCompatActivity
{
    private ProgressDialog progressDialog;
    private WebView webviev;
    private String newUrl="";
    String data="";
    ProgressBar pb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_layout);

        pb = findViewById(R.id.balanceContentProgressBar);

        webviev = (WebView) findViewById(R.id.wbBalance);
        webviev.getSettings().setJavaScriptEnabled(true);
        webviev.getSettings().setDefaultTextEncodingName("utf-8");
        webviev.getSettings().setDomStorageEnabled(true);
        webviev.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webviev.setBackgroundColor(Color.TRANSPARENT);
        webviev.getSettings().setJavaScriptEnabled(true);
        webviev.getSettings().setAppCacheEnabled(true);
        webviev.getSettings().setDatabaseEnabled(true);
        webviev.getSettings().setDomStorageEnabled(true);
        webviev.getSettings().setSupportZoom(true);
        webviev.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webviev.getSettings().setBuiltInZoomControls(true);
        //webviev.setWebViewClient(new GeoWebViewClient());
        webviev.loadUrl("https://aks.gtu.edu.tr/");

        webviev.getSettings().setGeolocationEnabled(true);


        webviev.setWebViewClient(new WebViewClient(){
           /* @Override
            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {

                handler.proceed();
            }*/
        });


        newUrl = "https://aks.gtu.edu.tr/";

        //new fetchData().execute();

    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Uri.parse(url).getHost().equals(URL)) {
                // This is your web site, so do not override; let the WebView to load the page
                return false;
            }
            // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);

            // this will ignore the Ssl error and will go forward to your site
            handler.proceed();
        }
    }

}
