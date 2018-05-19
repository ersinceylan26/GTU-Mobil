package com.mobil.gtu.gtumobil.Login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mobil.gtu.gtumobil.AnaMenu.MenuClass;

import java.util.ArrayList;
import java.util.List;

public class LoginDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "loginDatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLO = "loginTable";
    private static final String ROW_ID = "0";
    private static final String ROW_NAME = "Id";
    private static final String ROW_PASSWORD = "Password";

    public LoginDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLO + "("
                + ROW_NAME + " TEXT NOT NULL, "
                + ROW_PASSWORD + " TEXT NOT NULL)");

        setDefaultLabel(db);

    }

    public User fetchData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        User user =new User();
        String[] stunlar = {ROW_ID,ROW_NAME,ROW_PASSWORD};
        Cursor cursor = db.query(TABLO, stunlar,null,null,null,null,null);

        while (cursor.moveToNext()) {

            user.name=cursor.getString(1);
            user.password=cursor.getString(2);
        }

        return user;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void addData(String var0, String var1){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("delete from "+ TABLO);
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_NAME, var0);
            cv.put(ROW_PASSWORD, var1);

            db.insert(TABLO, null,cv);
        }catch (Exception e){
        }
        db.close();
    }


    public void setDefaultLabel(SQLiteDatabase db) {
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_NAME, "null");
            cv.put(ROW_PASSWORD, "null");

            db.insert(TABLO, null,cv);
        }
        catch (Exception e){
        }
    }

}
