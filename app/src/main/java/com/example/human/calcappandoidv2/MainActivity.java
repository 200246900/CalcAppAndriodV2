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
    String screenText = "";
    double firstUserInput = 0.00;
    double secondUserInput = 0.00;
    double answer = 0.00;
    String calculation = "";
    boolean stillTypingNumber = false;
    double tempNum = 0.00;

    //This function handles the user selecting a number
    public void numberClicked (View v)
    {
        //Assign whatever the number clicked to a currentInput
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        Button button = (Button) v;
        String string = (String) button.getText().toString();

        //If the user is still typing the question
        if (stillTypingNumber)
        {
            //If the user has not chosen a calculation grab screen string and assign
            screenText=textView2.getText().toString();

            //Update Screen
            textView2.setText(screenText+string);
        }
        else //User is done calculation
        {
            //Update display with number
            screenText="";
            textView2.setText(screenText+string);
            stillTypingNumber = (true);
        }
    }

    //This function handles the user selecting a calculation
    public void calculationClicked (View v)
    {
        //Assign whatever the number clicked to a currentInput
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        Button button = (Button) v;
        String string = (String) button.getText().toString();
        screenText=textView2.getText().toString();

        //Set boolean to false
        stillTypingNumber = false;

        //Assign first number entered, force to FLOAT
        firstUserInput = Double.parseDouble(screenText);

        //Assign the operation selected
        calculation = button.getText().toString();
    }

    //This function handles the user wishing to calculate their math
    public void equalsClicked (View v)
    {
        //Assign whatever the number clicked to a currentInput
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        Button button = (Button) v;
        String string = (String) button.getText().toString();
        screenText=textView2.getText().toString();

        //Set answer variable back to default
        answer = 0.0;

        //Assign second number entered, force to FLOAT
        secondUserInput = Double.parseDouble(screenText);

        //Check what operation was chosen
        if (calculation.equals("+"))
        {
            //adition
            answer = firstUserInput + secondUserInput;
        }
        else if (calculation.equals("-"))
        {
            //subtraction
            answer = firstUserInput - secondUserInput;
        }
        else if (calculation.equals("X"))
        {
            //multiplication
            answer = firstUserInput * secondUserInput;
        }
        else if (calculation.equals("/"))
        {
            //Division
            answer = firstUserInput / secondUserInput;
        }
        else if (calculation.equals("%"))
        {
            //Modulas
            answer = firstUserInput % secondUserInput;
        }

        //Update Calc with answer
        textView2.setText(String.valueOf(firstUserInput+" "+calculation+" "+secondUserInput+" "+" = "+answer));

        //Set boolean to false, user is done typing question
        stillTypingNumber = false;
    }

    //This function handles the user clearing the screen
    public void clearScreenClicked (View v)
    {
        //Grab and assign screen for clearing
        TextView textView2 = (TextView) findViewById(R.id.textView2);

        //Reset variables back to default
        stillTypingNumber = false;
        firstUserInput = 0;
        secondUserInput = 0;
        calculation = "";
        screenText = "";

        //Wipe calculation screen
        textView2.setText("0.0");
    }

    //This function handles the user selecting the inverse button
    public void inverseClicked (View v)
    {
        //Assign whatever the number clicked to a currentInput
        TextView textView2 = (TextView) findViewById(R.id.textView2);

        //Assign Calc text to temp number, force to FLOAT
        tempNum = Double.parseDouble(textView2.getText().toString());

            //Get inverse
            tempNum = (tempNum*(-1));

        //Update Calc display
        textView2.setText(textView2+"|"+String.valueOf(tempNum));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
