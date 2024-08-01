package com.example.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FlootDatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME="floot.db";
    public static int DB_VERSION=1;

    public static String TABLE_USERS="tbl_users";

    public static String KEY_ID="id";
    public static String KEY_USERNAME="username";
    public static String KEY_PASSWORD="password";

    public FlootDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryString="create table "+TABLE_USERS+" ("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_USERNAME+" Text,"+KEY_PASSWORD+" Text)";
        sqLiteDatabase.execSQL(queryString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
