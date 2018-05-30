package com.mobil.gtu.gtumobil.AnaMenu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Veritabani extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "menuDatabaseeee";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLO = "menutable";
    private static final String ROW_ID = "0";
    private static final String ROW_ULASIM_ = "Ulasim";
    private static final String ROW_HABERLER = "Haberler";
    private static final String ROW_REHBER = "Rehber";
    private static final String ROW_DUYURULAR = "Duyurular";
    private static final String ROW_ETKINLIKLER = "Etkinlikler";
    private static final String ROW_TRANSKRIPT= "Transkript";
    private static final String ROW_YEMEKBAKIYE= "YemekBakiye";
    private static final String ROW_BOLUMDUYULARI= "BolumDuyurulari";
    private static final String ROW_YEMEKMENUSU= "YemekMenusu";
    private static final String ROW_AKADEMIKTAKVIM= "AkademikTakvim";
    private static final String ROW_LOGIN= "Login";
    private static final String ROW_HARC= "Harc";
    private static final String ROW_HAKKIMIZDA= "Hakkimizda";

    public Veritabani(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLO + "("
                + ROW_ULASIM_ + " TEXT NOT NULL, "
                + ROW_HABERLER + " TEXT NOT NULL, "
                + ROW_REHBER + " TEXT NOT NULL, "
                + ROW_DUYURULAR + " TEXT NOT NULL, "
                + ROW_ETKINLIKLER + " TEXT NOT NULL, "
                + ROW_TRANSKRIPT + " TEXT NOT NULL, "
                + ROW_YEMEKBAKIYE + " TEXT NOT NULL, "
                + ROW_BOLUMDUYULARI + " TEXT NOT NULL, "
                + ROW_YEMEKMENUSU + " TEXT NOT NULL, "
                + ROW_AKADEMIKTAKVIM + " TEXT NOT NULL, "
                + ROW_LOGIN + " TEXT NOT NULL, "
                + ROW_HARC + " TEXT NOT NULL, "
                + ROW_HAKKIMIZDA + " TEXT NOT NULL)");

        setDefaultLabel(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { onCreate(db); }

    public void VeriEkle(String var0, String var1, String var2, String var3, String var4,
            String var5, String var6, String var7, String var8, String var9, String var10,String var11){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("delete from "+ TABLO);
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_ULASIM_, var0);
            cv.put(ROW_HABERLER, var1);
            cv.put(ROW_REHBER, var2);
            cv.put(ROW_DUYURULAR, var3);
            cv.put(ROW_ETKINLIKLER, var4);
            cv.put(ROW_TRANSKRIPT, var5);
            cv.put(ROW_YEMEKBAKIYE, var6);
            cv.put(ROW_BOLUMDUYULARI, var7);
            cv.put(ROW_YEMEKMENUSU, var8);
            cv.put(ROW_AKADEMIKTAKVIM, var9);
            cv.put(ROW_LOGIN, var10);
            cv.put(ROW_HARC, var10);
            cv.put(ROW_HAKKIMIZDA, var11);


            db.insert(TABLO, null,cv);
        }catch (Exception e){ }

        db.close();
    }

    public List<MenuClass> VeriListele(){
        List<String> veriler = new ArrayList<>();
        List<MenuClass> veriler2 = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            String[] stunlar = {ROW_ID, ROW_ULASIM_,ROW_HABERLER,ROW_REHBER,ROW_DUYURULAR,ROW_ETKINLIKLER,
                    ROW_TRANSKRIPT,ROW_YEMEKBAKIYE,ROW_BOLUMDUYULARI,ROW_YEMEKMENUSU,ROW_AKADEMIKTAKVIM,ROW_LOGIN,ROW_HARC,ROW_HAKKIMIZDA};
            Cursor cursor = db.query(TABLO, stunlar,null,null,null,null,null);
            while (cursor.moveToNext()){
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(1))),cursor.getColumnName(1).substring(0,1).toUpperCase()+cursor.getColumnName(1).substring(1)));
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(2))),cursor.getColumnName(2).substring(0,1).toUpperCase()+cursor.getColumnName(2).substring(1)));
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(3))),cursor.getColumnName(3).substring(0,1).toUpperCase()+cursor.getColumnName(3).substring(1)));
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(4))),cursor.getColumnName(4).substring(0,1).toUpperCase()+cursor.getColumnName(4).substring(1)));
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(5))),cursor.getColumnName(5).substring(0,1).toUpperCase()+cursor.getColumnName(5).substring(1)));
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(6))),cursor.getColumnName(6).substring(0,1).toUpperCase()+cursor.getColumnName(6).substring(1)));
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(7))),cursor.getColumnName(7).substring(0,1).toUpperCase()+cursor.getColumnName(7).substring(1)));
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(8))),cursor.getColumnName(8).substring(0,1).toUpperCase()+cursor.getColumnName(8).substring(1)));
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(9))),cursor.getColumnName(9).substring(0,1).toUpperCase()+cursor.getColumnName(9).substring(1)));
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(10))),cursor.getColumnName(10).substring(0,1).toUpperCase()+cursor.getColumnName(10).substring(1)));
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(11))),cursor.getColumnName(11).substring(0,1).toUpperCase()+cursor.getColumnName(11).substring(1)));
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(12))),cursor.getColumnName(12).substring(0,1).toUpperCase()+cursor.getColumnName(12).substring(1)));
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(13))),cursor.getColumnName(13).substring(0,1).toUpperCase()+cursor.getColumnName(13).substring(1)));

                veriler.add(cursor.getInt(0)
                        + " - "
                        + cursor.getString(1)
                        + " - "
                        + cursor.getString(2)
                        + " - "
                        + cursor.getString(3)
                        + " - "
                        + cursor.getString(4)
                        + " - "
                        + cursor.getString(5));
            }
        }catch (Exception e){ }

        db.close();

        return veriler2;
    }

    public boolean equalDataSources(String value){
        if(value.equals("false"))
        {
            return false;
        }
        else
            return true;
    }

    public void setDefaultLabel(SQLiteDatabase db) {
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_ULASIM_, false);
            cv.put(ROW_HABERLER, false);
            cv.put(ROW_REHBER, false);
            cv.put(ROW_DUYURULAR, false);
            cv.put(ROW_ETKINLIKLER, false);
            cv.put(ROW_TRANSKRIPT, false);
            cv.put(ROW_YEMEKBAKIYE, false);
            cv.put(ROW_BOLUMDUYULARI, false);
            cv.put(ROW_YEMEKMENUSU, false);
            cv.put(ROW_AKADEMIKTAKVIM, false);
            cv.put(ROW_LOGIN, false);
            cv.put(ROW_HARC, false);
            cv.put(ROW_HAKKIMIZDA, false);

            db.insert(TABLO, null,cv);
        }
        catch (Exception e){ }
    }

}
