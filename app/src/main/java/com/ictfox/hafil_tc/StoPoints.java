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

public class StoPoints extends ListActivity implements LocationListener {
	TextView view1;
	TextView view2;
	TextView view3;
	TextView view4;
	TextView view10;
	TextView view11;
	TextView view400;
	TextView view500;
	TextView view600;
	TextView view700;

	TextView txtLat;
	TextView txtLag;
	EditText flatnumber;
	EditText MinstyNumber;
	EditText Notes;
	Location location;
	String theNUM="0";
	String Mistrynum="0";
	String NotesString="لايوجد";
	int Answer=0;
	protected LocationManager locationManager;
	protected LocationListener locationListener;
	Button addNewPoint;
	Cursor cursor;
	MySQLiteHelper dbHandler;
	List<tjamo3firstGirdViewHelper> PointsID = new ArrayList<tjamo3firstGirdViewHelper>();
	List<tjamo3firstGirdViewHelper> fleetNumber = new ArrayList<tjamo3firstGirdViewHelper>();
	List<tjamo3firstGirdViewHelper> StudentsNumber = new ArrayList<tjamo3firstGirdViewHelper>();
	List<tjamo3firstGirdViewHelper> Dates = new ArrayList<tjamo3firstGirdViewHelper>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sto_points);
		Button SaveForOpen = (Button) findViewById(R.id.button2);
		flatnumber = (EditText) findViewById(R.id.editText1);
		MinstyNumber = (EditText) findViewById(R.id.editText2);

		final Button search = (Button) findViewById(R.id.button1);
		final Button searchLocations = (Button) findViewById(R.id.button01);
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
		
		
		
		
		search.setEnabled(true);
		searchLocations.setEnabled(true);
		Button endAndSync = (Button) findViewById(R.id.button3);
		addNewPoint = (Button) findViewById(R.id.button4);
		addNewPoint.setEnabled(false);
		Typeface font = Typeface.createFromAsset(getAssets(),
				"HelveticaNeueW23-Reg.ttf");
		view1 = (TextView) findViewById(R.id.textView1);
		view2 = (TextView) findViewById(R.id.textView2);
		view3 = (TextView) findViewById(R.id.TextView3);
		view10 = (TextView) findViewById(R.id.textView10);
		
		view11 = (TextView) findViewById(R.id.TextView03);
	view400 = (TextView) findViewById(R.id.TextView4);
	view500 = (TextView) findViewById(R.id.TextView01);
	view600 = (TextView) findViewById(R.id.TextView02);
	view700 = (TextView) findViewById(R.id.textView6);
	
		view1.setTypeface(font);
		view2.setTypeface(font);
		view3.setTypeface(font);
		view10.setTypeface(font);
		view11.setTypeface(font);
		
		 view400.setTypeface(font);
		 view500.setTypeface(font);
		 view600.setTypeface(font);
		 view700.setTypeface(font);
		 
			RadioButton rb  = (RadioButton) findViewById(R.id.radio0);
			RadioButton rb2  = (RadioButton) findViewById(R.id.radio1);
			rb.setTypeface(font);
			rb2.setTypeface(font);
			
			
		SharedPreferences mPrefs=PreferenceManager
				.getDefaultSharedPreferences(StoPoints.this);
		view10.setText(mPrefs.getString("UserID", "0").toString());
		
		
		
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
				0, this);

	    radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() 
	    {
	        public void onCheckedChanged(RadioGroup group, int checkedId) {
	            switch(checkedId){
	                case R.id.radio0:

	                	StoPoints.this.Answer = 0 ;

	                break;

	                case R.id.radio1:
	                	StoPoints.this.Answer = 1 ;

	                break;
	            }//


	        }
	    });
	    
		
		addNewPoint.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				final Dialog dialog = new Dialog(StoPoints.this);

				dialog.setContentView(R.layout.custom_dialog);
				dialog.setTitle("خطا!");

				Button save = (Button) dialog.findViewById(R.id.save);
				Button btnCancel = (Button) dialog.findViewById(R.id.cancel);
				
				dialog.show();

				save.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						EditText editText = (EditText) dialog
								.findViewById(R.id.editText);
						EditText MinstyNumber = (EditText) findViewById(R.id.editText2);
						
						EditText	flatnumber = (EditText) findViewById(R.id.editText1);
						txtLat = (TextView) dialog.findViewById(R.id.textView1);
						txtLag = (TextView) dialog.findViewById(R.id.textView2);
						
						
						
						if(editText.getText().toString().isEmpty()){
							
							Toast.makeText(getApplicationContext(), "قم بادخال عدد الطالبات اولا", Toast.LENGTH_LONG).show();
						}
						else{
						
						
						
						if(locationManager!=null){
						if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
							txtLat = (TextView) dialog.findViewById(R.id.textView1);
							txtLag = (TextView) dialog.findViewById(R.id.textView2);
							if(location!=null){
								txtLat.setText("" + location.getLatitude());
								txtLag.setText("" + location.getLongitude());
								}
						}
						MySQLiteHelper my = new MySQLiteHelper(StoPoints.this);
						if(txtLat.getText().equals("0.0")){				
							Toast.makeText(getApplicationContext(), "قم بتشغيل الجي بي اس وانتظر البيانات اولا", Toast.LENGTH_LONG).show();
						}
						
						else if (Integer.parseInt(editText.getText().toString())>99){					
							Toast.makeText(getApplicationContext(), "يجب ادخال رقم اقل من 99", Toast.LENGTH_LONG).show();
						}
						else{
							
							if(MinstyNumber.getText().toString().isEmpty()){
								
								StoPoints.this.Mistrynum="0";
							}
							
							
						long test = my.addCheckPoint(StoPoints.this.theNUM,
								String.valueOf(editText.getText()), txtLag.getText()
										.toString(), txtLat.getText()
										.toString()  ,StoPoints.this.Mistrynum , StoPoints.this.Answer );
						SharedPreferences mPrefs=PreferenceManager
								.getDefaultSharedPreferences(StoPoints.this);
						mPrefs.edit().putInt("Rad", StoPoints.this.Answer).apply();
						if(test>=1){
							Toast.makeText(StoPoints.this, "تم الحفظ بنجاح", Toast.LENGTH_LONG).show();
						
						}
						else{
							Toast.makeText(StoPoints.this, "خطأ! .. تأكد من لغة الجهاز انه لغه التوقيت اجنبية", Toast.LENGTH_LONG).show();
						}
						dialog.dismiss();
					}}}
						
						MySQLiteHelper dbHandler = new MySQLiteHelper(
								StoPoints.this);
						
						cursor = dbHandler.getCheckPointRows(StoPoints.this.theNUM);
						
						
						search.setEnabled(false);
						
						
						PointsID.clear();
						fleetNumber.clear();
						StudentsNumber.clear();
						Dates.clear();
						if (cursor.getCount() >= 1) {
							if (cursor.moveToFirst()) {
								do {
									PointsID.add(get(String.valueOf(cursor
											.getInt(0))));
									fleetNumber.add(get(cursor.getString(1)));
									StudentsNumber.add(get(String
											.valueOf(cursor.getInt(2))));
									Dates.add(get(cursor.getString(3)));

								} while (cursor.moveToNext());
							}
							cursor.close();
						}

						tjamo3firstGirdViewAdapter adapter = new tjamo3firstGirdViewAdapter(
								StoPoints.this, PointsID,
								getApplicationContext(), fleetNumber,
								StudentsNumber, Dates);
						setListAdapter(adapter);	
					}

				});
				
				btnCancel.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						dialog.dismiss();
						search.setEnabled(false);
					}
				
			});
				
			}
		});

		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				
     if(flatnumber==null || String.valueOf(flatnumber.getText()).isEmpty() ){
	
	Toast.makeText(StoPoints.this, "يجب ادخال رقم الشركة اولا", Toast.LENGTH_SHORT).show();
	
       } 
     
     
