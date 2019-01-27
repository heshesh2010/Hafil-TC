package com.ictfox.hafil_tc.buscheck;


import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.ictfox.hafil_tc.MyApplication;
import com.ictfox.hafil_tc.MySQLiteHelper;
import com.ictfox.hafil_tc.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.widget.TextView;


public class BusInfoDATEBASE extends AsyncTask<Void, Void, String>{


	Activity mActivity;
	Context context;
	ProgressDialog progressDialog;
	int flateNumber;
	String drivrsNid;
	int BusId=0;
	String platenumber;
	String model; 
	int seat1; 
	String name;
	String busType;
	Cursor test;
Cursor test2;
	MySQLiteHelper dbHandler;
	public BusInfoDATEBASE(Activity activity, ProgressDialog progressDialog,
			int i, Context context) {
		super();
		this.progressDialog = progressDialog;
		this.mActivity = activity;
		this.context = context;
		this.flateNumber=i;
	}
	
	@Override
	protected String doInBackground(Void... voids) {

		   MySQLiteHelper dbHandler = new MySQLiteHelper(this.context);






		   test =    dbHandler.getAllBusInfo(this.flateNumber);
		   if(test.getCount() >= 1){
			   while(test.moveToNext()){

				   BusId=test.getInt(0);
				   platenumber = test.getString(1);
				   busType=test.getString(2);
				   model=test.getString(3);
				   seat1 = test.getInt(4);
				   drivrsNid = test.getString(5);
				   name=test.getString(6);
			 }
		   }
else{
               return "error";

           }
        test2 = dbHandler.isBusExists(this.BusId);
        if(test2.getCount() >= 1){
            return "error";

        }
       return "ok";
	}
	
	@Override
	protected void onPostExecute(String result) {
        progressDialog.dismiss();

        if(result.equals("error")) {
            Toast.makeText(context.getApplicationContext(), "تاكد ان الرقم لم يتم عمل له فحص اليوم او ان الرقم صحيح", Toast.LENGTH_SHORT).show();
        } else {
            // using coustom font
            Typeface font = Typeface.createFromAsset(mActivity.getAssets(), "HelveticaNeueW23-Reg.ttf");

            TextView DriverName = (TextView) mActivity.findViewById(R.id.textView5);
            TextView NationalID = (TextView) mActivity.findViewById(R.id.textView7);
            TextView plateNumber = (TextView) mActivity.findViewById(R.id.textView9);
            TextView BusTpye = (TextView) mActivity.findViewById(R.id.textView11);
            TextView BusModel = (TextView) mActivity.findViewById(R.id.textView13);
            TextView seats = (TextView) mActivity.findViewById(R.id.textView15);

            DriverName.setTypeface(font);
            NationalID.setTypeface(font);
            plateNumber.setTypeface(font);
            BusTpye.setTypeface(font);
            BusModel.setTypeface(font);
            seats.setTypeface(font);

            DriverName.setText(name);
            NationalID.setText(drivrsNid);
            plateNumber.setText(String.valueOf(platenumber));
            BusTpye.setText(busType);
            BusModel.setText(model);
            seats.setText(String.valueOf(seat1));
            SharedPreferences prefs = PreferenceManager
                    .getDefaultSharedPreferences(this.mActivity);

            prefs.edit().putInt("fleetnumber", this.flateNumber).apply();
            ((MyApplication) mActivity.getApplication()).setall(this.flateNumber, platenumber, model, seat1, drivrsNid, name, busType, BusId);

        }
    }
	
}
