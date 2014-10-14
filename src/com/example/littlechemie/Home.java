package com.example.littlechemie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;

public class Home extends Activity 
{
	public Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);       
        b1=(Button)findViewById(R.id.button1); 
        b1.setOnClickListener(myhandler1);
      
    }
    
      View.OnClickListener myhandler1 = new View.OnClickListener() {
        public void onClick(View v) {
        	Intent intent=new Intent(v.getContext(),NewGame.class);
        	startActivity(intent);
        }
      };
      

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {    
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        
    	
    	switch(item.getItemId())
    	{
    		case R.id.action_settings:
    			iconactivity();
    			return true;
    			
    		default: return super.onOptionsItemSelected(item);
    	}
        
    }

    public void iconactivity()
	{
		//Toast.makeText(this, "Home Option Selected", Toast.LENGTH_SHORT).show();
    	Intent intentobject=new Intent(getApplicationContext(),Action.class);
    	startActivity(intentobject);
	}
}