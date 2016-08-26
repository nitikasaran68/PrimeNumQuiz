package com.example.nitikasaran.ass1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by nitikasaran on 26/08/16.
 */
public class Hint extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hint);
        TextView text = (TextView) findViewById(R.id.hint);
        text.setTypeface(Typeface.createFromAsset(getAssets(),"GrandHotel-Regular.otf"));
//        Intent i = getIntent();
//        String msg = i.getStringExtra("message");
//        currnum = Integer.parseInt(i.getStringExtra("num"));
//        if(msg.equals("True")){
//            text.setText("The number is Prime!");
//        }
//        else {
//            text.setText("The number is Non-prime!!");
//        }
    }

}
