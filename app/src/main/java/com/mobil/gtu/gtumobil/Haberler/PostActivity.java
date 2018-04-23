package com.mobil.gtu.gtumobil.Haberler;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.mobil.gtu.gtumobil.R;

import org.jsoup.nodes.Document;

public class PostActivity extends Activity implements PageDownloaded, AdapterView.OnItemSelectedListener {
    ProgressBar pb;
    Post post;
    WebView webView;
    Spinner spinner;
    private final String[] links = {
            "http://www.gtu.edu.tr/",
            "http://www.gtu.edu.tr/kategori/91/3/bilgisayar-muhendisligi.aspx", };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            post = (Post) extras.getSerializable("KEY");

        }

        webView =  findViewById(R.id.webview);

        pb = findViewById(R.id.progressBar);

        spinner = findViewById(R.id.announcement_spinner);

        if(post.getTitle().equals("announcement")){
            spinner.setOnItemSelectedListener(this);
        } else
            spinner.setVisibility(View.GONE);
        if(post!=null)
            loadURL(post.getLink());

    }

    @Override
    public void downloadCompleted(boolean status, Document document) {
        if(document!=null) {
            Log.d("downloadCompleted", "link: " + post.getLink() + " status: "  +status);
            webView.loadDataWithBaseURL(post.getLink(), document.toString(), "text/html", "utf-8","");
            webView.setVisibility(View.VISIBLE);
            pb.setVisibility(View.GONE);
        } else {
           // onBackPressed();
            Toast.makeText(getApplicationContext(), "Sayfa indirilemedi.", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setVerticalScrollBarEnabled(false);

        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                Log.d("shouldOverrideUrl", url +"");
                post.setLink(url);
                if(url.contains("Files")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
                else {
                    loadURL(url);
                }
                return true;
            }
        });
    }
    private void loadURL(String url){

        webView.setVisibility(View.GONE);
        pb.setVisibility(View.VISIBLE);

        new WebViewParser(this).execute(url, post.getTitle());
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d("onKeyDown", "");
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // On selecting a spinner item
        String url = adapterView.getItemAtPosition(i).toString();

        // Showing selected spinner item
        Toast.makeText(adapterView.getContext(), "Selected: " + url, Toast.LENGTH_LONG).show();
        loadURL(url);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
