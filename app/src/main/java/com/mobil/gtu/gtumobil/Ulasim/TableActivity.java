package com.mobil.gtu.gtumobil.Ulasim;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import com.mobil.gtu.gtumobil.R;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableActivity extends AppCompatActivity
{
    List<GebzeOtobusClass> yurtKalkis = new ArrayList<>();
    List<GebzeOtobusClass> gtuKalkis = new ArrayList<>();
    ListView listView2;
    ListView listView;
    String url490="";

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulasim_490_list);

        listView = findViewById(R.id.listGidis490);
        listView2 = findViewById(R.id.listGelis490);

        url490="http://www.kocaeli.bel.tr/tr/main/hatlar/490";

        new veriCek().execute();

    }

    public class veriCek extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            final GebzeOtobusAdapter adapter= new GebzeOtobusAdapter(TableActivity.this, yurtKalkis);
            listView.setAdapter(adapter);

            final GebzeOtobusAdapter adapter2= new GebzeOtobusAdapter(TableActivity.this, gtuKalkis);
            listView2.setAdapter(adapter2);

        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Document document490 = Jsoup.connect(url490).get();
                Elements element490 = document490.select("div.col-md-6.col");
                Elements content_H22 = element490.select("tbody");

                for(int i=0;i<content_H22.get(2).getElementsByTag("tr").size();i++)
                {
                   if(content_H22.get(2).getElementsByTag("tr").get(3).getElementsByTag("th").size()==2)
                    {
                        yurtKalkis.add(new GebzeOtobusClass(parseTime(content_H22.get(2).getElementsByTag("tr").get(i).getElementsByTag("th").get(1).outerHtml())
                                ,"-","-"));
                    }
                    else if(content_H22.get(2).getElementsByTag("tr").get(3).getElementsByTag("th").size()==3)
                    {
                        yurtKalkis.add(new GebzeOtobusClass(parseTime(content_H22.get(2).getElementsByTag("tr").get(i).getElementsByTag("th").get(1).outerHtml())
                                ,parseTime(content_H22.get(2).getElementsByTag("tr").get(i).getElementsByTag("th").get(2).outerHtml())
                                ,"-"));
                    }
                    else if(content_H22.get(2).getElementsByTag("tr").get(3).getElementsByTag("th").size()==4)
                    {
                        String result1=parseTime(content_H22.get(2).getElementsByTag("tr").get(i).getElementsByTag("th").get(1).outerHtml());
                        String result2=parseTime(content_H22.get(2).getElementsByTag("tr").get(i).getElementsByTag("th").get(2).outerHtml());
                        String result3=parseTime(content_H22.get(2).getElementsByTag("tr").get(i).getElementsByTag("th").get(3).outerHtml());

                        yurtKalkis.add(new GebzeOtobusClass(result1,result2,result3));
                    }
                }

                for(int i=0;i<content_H22.get(3).getElementsByTag("tr").size();i++)
                {
                    if(content_H22.get(3).getElementsByTag("tr").get(3).getElementsByTag("th").size()==2)
                    {
                        gtuKalkis.add(new GebzeOtobusClass(parseTime(content_H22.get(3).getElementsByTag("tr").get(i).getElementsByTag("th").get(1).outerHtml())
                                ,"-","-"));
                    }
                    else if(content_H22.get(3).getElementsByTag("tr").get(3).getElementsByTag("th").size()==3)
                    {
                        gtuKalkis.add(new GebzeOtobusClass(parseTime(content_H22.get(3).getElementsByTag("tr").get(i).getElementsByTag("th").get(1).outerHtml())
                                ,parseTime(content_H22.get(2).getElementsByTag("tr").get(i).getElementsByTag("th").get(2).outerHtml())
                                ,"-"));
                    }
                    else if(content_H22.get(3).getElementsByTag("tr").get(3).getElementsByTag("th").size()==4)
                    {
                        String result1=parseTime(content_H22.get(3).getElementsByTag("tr").get(i).getElementsByTag("th").get(1).outerHtml());
                        String result2=parseTime(content_H22.get(3).getElementsByTag("tr").get(i).getElementsByTag("th").get(2).outerHtml());
                        String result3=parseTime(content_H22.get(3).getElementsByTag("tr").get(i).getElementsByTag("th").get(3).outerHtml());

                        gtuKalkis.add(new GebzeOtobusClass(result1,result2,result3));
                    }
                }

                return null;

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPreExecute() { }

    }

    public String parseTime(String time)
    {
        String result;

        if(time.length()>10) {
            int findndex = time.lastIndexOf(':');

            result=time.substring(findndex-2,findndex)+time.substring(findndex,findndex+3);
            result =result.replace("\n", "");
            return result;
        }

        return "--";
    }


}
