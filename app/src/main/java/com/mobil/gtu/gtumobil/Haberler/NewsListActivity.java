package com.mobil.gtu.gtumobil.Haberler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mobil.gtu.gtumobil.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by yasinacikgoz on 25.02.2018.
 */

public class NewsListActivity extends Activity {

    ListView listView;
    Context context = this ;
    ProgressBar pb;
    private final String url = "http://www.gtu.edu.tr";
    private final int max_news = 12;
    Post[] newsArray = new Post[max_news];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newslist);
        listView = findViewById(R.id.listView);

        pb = findViewById(R.id.progressBar);

        if(isNetworkConnected()){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0 ; i < max_news ; ++i){
                        Post tempPost = new Post();
                        newsArray[i] = tempPost;
                    }

                }
            }).start();
            PostAdapter postAdapter = new PostAdapter();
            listView.setAdapter(postAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    if(!newsArray[position].getLink().equals("")){
                        Intent myIntent = new Intent(view.getContext(), PostActivity.class);

                        myIntent.putExtra("KEY", newsArray[position]);
                        startActivityForResult(myIntent, 0);

                    }

                }
            });

            new ParsePage().execute();
        } else{
            Toast.makeText(context, "No internet connection", Toast.LENGTH_LONG).show();
        }
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    private class ParsePage extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            //load the document !
            Document doc;
            try{
                //Connect to the website and get the HTML!
                doc = Jsoup.connect(url).get();
                Elements elements = doc.getElementsByClass("news-img");
                Elements contents = elements.select("a");

                Elements news = contents.select("img");


                for(int i = 0; i < max_news; ++i){
                        newsArray[i] = new Post(news.get(i).attr("alt"),
                                contents.get(i).attr("href"),
                                url + news.get(i).attr("src").
                                        replace("AjaxResize.ashx?file=", "").
                                        replace("&width=190&height=190", ""));

                }

            }catch (IOException e){

                e.printStackTrace();
            }
            return "Executed";
        }
        protected void onPostExecute(String result){

            listView.setVisibility(View.VISIBLE);
            pb.setVisibility(View.GONE);
            listView.invalidateViews();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            listView.setVisibility(View.INVISIBLE);
        }

    }
    class PostAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return newsArray.length;
        }

        @Override
        public Post getItem(int i) {
            return newsArray[i];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.post_layout,null);
            ImageView imageView = view.findViewById(R.id.newsImg);
            final TextView title_txt = view.findViewById(R.id.newsText);

            if (!newsArray[i].getImgLink().equals("")) {
                Picasso
                        .with(context)
                        .load(newsArray[i].getImgLink())
                        .fit()
                        .into(imageView, new Callback() {
                            @Override
                            public void onSuccess() {
                                // Log.d("Success","Compelete");
                            }

                            @Override
                            public void onError() {

                            }
                        });

                title_txt.setText(newsArray[i].getTitle());

            }

            return view;
        }
    }

}