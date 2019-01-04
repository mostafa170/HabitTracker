package com.example.android.habittracker.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mostafa on 22/07/2017.
 */

public class DBHabitTrackerHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "habittracker.db";
    private static final int DATABASE_VERSION = 1;

    public DBHabitTrackerHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + HabitTrackerContract.HabitEntry.TABLE_NAME + " ("
                + HabitTrackerContract.HabitEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitTrackerContract.HabitEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + HabitTrackerContract.HabitEntry.COLUMN_CATEGORY + " TEXT NOT NULL,"
                + HabitTrackerContract.HabitEntry.COLUMN_COUNTER + " INTEGER NOT NULL );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int j) {

    }

    public boolean addHabit (String name, String category,int counter) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HabitTrackerContract.HabitEntry.COLUMN_NAME, name);
        contentValues.put(HabitTrackerContract.HabitEntry.COLUMN_CATEGORY, category);
        contentValues.put(HabitTrackerContract.HabitEntry.COLUMN_COUNTER, counter);
        db.insert(HabitTrackerContract.HabitEntry.TABLE_NAME, null, contentValues);
        return true;
    }

    public Cursor readAllHabits(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                HabitTrackerContract.HabitEntry._ID,
                HabitTrackerContract.HabitEntry.COLUMN_NAME,
                HabitTrackerContract.HabitEntry.COLUMN_CATEGORY,
                HabitTrackerContract.HabitEntry.COLUMN_COUNTER
        };
        Cursor cursor = db.query(
                HabitTrackerContract.HabitEntry.TABLE_NAME ,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }

    public Integer deleteHabit (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(HabitTrackerContract.HabitEntry.TABLE_NAME ,
                HabitTrackerContract.HabitEntry.ID+" = ? ",
                new String[] { Integer.toString(id) });
    }
}
