package com.example.tutorium;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "Users.db";
    private static String TABLE_NAME = "UserDetails";
    public static String NAME = "NAME";
    public static String MOBILE = "MOBILE";
    public static String DOB = "DOB";
    public static String EMAIL = "EMAIL";
    public static String USERNAME = "USERNAME";
    public static String PASSWORD = "PASSWORD";

    SQLiteDatabase db = getWritableDatabase();

    public MyDBHelper( Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+" (NAME TEXT,MOBILE TEXT,EMAIL TEXT,DOB TEXT,USERNAME TEXT PRIMARY KEY,PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    boolean insertdata(String name,String dob,String email,String username,String password,String mn){

        ContentValues values = new ContentValues();
        values.put(NAME,name);
        values.put(MOBILE,mn);
        values.put(DOB,dob);
        values.put(EMAIL,email);
        values.put(USERNAME,username);
        values.put(PASSWORD,password);

        long result = db.insert(TABLE_NAME,null,values);
        return result!=-1;
    }
    boolean checkuserpass(String username,String password){
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE USERNAME = ? AND PASSWORD = ?" , new String[]{username,password});
        if(cursor.getCount()>0){
            return true;
        }
        else
        {
            return false;
        }
    }
}
