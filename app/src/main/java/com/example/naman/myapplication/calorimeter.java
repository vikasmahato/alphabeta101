package com.example.naman.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by NAMAN on 27-01-2017.
 */

public class calorimeter extends AppCompatActivity{

    public static int calIntake;

    EditText age,height,weight,gender;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal_act);

        age = (EditText)findViewById(R.id.age);
        height = (EditText)findViewById(R.id.height);
        weight = (EditText)findViewById(R.id.weight);
        gender = (EditText)findViewById(R.id.gender);




    }

    public void calculate_calories(View v){

        double calories = 0;
        double age_val = Integer.parseInt(age.getText().toString());
        double height_val = Integer.parseInt(height.getText().toString());
        double weight_val = Integer.parseInt(weight.getText().toString());
        weight_val*=2.20462;
        char gender_val = gender.getText().toString().charAt(0);
        if(gender_val=='F' )
            calories = 655 + (4.35*weight_val) + (4.7*height_val)-(4.7*age_val);
        else
            calories = 66 + (6.23*weight_val) + (12.7*height_val) - (6.8*age_val);
        calories*=1.725;
        int each_time = (int)(calories/6.0);

        calIntake = each_time;

        Intent myIntent = new Intent(calorimeter.this, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(calorimeter.this, 0, myIntent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Calendar firingCal= Calendar.getInstance();
        Calendar currentCal = Calendar.getInstance();

        firingCal.set(Calendar.HOUR, 8);
        firingCal.set(Calendar.MINUTE, 0);
        firingCal.set(Calendar.SECOND, 0);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR,21);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);

        long stop = cal.getTimeInMillis();
        long intendedTime = firingCal.getTimeInMillis();
        long currentTime = currentCal.getTimeInMillis();

        if(currentTime>stop){
            firingCal.add(Calendar.HOUR_OF_DAY,11);
            intendedTime = firingCal.getTimeInMillis();
            alarmManager.setRepeating(AlarmManager.RTC, intendedTime, 9000000, pendingIntent);
        } else{
            firingCal.add(Calendar.HOUR_OF_DAY, 3);
            intendedTime = firingCal.getTimeInMillis();

            alarmManager.setRepeating(AlarmManager.RTC, intendedTime, 9000000, pendingIntent);
        }
        Toast.makeText(this, "alarm set", Toast.LENGTH_SHORT).show();
        myIntent.putExtra("calIntake",calIntake);

    }
    

}
