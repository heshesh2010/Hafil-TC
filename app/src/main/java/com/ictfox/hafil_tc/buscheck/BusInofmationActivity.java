package com.ictfox.hafil_tc.buscheck;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.ictfox.hafil_tc.MyApplication;
import com.ictfox.hafil_tc.R;

public class BusInofmationActivity extends Activity {
	
	EditText Inpute_flateNumber;
	
	TextView view1;
	TextView view2;
	TextView view3;
	TextView view4;
	TextView view5;
	TextView view6;
	TextView view7;
	TextView view8;
TextView view9;
	TextView DriverName;
	TextView NationalID;
	TextView plateNumber;
	TextView BusTpye;
	TextView BusModel;
	TextView seats;
	TextView userID;
TextView  fleetTextView;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bus_inofmation);
	    SharedPreferences prefs = PreferenceManager
			.getDefaultSharedPreferences(this);

         Inpute_flateNumber    = (EditText)findViewById(R.id.editText1);
		Button SearchButton = (Button)findViewById(R.id.button1);  
		userID = (TextView) findViewById(R.id.textView16);
		Typeface font = Typeface.createFromAsset(getAssets(), "HelveticaNeueW23-Reg.ttf");
		userID.setText(prefs.getString("UserID", "0"));
		// ForViewOnly
		 view1 = (TextView) findViewById(R.id.textView1);
		 view2 = (TextView) findViewById(R.id.textView2);
		 view3 = (TextView) findViewById(R.id.textView4);
		 view4 = (TextView) findViewById(R.id.textView6);
		 view5 = (TextView) findViewById(R.id.textView8);
		 view6 = (TextView) findViewById(R.id.textView10);
		 view7 = (TextView) findViewById(R.id.textView12);
		 view8 = (TextView) findViewById(R.id.textView14);

        view9 = (TextView) findViewById(R.id.textView144);
			 DriverName = (TextView) findViewById(R.id.textView5);
			 NationalID = (TextView) findViewById(R.id.textView7); 
			 plateNumber = (TextView) findViewById(R.id.textView9);
			 BusTpye = (TextView) findViewById(R.id.textView11);
			 BusModel = (TextView) findViewById(R.id.textView13); 
			 seats = (TextView) findViewById(R.id.textView15);
          fleetTextView = (TextView) findViewById(R.id.textView155);
		view1.setTypeface(font);
		view2.setTypeface(font);
		view3.setTypeface(font);
		view4.setTypeface(font);
		view5.setTypeface(font);
		view6.setTypeface(font);
		view7.setTypeface(font);
		view8.setTypeface(font);
        view9.setTypeface(font);
		
		
		 SearchButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						ProgressDialog progressDialog = new ProgressDialog(
								BusInofmationActivity.this);
                        TextView  view9 = (TextView) findViewById(R.id.textView144);
                        EditText  Inpute_flateNumber    = (EditText)findViewById(R.id.editText1);
                        fleetTextView.setText(Inpute_flateNumber.getText().toString());

						progressDialog.setMessage("جاري البحث عن البيانات برجاء الانتظار");
						progressDialog.show();
						progressDialog.setCancelable(false);
						progressDialog.setCanceledOnTouchOutside(false);
						BusInfoDATEBASE MyTask = new BusInfoDATEBASE(
									BusInofmationActivity.this, progressDialog,Integer.parseInt(Inpute_flateNumber.getText().toString()),
									getApplicationContext()
									);
							MyTask.execute();	
					}
				});
		 
	
	}
	 @Override
	 protected void onResume() {
	     super.onResume();

	     DriverName.setText(((MyApplication) this.getApplication()).name);
	     NationalID.setText(((MyApplication) this.getApplication()).nationalid); 
	     plateNumber.setText(((MyApplication) this.getApplication()).platenumber);
	     BusTpye.setText(((MyApplication) this.getApplication()).busType);
	     BusModel.setText(((MyApplication) this.getApplication()).model);
	     seats.setText(String.valueOf(((MyApplication) this.getApplication()).seat1));
         fleetTextView.setText(String.valueOf(((MyApplication) this.getApplication()).fleetnumber));
	     }
}
