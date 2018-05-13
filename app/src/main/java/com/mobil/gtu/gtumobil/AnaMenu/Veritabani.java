package com.mobil.gtu.gtumobil.AnaMenu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Veritabani extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "menuDatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLO = "menutable";
    private static final String ROW_ID = "0";
    private static final String ROW_KISILER_ = "Ulasim";
    private static final String ROW_HABERLER = "Haberler";
    private static final String ROW_REHBER = "Rehber";
    private static final String ROW_DUYURULAR = "Duyurular";
    private static final String ROW_ETKINLIKLER = "Etkinlikler";

    public Veritabani(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLO + "("
                + ROW_KISILER_ + " TEXT NOT NULL, "
                + ROW_HABERLER + " TEXT NOT NULL, "
                + ROW_REHBER + " TEXT NOT NULL, "
                + ROW_DUYURULAR + " TEXT NOT NULL, "
                + ROW_ETKINLIKLER + " TEXT NOT NULL)");

        setDefaultLabel(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void VeriEkle(String var0, String var1, String var2, String var3, String var4){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("delete from "+ TABLO);
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_KISILER_, var0);
            cv.put(ROW_HABERLER, var1);
            cv.put(ROW_REHBER, var2);
            cv.put(ROW_DUYURULAR, var3);
            cv.put(ROW_ETKINLIKLER, var4);

            db.insert(TABLO, null,cv);
        }catch (Exception e){
        }
        db.close();
    }


    public List<MenuClass> VeriListele(){
        List<String> veriler = new ArrayList<String>();
        List<MenuClass> veriler2 = new ArrayList<MenuClass>();

        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String[] stunlar = {ROW_ID,ROW_KISILER_,ROW_HABERLER,ROW_REHBER,ROW_DUYURULAR,ROW_ETKINLIKLER};
            Cursor cursor = db.query(TABLO, stunlar,null,null,null,null,null);
            while (cursor.moveToNext()){

                veriler2.add(new MenuClass((equalDataSources(cursor.getString(1))),cursor.getColumnName(1).substring(0,1).toUpperCase()+cursor.getColumnName(1).substring(1)));
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(2))),cursor.getColumnName(2).substring(0,1).toUpperCase()+cursor.getColumnName(2).substring(1)));
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(3))),cursor.getColumnName(3).substring(0,1).toUpperCase()+cursor.getColumnName(3).substring(1)));
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(4))),cursor.getColumnName(4).substring(0,1).toUpperCase()+cursor.getColumnName(4).substring(1)));
                veriler2.add(new MenuClass((equalDataSources(cursor.getString(5))),cursor.getColumnName(5).substring(0,1).toUpperCase()+cursor.getColumnName(5).substring(1)));


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
        }catch (Exception e){
        }
        db.close();
        return veriler2;
    }

    public boolean equalDataSources(String value)
    {
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
            cv.put(ROW_KISILER_, false);
            cv.put(ROW_HABERLER, false);
            cv.put(ROW_REHBER, false);
            cv.put(ROW_DUYURULAR, false);
            cv.put(ROW_ETKINLIKLER, false);

            db.insert(TABLO, null,cv);
        }
        catch (Exception e){
        }
    }

}
