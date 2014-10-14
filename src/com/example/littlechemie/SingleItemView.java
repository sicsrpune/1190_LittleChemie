package com.example.littlechemie;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
 
public class SingleItemView extends Activity {
    // Declare Variables
    TextView txtcountry;
    ImageView imgflag;
    String country;
    int flag;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);
        // Get the intent from ListViewAdapter
        //Intent i = getIntent();
        
        // Get the results of country
        //country = i.getStringExtra("country");
        
        // Get the results of flag
        //flag = i.getIntExtra("flag", flag);
 
        // Locate the TextViews in singleitemview.xml
        //txtcountry = (TextView) findViewById(R.id.country);
         
        // Locate the ImageView in singleitemview.xml
        //imgflag = (ImageView) findViewById(R.id.flag);
 
        // Load the results into the TextViews
        //txtcountry.setText(country);
        
        // Load the image into the ImageView
        //imgflag.setImageResource(flag);
    }
}

