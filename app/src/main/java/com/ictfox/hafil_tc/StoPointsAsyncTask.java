package com.ictfox.hafil_tc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.widget.TextView;

import java.text.ParseException;

public class StoPointsAsyncTask extends AsyncTask<Void, Void, String>{


	Activity mActivity;
	Context context;
	ProgressDialog progressDialog;
	String flateNumber;
	String drivrsNid;
	int fleetnumber;
	String platenumber;
	String model; 
	int seat1; 
	String name;
	String busType;
	Cursor test;
	int busID;
	MySQLiteHelper dbHandler;
	
	public StoPointsAsyncTask(Activity activity, ProgressDialog progressDialog,
			String theNUM, Context context) {
		super();
		this.progressDialog = progressDialog;
		this.mActivity = activity;
		this.context = context;
		this.flateNumber=theNUM;
	}
	
	@Override
	protected String doInBackground(Void... voids) {
		
		   MySQLiteHelper dbHandler = new MySQLiteHelper(this.context);
			try {
				String Exception = dbHandler.getPathStatus(this.flateNumber);
				if(Exception.equals("Closed")){

					return "error";


				}

				else{




		   test =    dbHandler.getBusInfoForCheckPoints(this.flateNumber);

		   if(test.getCount() >= 1){
			   do{

				   platenumber = test.getString(0);
				   name=test.getString(2);

			   }while(test.moveToNext());

		   }
		   else if (test.getCount()==0){


			   return "error";

		   }


				}
				}
				 catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		return "ok";










	}
	
	@Override
	protected void onPostExecute(String result) {
		 if(result.equals("error") ){
			 progressDialog.dismiss();
		 
		 
			 AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.mActivity);
		      
		        // Setting Dialog Title
		        alertDialog.setTitle("خطأ");
		  
		        // Setting Dialog Message
		        alertDialog.setMessage("خطأ لا يوجد مسار مفتوح");
		  
		        // On pressing Settings button
		        alertDialog.setPositiveButton("المحاوله مجددا", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog,int which) {
		            }
		        });
		 
		  
		        // Showing Alert Message
		        alertDialog.show();
		    }


		 else{
		// using coustom font
		Typeface font = Typeface.createFromAsset(mActivity.getAssets(), "HelveticaNeueW23-Reg.ttf");
			
		TextView DriverName = (TextView) mActivity.findViewById(R.id.textView4);
		TextView plateNumber = (TextView) mActivity.findViewById(R.id.textView3);
		DriverName.setTypeface(font);
		plateNumber.setTypeface(font);
		DriverName.setText(name);
		plateNumber.setText(String.valueOf(platenumber));
		
		
		progressDialog.dismiss();
		 ((MyApplication) mActivity.getApplication()).setall(fleetnumber, platenumber, model, seat1, drivrsNid, name,busType,busID );
		 }
	}
}
	
		

