package com.mobil.gtu.gtumobil.Etkinlik;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobil.gtu.gtumobil.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by ersin on 15.04.2018.
 */

public class FragmentDuzenleme extends Fragment {

    View v;

    public FragmentDuzenleme(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        Log.d("onCreateView", "Girdim ");

        v = inflater.inflate(R.layout.activity_etkinlik_duzenleme,container,false);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        //new BackgroundTask().execute((Void) null);

        super.onCreate(savedInstanceState);


    }

}














