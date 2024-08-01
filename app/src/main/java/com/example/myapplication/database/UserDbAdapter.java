package com.example.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.myapplication.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserDbAdapter extends  FlootDatabaseHelper {
    public UserDbAdapter(@Nullable Context context) {
        super(context);
    }
    public long insertUser(User user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_USERNAME, user.getUserName());
        contentValues.put(KEY_PASSWORD, user.getPassword());
        return db.insert(TABLE_USERS, null, contentValues);
    }
    public long changePassword(User user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_PASSWORD, user.getPassword());

        // return db.update(TABLE_USERS,contentValues,KEY_ID+"="+user.getId(),null);
        return db.update(TABLE_USERS, contentValues, KEY_ID + "= ? ",
                new String[]{String.valueOf(user.getId())});
    }

    public long deleteAllUsers() {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_USERS, null, null);
    }


    public long deleteUser(int userId) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_USERS, KEY_ID + " = ? ", new String[]{userId + ""});
    }

    public List<String> getAllUsers() {
        SQLiteDatabase db = getReadableDatabase();
        List<String> usersList = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from " + TABLE_USERS, null);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            int userId = cursor.getInt(cursor.getColumnIndex(KEY_ID));

            String username=cursor.getString(cursor.getColumnIndex(KEY_USERNAME));
            usersList.add(username);

        }

        return usersList;
    }
}
