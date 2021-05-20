package com.example.foodrescuemobileapp4.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foodrescuemobileapp4.model.User;
import com.example.foodrescuemobileapp4.util.Util;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USER_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "(" + Util.USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + Util.USERNAME + " TEXT" + Util.EMAIL + "TEXT" + Util.PHONE + "TEXT" + Util.ADDRESS + "TEXT" + Util.PASSWORD + "TEXT)";
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String DROP_USER_TABLE = "DROP TABLE IF EXISTS";
        sqLiteDatabase.execSQL(DROP_USER_TABLE, new String[]{Util.TABLE_NAME});

        onCreate(sqLiteDatabase);
    }

    public long insertUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.USERNAME,user.getUsername());
        contentValues.put(Util.EMAIL, user.getEmail());
        contentValues.put(Util.PHONE, user.getPhone());
        contentValues.put(Util.ADDRESS, user.getAddress());
        contentValues.put(Util.PASSWORD, user.getPassword());
        long newRowId = db.insert(Util.TABLE_NAME, null, contentValues);
        db.close();
        return newRowId;
    }



}
