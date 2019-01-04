package com.example.android.habittracker.DB;

import android.provider.BaseColumns;

/**
 * Created by mostafa on 22/07/2017.
 */

public class HabitTrackerContract {
    private HabitTrackerContract() {
    }

    public static final class HabitEntry implements BaseColumns {
        public final static String TABLE_NAME = "habits";
        public final static String ID = BaseColumns._ID;
        public final static String COLUMN_NAME ="name";
        public final static String COLUMN_CATEGORY ="category";
        public final static String COLUMN_COUNTER="counterPerWeek";
    }

}
