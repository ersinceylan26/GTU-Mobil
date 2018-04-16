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

public class FragmentGoster extends Fragment {

    View v;
    private ProgressDialog progressDialog;

    private RecyclerView myRecyclerView;
    private List<EtkinlikNoMoreClass> dataEtkinlik;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    ArrayList<String> keys ;

    public FragmentGoster(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        Log.d("onCreateView", "Girdim ");

        v = inflater.inflate(R.layout.activity_etkinlik_gosterrr,container,false);
        mymehtod2();
        mymehtod();
        myRecyclerView = (RecyclerView) v.findViewById(R.id.etkinlikListRecycler);


        Log.d("onCreateView", "Ciktim ");
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        //new BackgroundTask().execute((Void) null);

        super.onCreate(savedInstanceState);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }
    public void mymehtod2() {

        keys = new ArrayList<>();
        // Read from the database
        myRef.child("Etkinliler").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                HashMap<String,String> value = (HashMap<String, String>) dataSnapshot.getValue(Boolean.parseBoolean("121044064"));
                //Log.d("Deger", "Sayac ");

                Iterator it = value.entrySet().iterator();

                //Log.d("Deger", String.valueOf(value.size()));

                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    System.out.println(pair.getKey());
                    Log.w("KEY", pair.getKey().toString());
                    keys.add(pair.getKey().toString());
                }

                mymehtod();

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("asda", "Failed to read value.", error.toException());
            }
        });


    }

    public void mymehtod()
    {
        dataEtkinlik = new ArrayList<>();
        for(int j =0 ; j<keys.size();j++)
        {
            Log.w("GIRDIM", "ZZZAAAA.");
            myRef.child("Etkinliler").child(keys.get(j)).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    ArrayList<HashMap<String,String >> value = (ArrayList<HashMap<String,String >>) dataSnapshot.getValue();
                    Log.d("Deger", "Sayac ");

                    for(int i=0;i<value.size();i++)
                    {
                        Log.d("Deger", value.get(i).get("etkinlikBasligi"));

                        EtkinlikNoMoreClass yeni = new EtkinlikNoMoreClass(value.get(i).get("etkinlikBasligi"),value.get(i).get("etkinlikTarihi"));

                        for(int k = 0 ; k < dataEtkinlik.size();k++)
                        {
                            Log.d("Etkinlik Basligi Yeni", yeni.getEtkinlikBasligi());
                            Log.d("Etkinlik Basligi data", dataEtkinlik.get(k).getEtkinlikBasligi());

                            if(yeni.getEtkinlikBasligi()==dataEtkinlik.get(k).getEtkinlikBasligi())
                            {
                                dataEtkinlik.remove(k);
                            }
                        }

                        dataEtkinlik.add(yeni);
                    }

                    Log.d("Boyut", Integer.toString(dataEtkinlik.size()));

                    RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),dataEtkinlik);
                    myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    myRecyclerView.setAdapter(recyclerViewAdapter);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w("asda", "Failed to read value.", error.toException());
                }
            });
        }


    }

}














