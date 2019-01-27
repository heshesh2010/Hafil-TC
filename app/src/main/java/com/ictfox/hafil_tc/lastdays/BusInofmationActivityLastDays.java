package com.ictfox.hafil_tc.lastdays;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.TextView;
import com.ictfox.hafil_tc.MySQLiteHelper;
import com.ictfox.hafil_tc.R;

public class BusInofmationActivityLastDays extends Activity {
	TextView hh;
	TextView drivers;
	TextView seats;
	String result1;
	String today ;
	int BUSID;
	SharedPreferences prefs;
	TextView DriverName;
	TextView NationalID;
	TextView plateNumber;
	TextView BusTpye;
	TextView BusModel;
	int fleetnumber;
EditText  fleetNumberBox;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bus_inofmation_activity_last_days);

		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(BusInofmationActivityLastDays.this);



		// using coustom font
		Typeface font = Typeface.createFromAsset(getAssets(), "HelveticaNeueW23-Reg.ttf");
			
		 DriverName = (TextView) findViewById(R.id.textView5);
		 NationalID = (TextView) findViewById(R.id.textView7); 
		 plateNumber = (TextView) findViewById(R.id.textView9);
		 BusTpye = (TextView) findViewById(R.id.textView11);
		 BusModel = (TextView) findViewById(R.id.textView13); 
		 seats = (TextView) findViewById(R.id.textView15);
          fleetNumberBox=     (EditText)     findViewById(R.id.editText1);
        // ForViewOnly
        TextView  view2 = (TextView) findViewById(R.id.textView2);
        TextView   view22 = (TextView) findViewById(R.id.textView3);
        TextView  view3 = (TextView) findViewById(R.id.textView4);
        TextView view4 = (TextView) findViewById(R.id.textView6);
        TextView view5 = (TextView) findViewById(R.id.textView8);
        TextView view6 = (TextView) findViewById(R.id.textView10);
        TextView  view7 = (TextView) findViewById(R.id.textView12);
        TextView  view8 = (TextView) findViewById(R.id.textView14);


        view2.setTypeface(font);
        view22.setTypeface(font);
        view3.setTypeface(font);
        view4.setTypeface(font);
        view5.setTypeface(font);
        view6.setTypeface(font);
        view7.setTypeface(font);
        view8.setTypeface(font);


		DriverName.setTypeface(font);
		NationalID.setTypeface(font);
		plateNumber.setTypeface(font);
		BusTpye.setTypeface(font);
		BusModel.setTypeface(font);
		seats.setTypeface(font);

        view22.setText(prefs.getString("UserID", "0"));

		   MySQLiteHelper dbHandler = new MySQLiteHelper(BusInofmationActivityLastDays.this);
		   Cursor  test =    dbHandler.getAllBusInfoLastDate(prefs.getString("Date", "0"));
		   if(test.getCount() >= 1){
			   while(test.moveToNext()){
				   plateNumber.setText(test.getString(2));
				   seats.setText(String.valueOf(test.getInt(5)));
				   NationalID.setText(""+test.getString(6));
				   DriverName.setText(""+test.getString(7));
				   BusModel.setText(test.getString(4));
				   BusTpye.setText(test.getString(3));
				   fleetnumber=test.getInt(1);
				   BUSID = test.getInt(0);
			 }
		   }
        fleetNumberBox.setText(String.valueOf(fleetnumber));
		   prefs.edit().putInt("fleetnumber", fleetnumber).apply();
        prefs.edit().putString("BusId", String.valueOf(BUSID)).apply();
	}
/*
@Override
protected void onResume() {
    super.onResume();

    MySQLiteHelper dbHandler = new MySQLiteHelper(BusInofmationActivityLastDays.this);
    Cursor  test =    dbHandler.getAllBusInfoLastDate(prefs.getString("Date", "0"));
    SharedPreferences prefs = PreferenceManager
            .getDefaultSharedPreferences(BusInofmationActivityLastDays.this);

    if(test.getCount() >= 1){
        while(test.moveToNext()){
            plateNumber.setText(test.getString(2));
            seats.setText(String.valueOf(test.getInt(5)));
            NationalID.setText(""+test.getString(6));
            DriverName.setText(""+test.getString(7));
            BusModel.setText(test.getString(4));
            BusTpye.setText(test.getString(3));
            fleetnumber=test.getInt(1);
            BUSID = test.getInt(0);
        }
    }
    prefs.edit().putInt("fleetnumber", fleetnumber).apply();
    prefs.edit().putString("BusId", String.valueOf(BUSID)).apply();

}
*/
}
    

