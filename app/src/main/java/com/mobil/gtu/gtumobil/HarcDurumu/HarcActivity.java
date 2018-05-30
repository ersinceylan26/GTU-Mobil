package com.mobil.gtu.gtumobil.HarcDurumu;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mobil.gtu.gtumobil.R;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by ersin on 4.03.2018.
 */

public class HarcActivity extends AppCompatActivity {

    TextView txOgrId2,txHarcMiktar2,txHarcOdenen2,txHarcKalan2,txHarcIade2;
    TextView txOgrId,txHarcMiktar,txHarcOdenen,txHarcKalan,txHarcIade;
    String harcMiktari,harcOdenen,ogrID,harcKalan,harcIade ;
    ProgressBar progressBar;
    String url = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harc_layout);

        progressBar = findViewById(R.id.harcProgressBar);

        url = "http://login.apollo.gtu.edu.tr/tr/Login?return=http%3a%2f%2flogin.apollo.gtu.edu.tr%2f";

        txOgrId = findViewById(R.id.harcId2);
        txHarcMiktar = findViewById(R.id.harcMiktari2);
        txHarcOdenen = findViewById(R.id.hardOdenen2);
        txHarcKalan = findViewById(R.id.harcKalan2);
        txHarcIade = findViewById(R.id.harcIade2);

        txOgrId2 = findViewById(R.id.harcId);
        txHarcMiktar2 = findViewById(R.id.harcMiktari);
        txHarcOdenen2 = findViewById(R.id.hardOdenen);
        txHarcKalan2 = findViewById(R.id.harcKalan);
        txHarcIade2 = findViewById(R.id.harcIade);

        txOgrId2.setVisibility(View.GONE);
        txHarcMiktar2.setVisibility(View.GONE);
        txHarcOdenen2.setVisibility(View.GONE);
        txHarcKalan2.setVisibility(View.GONE);
        txHarcIade2.setVisibility(View.GONE);

        progressBar.setVisibility(View.VISIBLE);

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

            progressBar.setVisibility(View.GONE);

            txOgrId2.setVisibility(View.VISIBLE);
            txHarcIade2.setVisibility(View.VISIBLE);
            txHarcMiktar2.setVisibility(View.VISIBLE);
            txHarcOdenen2.setVisibility(View.VISIBLE);
            txHarcKalan2.setVisibility(View.VISIBLE);
            txHarcIade2.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                String line;
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet("http://apiois.apollo.gtu.edu.tr/api/HarcSorgulama/Getir?ogrenciID=121044064");
                HttpResponse response2= client.execute(request);
                HttpEntity entity2 = response2.getEntity();
                InputStream in = entity2.getContent();

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                line = reader.readLine();

                JSONObject jsonObj = new JSONObject(line);

                harcMiktari = jsonObj.getString("HarcMiktari");
                harcOdenen = jsonObj.getString("Odenen");
                ogrID = jsonObj.getString("OgrID");
                harcKalan = jsonObj.getString("Kalan");
                harcIade = jsonObj.getString("Iade");

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





