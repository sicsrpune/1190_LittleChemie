package com.example.littlechemie;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
 
public class NewGame extends Activity implements TextToSpeech.OnInitListener 
{ 	
	int count = 0;
	int countn = count;
	String droppedItem = "",droppedItem1 = "",droppedItem2 = "";	
    ListView list;
    ListViewAdapter adapter;
   
    String[] country;    
    int[] flag;
    TextView tv; 
    ArrayList<WorldPopulation> arraylist = new ArrayList<WorldPopulation>();
    LinearLayout targetLayout;
    ListView listSource;    
    ImageView listTarget,listTarget1,listTarget2;
    TextToSpeech tts;
   
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        
       
        tts=new TextToSpeech(getApplicationContext(),this);
        targetLayout = (LinearLayout)findViewById(R.id.targetlayout);
        list = 	(ListView)findViewById(R.id.listview);
        listTarget = (ImageView)findViewById(R.id.targetlist);
        listTarget1 = (ImageView)findViewById(R.id.targetlist1);
        listTarget2 = (ImageView)findViewById(R.id.targetlist2);
        tv = (TextView)findViewById(R.id.targettextview);
        
        try{
             	country = new String[]
        			{
        			"Acidrain", "Air","Airplane","Alarm Clock","Alcohol","Ambulance","Antarctica","Astronut","Atmosphere","Atomic Bomb","Axe",
        			"Banana","Bat","Batman","Batter","Beach","Bee","Bird","Blade","Blood","Boat","Boiler","Brick","Bridge","Bullet","Bus",
        			"Cactus","Camel","Car","Carbon Dioxide","Cat","Cigarette","Clay","Clock","Cloud","Coal","Coffin","Cold","Computer","Computer Mouse","Cookie","Corpse","Cotton","Cow","Crow", 
        			"Dam","Day","Desert","Diamond","Dinosaur","Doctor","Dog","Dough","Dry Ice","Duck","Dune","Dust","Dynamite",
        			"Eagle","Earth","Egg","Electricity","Email","Energy","Explosion",
        			"Farm","Farmer","Fence","Field","Fire","Fireman","Firetruck","Fireworks","Fish","Flour","Flower","Fog","Fossil","Fountain","Frog","Fruit",
        			"Glacier","Grass","Grave","Gun","Gunpowder",
        			"Ham","Helicopter","Hippo","Honey","Horizon","Hospital","House","Human",
        			"Ice","Ice Berg","Ice Cream","Internet",
        			"Jack O Lantern","Juice","Jam",
        			"Lava","Leather","Lemonade","Letter","Life","Light","Light House","Lion","Love","Lumberjack",
        			"Map","Meat","Metal","Milk","Milk Shake","Mountain","Monkey","Mouse","Mummy",
        			"Night",
        			"Oasis","Ocean","Oxygen",
        			"Paper","Pasta","Pencil","Penguin","Picnic","Pilot","Pipe","Planet","Plant","Pond","Popsicle","Pottery","Pressure","Printer","Pumpkin","Pyramid",
        			"Rain","Rainbow","River","Robot","Rocket","Rose",
        			"Sailboat","Sailor","Salt","Sand","Sandwich","Santa","Seal","Shark","Skeleton","Sky","Smog","Smoke","Soda","Space","Space Station","Sphinx","Statue","Steam","Steamboat","Steamengine","Stone","Sugar","Sun","Sun Flower","Sword",
        			"Tank","Taser","Tide","Time","Titanic","Toast","Tobacco","Tool","Tractor","Train","Tree",
        			"Unicorn",
        			"Vase","Vegetable", "Volcano","Vulture",
        			"Wall","Water Gun", "Water", "Water Pipe","Wheat","Wheel","Wild Animal","Wind","Windmmill","Wind Turbine","Wine","Wire","Wolf","Wood",
        			"Zombie"
        			};
   
        	flag = new int[] {
        			R.drawable.acidrain152,R.drawable.air4,R.drawable.airplane153,R.drawable.alarmclock404,R.drawable.alcohol203,R.drawable.ambulance334,R.drawable.antarctica159,R.drawable.astronaut162,R.drawable.atmosphere163,R.drawable.atomicbomb164,R.drawable.axe57,       		 		
        			
        			R.drawable.banana394,R.drawable.bat264,R.drawable.batman343,R.drawable.batter479,R.drawable.beach107,R.drawable.bee461,R.drawable.bird46,R.drawable.blade55,R.drawable.blood112,R.drawable.boat100,R.drawable.boiler38,R.drawable.brick172,R.drawable.bridge365,R.drawable.bullet39,R.drawable.bus508,        		  		
        			          		
        			R.drawable.cactus102,R.drawable.camel246,R.drawable.car175,R.drawable.carbondioxide363,R.drawable.cat238,R.drawable.cigarette221,R.drawable.clay50,R.drawable.clock117,R.drawable.cloud15,R.drawable.coal30,R.drawable.coffin97,R.drawable.cold143,R.drawable.computer230,R.drawable.computermouse441,R.drawable.cookie267,R.drawable.corpse95,R.drawable.cotton431,R.drawable.cow76, R.drawable.crow485,                
        			                  
        			R.drawable.dam344,R.drawable.day126,R.drawable.desert101,R.drawable.diamond31,R.drawable.dinosaur180,R.drawable.doctor207,R.drawable.dog181,R.drawable.dough86,R.drawable.dryice397,R.drawable.duck182,R.drawable.dune183,R.drawable.dust14,R.drawable.dynamite288,        		
        			          		
        			R.drawable.eagle332,R.drawable.earth3,R.drawable.egg49,R.drawable.electricity114,R.drawable.email314,R.drawable.energy11,R.drawable.explosion26,        		
        			          		
        			R.drawable.farm496,R.drawable.farmer71,R.drawable.fence424,R.drawable.field70,R.drawable.fire2,R.drawable.fireman106,R.drawable.firetruck421,R.drawable.fireworks189,R.drawable.fish68,R.drawable.flour85,R.drawable.flower416,R.drawable.fog191,R.drawable.fossil224,R.drawable.fountain476,R.drawable.frog504,R.drawable.fruit88,        		
        			          		
        			R.drawable.glacier202,R.drawable.grass75,R.drawable.grave98,R.drawable.gun94,R.drawable.gunpowder25,
        			          		
        			R.drawable.ham93,R.drawable.helicopter411,R.drawable.hippo468,R.drawable.hoiney464,R.drawable.horizon197,R.drawable.hospital199,R.drawable.house72,R.drawable.human48,
        			          		        		
        			R.drawable.ice148,R.drawable.iceberg268,R.drawable.icecream200,R.drawable.internet345,
        			          		
        			R.drawable.jack_o_lantern460,R.drawable.juice256,R.drawable.jam483,
        			          		
        			R.drawable.lava6,R.drawable.leather348,R.drawable.lemonade449,R.drawable.letter260,R.drawable.life44,R.drawable.light122,R.drawable.lighthouse301,R.drawable.lion285,R.drawable.love59,R.drawable.lumberjack60,
        			                
        			R.drawable.map428, R.drawable.meat90, R.drawable.metal36,R.drawable.milk77,R.drawable.milkshake427,R.drawable.mmountain201,R.drawable.monkey303,R.drawable.mouse231,R.drawable.mummy388,
        			
        			R.drawable.night127,
        			
        			R.drawable.oasis215, R.drawable.ocean10,R.drawable.oxygen355,
        			           		
        			R.drawable.paper208,R.drawable.pasta442,R.drawable.pencil233,R.drawable.penguin150,R.drawable.picnic413,R.drawable.pilot222,R.drawable.pipe81,R.drawable.planet248,R.drawable.plant24,R.drawable.pond360,R.drawable.popsicle277,R.drawable.pottery52,R.drawable.pressure7,R.drawable.printer369,R.drawable.pumpkin458,R.drawable.pyramid356,
        			       			                   
        			R.drawable.rain13,R.drawable.rainbow110,R.drawable.river266,R.drawable.robot216,R.drawable.rocket249,R.drawable.rose415,
        			           		
        			R.drawable.sailboat113,R.drawable.sailor245,R.drawable.salt210,R.drawable.sand28,R.drawable.sandwich91,R.drawable.santa371,R.drawable.seal410,R.drawable.shark227,R.drawable.skeleton453,R.drawable.sky22,R.drawable.smog253,R.drawable.smoke92,R.drawable.soda502,R.drawable.space228,R.drawable.spacestation474,R.drawable.sphinx482,R.drawable.statue320,R.drawable.steam5,R.drawable.steamboat62,R.drawable.steamengine54,R.drawable.stone27,R.drawable.sugar263,R.drawable.sun108,R.drawable.sunflower124,R.drawable.sword149,
        			                   
        			R.drawable.tank391,R.drawable.taser486,R.drawable.tide131,R.drawable.time41,R.drawable.titanic386,R.drawable.toast147,R.drawable.tobacco80,R.drawable.tool53,R.drawable.tractor503,R.drawable.train61,R.drawable.tree42,
        			           		
        			R.drawable.unicorn219,
        			           		
        			R.drawable.vase473,R.drawable.vegetable457,R.drawable.volcano8,R.drawable.vulture269,
        			           		
        			R.drawable.wall247,R.drawable.wategun405,R.drawable.water1,R.drawable.water_pipe139,R.drawable.wheat84,R.drawable.wheel82,R.drawable.wildanimal140,R.drawable.wind20,R.drawable.windmmill151,R.drawable.windturbine406,R.drawable.wine235,R.drawable.wire119,R.drawable.wolf242,R.drawable.wood56,	
        			
        			R.drawable.zombie96
        			};      
 
        for (int i = 0; i < country.length; i++)
        {
            WorldPopulation wp = new WorldPopulation(country[i],flag[i]);
            // Binds all strings into an array
            arraylist.add(wp);
        }
        }
        catch(ArrayIndexOutOfBoundsException ai)
        {ai.printStackTrace();}
        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);
 
        // Binds the Adapter to the ListView
        list.setAdapter(adapter);
        
    

        
        MyDragEventListener myDragEventListener = new MyDragEventListener();
        
        list.setOnDragListener(myDragEventListener);
        listTarget.setOnDragListener(myDragEventListener);
        listTarget1.setOnDragListener(myDragEventListener);
        listTarget2.setOnDragListener(myDragEventListener);

        list.setOnItemLongClickListener(new OnItemLongClickListener() 
        {
        	@Override
        	public boolean onItemLongClick(AdapterView<?> l, View v,
        			int position, long id) 
        	{ //((TextView)v).getText() - return key to new array, value R.id.car;selectedImage = items[car]=R.drawable.car
        		//Selected item is passed as item in dragData
        		ClipData.Item item = new ClipData.Item(country[position]);
         
        		String[] clipDescription = {ClipDescription.MIMETYPE_TEXT_PLAIN};
        		ClipData dragData = new ClipData("hola",clipDescription,item);
        		DragShadowBuilder myShadow = new MyDragShadowBuilder(v);

        		v.startDrag(dragData, //ClipData
                        	myShadow,  //View.DragShadowBuilder
                        	null,  //Object myLocalState
                        	0);    //flags
         
        		return true;
        		}
        	});
        
    	}
        
	@Override
	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {
			 
            int result = tts.setLanguage(Locale.US);
            tts.setSpeechRate((float) 0.3);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            }
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
		

		
	}
    
    	private static class MyDragShadowBuilder extends View.DragShadowBuilder 
    	{
    		private static Drawable shadow;
    
    		public MyDragShadowBuilder(View v) 
    		{
    			super(v);
    			shadow = new ColorDrawable(Color.LTGRAY);
    		}
    
    		@Override
    		public void onProvideShadowMetrics (Point size, Point touch)
    		{
    			int width = getView().getWidth();
    			int height = getView().getHeight();

    			shadow.setBounds(0, 0, width, height);
    			size.set(width, height);
    			touch.set(width / 2, height / 2);
    		}

    		@Override
    		public void onDrawShadow(Canvas canvas) 
    		{
    			shadow.draw(canvas);
    		}
    
    	}
   
    	protected class MyDragEventListener implements View.OnDragListener 
    	{
    		
    		int previous = 0;
    		String[] country = new String[]
    				{
    				"Acidrain", "Air","Airplane","Alarm Clock","Alcohol","Ambulance","Antarctica","Astronut","Atmosphere","Atomic Bomb","Axe",
    				"Banana","Bat","Batman","Batter","Beach","Bee","Bird","Blade","Blood","Boat","Boiler","Brick","Bridge","Bullet","Bus",
    				"Cactus","Camel","Car","Carbon Dioxide","Cat","Cigarette","Clay","Clock","Cloud","Coal","Coffin","Cold","Computer","Computer Mouse","Cookie","Corpse","Cotton","Cow","Crow", 
    				"Dam","Day","Desert","Diamond","Dinosaur","Doctor","Dog","Dough","Dry Ice","Duck","Dune","Dust","Dynamite",
    				"Eagle","Earth","Egg","Electricity","Email","Energy","Explosion",
    				"Farm","Farmer","Fence","Field","Fire","Fireman","Firetruck","Fireworks","Fish","Flour","Flower","Fog","Fossil","Fountain","Frog","Fruit",
    				"Glacier","Grass","Grave","Gun","Gunpowder",
    				"Ham","Helicopter","Hippo","Honey","Horizon","Hospital","House","Human",
    				"Ice","Ice Berg","Ice Cream","Internet",
    				"Jack O Lantern","Juice","Jam",
    				"Lava","Leather","Lemonade","Letter","Life","Light","Light House","Lion","Love","Lumberjack",
    				"Map","Meat","Metal","Milk","Milk Shake","Mountain","Monkey","Mouse","Mummy",
    				"Night",
    				"Oasis","Ocean","Oxygen",
    				"Paper","Pasta","Pencil","Penguin","Picnic","Pilot","Pipe","Planet","Plant","Pond","Popsicle","Pottery","Pressure","Printer","Pumpkin","Pyramid",
    				"Rain","Rainbow","River","Robot","Rocket","Rose",
    				"Sailboat","Sailor","Salt","Sand","Sandwich","Santa","Seal","Shark","Skeleton","Sky","Smog","Smoke","Soda","Space","Space Station","Sphinx","Statue","Steam","Steamboat","Steamengine","Stone","Sugar","Sun","Sun Flower","Sword",
    				"Tank","Taser","Tide","Time","Titanic","Toast","Tobacco","Tool","Tractor","Train","Tree",
    				"Unicorn",
    				"Vase","Vegetable", "Volcano","Vulture",
    				"Wall","Water Gun", "Water", "Water Pipe","Wheat","Wheel","Wild Animal","Wind","Windmmill","Wind Turbine","Wine","Wire","Wolf","Wood",
    				"Zombie"
    				};
    
    		int[] flag = new int[] {
    				R.drawable.acidrain152,R.drawable.air4,R.drawable.airplane153,R.drawable.alarmclock404,R.drawable.alcohol203,R.drawable.ambulance334,R.drawable.antarctica159,R.drawable.astronaut162,R.drawable.atmosphere163,R.drawable.atomicbomb164,R.drawable.axe57,       		 		
        			
        			R.drawable.banana394,R.drawable.bat264,R.drawable.batman343,R.drawable.batter479,R.drawable.beach107,R.drawable.bee461,R.drawable.bird46,R.drawable.blade55,R.drawable.blood112,R.drawable.boat100,R.drawable.boiler38,R.drawable.brick172,R.drawable.bridge365,R.drawable.bullet39,R.drawable.bus508,       		  		
        			          		
        			R.drawable.cactus102,R.drawable.camel246,R.drawable.car175,R.drawable.carbondioxide363,R.drawable.cat238,R.drawable.cigarette221,R.drawable.clay50,R.drawable.clock117,R.drawable.cloud15,R.drawable.coal30,R.drawable.coffin97,R.drawable.cold143,R.drawable.computer230,R.drawable.computermouse441,R.drawable.cookie267,R.drawable.corpse95,R.drawable.cotton431,R.drawable.cow76, R.drawable.crow485,                
        			                  
        			R.drawable.dam344,R.drawable.day126,R.drawable.desert101,R.drawable.diamond31,R.drawable.dinosaur180,R.drawable.doctor207,R.drawable.dog181,R.drawable.dough86,R.drawable.dryice397,R.drawable.duck182,R.drawable.dune183,R.drawable.dust14,R.drawable.dynamite288,        		
        			          		
        			R.drawable.eagle332,R.drawable.earth3,R.drawable.egg49,R.drawable.electricity114,R.drawable.email314,R.drawable.energy11,R.drawable.explosion26,        		
        			          		
        			R.drawable.farm496,R.drawable.farmer71,R.drawable.fence424,R.drawable.field70,R.drawable.fire2,R.drawable.fireman106,R.drawable.firetruck421,R.drawable.fireworks189,R.drawable.fish68,R.drawable.flour85,R.drawable.flower416,R.drawable.fog191,R.drawable.fossil224,R.drawable.fountain476,R.drawable.frog504,R.drawable.fruit88,        		
        			          		
        			R.drawable.glacier202,R.drawable.grass75,R.drawable.grave98,R.drawable.gun94,R.drawable.gunpowder25,
        			          		
        			R.drawable.ham93,R.drawable.helicopter411,R.drawable.hippo468,R.drawable.hoiney464,R.drawable.horizon197,R.drawable.hospital199,R.drawable.house72,R.drawable.human48,
        			          		        		
        			R.drawable.ice148,R.drawable.iceberg268,R.drawable.icecream200,R.drawable.internet345,
        			          		
        			R.drawable.jack_o_lantern460,R.drawable.juice256,R.drawable.jam483,
        			          		
        			R.drawable.lava6,R.drawable.leather348,R.drawable.lemonade449,R.drawable.letter260,R.drawable.life44,R.drawable.light122,R.drawable.lighthouse301,R.drawable.lion285,R.drawable.love59,R.drawable.lumberjack60,
        			                
        			R.drawable.map428, R.drawable.meat90, R.drawable.metal36,R.drawable.milk77,R.drawable.milkshake427,R.drawable.mmountain201,R.drawable.monkey303,R.drawable.mouse231,R.drawable.mummy388,
        			
        			R.drawable.night127,
        			
        			R.drawable.oasis215, R.drawable.ocean10,R.drawable.oxygen355,
        			           		
        			R.drawable.paper208,R.drawable.pasta442,R.drawable.pencil233,R.drawable.penguin150,R.drawable.picnic413,R.drawable.pilot222,R.drawable.pipe81,R.drawable.planet248,R.drawable.plant24,R.drawable.pond360,R.drawable.popsicle277,R.drawable.pottery52,R.drawable.pressure7,R.drawable.printer369,R.drawable.pumpkin458,R.drawable.pyramid356,
        			       			                   
        			R.drawable.rain13,R.drawable.rainbow110,R.drawable.river266,R.drawable.robot216,R.drawable.rocket249,R.drawable.rose415,
        			           		
        			R.drawable.sailboat113,R.drawable.sailor245,R.drawable.salt210,R.drawable.sand28,R.drawable.sandwich91,R.drawable.santa371,R.drawable.seal410,R.drawable.shark227,R.drawable.skeleton453,R.drawable.sky22,R.drawable.smog253,R.drawable.smoke92,R.drawable.soda502,R.drawable.space228,R.drawable.spacestation474,R.drawable.sphinx482,R.drawable.statue320,R.drawable.steam5,R.drawable.steamboat62,R.drawable.steamengine54,R.drawable.stone27,R.drawable.sugar263,R.drawable.sun108,R.drawable.sunflower124,R.drawable.sword149,
        			                   
        			R.drawable.tank391,R.drawable.taser486,R.drawable.tide131,R.drawable.time41,R.drawable.titanic386,R.drawable.toast147,R.drawable.tobacco80,R.drawable.tool53,R.drawable.tractor503,R.drawable.train61,R.drawable.tree42,
        			           		
        			R.drawable.unicorn219,
        			           		
        			R.drawable.vase473,R.drawable.vegetable457,R.drawable.volcano8,R.drawable.vulture269,
        			           		
        			R.drawable.wall247,R.drawable.wategun405,R.drawable.water1,R.drawable.water_pipe139,R.drawable.wheat84,R.drawable.wheel82,R.drawable.wildanimal140,R.drawable.wind20,R.drawable.windmmill151,R.drawable.windturbine406,R.drawable.wine235,R.drawable.wire119,R.drawable.wolf242,R.drawable.wood56,	
        			
        			R.drawable.zombie96
     				           
    				};       
    				       

    		@Override
    		public boolean onDrag(View v, DragEvent event) 
    		{
    			final int action = event.getAction(); 
    			
    			switch(action) 
    			{
    				case DragEvent.ACTION_DRAG_STARTED:
    					if (event.getClipDescription()
    							.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN))
    					{
    						return true;
    					}
    					else
    					{
    						return false; //reject
    					}
     
    					case DragEvent.ACTION_DRAG_ENTERED:
    						return true;
    					case DragEvent.ACTION_DRAG_LOCATION:
    						return true;
    					case DragEvent.ACTION_DRAG_EXITED:
    						return true;
    					case DragEvent.ACTION_DROP:
    						// Gets the item containing the dragged data
    						ClipData.Item item = event.getClipData().getItemAt(0);

    						if(v == listTarget)
    						{
    							int position;
    							droppedItem = item.getText().toString();
    							//Log.i("Helllo",droppedItem+" How you");
    							for(int i=0; i<country.length;i++)
    							{
    								if(droppedItem.equalsIgnoreCase(country[i]))
    								{
    									position = i;
    									listTarget.setImageResource(flag[position]);
    									tts.speak(country[i], TextToSpeech.QUEUE_FLUSH, null);
    									//listTarget.setBackgroundColor(Color.CYAN);
    								}
    							} 
    							return true;
    						}
      
    						if(v == listTarget1)
    						{
    							int position;
    							droppedItem1 = item.getText().toString();
    							Log.i("Helllo",droppedItem1+"How you");
    							for(int i=0; i<country.length;i++)
    							{
    								if(droppedItem1.equalsIgnoreCase(country[i]))
    								{
    									position = i;
    									listTarget1.setImageResource(flag[position]);
    									tts.speak(country[i], TextToSpeech.QUEUE_FLUSH, null);
    									//listTarget1.setBackgroundColor(Color.GREEN);
    									
    								}
    							}
    							return true;
    						}
      
    						if(v == listTarget2)
    						{
    							int position;
    							droppedItem2 = item.getText().toString();
    							Log.i("Helllo",droppedItem2+"How you");
    							for(int i=0; i<country.length;i++)
    							{
    								if(droppedItem2.equalsIgnoreCase(country[i]))
    								{
    									position = i;
    									listTarget2.setImageResource(flag[position]);
    									tts.speak(country[i], TextToSpeech.QUEUE_FLUSH, null);
    									//listTarget2.setBackgroundColor(Color.MAGENTA);
    								}
    							}
    							   	if(!droppedItem.equals("") && !droppedItem1.equals(""))	
    							   	{					
    							   		SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();    							
    							   		int i = getContent(droppedItem, droppedItem1, droppedItem2);    							
    							   		editor.putInt("PREVIOUS", i);
    							   		editor.commit();
    							   		if(i>0)
    							   		{				
    							   			if(previous == i){
    							   		}
    							   		else 
    							   		{
    									count++;
    									SharedPreferences prefs1 = getPreferences(MODE_PRIVATE); 
    		   							previous = prefs1.getInt("PREVIOUS", -1);
    		   							tv.setText(Integer.toString(count));
    							   		}
    							   	}
    							   	
    							   		else
    							   		{
    							   			int duration = Toast.LENGTH_SHORT;
    							   			Context context = getApplicationContext();
    							   			CharSequence text = "Try Again !!!";
    							   			//String text = "This is a Wrong Combination so Try Again ";
    							   			Toast.makeText(context, text, duration).show();
    							   			//tv.setText(Integer.toString(count));
    							   			//tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    							   		}
    							   	}
    							   	else
    							   	{
    							   		int duration = Toast.LENGTH_SHORT;
							   			Context context = getApplicationContext();
							   			CharSequence text = "Drag  Sequentially ";
							   			Toast.makeText(context, text, duration).show();
							   			
    							   	}
    							return true;
    							
    						}
    						
              
	     case DragEvent.ACTION_DRAG_ENDED:
	    	 if (event.getResult())
	    	 {
	       //commentMsg += v.getTag() + " : ACTION_DRAG_ENDED - success.\n";
	       //comments.setText(commentMsg);
	      } else 
	      {
	       //commentMsg += v.getTag() + " : ACTION_DRAG_ENDED - fail.\n";
	      // comments.setText(commentMsg);
	      };
	        return true;
	     default: //unknown case
	      //commentMsg += v.getTag() + " : UNKNOWN !!!\n";
	      //comments.setText(commentMsg);
	      return false;
	
	     }
    } 
    		
    		public int getContent(String item1,String item2,String item3){
    			
    			int flag = 0;
    			
    			try {
    				Resources res = getResources();
    				
    				String combinations[] = res.getStringArray(R.array.combination);
    				
    				for(int i = 0; i < combinations.length; i++) {
    					
    					String combination[] = combinations[i].split(":");
    					
    					if(combination[0].equalsIgnoreCase(item1) && combination[1].equalsIgnoreCase(item2) && combination[2].equalsIgnoreCase(item3))
    					{
    						flag = 1 + i;
    						break;
    					}
    				}
    			}
    			catch(NullPointerException e){}
    			return flag;
    		}
   }
    	
}

