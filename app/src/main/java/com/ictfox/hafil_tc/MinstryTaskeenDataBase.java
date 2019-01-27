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

public class MinstryTaskeenDataBase extends AsyncTask<Void, Void, String>{

	Activity mActivity;
	Context context;
	ProgressDialog progressDialog;
	Cursor test;
	String schoolid="0";
	String schoolName="0";
	String adminname="0";
String mistrayNum;




	public MinstryTaskeenDataBase(Activity activity, ProgressDialog progressDialog,
                                  Context context, String mistrayNum) {
		super();
		this.progressDialog = progressDialog;
		this.mActivity = activity;
		this.context = context;
		this.mistrayNum=mistrayNum;
	}
	
	@Override
	protected String doInBackground(Void... voids) {


		   MySQLiteHelper dbHandler = new MySQLiteHelper(this.context);
		   test =    dbHandler.getAlllocationInfo(this.mistrayNum);
		   if(test.getCount() >= 1){
			   if (test.moveToFirst()) {
			   do {

				   schoolid = test.getString(0);
				   schoolName = test.getString(1);
				adminname = test.getString(2);
			   }while (test.moveToNext());
			 }
			   test.close();
			   }

		
		
		return "ok";

	}
	
	@Override
	protected void onPostExecute(String result) {
		

		// using coustom font
		Typeface font = Typeface.createFromAsset(mActivity.getAssets(), "HelveticaNeueW23-Reg.ttf");
			
		
		TextView schoolName = (TextView) mActivity.findViewById(R.id.textView15);
		TextView adminnamepostion = (TextView) mActivity.findViewById(R.id.textView16);
  
	  
		schoolName.setTypeface(font);
		adminnamepostion.setTypeface(font);

		
		schoolName.setText(this.schoolName);
		adminnamepostion.setText(this.adminname);
		
		
		progressDialog.dismiss();
		
		
		
		final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.mActivity);
		
		//backup();
		
		alertDialog.setTitle("خطأ");
		alertDialog.setMessage("لا يوجد بيانات .. برجاء التأكد من رقم الوزارة");
		alertDialog.setPositiveButton("نعم",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
					}
				});
		
		
		if (schoolName.getText().toString().equals("0")) {

			alertDialog.show();

		}
		
		((MyApplication) mActivity.getApplication()).setallLocationInfo(this.schoolid, this.schoolName);
		
	}
	
	
	
}