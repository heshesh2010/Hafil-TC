package com.ictfox.hafil_tc;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import com.ictfox.hafil_tc.lastdays.TabHostActivityLastDays;

public class LastDaysAsyncTask extends AsyncTask<Void, Void, String>{
	ProgressDialog progressDialog;
	Activity mActivity;
	Context context;
	String BusId;
	String Date;
	String drivrsNid;
	String platenumber;
	String model; 
	int seat1; 
	String name;
	String busType;
	Cursor test;
	int fleetNumber;
	
	MySQLiteHelper dbHandler;
	
	public LastDaysAsyncTask(Activity activity, ProgressDialog progressDialog,
			String busID,String date, Context context) {
		super();
		this.progressDialog = progressDialog;
		this.mActivity = activity;
		this.context = context;
		this.BusId=busID;
		this.Date=date;
	}
	
	@Override
	protected String doInBackground(Void... voids) {

   

		   MySQLiteHelper dbHandler = new MySQLiteHelper(this.context);
		   test =    dbHandler.getAllBusInfoLastDate(this.Date);
		   if(test.getCount() >= 1){
			   if (test.moveToFirst()) {
			   do {
				   fleetNumber = test.getInt(1);
			   }while (test.moveToNext());
				 }
				   test.close();
				   }
	return 	"ok";
		
	
	
  
}

@Override
protected void onPostExecute(String result) {
	Intent ii=new Intent(this.mActivity, TabHostActivityLastDays.class);
	SharedPreferences prefs = PreferenceManager
			.getDefaultSharedPreferences(this.mActivity);
	prefs.edit().putInt("fleetnumber", fleetNumber).apply();
	prefs.edit().putString("BusId", BusId).apply();
	this.progressDialog.dismiss();
    ii.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(ii);
    
}
}
