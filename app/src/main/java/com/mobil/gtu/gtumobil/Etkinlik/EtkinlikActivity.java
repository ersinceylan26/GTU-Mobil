package com.mobil.gtu.gtumobil.Etkinlik;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobil.gtu.gtumobil.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ersin on 31.03.2018.
 */

public class EtkinlikActivity  extends AppCompatActivity
{
    Button send ;
    TextView etkinlikBasligi;
    TextView etkinlikTarihi ;
    TextView etkinlikMekani;
    TextView etkinlikMuracaat ;
    TextView etkinlikAciklamasi ;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    int loginID = 121044064;
    int etkinlikStatus=0;

    ArrayList<String> keys = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etkinlik_ekleme);

        etkinlikBasligi = (TextView) findViewById(R.id.etkinlikBasligi);
        etkinlikTarihi = (TextView) findViewById(R.id.etkinlikTarihi);
        etkinlikMekani = (TextView) findViewById(R.id.etkinlikMekani);
        etkinlikMuracaat = (TextView) findViewById(R.id.etkinlikMuracaat);
        etkinlikAciklamasi = (TextView) findViewById(R.id.etkinlikAciklama);
        send = (Button) findViewById(R.id.etkinlikSend);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                StringBuilder sb = new StringBuilder();

                FireBaseDataMap obj = new FireBaseDataMap();
                HashMap<String, String> dataMap = obj.fireebaseMap();

                dataMap.put("loginID", Integer.toString(loginID));
                dataMap.put("etkinlikBasligi",(etkinlikBasligi.getText().toString()));
                dataMap.put("etkinlikTarihi",(etkinlikTarihi.getText().toString()));
                dataMap.put("etkinlikMekani",(etkinlikMekani.getText().toString()));
                dataMap.put("etkinlikMuracaat",(etkinlikMuracaat.getText().toString()));
                dataMap.put("etkinlikAciklamasi",(etkinlikAciklamasi.getText().toString()));

                //myRef.child("Etkinliler").child(Integer.toString(loginID)).child("1").setValue(sb.toString());

                if(etkinlikStatus==0)
                {
                    myRef.child("Etkinliler").child(Integer.toString(loginID)).child("0").setValue(dataMap);
                    myRef.child("EtkinlikSayaci").child(Integer.toString(loginID)).setValue("1");
                }
                else
                {
                    myRef.child("Etkinliler").child(Integer.toString(loginID)).child(Integer.toString(etkinlikStatus)).setValue(dataMap);
                    etkinlikStatus++;
                    myRef.child("EtkinlikSayaci").child(Integer.toString(loginID)).setValue(Integer.toString(etkinlikStatus));
                }

            }
        });



        // Read from the database
        myRef.child("EtkinlikSayaci").child(Integer.toString(loginID)).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);

                if(value==null)
                {
                    etkinlikStatus=0;
                }
                else
                {
                    etkinlikStatus = Integer.parseInt(value);
                }

                Log.d("adasd", "Sayac " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("asda", "Failed to read value.", error.toException());
            }
        });






    }




}
