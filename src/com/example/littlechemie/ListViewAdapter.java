package com.example.littlechemie;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class ListViewAdapter extends BaseAdapter {
 
    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<WorldPopulation> worldpopulationlist = null;
    private ArrayList<WorldPopulation> arraylist;
 
    public ListViewAdapter(Context context,List<WorldPopulation> worldpopulationlist) {
        mContext = context;
        this.worldpopulationlist = worldpopulationlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<WorldPopulation>();
        this.arraylist.addAll(worldpopulationlist);
    }
 
    public class ViewHolder {        
        TextView country;        
        ImageView flag;
    }
 
    @Override
    public int getCount() {
        return worldpopulationlist.size();
    }
 
    @Override
    public WorldPopulation getItem(int position) {
        return worldpopulationlist.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml           
            holder.country = (TextView) view.findViewById(R.id.country);            
            // Locate the ImageView in listview_item.xml
            holder.flag = (ImageView) view.findViewById(R.id.flag);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.country.setText(worldpopulationlist.get(position).getCountry());
        // Set the results into ImageView
        holder.flag.setImageResource(worldpopulationlist.get(position).getFlag());
        // Listen for ListView Item Click
//      view.setOnLongClickListener(new OnLongClickListener() {
 
//            @Override
//            public boolean onLongClick(View arg0) {
//                // Send single item click data to SingleItemView Class
//                //Intent intent = new Intent(mContext, SingleItemView.class);
//                // Pass all data country
//                //intent.putExtra("country",(worldpopulationlist.get(position).getCountry()));
//                
//                // Pass all data flag
//                //intent.putExtra("flag",(worldpopulationlist.get(position).getFlag()));
//                // Start SingleItemView Class
//                //mContext.startActivity(intent);
//				return false;
//            }
//       });
 
        return view;
    }
 
    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        worldpopulationlist.clear();
        if (charText.length() == 0) {
            worldpopulationlist.addAll(arraylist);
        } else {
            for (WorldPopulation wp : arraylist) {
                if (wp.getCountry().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    worldpopulationlist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
 
}

