package com.mobil.gtu.gtumobil.Login;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


import com.mobil.gtu.gtumobil.R;


import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import java.net.URL;


/**
 * Created by ersin on 4.03.2018.
 */

public class LoginActivity extends AppCompatActivity {

    EditText editTextPass,editTextMail;
    CheckBox rememberMe;
    TextView errorCase;
    Button loginButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        rememberMe = findViewById(R.id.rememberMe);
        loginButton = findViewById(R.id.loginButton);
        editTextPass = findViewById(R.id.editTextPass);
        editTextMail = findViewById(R.id.editTextMail);
        errorCase = findViewById(R.id.errorCase);

        final User user;
        final LoginDatabase vt = new LoginDatabase(LoginActivity.this);

        user = vt.fetchData();

        if(user.getPassword()!=null || user.getName()!=null)
        {
            editTextMail.setText(user.getName());
            editTextPass.setText(user.getPassword());
            editTextMail.setFocusable(false);
            editTextMail.setEnabled(false);
            editTextPass.setFocusable(false);
            editTextPass.setEnabled(false);
        }
        else
        {
            /*ProgressDialog progress;

            progress = new ProgressDialog(this);
            progress.setTitle("Login");
            progress.setMessage("Giriş Yapılıyor");
            progress.setCancelable(false);
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.show();*/

            // Auth işlemi yaptırılacak

        }

        Log.d("yasa",user.getName()+user.getPassword());

        new fetchNewsList().execute();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(editTextPass.getText().equals("") || editTextMail.equals(""))
                {
                    Log.w("errorgeldi", user.getName() + user.getPassword());
                    errorCase.setText("* Tüm Alanları Doldurunuz.");
                    errorCase.setVisibility(View.VISIBLE);
                }
                else
                {
                    user.setName(editTextMail.getText().toString());
                    user.setPassword(editTextPass.getText().toString());

                    Log.w("asda", user.getName() + user.getPassword());

                    vt.addData(editTextMail.toString(),editTextPass.toString());
                }


                CheckBox rememberMe = findViewById(R.id.rememberMe);
                if(rememberMe.isChecked())
                {
                    Log.w("errorgeldi", user.getName() + user.getPassword());
                }



            }
        });

    }



    public class fetchNewsList extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPostExecute(Void aVoid) {

        }

        @Override
        protected Void doInBackground(Void... voids) {

            URL website = null;
            try {
                website = new URL("http://login.apollo.gtu.edu.tr/tr/Login?return=http%3a%2f%2flogin.apollo.gtu.edu.tr%2f");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection) website.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(2000);
            try {
                conn.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            conn.setDoInput(true);
            // Starts the query
            try {
                conn.connect();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                conn.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder result = new StringBuilder();
                String line;
                while((line = reader.readLine()) != null) {
                    result.append(line);
                }

                Log.w("ersooo", result.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

    }



}
