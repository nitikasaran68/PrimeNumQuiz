package com.example.nitikasaran.ass1;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
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
import android.content.Intent;

import java.util.Random;

public class MyActivity extends AppCompatActivity {

    Random rand = new Random();
    static int scoren = 0;
    static boolean done = false ;
    static boolean hinttaken = false;
    static boolean cheattaken = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Button yes = (Button) findViewById(R.id.yesbutton);
        Button no = (Button) findViewById(R.id.nobutton);
        Button next = (Button) findViewById(R.id.nextbutton);
        TextView number = (TextView) findViewById(R.id.number);
        TextView ques = (TextView) findViewById(R.id.ques);
        TextView score = (TextView) findViewById(R.id.score);
        score.setTypeface(Typeface.createFromAsset(getAssets(),"GrandHotel-Regular.otf"));
        number.setTypeface(Typeface.createFromAsset(getAssets(),"GrandHotel-Regular.otf"));
        ques.setTypeface(Typeface.createFromAsset(getAssets(),"GrandHotel-Regular.otf"));
        ques.setTextSize(80);
        Intent i = getIntent();
        String num = i.getStringExtra("num");
        //if(numnull)){
            number.setText(Integer.toString(rand.nextInt(1000)));
//        else{
//            number.setText(num);
//        }
        score.setText("Score : " + scoren);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        TextView number = (TextView) findViewById(R.id.number);
        savedInstanceState.putInt("score",scoren);
        savedInstanceState.putInt("num",Integer.parseInt(number.getText().toString()));
        savedInstanceState.putBoolean("done",done);
    }

    @Override
    public void onRestoreInstanceState(Bundle state){
        super.onRestoreInstanceState(state);
        done = state.getBoolean("done");
        if(done) {
            Button yes = (Button) findViewById(R.id.yesbutton);
            Button no = (Button) findViewById(R.id.nobutton);
            yes.setEnabled(false);
            no.setEnabled(false);
        }
        TextView number = (TextView) findViewById(R.id.number);
        number.setText(Integer.toString(state.getInt("num")));
        scoren = state.getInt("score");
        TextView score = (TextView) findViewById(R.id.score);
        score.setText("Score : " + scoren);
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
        done = true;
        TextView number = (TextView) findViewById(R.id.number);
        if(isPrime(Integer.parseInt(number.getText().toString()))) {
            Toast.makeText(getApplicationContext(), "Correct Answer",
                    Toast.LENGTH_SHORT).show();
            scoren++;
            TextView score = (TextView) findViewById(R.id.score);
            score.setText("Score : " + Integer.toString(scoren));
        }
        else
            Toast.makeText(getApplicationContext(), "Wrong Answer",
                    Toast.LENGTH_SHORT).show();
        Button yes = (Button) findViewById(R.id.yesbutton);
        Button no = (Button) findViewById(R.id.nobutton);
        yes.setEnabled(false);
        no.setEnabled(false);
    }

    public void nobut(View view){
        done = true;
        TextView number = (TextView) findViewById(R.id.number);
        if(isPrime(Integer.parseInt(number.getText().toString())))
            Toast.makeText(getApplicationContext(), "Wrong Answer",
                    Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(getApplicationContext(), "Correct Answer",
                    Toast.LENGTH_SHORT).show();
            scoren++;
            TextView score = (TextView) findViewById(R.id.score);
            score.setText("Score : " + Integer.toString(scoren));
        }
        Button yes = (Button) findViewById(R.id.yesbutton);
        Button no = (Button) findViewById(R.id.nobutton);
        yes.setEnabled(false);
        no.setEnabled(false);
    }

    public void nextbut(View view){
//        Button hintb = (Button)findViewById(R.id.hintbut);
//        hintb.setEnabled(true);
//        Button cheatb = (Button)findViewById(R.id.cheatbut);
//        cheatb.setEnabled(true);
        hinttaken = false;
        cheattaken = false;
        done = false;
        TextView number = (TextView) findViewById(R.id.number);
        number.setText(Integer.toString(rand.nextInt(1000)));
        Button yes = (Button) findViewById(R.id.yesbutton);
        Button no = (Button) findViewById(R.id.nobutton);
        yes.setEnabled(true);
        no.setEnabled(true);
    }

    public void hint(View view){
        hinttaken = true;
       // Button hintb = (Button)findViewById(R.id.hintbut);
       // hintb.setEnabled(false);
        Intent intent = new Intent(this, Hint.class);
        startActivity(intent);
    }

    public void cheat(View view){
        cheattaken = true;
       // Button hintb = (Button)findViewById(R.id.cheatbut);
       // hintb.setEnabled(false);
        Intent intent = new Intent(this, Cheat.class);
        TextView ques = (TextView) findViewById(R.id.number);
        int x = Integer.parseInt(ques.getText().toString());
        intent.putExtra("message", Boolean.toString(isPrime(x)));
        intent.putExtra("num", ques.getText().toString());
        startActivity(intent);
    }

    @Override
    public void onResume(){
        super.onResume();
        if(hinttaken) {
            Toast.makeText(getApplicationContext(), "You just took a hint!",
                    Toast.LENGTH_SHORT).show();
            hinttaken = false;
        }
        if(cheattaken){
            Toast.makeText(getApplicationContext(), "You just took a cheat!",
                    Toast.LENGTH_SHORT).show();
            cheattaken = false;
        }
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
