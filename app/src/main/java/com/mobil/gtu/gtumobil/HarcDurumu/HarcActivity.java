package com.mobil.gtu.gtumobil.HarcDurumu;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.mobil.gtu.gtumobil.Login.LoginDatabase;
import com.mobil.gtu.gtumobil.Login.User;
import com.mobil.gtu.gtumobil.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ersin on 4.03.2018.
 */

public class HarcActivity extends AppCompatActivity {

    TextView txOgrId;
    TextView txHarcMiktar;
    TextView txHarcOdenen;
    TextView txHarcKalan;
    TextView txHarcIade;

    String harcMiktari;
    String harcOdenen ;
    String ogrID ;
    String harcKalan;
    String harcIade ;


    private String url = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harc_layout);

        url = "http://login.apollo.gtu.edu.tr/tr/Login?return=http%3a%2f%2flogin.apollo.gtu.edu.tr%2f";

        txOgrId = findViewById(R.id.harcId2);
        txHarcMiktar = findViewById(R.id.harcMiktari2);
        txHarcOdenen = findViewById(R.id.hardOdenen2);
        txHarcKalan = findViewById(R.id.harcKalan2);
        txHarcIade = findViewById(R.id.harcIade2);
        //vt.deleteData();

        new fetchNewsList().execute();

    }


    public class fetchNewsList extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPostExecute(Void aVoid) {
            txOgrId.setText(ogrID);
            txHarcMiktar.setText(harcMiktari);
            txHarcOdenen.setText(harcOdenen);
            txHarcKalan.setText(harcKalan);
            txHarcIade.setText(harcIade);

            Log.d("ersoooo", "asdasdasdasd");
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Document document = Jsoup.connect(url).get();
                StringBuilder sb = new StringBuilder();
                HttpClient client = new DefaultHttpClient();

                HttpGet request = new HttpGet("http://apiois.apollo.gtu.edu.tr/api/HarcSorgulama/Getir?ogrenciID=121044064");
                HttpResponse response2= client.execute(request);
                HttpEntity entity2 = response2.getEntity();
                InputStream in = entity2.getContent();

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line = "";
                int count =0;
                line = reader.readLine();
                Log.d("ersoooo", line);

                JSONObject jsonObj = new JSONObject(line.toString());

                harcMiktari = jsonObj.getString("HarcMiktari");
                harcOdenen = jsonObj.getString("Odenen");
                ogrID = jsonObj.getString("OgrID");
                harcKalan = jsonObj.getString("Kalan");
                harcIade = jsonObj.getString("Iade");


                Log.d("ersoooo", harcMiktari);
                Log.d("ersoooo", harcOdenen);
                Log.d("ersoooo", harcKalan);
                Log.d("ersoooo", harcIade);
                Log.d("ersoooo", ogrID);



                return null;

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

}





