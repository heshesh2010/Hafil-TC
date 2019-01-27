package com.ictfox.hafil_tc;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;


public class ExcelImport extends AsyncTask<Void, Void, String>{
	Activity mActivity;
	Context context;
	ProgressDialog progressDialog;
	MySQLiteHelper dbHandler;
	String line = null;
	URL url;
	String str;
	String user;
	String pass;
	
	public ExcelImport(Activity activity, ProgressDialog progressDialog,
			 Context context,String user , String pass) {
		super();
		this.progressDialog = progressDialog;
		this.mActivity = activity;
		this.context = context;
		this.user=user;
		this.pass=pass;

	}
	
	@Override
	protected String doInBackground(Void... voids) {
		
	

 
		boolean flag_is_header = false;
		  dbHandler = new MySQLiteHelper(this.context);






		//////////////////////////////////*
		try {
			url = new URL(
					"http://hsts.hafilstc.com/HSTCWebServices/importexcel/schoolsmaster2.csv");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream(), "UTF-8"));
			dbHandler = new MySQLiteHelper(context);
			dbHandler.open();
			dbHandler.begin();
			while ((line = in.readLine()) != null) {
				String[] insertValues = line.split(",");
				if (flag_is_header) {


					
					 dbHandler.insertSchoolMaster(insertValues[0],
							insertValues[1], insertValues[2], insertValues[3],
							insertValues[4], insertValues[5]);

					//Log.e("no. of rows inserted", "" + row);
					 
				} else {
					flag_is_header = true;
				}
			}
			 dbHandler.setsucss();
			 dbHandler.end();
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			flag_is_header = false;
			dbHandler.close();
		}
		///////////////////////////////////////////*
		
		try {
			
			url = new URL("http://hsts.hafilstc.com/HSTCWebServices/importexcel/locations.csv");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"Windows-1256"));
			dbHandler = new MySQLiteHelper(context);
			dbHandler.open();
			dbHandler.begin();
			while ((line = in.readLine()) != null) {

				String[] insertValues = line.split(",");
				if (flag_is_header) {


					
					dbHandler.insertUserInfo(insertValues[0],
							insertValues[1],insertValues[2]);
					//Log.e("no. of rows inserted", ""+row);
					
				} else {
					flag_is_header = true;
				}
			}
			 dbHandler.setsucss();
			 dbHandler.end();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
finally {
	flag_is_header = false;
			dbHandler.close();
		}
		
		//===============================================
		try {
			url = new URL("http://hsts.hafilstc.com/HSTCWebServices/importexcel/schools.csv");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"Windows-1256"));
			dbHandler = new MySQLiteHelper(context);
			dbHandler.open();
			dbHandler.begin();
			while ((line = in.readLine()) != null) {

				String[] insertValues = line.split(",");
				if (flag_is_header) {


					
					dbHandler.insertSchools(insertValues[0],
 							insertValues[1],insertValues[2],insertValues[3]);
					//Log.e("no. of rows inserted", ""+row);
					
				} else {
					flag_is_header = true;
				}
			}
			 dbHandler.setsucss();
			 dbHandler.end();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			flag_is_header = false;
			dbHandler.close();
		}
		
		//======================================================
		
		try {
			url = new URL("http://hsts.hafilstc.com/HSTCWebServices/importexcel/drivers.csv");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
			dbHandler = new MySQLiteHelper(context);
			dbHandler.open();
			dbHandler.begin();
			while ((line = in.readLine()) != null) {

				String[] insertValues = line.split(",");
				if (flag_is_header) {


					dbHandler.insertDrivers(insertValues[0],
							insertValues[1],insertValues[2],insertValues[3]);
					//Log.e("no. of rows inserted", ""+row);

				} else {
					flag_is_header = true;
				}
			}
			 dbHandler.setsucss();
			 dbHandler.end();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		finally {
			flag_is_header = false;
			dbHandler.close();
		}
		
		//======================================================
		
		try {
			url = new URL("http://hsts.hafilstc.com/HSTCWebServices/importexcel/fleetmaster.csv");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"Windows-1256"));
			dbHandler = new MySQLiteHelper(context);
			dbHandler.open();
			dbHandler.begin();
			while ((line = in.readLine()) != null) {

				String[] insertValues = line.split(",");
				if (flag_is_header) {


					dbHandler.insertFleetMaster(insertValues[0],
							insertValues[1],insertValues[2],insertValues[3],insertValues[4],insertValues[5]);
					//Log.e("no. of rows inserted", ""+row);

				} else {
					flag_is_header = true;
				}

			}
			 dbHandler.setsucss();
			 dbHandler.end();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		finally {
			flag_is_header = false;
			dbHandler.close();
		}
		
		
		//======================================================
		
		try {
			url = new URL("http://hsts.hafilstc.com/HSTCWebServices/importexcel/schoolfleetdrivers.csv");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"Windows-1256"));
			dbHandler = new MySQLiteHelper(context);
			dbHandler.open();
			dbHandler.begin();
			while ((line = in.readLine()) != null) {

				String[] insertValues = line.split(",");
				if (flag_is_header) {


					dbHandler.insertSchoolFleetDrivers(insertValues[0],
							insertValues[1],insertValues[2]);
					//Log.e("no. of rows inserted", ""+row);

				} else {
					flag_is_header = true;
				}
			}
			
			 dbHandler.setsucss();
			 dbHandler.end();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			flag_is_header = false;
			dbHandler.close();
		}
		
		//======================================================
		
		try {
			url = new URL("http://hsts.hafilstc.com/HSTCWebServices/importexcel/UsersMaster.csv");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"Windows-1256"));
			dbHandler = new MySQLiteHelper(context);
			dbHandler.open();
			dbHandler.begin();
			while ((line = in.readLine()) != null) {

				String[] insertValues = line.split(",");
				if (flag_is_header) {


					dbHandler.insertUsersMaster(insertValues[0],
							insertValues[1]);
					//Log.e("no. of rows inserted", ""+row);

				} else {
					flag_is_header = true;
				}
			}
			
			 dbHandler.setsucss();
			 dbHandler.end();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			flag_is_header = false;
			dbHandler.close();
		}

		return line;
	}
	@Override
	protected void onPostExecute(String result) {
		progressDialog.dismiss();
		Toast.makeText(this.context, "تم تحميل البيانات بنجاح", Toast.LENGTH_LONG).show();
		SharedPreferences prefs = PreferenceManager
					.getDefaultSharedPreferences(this.mActivity);
		 try {
		if(Integer.parseInt(dbHandler.CheckLogin(this.user, this.pass))>0){

			int user2 = Integer.parseInt(dbHandler.CheckLogin(this.user, this.pass));
			
			prefs.edit().putString("UserID", String.valueOf(user2)).commit();
			Toast.makeText(this.context, String.valueOf(user2), Toast.LENGTH_LONG).show();
			 Intent intent = new Intent(this.context, MainBoardActivity.class);
	         intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
	         this.context.getApplicationContext().startActivity(intent);
		} 
		else{
			Toast.makeText(this.context, "خطأ تاكد من اسم المستخدم وكلمة المرور", Toast.LENGTH_LONG).show();
		}
		 
		 
		 
		 }catch (ParseException e) {
			Toast.makeText(this.context, "الاسم غير مطابق للبيانات", Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
	
}
}