package com.ictfox.hafil_tc;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.ictfox.hafil_tc.buscheck.TabHostActivity;

import java.util.ArrayList;
import java.util.List;

public class LastDaysActivity extends ListActivity {
	Cursor cursor;
	List<String> busIDs = new ArrayList<String>();
	List<LastDaysHelper> Dates = new ArrayList<LastDaysHelper>();
	List<LastDaysHelper> plateNumber = new ArrayList<LastDaysHelper>();
List<LastDaysHelper> fleetNumber = new ArrayList<LastDaysHelper>();
List<LastDaysHelper> status = new ArrayList<LastDaysHelper>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_last_days);
		final Button newFourm = (Button) findViewById(R.id.button1);


        //ListView mListView = getListView();

		   
		   MySQLiteHelper dbHandler = new MySQLiteHelper(LastDaysActivity.this);
		   cursor =    dbHandler.GiridView();
		
		   if(cursor.getCount() >= 1){
			   if (cursor.moveToFirst()) {
				   do {

				   plateNumber.add(get(cursor.getString(0)));
                   fleetNumber.add(get(String.valueOf(cursor.getInt(1))));
                       Dates.add(get(cursor.getString(2)));
				   busIDs.add(String.valueOf(cursor.getInt(3)));
                       status.add(get(String.valueOf(cursor.getInt(4))));
				   }while (cursor.moveToNext());
				 }
			   cursor.close();
				   }
		  
		   
		
		
		
		
		
		
		LastDaysAdapter adapter = new LastDaysAdapter(this, Dates,
				getApplicationContext(), fleetNumber , plateNumber ,status);

		setListAdapter(adapter);

		newFourm.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(LastDaysActivity.this,
						TabHostActivity.class);
				startActivity(i);

			}
		});

	}

	private LastDaysHelper get(String s) {

		return new LastDaysHelper(s);

	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
	    TextView view1 = (TextView) v.findViewById(R.id.TextView1);
	    TextView Date = (TextView) v.findViewById(R.id.textView2);

	    String fleetNumber = view1.getText().toString();
	    String date = Date.getText().toString();
	    
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(LastDaysActivity.this);

        String text3 = date.replaceAll("\\s","");

		prefs.edit().putString("Date", text3).commit();
		
		
		ProgressDialog progressDialog = new ProgressDialog(
				LastDaysActivity.this);

		progressDialog.setMessage("جاري جلب البيانات برجاء الانتظار");
		progressDialog.show();
		progressDialog.setCancelable(false);
		progressDialog.setCanceledOnTouchOutside(false);
		
		LastDaysAsyncTask MyTask = new LastDaysAsyncTask(
					LastDaysActivity.this, progressDialog,busIDs.get(position),text3,
					LastDaysActivity.this.getApplicationContext()
					);
			MyTask.execute();
	}
}
