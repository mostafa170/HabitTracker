package com.example.android.habittracker.delete;

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

public class DeleteHabitTracker extends AppCompatActivity {

    private DBHabitTrackerHelper mydb ;

    EditText idEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_habit);

        idEditText =(EditText)findViewById(R.id.idToDelete);
        mydb =new DBHabitTrackerHelper(this);

        Button delet =(Button)findViewById(R.id.deleteHabit);
        delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEditText.getText().toString();
                Integer integer=Integer.parseInt(id);
                mydb.deleteHabit(integer);
                Toast.makeText(DeleteHabitTracker.this,"Habits has been Deleted Successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
}
