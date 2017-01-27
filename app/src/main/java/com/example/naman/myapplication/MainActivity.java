package com.example.naman.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tracometer(View view){


    }

    public void nutrition(View view){

        Intent i = new Intent();
        i.setClass(MainActivity.this,calorimeter.class);
        startActivity(i);

    }

    public void chat(View view){

    Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        startActivity(i);


    }

    public void sportscult(View view){
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        Uri a = Uri.parse("http://www.sportscult.in");
        i.setData(a);
        startActivity(i);

    }

    public void asknknow(View view){

        Intent i = new Intent();
        i.setClass(MainActivity.this,AskAndKnow.class);
        startActivity(i);
    }
}
