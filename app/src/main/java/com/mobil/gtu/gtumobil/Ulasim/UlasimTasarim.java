package com.mobil.gtu.gtumobil.Ulasim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mobil.gtu.gtumobil.R;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ersin on 14.04.2018.
 */

public class UlasimTasarim extends AppCompatActivity
{
    RecyclerView recyclerView;
    UlasimAdapter ulasimAdapter;
    List<Parent> parents;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulasim_tasarim);
        getParents();
        ulasimAdapter = new UlasimAdapter(parents);

        recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(ulasimAdapter);



    }

    public List<Parent> getParents() {

        parents = new ArrayList<>(6);
        List<Child> children = new ArrayList<>(3);

        children.add(new Child("asdasd"));
        children.add(new Child("asdasd"));
        children.add(new Child("asdasd"));


        parents.add(new Parent("17B (Pendik Yönü)", children));

        parents.add(new Parent("17B (Gebze Yönü)", children));

        parents.add(new Parent("490 (Pendik Yönü)", children));

        parents.add(new Parent("490 (Pendik Yönü)", children));

        parents.add(new Parent("Ring (Danışma Hareket)", children));

        parents.add(new Parent("Ring (Kimya Hareket)", children));


        return parents;
    }
}
