package com.example.android.habittracker.UI;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.android.habittracker.DB.DBHabitTrackerHelper;
import com.example.android.habittracker.R;
import com.example.android.habittracker.add.AddHabitTracker;
import com.example.android.habittracker.delete.DeleteHabitTracker;

public class MainActivity  extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private DBHabitTrackerHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toAddHabit(View view) {

        Intent add = new Intent(this, AddHabitTracker.class);
        startActivity(add);
    }

    public void toDeleteHabits(View view) {
        Intent delete = new Intent(this, DeleteHabitTracker.class);
        startActivity(delete);

    }

    public void PreviewHabit(View view) {
        mydb = new DBHabitTrackerHelper(this);
        Cursor cursor = mydb.readAllHabits();
        while (cursor.moveToNext()) {
            Log.v(TAG,"habit: " + cursor.getString(0) + " " + cursor.getString(1) +
                    " " + cursor.getString(2) + " " + cursor.getString(3));
        }
    }
}
