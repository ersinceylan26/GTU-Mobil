package com.mobil.gtu.gtumobil.Rehber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.mobil.gtu.gtumobil.R;
import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity
{
    RecyclerView myRecycler;
    List<Contact> lstContact;
    List<Contact> lstContactSearch;
    Button guideSearch;
    EditText guideSearchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        lstContact = new ArrayList<>();
        lstContactSearch = new ArrayList<>();

        lstContact.add(new Contact("Yusuf Sinan Akgül","Öğretim Üyesi","0 (212) 333 22 11","yusufsinan@gtu.edu.tr"));
        lstContact.add(new Contact("Mehmet Göktürk","Öğretim Üyesi","0 (212) 444 22 11","mgokturk@gtu.edu.tr"));
        lstContact.add(new Contact("Hasari Çelebi","Öğretim Üyesi","0 (212) 555 22 11","hasaricelebi@gtu.edu.tr"));
        lstContact.add(new Contact("Meral Şahin","Bil. Müh. Sekreterlik","0 (212) 666 22 11","meralsahin@gtu.edu.tr"));

        myRecycler = findViewById(R.id.guideRecycler);
        GuideAdapter mAdapter = new GuideAdapter(this,lstContact);
        myRecycler.setLayoutManager(new LinearLayoutManager(this));
        myRecycler.setAdapter(mAdapter);

        guideSearch = findViewById(R.id.guideSearchButton);
        guideSearchText = findViewById(R.id.guideSearchTxt);

        guideSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lstContactSearch.clear();

                for(int i = 0 ; i < lstContact.size();i++)
                {
                   if(lstContact.get(i).getName().toUpperCase().contains(guideSearchText.getText().toString().toUpperCase())
                           ||lstContact.get(i).getUnvan().toUpperCase().contains(guideSearchText.getText().toString().toUpperCase()))
                   {
                       lstContactSearch.add(lstContact.get(i));
                   }
                }

                myRecycler = findViewById(R.id.guideRecycler);
                GuideAdapter mAdapter = new GuideAdapter(getApplicationContext(),lstContactSearch);
                myRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                myRecycler.setAdapter(mAdapter);
            }
        });

    }
}
