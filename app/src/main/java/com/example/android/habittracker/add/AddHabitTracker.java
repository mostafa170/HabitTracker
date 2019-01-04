package com.example.android.habittracker.add;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.habittracker.DB.DBHabitTrackerHelper;
import com.example.android.habittracker.R;

/**
 * Created by mostafa on 22/07/2017.
 */

public class AddHabitTracker extends AppCompatActivity {

    private DBHabitTrackerHelper mydb ;

    EditText nameEditText, categoryEditText, countertEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);

        nameEditText = (EditText) findViewById(R.id.habitName);
        categoryEditText = (EditText) findViewById(R.id.habitCategory);
        countertEditText = (EditText) findViewById(R.id.habitCounter);
        mydb =new DBHabitTrackerHelper(this);

        Button save =(Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String habitName = nameEditText.getText().toString();
                String category = categoryEditText.getText().toString();
                String num = countertEditText.getText().toString();
                Integer number=Integer.parseInt(num);

                mydb.addHabit(habitName,category,number);
                Toast.makeText(AddHabitTracker.this,"Habit has been Added Successfully",Toast.LENGTH_LONG).show();
            }
        });

    }
}