else{
	EditText flatnumber = (EditText) findViewById(R.id.editText1);
	StoPoints.this.theNUM= String.valueOf(flatnumber.getText()) ;
	
				ProgressDialog progressDialog = new ProgressDialog(
						StoPoints.this);
				progressDialog
						.setMessage("جاري البحث عن البيانات برجاء الانتظار");
				progressDialog.show();
				progressDialog.setCancelable(false);
				progressDialog.setCanceledOnTouchOutside(false);
				StoPointsAsyncTask MyTask = new StoPointsAsyncTask(
						StoPoints.this, progressDialog, StoPoints.this.theNUM,
						getApplicationContext());
				MyTask.execute();

				checkforValidation();

				MySQLiteHelper dbHandler = new MySQLiteHelper(StoPoints.this);
				cursor = dbHandler.getCheckPointRows(StoPoints.this.theNUM);

				PointsID.clear();
				fleetNumber.clear();
				StudentsNumber.clear();
				if (cursor.getCount() >= 1) {
					if (cursor.moveToFirst()) {
						do {
							PointsID.add(get(String.valueOf(cursor.getInt(0))));
							fleetNumber.add(get(cursor.getString(1)));
							StudentsNumber.add(get(String.valueOf(cursor
									.getInt(2))));
							Dates.add(get(cursor.getString(3)));

						} while (cursor.moveToNext());
					}
					cursor.close();
				}

				tjamo3firstGirdViewAdapter adapter = new tjamo3firstGirdViewAdapter(
						StoPoints.this, PointsID, getApplicationContext(),
						fleetNumber, StudentsNumber, Dates);

				setListAdapter(adapter);
			}}
		});

		
		
		searchLocations.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				
				
				if(MinstyNumber.getText().toString()==null||MinstyNumber.getText().toString().isEmpty()){
					
					Toast.makeText(getApplicationContext(), "يجب ادخال رقم الوزاره اولا ", Toast.LENGTH_SHORT).show();
					
				}
				
				else{
					StoPoints.this.Mistrynum=String.valueOf(MinstyNumber.getText()) ;
				ProgressDialog progressDialog = new ProgressDialog(
						StoPoints.this);
				progressDialog.setMessage("جاري جلب لبيانات برجاء الانتظار");
				progressDialog.show();
				progressDialog.setCancelable(false);
				progressDialog.setCanceledOnTouchOutside(false);
				
				
				LocationsDataBase MyTask = new LocationsDataBase(
						StoPoints.this, progressDialog,
						getApplicationContext(),  String.valueOf(MinstyNumber.getText()));
				MyTask.execute();
				}
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		endAndSync.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				MySQLiteHelper my = new MySQLiteHelper(StoPoints.this);
				Notes = (EditText) findViewById(R.id.editText3);
				if(isOnline()==false){
					
					Toast.makeText(StoPoints.this, "يجب تشغيل الانترنت اولا لتتم المزامنة", Toast.LENGTH_SHORT).show();
				}
				else if(StoPoints.this.StudentsNumber.isEmpty()){
					 Toast.makeText(StoPoints.this, "لايوجد مسار للمزامنة", Toast.LENGTH_SHORT).show();
				 }

				 else{
					 StoPoints.this.NotesString=Notes.getText().toString();
						if (StoPoints.this.NotesString.toString().isEmpty()){
								
							StoPoints.this.NotesString = "لايوجد";
						}
				//my.endPath(StoPoints.this.theNUM);
				//my.InsertNoresToCheckPoints(StoPoints.this.NotesString,StoPoints.this.theNUM,StoPoints.this.Mistrynum);
				ProgressDialog progressDialog = new ProgressDialog(
						StoPoints.this);
				progressDialog
						.setMessage("جاري المزامنة مع السيرفر");
				progressDialog.show();
				progressDialog.setCancelable(false);
				progressDialog.setCanceledOnTouchOutside(false);
				PathLastDaysSync MyTask = new PathLastDaysSync(
						StoPoints.this, progressDialog, StoPoints.this.theNUM,
						getApplicationContext(),"Closed",StoPoints.this.NotesString);
				MyTask.execute();

				 }
			
				
			}
		});
		
	

	
	
	   SaveForOpen.setOnClickListener(new OnClickListener() {
		   
			@Override
			public void onClick(View v) {
				dbHandler = new MySQLiteHelper(StoPoints.this);
				Notes = (EditText) findViewById(R.id.editText3);
				
				 try {
					 if(isOnline()==false){
						 Toast.makeText(StoPoints.this, "يجب تشغيل الانترنت اولا", Toast.LENGTH_SHORT).show();
					 }
					 else if(StoPoints.this.StudentsNumber.isEmpty()){
						 Toast.makeText(StoPoints.this, "لايوجد مسار للمزامنة", Toast.LENGTH_SHORT).show();
					 }
					 else{
					String result =    dbHandler.getPathStatus(StoPoints.this.theNUM);
					if(result.equals("Closed")){
						Toast.makeText(StoPoints.this, "المسار مغلق ", Toast.LENGTH_SHORT).show();
					}
					else{
						StoPoints.this.NotesString =Notes.getText().toString();
						if (StoPoints.this.NotesString.isEmpty()){
							
							StoPoints.this.NotesString = "لايوجد مسار للمزامنة";
						}
						//dbHandler.InsertNoresToCheckPoints(StoPoints.this.NotesString,StoPoints.this.theNUM,StoPoints.this.Mistrynum);
						ProgressDialog progressDialog = new ProgressDialog(
								StoPoints.this);
						progressDialog
								.setMessage("جاري المزامنة برجاء الانتظار");
						progressDialog.show();
						progressDialog.setCancelable(false);
						progressDialog.setCanceledOnTouchOutside(false);
						PathLastDaysSync MyTask = new PathLastDaysSync(
								StoPoints.this, progressDialog, StoPoints.this.theNUM,
								getApplicationContext(),"Open",StoPoints.this.NotesString);
								
						MyTask.execute();
						
					}
					 }	
					
			
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				
			}
		});

	}
	
	
	
	
	public void checkforValidation() {

		MySQLiteHelper dbHandler = new MySQLiteHelper(StoPoints.this);
		String Exception = dbHandler.CheckforPathIsExsits(this.theNUM);
		if (Exception.equals("NoPath")) {
			addNewPoint.setEnabled(true);
			
		}

		else {

			addNewPoint.setEnabled(false);

		}

	}

	@Override
	public void onProviderDisabled(String provider) {
		
		if(!((Activity) StoPoints.this).isFinishing())
		{
		    //show dialog
		
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(StoPoints.this);

		// Setting Dialog Title
		alertDialog.setTitle("خطأ!");

		// Setting Dialog Message
		alertDialog.setMessage("يجب تشغيل الجي بي اس اولا");

		// On pressing Settings button
		alertDialog.setPositiveButton("صفحة الاعدادات",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(
								Settings.ACTION_LOCATION_SOURCE_SETTINGS);
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

