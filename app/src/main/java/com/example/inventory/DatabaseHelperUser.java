package com.example.inventory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHelperUser extends SQLiteOpenHelper {

    public static final String database_name = "inventory";
    public static final String table_name = "User";

    public static  final String row_no_induk = "no_induk";
    public static  final String row_nama = "nama";
    public static  final String row_email = "email";
    public static  final String row_prodi = "prodi";
    public static  final String row_password = "password";

    private SQLiteDatabase db;

    public DatabaseHelperUser(Context context)
    {
        super(context, database_name, null, 3);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + table_name + "("
                + row_no_induk + " VARCHAR PRIMARY KEY,"
                + row_nama + " VARCHAR,"
                + row_email + " VARCHAR,"
                + row_prodi + " VARCHAR,"
                + row_password + " VARCHAR" + ")";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);
    }

    public void insertData (ContentValues values)
    {
        db.insert(table_name, null, values);
    }

    public boolean checkUser(String no_induk, String password)
    {
        final String DATABASE_COMPARE = "select count(*) from user where no_induk='" + no_induk + "' and password='" + password + "'; ";

        int count = (int) DatabaseUtils.longForQuery(db, DATABASE_COMPARE, null);
        System.out.println(count);
        System.out.println("Username adalah "+no_induk);
        System.out.println("password adalah "+password);
        if (count>0)
            return true;
        else
            return false;
    }

    public ArrayList<HashMap<String, String>> getAllData() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT * FROM " + "user";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("no_induk", cursor.getString(0));
                map.put("password", cursor.getString(1));
            } while (cursor.moveToNext());

        }
        Log.e("select sqlite", "" + wordList);
        database.close();
        return wordList;
    }

    public void delete() {


        String updateQuery = "Delete from User where password = 'A'";
        Log.e("update sqlite", updateQuery);
        db.delete("user", "password=?", new String[]{"A"});
        //db.rawQuery(updateQuery, null);
        db.close();
    }
    /*public void addData(String no_induk, String nama, String email, String prodi, String password)  {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(row_no_induk,no_induk);
        values.put(row_nama, nama);
        values.put(row_email, email);
        values.put(row_prodi, prodi);
        values.put(row_password , password);
        db.insert(table_name, null, values);
        db.close();
    }*/

    }

