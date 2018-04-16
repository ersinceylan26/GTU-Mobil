package com.mobil.gtu.gtumobil.Ulasim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.mobil.gtu.gtumobil.R;
import com.mobil.gtu.gtumobil.Ulasim.Adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ersin on 14.04.2018.
 */

public class UlasimTasarim extends AppCompatActivity
{
    RecyclerView recyclerView;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyAdapter) recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulasim_tasarim);

        recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter(this,initData());
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);

        recyclerView.setAdapter(adapter);


    }

    private List<ParentObject> initData()
    {
        TitleCreator titleCreator = TitleCreator.get(this);
        List<TitleParent> titles = titleCreator.getAll();
        List<ParentObject> parentObjects = new ArrayList<>();

        for(TitleParent title: titles)
        {
            List<Object> childList = new ArrayList<>();
            childList.add(new TitleChild("Add to contacts","SendMessage"));
            title.setChildObjectList(childList);
            parentObjects.add(title);
        }

        return parentObjects;

    }



}
