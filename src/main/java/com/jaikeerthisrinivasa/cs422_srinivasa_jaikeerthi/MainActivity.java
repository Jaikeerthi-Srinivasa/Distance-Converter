package com.jaikeerthisrinivasa.cs422_srinivasa_jaikeerthi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private TextView actionDisplay;
    private TextView heading1;
    private TextView heading2;
    private TextView history;
    public static double miles_to_kilometer = 1.60934;
    public static double kilometre_to_miles = 0.621371;
    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //actionDisplay = findViewById(R.id.actionDisplay);
        heading1 = findViewById(R.id.textView2);
        heading2 = findViewById(R.id.textView3);
        history = findViewById(R.id.textView5);
        heading1.setText("Miles value");
        heading2.setText("Kilometer value");
//        changTextFunc();
        history.setMovementMethod(new ScrollingMovementMethod());
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

//    public void radioClicked(View v) {
//        String selectionText = ((RadioButton) v).getText().toString();
//        actionDisplay.setText(String.format("Group 1: You Selected %s", selectionText));
//
//    }
//    void changTextFunc(){
//
//    }
    public void radioClicked2(View v) {
        String selectionText = ((RadioButton) v).getText().toString();

        if(selectionText.equals("Miles to Kilometer")){
            //actionDisplay.setText(String.format("Group 1: You Selected %s", selectionText));
            heading1.setText("Miles value");
            heading2.setText("Kilometer value");
        }
        if(selectionText.equals("Kilometer to Miles")){
            //Log.d(TAG, "radioClicked2: "+"Yes");
            //actionDisplay.setText(String.format("Group 1: You Selected %s", selectionText));
            heading1.setText("Kilometer value");
            heading2.setText("Miles value");
        }
    }
    public void doConvert(View v){
        //actionDisplay.setText(String.format(heading1.getText().toString()));
        if(heading1.getText().toString().equals("Miles value")){
            EditText ml = findViewById(R.id.milesvalue);//getting the user input for the miles value
            String value  = ml.getText().toString();//
            if(value.isEmpty()){
                //Log.d(TAG, "doConvert: "+"Yes");
                Toast.makeText(this,"Enter distance to Convert", Toast.LENGTH_SHORT).show();
            }
            else{
            double milesvalue = Double.parseDouble(value);//
            double kmvalue = milesvalue * miles_to_kilometer;
            TextView kilo = findViewById(R.id.kilometervalue);
            kilo.setText(String.format("%.1f",kmvalue));
            String result = String.format("%.1f",kmvalue);
            String value1 = history.getText().toString();
//            value1= heading1.getText().toString()+":"+milesvalue+"==="+heading2.getText().toString()+":"+result+"\n"+value1;
            value1= milesvalue+"Mi"+"==>"+result+"Km"+"\n"+value1;
            history.setText(value1);
            ml.setText("");
            }
//            }
//            if(ml.()){
//                Toast.makeText(this,"Enter distance to Convert", Toast.LENGTH_SHORT).show();
//            }

        }
        else{

            EditText ml = findViewById(R.id.milesvalue);//getting the user input for the miles value
            String value  = ml.getText().toString();//
            if(value.isEmpty()){
                //Log.d(TAG, "doConvert: "+"Yes");
                Toast.makeText(this,"Enter distance to Convert", Toast.LENGTH_SHORT).show();
            }
            else{
            double milesvalue = Double.parseDouble(value);//
            double kmvalue = milesvalue * kilometre_to_miles;
            TextView kilo = findViewById(R.id.kilometervalue);
            kilo.setText(String.format("%.1f",kmvalue));
            String result = String.format("%.1f",kmvalue);
            String value1 = history.getText().toString();
//            value1= heading1.getText().toString()+":"+milesvalue+"==="+heading2.getText().toString()+":"+result+"\n"+value1;
            value1= milesvalue+"Km"+"==>"+result+"Mi"+"\n"+value1;
            history.setText(value1);
            ml.setText("");}
        }
    }
    public void doClear(View v){
        history.setText("");
    }
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString("textView",history.getText().toString());//to save conversion history

        outState.putString("Input",heading1.getText().toString());
        outState.putString("Output",heading2.getText().toString());
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        history.setText(savedInstanceState.getString("textView"));//to restore conversion history
        heading1.setText(savedInstanceState.getString(  "Input"));
        heading2.setText(savedInstanceState.getString( "Output"));
    }
}
