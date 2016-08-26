package com.example.nitikasaran.ass1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;

/**
 * Created by nitikasaran on 26/08/16.
 */

public class Cheat extends AppCompatActivity {

    int currnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cheat);
        TextView text = (TextView) findViewById(R.id.cheattext);
        text.setTypeface(Typeface.createFromAsset(getAssets(),"GrandHotel-Regular.otf"));
        Intent i = getIntent();
        String msg = i.getStringExtra("message");
        currnum = Integer.parseInt(i.getStringExtra("num"));
        if(msg.equals("true")){
            text.setText("The number is prime!!");
        }
        else {
            text.setText("The number is not prime!!");
        }
    }

    public void back(View view){
        Intent intent = new Intent(this, MyActivity.class);
        TextView ques = (TextView) findViewById(R.id.number);
        int x = Integer.parseInt(ques.getText().toString());
        intent.putExtra("number", currnum);
        startActivity(intent);
    }
}
