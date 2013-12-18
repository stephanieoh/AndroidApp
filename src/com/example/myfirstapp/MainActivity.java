package com.example.myfirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  
        final TextView answer = (TextView) findViewById(R.id.textView1);
        final EditText price = (EditText) findViewById(R.id.editText1);
        final EditText tax = (EditText) findViewById(R.id.editText2);
        Button calculate = (Button) findViewById(R.id.button1);
        final RadioGroup percent = (RadioGroup) findViewById(R.id.radioGroup1);
        
        
        
        
        ((RadioButton) findViewById(R.id.ten)).setId(10);
        ((RadioButton) findViewById(R.id.fifteen)).setId(15);
        ((RadioButton) findViewById(R.id.twenty)).setId(20);
        
        
        
        calculate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Editable bob = price.getText();
		        String pricestring = bob.toString();
		        Editable sam = tax.getText();
		        String taxstring = sam.toString();
		        Double priceVal;
		        Double taxVal;
		        int multiplier = percent.getCheckedRadioButtonId();
		        //taxVal = Double.parseDouble(taxstring);
		        
		        if (taxstring.equals("")){
		        	taxVal = 0.;
		        } else
		        {
		        	taxVal = Double.parseDouble(taxstring);
		        }
		        
		        if(pricestring.equals("")){
		        	answer.setText("Type in a price!");
		        } else if (multiplier == -1) {
		        	answer.setText("Select a tip percent!!");
		        } else {
		        	priceVal = Double.parseDouble(pricestring);
		        	answer.setText(String.format("$%.2f", priceVal*(1+((taxVal+multiplier)*.01))));
		        }
				
				
			}
		});
    }

  

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
