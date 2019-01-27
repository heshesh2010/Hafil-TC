package com.ictfox.hafil_tc;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

public class LastTaskeenAsyncTask extends AsyncTask<Void, Void, String>{
	ProgressDialog progressDialog;
	Activity mActivity;
	Context context;

String MinstaryNumber=""  ;
String fleetNumber=""   ;
String NATID=""   ;
String plateNumber=""   ;
String userName=""   ;
String schoolName=""   ;
String SchoolAdress=""   ;
String DriverName=""   ;
String DriverMobile=""   ;
String numOfOrders=""   ;
String Date="" ;
int type=0 ;
String note="";
String TaskeenArea ="";
String TaskeenCity = "";

	Cursor test;
	MySQLiteHelper dbHandler;

	public LastTaskeenAsyncTask(Activity activity, ProgressDialog progressDialog,
                                 String date, Context context) {
		super();
		this.progressDialog = progressDialog;
		this.mActivity = activity;
		this.context = context;
		this.Date=date;
	}
	
	@Override
	protected String doInBackground(Void... voids) {

   

		   MySQLiteHelper dbHandler = new MySQLiteHelper(this.context);
		   test =    dbHandler.getAllTaskeenInfoLastDate(this.Date);
		   if(test.getCount() >= 1){
			   if (test.moveToFirst()) {
			   do {
                   MinstaryNumber = String.valueOf(test.getInt(0));
                   fleetNumber= String.valueOf(test.getInt(1));
                   NATID= test.getString(2);
                   plateNumber=test.getString(3);
                   userName =test.getString(4);
                   schoolName= test.getString(5);
                   SchoolAdress=test.getString(6);
                   DriverName=test.getString(7);
                   DriverMobile=test.getString(8);
                   numOfOrders=test.getString(9);
                   Date=test.getString(10);
                   type=test.getInt(11);
                 note=test.getString(12);
                   TaskeenArea=test.getString(13);
                  TaskeenCity=test.getString(14);








			   }while (test.moveToNext());
				 }
				   test.close();
				   }
	return 	"ok";
		
	
	
  
}

@Override
protected void onPostExecute(String result) {
	Intent ii=new Intent(this.mActivity, TaskeenLastDays.class);
	SharedPreferences prefs = PreferenceManager
			.getDefaultSharedPreferences(this.mActivity);

	prefs.edit().putString("MinstaryNumber", MinstaryNumber).apply();
    prefs.edit().putString("fleetNumber", fleetNumber).apply();
    prefs.edit().putString("NATID", NATID).apply();
    prefs.edit().putString("plateNumber", plateNumber).apply();
    prefs.edit().putString("userName", userName).apply();
    prefs.edit().putString("schoolName", schoolName).apply();
    prefs.edit().putString("SchoolAdress", SchoolAdress).apply();
    prefs.edit().putString("DriverName", DriverName).apply();
    prefs.edit().putString("DriverMobile", DriverMobile).apply();
    prefs.edit().putString("numOfOrders", numOfOrders).apply();
    prefs.edit().putString("Date", Date).apply();
    prefs.edit().putInt("TaskeenType", type).apply();
    prefs.edit().putString("note", note).apply();
    prefs.edit().putString("TaskeenArea", TaskeenArea).apply();
    prefs.edit().putString("TaskeenCity", TaskeenCity).apply();


	this.progressDialog.dismiss();
    ii.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(ii);
    
}
}
