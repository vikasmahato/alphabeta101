package com.example.naman.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

/**
 * Created by NAMAN on 27-01-2017.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Vibrator vib = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vib.vibrate(4000);
        Bundle b = intent.getExtras();
        int a = b.getInt("calIntake");
        Toast.makeText(context, "Time for a meal take "+a+" calories", Toast.LENGTH_SHORT).show();
    }
}
