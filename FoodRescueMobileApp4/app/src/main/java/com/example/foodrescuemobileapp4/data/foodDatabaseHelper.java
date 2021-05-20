package com.example.foodrescuemobileapp4.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foodrescuemobileapp4.Food;
import com.example.foodrescuemobileapp4.util.Util;
import com.example.foodrescuemobileapp4.util.foodUtil;

public class foodDatabaseHelper extends SQLiteOpenHelper {
    public foodDatabaseHelper(@Nullable Context context) {
        super(context, foodUtil.TABLE_NAME, null, foodUtil.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_FOOD_TABLE = "CREATE TABLE " + foodUtil.TABLE_NAME + "(" + foodUtil.FOOD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + foodUtil.FOODTITLE + " TEXT" + foodUtil.FOODIMAGE + "TEXT)";
        sqLiteDatabase.execSQL(CREATE_FOOD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String DROP_FOOD_TABLE = "DROP TABLE IF EXISTS";
        sqLiteDatabase.execSQL(DROP_FOOD_TABLE, new String[]{foodUtil.TABLE_NAME});
        onCreate(sqLiteDatabase);
    }

    public long insertFood(Food food)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(foodUtil.FOODTITLE,food.getTitle());
        contentValues.put(foodUtil.FOODIMAGE,food.getImage());

        long newRowId = db.insert(foodUtil.TABLE_NAME, null, contentValues);
        db.close();
        return newRowId;
    }

}
