package com.example.nitikasaran.ass1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MyActivity extends AppCompatActivity {

    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button yes = (Button) findViewById(R.id.yesbutton);
        Button no = (Button) findViewById(R.id.nobutton);
        Button next = (Button) findViewById(R.id.nextbutton);
        TextView number = (TextView) findViewById(R.id.number);
        TextView ques = (TextView) findViewById(R.id.ques);
        number.setText(Integer.toString(rand.nextInt(1000)));
    }

    boolean isPrime(int n){
        if(n<2) return false;
        if(n==2) return true;
        int i;
        double n1 = Math.sqrt(n);
        for(i=2;i<=n1;i++){
           if(n%i==0)
               return false;
        }
        return true;
    }

    public void yesbut(View view){
        TextView number = (TextView) findViewById(R.id.number);
        if(isPrime(Integer.parseInt(number.getText().toString())))
            Toast.makeText(getApplicationContext(), "Correct Answer",
                Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(), "Wrong Answer",
                    Toast.LENGTH_LONG).show();
    }

    public void nobut(View view){
        TextView number = (TextView) findViewById(R.id.number);
        if(isPrime(Integer.parseInt(number.getText().toString())))
            Toast.makeText(getApplicationContext(), "Wrong Answer",
                    Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(), "Correct Answer",
                    Toast.LENGTH_LONG).show();
    }

    public void nextbut(View view){
        TextView number = (TextView) findViewById(R.id.number);
        number.setText(Integer.toString(rand.nextInt(1000)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
