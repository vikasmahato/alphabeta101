package com.example.naman.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Performance_tracker extends AppCompatActivity {

    EditText laptime,workouttime;
    TextView editText;
    Button create_graph;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance_tracker);

        laptime = (EditText)findViewById(R.id.laptime);
        workouttime = (EditText)findViewById(R.id.workouttime);
        create_graph = (Button)findViewById(R.id.create_graph);
        editText = (TextView) findViewById(R.id.editText);
       // dbHandler = new MyDBHandler(this,null,null,1);

    }

    public void graph_it(View v){

        int work = Integer.parseInt(workouttime.getText().toString());
        int performance = Integer.parseInt(laptime.getText().toString());
        Days days = new Days(work,performance);
        dbHandler = new MyDBHandler(getApplicationContext(),1);
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(MyDBHandler.COLUMN_WORKOUT,days.get_workout());
        cv.put(MyDBHandler.COLUMN_PERFORMANCE,days.get_performance());
        //dbHandler.addDay(days);
        db.insert(MyDBHandler.TABLE_DAYS,null,cv);
        editText.setText(dbHandler.databasetoString());
        //Toast.makeText(Performance_tracker.this, "sdvgrs", Toast.LENGTH_SHORT).show();


    }



}
