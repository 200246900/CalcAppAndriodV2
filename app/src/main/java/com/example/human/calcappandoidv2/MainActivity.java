package com.example.human.calcappandoidv2;

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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //Variables
    ArrayList<String> arrayList = new ArrayList<String>();
    String string1 = "";
    String string2 = "";
    double firstUserInput = 0.00;
    double secondUserInput = 0.00;
    double answer = 0.00;
    String calculation = "";
    boolean stillTypingNumber = false;
    double tempNum = 0.00;

    public void onCLick1 (View v)
    {
        //Assign whatever the number clicked to a currentInput
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        Button button = (Button) v;
        String string = (String) button.getText().toString();

        //If the user is still typing the question
        if (stillTypingNumber)
        {
            //If the user has not chosen a calculation
            textView2.setText(string);
        }
        else //User is done calculation
        {
            //Update display with number
            textView2.setText(string);
            stillTypingNumber = (true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
