package com.mobil.gtu.gtumobil.Login;

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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by ersin on 4.03.2018.
 */

public class LoginActivity extends AppCompatActivity {

    EditText editTextPass, editTextMail;
    CheckBox rememberMe;
    TextView errorCase;
    Button loginButton;
    private String url = "";

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
        url = "http://login.apollo.gtu.edu.tr/tr/Login?return=http%3a%2f%2flogin.apollo.gtu.edu.tr%2f";
        errorCase.setVisibility(View.GONE);

        //vt.deleteData();

        user = vt.fetchData();

        if (user.getName().compareTo("null") != 0 || user.getPassword().compareTo("null") != 0) {
            editTextMail.setText(user.getName());
            editTextPass.setText(user.getPassword());
            editTextMail.setFocusable(false);
            editTextMail.setEnabled(false);
            editTextPass.setFocusable(false);
            editTextPass.setEnabled(false);

            rememberMe.setChecked(true);
        } else {

            /*ProgressDialog progress;

            progress = new ProgressDialog(this);
            progress.setTitle("Login");
            progress.setMessage("Giriş Yapılıyor");
            progress.setCancelable(false);
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.show();*/

            // Auth işlemi yaptırılacak

        }

        new fetchNewsList().execute();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextPass.getText().toString().matches("") ||
                        editTextMail.getText().toString().matches("")) {
                    Log.w("orospu", user.getName() + user.getPassword());
                    errorCase.setText("* Tüm Alanları Doldurunuz");
                    errorCase.setVisibility(View.VISIBLE);
                } else {
                    user.setName(editTextMail.getText().toString());
                    user.setPassword(editTextPass.getText().toString());

                    Log.w("asda", user.getName() + user.getPassword());

                    CheckBox rememberMe = findViewById(R.id.rememberMe);
                    if (rememberMe.isChecked()) {
                        Log.w("errorgeldi", user.getName() + user.getPassword());
                        vt.addData(editTextMail.getText().toString(), editTextPass.getText().toString());
                    } else {
                        vt.deleteData();
                    }


                }


            }
        });

    }


    public class fetchNewsList extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPostExecute(Void aVoid) {

        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Document document = Jsoup.connect(url).get();
                StringBuilder sb = new StringBuilder();
                HttpClient client = new DefaultHttpClient();

                HttpGet request = new HttpGet("http://login.apollo.gtu.edu.tr/tr/Login?return=http%3a%2f%2flogin.apollo.gtu.edu.tr%2f");
                HttpResponse response2= client.execute(request);
                HttpEntity entity2 = response2.getEntity();
                InputStream in = entity2.getContent();


                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line = "";
                int count =0;
                while((line = reader.readLine()) != null){
                    Log.d("ersoooo", line);
                    Log.d("countttt", Integer.toString(count));
                    count++;

                    if(count==97)
                        break;

                }
                Log.d("benburdayim", Integer.toString(count));
                Log.d("benburdayim", line);


                Document document1 = new Document(line);
                Log.d("nabiyonla", line);
                Log.d("taha", "+"+line.substring(69,line.length()-4)+"+");


                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://login.apollo.gtu.edu.tr/tr/Login?return=http%3a%2f%2flogin.apollo.gtu.edu.tr%2f");

                List<NameValuePair> nameValuePair = new ArrayList<>();

                nameValuePair.add(new BasicNameValuePair("UserName", "ersinceylan"));
                nameValuePair.add(new BasicNameValuePair("Password", "5014551"));
                nameValuePair.add(new BasicNameValuePair("__RequestVerificationToken", line.substring(69,line.length()-4)));

                //httppost.setHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded");

                httppost.setEntity(new UrlEncodedFormEntity(nameValuePair));

                HttpResponse response= httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                final String responseText1 = EntityUtils.toString(entity);
                Log.d("Response Metni: ", responseText1);

                return null;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

}





