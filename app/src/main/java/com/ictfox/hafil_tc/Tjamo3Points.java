package com.ictfox.hafil_tc;

import java.util.ArrayList;
import java.util.List;

import android.location.LocationListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Tjamo3Points extends ListActivity {
	List<Tjmo3Helper> fleetNumber = new ArrayList<Tjmo3Helper>();
	List<Tjmo3Helper> palateNumber = new ArrayList<Tjmo3Helper>();
	List<Tjmo3Helper> Dates = new ArrayList<Tjmo3Helper>();
	List<Tjmo3Helper> path = new ArrayList<Tjmo3Helper>();
	Cursor cursor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tjamo3_points);
		Button AddNewWay = (Button) findViewById(R.id.button1);
		
		
		
		
		MySQLiteHelper dbHandler = new MySQLiteHelper(Tjamo3Points.this);
		   cursor =    dbHandler.getCheckPointPathRows();
		

		   if(cursor.getCount() >= 1){
			   if(cursor.moveToFirst()){
		            do{
		            	fleetNumber.add(get(String.valueOf(cursor.getInt(0))));
		            	palateNumber.add(get(cursor.getString(1)));
		            	Dates.add(get(cursor.getString(2)));
		            	path.add(get(cursor.getString(3)));

		            }while(cursor.moveToNext());
		        }   
			   cursor.close();
		   }
		  
			
		   Tjamo3Adapter adapter = new Tjamo3Adapter(Tjamo3Points.this, fleetNumber,
				getApplicationContext(), palateNumber ,Dates, path);

		setListAdapter(adapter);	
		
		
		
		
		
		
		
		
		
		
		
		
		AddNewWay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		
				Intent intent1 = new Intent(Tjamo3Points.this, StoPoints.class);
				startActivity(intent1);	
				Tjamo3Points.this.finish();
		
			}
		});
		
		
		
		
		
		
	}
	private Tjmo3Helper get(String s) {

		return new Tjmo3Helper(s);

	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(Tjamo3Points.this);
		prefs.edit().remove("CurrentDate").commit();
		prefs.edit().remove("fleetnumber").commit();
		
	    TextView date = (TextView) v.findViewById(R.id.textView2);
	    TextView myView2 = (TextView) v.findViewById(R.id.TextView1);
	    String text = date.getText().toString();
	    String text2 = myView2.getText().toString();
	    

		
		prefs.edit().putString("CurrentDate", text).apply();
		prefs.edit().putString("fleetnumber", text2).apply();
		
		Intent intent1 = new Intent(Tjamo3Points.this, Tjamo3LastDate.class);
		startActivity(intent1);
		this.finish();
		
		
	}
	@Override
	protected void onResume() {
	    super.onResume();
Button AddNewWay = (Button) findViewById(R.id.button1);
		
fleetNumber.clear();
palateNumber.clear();
Dates.clear();
path.clear();
		
		MySQLiteHelper dbHandler = new MySQLiteHelper(Tjamo3Points.this);
		   cursor =    dbHandler.getCheckPointPathRows();
		

		   if(cursor.getCount() >= 1){
			   if(cursor.moveToFirst()){
		            do{
		            	fleetNumber.add(get(String.valueOf(cursor.getInt(0))));
		            	palateNumber.add(get(cursor.getString(1)));
		            	Dates.add(get(cursor.getString(2)));
		            	path.add(get(cursor.getString(3)));

		            }while(cursor.moveToNext());
		        }   
			   cursor.close();
		   }
		  
			
		   Tjamo3Adapter adapter = new Tjamo3Adapter(Tjamo3Points.this, fleetNumber,
				getApplicationContext(), palateNumber ,Dates, path);

		setListAdapter(adapter);	
	}
	
	
	
	
}
