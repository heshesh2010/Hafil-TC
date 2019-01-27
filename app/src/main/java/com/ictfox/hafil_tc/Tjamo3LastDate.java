package com.ictfox.hafil_tc;

import android.app.*;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.RadioGroup.OnCheckedChangeListener;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Tjamo3LastDate extends ListActivity implements LocationListener{
	TextView view10;
	TextView view3;
	TextView view4;
	TextView view5;
	TextView view7;
	TextView view8;
	TextView view200;
	TextView view100;
	TextView view300;
	TextView view400;
	TextView view500;
	TextView txtLat;
	TextView txtLag;
	Location location;
	EditText flatnumber;
	Button addNewPoint;
	Button SaveForOpen;
	Button endAndSync;
	EditText Notes;
	protected LocationManager locationManager;
	Cursor cursor;
	List<tjamo3firstGirdViewHelper> PointsID = new ArrayList<tjamo3firstGirdViewHelper>();
	List<tjamo3firstGirdViewHelper> fleetNumber = new ArrayList<tjamo3firstGirdViewHelper>();
	List<tjamo3firstGirdViewHelper> StudentsNumber = new ArrayList<tjamo3firstGirdViewHelper>();
	List<tjamo3firstGirdViewHelper> Dates = new ArrayList<tjamo3firstGirdViewHelper>();
	String Date = "0";
	String fleetnumber ;
	Cursor test;
	MySQLiteHelper dbHandler;
	String platenumber;
	int BusId; 
	String name;
	int Answer=0;
String schoolName ;
String  SchoolAddress;
String NotesString="لا يوجد";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tjamo3_last_date);
		

		  SaveForOpen = (Button) findViewById(R.id.button2);
		  endAndSync = (Button) findViewById(R.id.button3);
		 addNewPoint = (Button) findViewById(R.id.button4);
			Notes = (EditText) findViewById(R.id.editText3);
		
				locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
				
				RadioButton rb  = (RadioButton) findViewById(R.id.radio0);
				RadioButton rb2  = (RadioButton) findViewById(R.id.radio1);
				view100=(TextView) findViewById(R.id.TextView4);//   
				view200= (TextView) findViewById(R.id.TextView01);
				view300= (TextView) findViewById(R.id.TextView3);
				view400= (TextView) findViewById(R.id.textView2);
				view500= (TextView) findViewById(R.id.textView1);
				RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
				 view10 = (TextView) findViewById(R.id.textView10);// ��� ��������
				 view3 = (TextView) findViewById(R.id.textView3);// ��� ������
				 view4 = (TextView) findViewById(R.id.textView4);// ��� ������
				 view7 = (TextView) findViewById(R.id.textView7);// �������
				 view8= (TextView) findViewById(R.id.TextView03);
				 view5= (TextView) findViewById(R.id.textView5);//   ��� �������
				final SharedPreferences	 prefs = PreferenceManager
							.getDefaultSharedPreferences(Tjamo3LastDate.this);
				
				//get date and fleetNumber from first Gird View
				Date = prefs.getString("CurrentDate", "0");
				Tjamo3LastDate.this.fleetnumber = prefs.getString("fleetnumber", "0");
				
				
				
				view10.setText(prefs.getString("UserID", "0").toString());
				
			    radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() 
			    {
			        public void onCheckedChanged(RadioGroup group, int checkedId) {
			            switch(checkedId){
			                case R.id.radio0:
			                
			                	Tjamo3LastDate.this.Answer = 0 ;

			                break;

			                case R.id.radio1:
			                	Tjamo3LastDate.this.Answer = 1 ;

			                break;
			            }//


			        }
			    });
			    
			    
			    SharedPreferences mPrefs=PreferenceManager
						.getDefaultSharedPreferences(Tjamo3LastDate.this);
			    
			    if(mPrefs.getInt("Rad", 0)==0){
			    	Answer=0;
			    	radioGroup.check(R.id.radio0);
			    }
			    else{
			    	Answer=1;
			    	radioGroup.check(R.id.radio1);
			    }
				
				
				
				// for Atumatic GirdView
				 dbHandler = new MySQLiteHelper(
						Tjamo3LastDate.this);
				 Notes.setText(dbHandler.getCheckPointNote(Tjamo3LastDate.this.fleetnumber));
				 
				cursor = dbHandler.getCheckPointRows(Tjamo3LastDate.this.fleetnumber);
				if (cursor.getCount() >= 1) {
					if (cursor.moveToFirst()) {
						do {
							PointsID.add(get(String.valueOf(cursor
									.getInt(0))));
							fleetNumber.add(get(cursor.getString(1)));
							StudentsNumber.add(get(String
									.valueOf(cursor.getInt(2))));
							Dates.add(get(cursor.getString(3)));
							prefs.edit().putInt("ministryno", cursor.getInt(4)).apply();
						} while (cursor.moveToNext());
					}
					cursor.close();
				}

				tjamo3firstGirdViewAdapter adapter = new tjamo3firstGirdViewAdapter(
						Tjamo3LastDate.this, PointsID,
						getApplicationContext(), fleetNumber,
						StudentsNumber, Dates);

				setListAdapter(adapter);
				view3.setText(Tjamo3LastDate.this.fleetnumber);
				try {
					checkforValidation();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
				
				
				
				
				
				
				
				
				
				
				//forGetting automatic bus info 
				dbHandler = new MySQLiteHelper(Tjamo3LastDate.this);
				 test =    dbHandler.getBusInfoForCheckPoints(Tjamo3LastDate.this.fleetnumber);
				   if(test.getCount() >= 1){
					   
					   do {

						   platenumber = test.getString(0);
						   BusId=test.getInt(1);
						   name=test.getString(2);

					 }while (cursor.moveToNext());

				   }
				   

				   
					//forGetting automatic bus info 
					dbHandler = new MySQLiteHelper(Tjamo3LastDate.this);
					 test =    dbHandler.getSchoolInfoForCheckPoints(prefs.getInt("ministryno", 0));
					   if(test.getCount() >= 1){
						   
						   do {

							   schoolName = test.getString(0);
							   SchoolAddress=test.getString(1);

						 }while (cursor.moveToNext());

					   }			   
				   
				   view5.setText(schoolName);
				   view7.setText(SchoolAddress);
				   
				   
				   
				   
				   
				   
				   
				   
				   SaveForOpen.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							Notes = (EditText) findViewById(R.id.editText3);
							dbHandler = new MySQLiteHelper(Tjamo3LastDate.this);
							Tjamo3LastDate.this.NotesString=Notes.getText().toString();
							if (Tjamo3LastDate.this.NotesString.isEmpty()){
								
								Tjamo3LastDate.this.NotesString = "لايوجد";
							}

							 try {
								String result =    dbHandler.getPathStatus(Tjamo3LastDate.this.fleetnumber);
								if(!isOnline()){
									Toast.makeText(Tjamo3LastDate.this, "يجب تشغيل الانترنت", Toast.LENGTH_SHORT).show();
								}
								else{
								if(result.equals("Closed")){
									
									Toast.makeText(Tjamo3LastDate.this, "المسار مغلق", Toast.LENGTH_SHORT).show();
									
									
									
								}
								else{
									
									ProgressDialog progressDialog = new ProgressDialog(
											Tjamo3LastDate.this);
									progressDialog
											.setMessage("جاري مزامنة البيانات");
									progressDialog.show();
									progressDialog.setCancelable(false);
									progressDialog.setCanceledOnTouchOutside(false);
									PathLastDaysSync MyTask = new PathLastDaysSync(
											Tjamo3LastDate.this, progressDialog, Tjamo3LastDate.this.fleetnumber,
											getApplicationContext(),"Open",Tjamo3LastDate.this.NotesString);
											
									MyTask.execute();
									
									
									
								}
								}
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
							
						}
					});
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				
				
				addNewPoint.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
			
						final Dialog dialog = new Dialog(Tjamo3LastDate.this);

				        dialog.setContentView(R.layout.custom_dialog);
				        dialog.setTitle("اضافة نقطة جديدة");

				        Button save =(Button)dialog.findViewById(R.id.save);
				        Button btnCancel = (Button) dialog.findViewById(R.id.cancel);
				        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
						txtLat = (TextView) dialog.findViewById(R.id.textView1);
						txtLag = (TextView) dialog.findViewById(R.id.textView2);
						if(location!=null){
							txtLat.setText("" + location.getLatitude());
							txtLag.setText("" + location.getLongitude());
							}
				        }
				        dialog.show();
						
				        
				        //========================
				        save.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View v) {
								 EditText editText=(EditText)dialog.findViewById(R.id.editText);
									txtLat = (TextView) dialog.findViewById(R.id.textView1);
									txtLag = (TextView) dialog.findViewById(R.id.textView2);
								 
									if(editText.getText().toString().isEmpty()){
										
										Toast.makeText(getApplicationContext(), "يجب ادخال ارقام الطلبة", Toast.LENGTH_LONG).show();
										
									}
									else{
									if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
										txtLat = (TextView) dialog.findViewById(R.id.textView1);
										txtLag = (TextView) dialog.findViewById(R.id.textView2);
										if(location!=null){
											txtLat.setText("" + location.getLatitude());
											txtLag.setText("" + location.getLongitude());
											}
									}
								if(txtLat.getText().equals("0.0")){
									
									Toast.makeText(getApplicationContext(), "قم بتشغيل الجي بي اس اولا", Toast.LENGTH_LONG).show();
									
								}
								else if (Integer.parseInt(editText.getText().toString())>99){					
									Toast.makeText(getApplicationContext(), "يجب ادخال رقم اكبر من 99", Toast.LENGTH_LONG).show();
								}
								else{
								// To Save the POINT 
								MySQLiteHelper my = new MySQLiteHelper(Tjamo3LastDate.this);
								try {
									my.addCheckPointLastDays(Tjamo3LastDate.this.fleetnumber, editText.getText().toString(), txtLag.getText().toString(),  txtLat.getText().toString() , Date, prefs.getInt("ministryno", 0) , Tjamo3LastDate.this.Answer);
									dialog.dismiss();
									Toast.makeText(Tjamo3LastDate.this, "تم حفظ البيانات بنجاح ", Toast.LENGTH_SHORT).show();
									SharedPreferences mPrefs=PreferenceManager
											.getDefaultSharedPreferences(Tjamo3LastDate.this);
									mPrefs.edit().putInt("Rad", Tjamo3LastDate.this.Answer).apply();
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								}
									}
								// Refresh GirdView 
								MySQLiteHelper dbHandler = new MySQLiteHelper(Tjamo3LastDate.this);
								   cursor =    dbHandler.getCheckPointRows(Tjamo3LastDate.this.fleetnumber);
								   PointsID.clear();
								   fleetNumber.clear();
								   StudentsNumber.clear();
								   Dates.clear();
								   if(cursor.getCount() >= 1){
									   if(cursor.moveToFirst()){
								            do{
										   PointsID.add(get(String.valueOf(cursor.getInt(0))));
										   fleetNumber.add(get(cursor.getString(1)));
										   StudentsNumber.add(get(String.valueOf(cursor.getInt(2))));
										   Dates.add(get(cursor.getString(3)));

								            }while(cursor.moveToNext());
								        }   
									   cursor.close();
								   }
								  
									
								   tjamo3firstGirdViewAdapter adapter = new tjamo3firstGirdViewAdapter(Tjamo3LastDate.this, PointsID,
										getApplicationContext(), fleetNumber ,StudentsNumber, Dates);

								setListAdapter(adapter);
								
						}
								   
						});
				        btnCancel.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View v) {
								dialog.dismiss();
							}
						
					});
					}
				});
				
				   view5.setText(platenumber);
				   view4.setText(name);
				   
					
					
				   
				   Typeface font = Typeface.createFromAsset(getAssets(), "HelveticaNeueW23-Reg.ttf");
					view10.setTypeface(font);
					view3.setTypeface(font);
					view7.setTypeface(font);
					view8.setTypeface(font);
					view5.setTypeface(font);
					 view4.setTypeface(font);
					 view100.setTypeface(font);
					 view200.setTypeface(font);
					 view300.setTypeface(font);
					 view400.setTypeface(font);
					 view500.setTypeface(font);
				   
				   
					 rb.setTypeface(font);
					 rb2.setTypeface(font);
				   
				   
				   
				   
				endAndSync.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						MySQLiteHelper my = new MySQLiteHelper(Tjamo3LastDate.this);
						Notes = (EditText) findViewById(R.id.editText3);
						Tjamo3LastDate.this.NotesString=Notes.getText().toString();
						if(isOnline()==false){
							
							Toast.makeText(getApplicationContext(), "يجب تشغيل الانترنت اولا", Toast.LENGTH_LONG).show();
						}
						else{
							if (Tjamo3LastDate.this.NotesString.isEmpty()){
								
								Tjamo3LastDate.this.NotesString = "لايوجد";
							}
							//dbHandler.updateNotesIntoCheckPoint(Tjamo3LastDate.this.NotesString,Tjamo3LastDate.this.fleetnumber);


						ProgressDialog progressDialog = new ProgressDialog(
								Tjamo3LastDate.this);
						progressDialog
								.setMessage("جاري المزامنة برجاء الانتظار");
						progressDialog.show();
						progressDialog.setCancelable(false);
						progressDialog.setCanceledOnTouchOutside(false);
						PathLastDaysSync MyTask = new PathLastDaysSync(
								Tjamo3LastDate.this, progressDialog, Tjamo3LastDate.this.fleetnumber,
								getApplicationContext(),"Closed",Tjamo3LastDate.this.NotesString);
								
						MyTask.execute();

					}}
				});
				
		}
	
	public void checkforValidation() throws ParseException {
		 addNewPoint = (Button) findViewById(R.id.button4);
		  SaveForOpen = (Button) findViewById(R.id.button2);
		  endAndSync = (Button) findViewById(R.id.button3);
		  
		MySQLiteHelper dbHandler = new MySQLiteHelper(Tjamo3LastDate.this);
		String Exception = dbHandler.getPathStatus(Tjamo3LastDate.this.fleetnumber);
        SharedPreferences mPrefs=PreferenceManager
                .getDefaultSharedPreferences(Tjamo3LastDate.this);

        if(Integer.parseInt(mPrefs.getString("UserID", "0"))==999){
            addNewPoint.setEnabled(true);
            SaveForOpen.setEnabled(true);
            endAndSync.setEnabled(true);

        }

		else if (Exception.equals("Closed")) {
			addNewPoint.setEnabled(false);
			SaveForOpen.setEnabled(false);
			endAndSync.setEnabled(false);
			
		}

		else {

			addNewPoint.setEnabled(true);
			SaveForOpen.setEnabled(true);
			endAndSync.setEnabled(true);

		}

	}

		@Override
		public void onProviderDisabled(String provider) {
			if(!((Activity) Tjamo3LastDate.this).isFinishing())
			{
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(Tjamo3LastDate.this);
		      
	        // Setting Dialog Title
	        alertDialog.setTitle("خطا");
	  
	        // Setting Dialog Message
	        alertDialog.setMessage("يجب تشغيل الجي بي اس اولا");
	  
	        // On pressing Settings button
	        alertDialog.setPositiveButton("صفحة الاعدادات", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog,int which) {
	                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
	               startActivity(intent);
	            }
	        });
	 
	  
	        // Showing Alert Message
	        alertDialog.show();
	    }
		}
		@Override
		public void onProviderEnabled(String provider) {
			
		}
		 
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {

			
			
		}
		
		@Override
		public void onLocationChanged(Location location2) {
			location = location2; 
		}
		
		private tjamo3firstGirdViewHelper get(String s) {

			return new tjamo3firstGirdViewHelper(s);

		}
		boolean isOnline() {
			ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext()
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

			if (netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()) {

				return false;
			}
			return true;
		}
	}

