package com.mobil.gtu.gtumobil.Ulasim;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.mobil.gtu.gtumobil.R;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ersin on 14.04.2018.
 */

public class UlasimActivity extends AppCompatActivity
{
    Button button490, buttonRing;
    UlasimAdapter ulasimAdapter;
    List<UlasimParent> parents;
    RecyclerView recyclerView;
    ImageButton expandSearch;
    Elements element17B;
    String url490="";
    String url17B="";
    ProgressBar pb;
    String data="";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulasim_tasarim);

        url490="http://www.kocaeli.bel.tr/tr/main/hatlar/490";
        url17B="http://www.iett.istanbul/tr/main/duraklar/212091/BAYRAMO%C4%9ELU-%C4%B0ETT-Duraktan-Ge%C3%A7en-Hatlar-Durak-Bilgileri-Hatt%C4%B1n-Duraktan-Ge%C3%A7i%C5%9F-Saatleri#StaionLiveData";
        pb = findViewById(R.id.ulasimProgressBar);
        recyclerView = findViewById(R.id.myRecyclerView);
        expandSearch = findViewById(R.id.expandSearch);

        recyclerView.animate()
                .translationY(0)
                .setDuration(1000)
                .setStartDelay(300);

        new fetchData().execute();

        button490 = findViewById(R.id.loginButton11);
        buttonRing = findViewById(R.id.loginButton33);

        button490.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UlasimActivity.this, TableActivity.class);
                startActivity(intent);
            }
        });

    }

    public List<UlasimParent> getParents(Elements onYediB) {

        parents = new ArrayList<>(6);
        List<UlasimChild> children = new ArrayList<>(3);

        List<UlasimChild> onYediBList = new ArrayList<>(onYediB.size());

        for (int i=0;i<onYediB.size();i++)
        {
            onYediBList.add(new UlasimChild(onYediB.get(i).text().toString()));
        }

        children.add(new UlasimChild("aaaa"));
        children.add(new UlasimChild("asdaaaasd"));
        children.add(new UlasimChild("asdaaaaaaaaaasd"));

        parents.add(new UlasimParent("17B (Pendik Yönü)", onYediBList));
        parents.add(new UlasimParent("17B (Gebze Yönü)", children));
        parents.add(new UlasimParent("490 (Gebze Yönü)", children));
        parents.add(new UlasimParent("490 (KYK Yönü)", children));
        parents.add(new UlasimParent("Ring (Danışma Hareket)", children));
        parents.add(new UlasimParent("Ring (Kimya Hareket)", children));

        return parents;
    }

    public class fetchData extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            getParents(element17B);
            ulasimAdapter = new UlasimAdapter(parents);

            recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            recyclerView.setAdapter(ulasimAdapter);

            pb.setVisibility(View.GONE);

            button490.setVisibility(View.VISIBLE);
            buttonRing.setVisibility(View.VISIBLE);

        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Document document490 = Jsoup.connect(url490).get();
                Elements element490 = document490.select("div.col-md-6.col");
                Element style = document490.head();
                Elements content = element490.select("tbody");

                data+=style;
                data+=content.get(2).outerHtml();

                Document document17B = Jsoup.connect(url17B).get();
                element17B = document17B.select("td.td_LineEstimated");

                String info = element490.get(2).text().toString();

                String[] infows = info.split(" ");

                ArrayList<OneRowUlasim> allInfo = new ArrayList<>();

                for(int i = 10; i<infows.length-3;i=i+4)
                {
                    allInfo.add(new OneRowUlasim(infows[i],infows[i+1],infows[i+2],infows[i+3]));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPreExecute() { }

    }

}
