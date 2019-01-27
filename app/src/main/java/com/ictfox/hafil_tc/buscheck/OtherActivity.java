package com.ictfox.hafil_tc.buscheck;


import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings.Secure;
import android.widget.*;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.ictfox.hafil_tc.MyApplication;
import com.ictfox.hafil_tc.R;

public class OtherActivity extends Activity  {




	int battry = 0  ;
	int caoutch= 0;
	int second_coutuch=0;
	int new_color=0;
	int budy=0;
	int color=0;
	int doors=0;
    int external_clean=0;

	private String android_id;
 EditText num;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);

      num = (EditText) findViewById(R.id.editText);

//num.setText("0");



        RadioGroup battry = (RadioGroup) findViewById(R.id.radioGroup1);
		RadioGroup caoutch = (RadioGroup) findViewById(R.id.radioGroup2);
		RadioGroup second_coutuch = (RadioGroup) findViewById(R.id.radioGroup3);
		RadioGroup new_color =  (RadioGroup) findViewById(R.id.radioGroup4);
		RadioGroup budy = (RadioGroup) findViewById(R.id.radioGroup5);
		RadioGroup color = (RadioGroup) findViewById(R.id.radioGroup6);
		RadioGroup doors = (RadioGroup) findViewById(R.id.radioGroup7);
        RadioGroup external_clean = (RadioGroup) findViewById(R.id.radioGroup8);
		// coding =================================


		
		 android_id = Secure.getString(this.getContentResolver(),Secure.ANDROID_ID);

		Typeface font = Typeface.createFromAsset(getAssets(), "HelveticaNeueW23-Reg.ttf");


        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.TextView3);
        TextView textView4 = (TextView) findViewById(R.id.TextView4);
        TextView textView5 = (TextView) findViewById(R.id.TextView5);
        TextView textView6 = (TextView) findViewById(R.id.TextView6);
        TextView textView7 = (TextView) findViewById(R.id.TextView7);
        TextView textView8 = (TextView) findViewById(R.id.TextView8);
        TextView textView9 = (TextView) findViewById(R.id.textView22);


        textView1.setTypeface(font);
        textView2.setTypeface(font);
        textView3.setTypeface(font);
        textView4.setTypeface(font);
        textView5.setTypeface(font);
        textView6.setTypeface(font);
        textView7.setTypeface(font);
        textView8.setTypeface(font);
        textView9.setTypeface(font);

        textView3.requestFocus();



        RadioButton battry_work = (RadioButton) findViewById(R.id.radio0);
        RadioButton battry_notWork = (RadioButton) findViewById(R.id.radio1);

        RadioButton caoutch_good = (RadioButton) findViewById(R.id.radio2);
        RadioButton caoutch_normal = (RadioButton) findViewById(R.id.radio3);
        RadioButton caoutch_bad = (RadioButton) findViewById(R.id.radio4);

        RadioButton second_coutuch_good = (RadioButton) findViewById(R.id.radio5);
        RadioButton second_coutuch_normal = (RadioButton) findViewById(R.id.radio6);
        RadioButton second_coutuch_bad = (RadioButton) findViewById(R.id.radio7);
        RadioButton second_coutuch_notfound = (RadioButton) findViewById(R.id.radio77);



        RadioButton new_color_yes = (RadioButton) findViewById(R.id.radio8);
        RadioButton new_color_no = (RadioButton) findViewById(R.id.radio9);

        RadioButton budy_good = (RadioButton) findViewById(R.id.radio10);
        RadioButton budy_hit = (RadioButton) findViewById(R.id.radio11);
        RadioButton budy_bad = (RadioButton) findViewById(R.id.radio12);

        RadioButton color_good = (RadioButton) findViewById(R.id.radio13);
        RadioButton color_normal = (RadioButton) findViewById(R.id.radio14);
        RadioButton color_bad = (RadioButton) findViewById(R.id.radio15);

        RadioButton doors_good = (RadioButton) findViewById(R.id.radio18);
        RadioButton doors_bad = (RadioButton) findViewById(R.id.radio17);

        RadioButton external_clean_yes = (RadioButton) findViewById(R.id.radio21);
        RadioButton external_clean_no = (RadioButton) findViewById(R.id.radio20);


        battry_work.setTypeface(font);
        battry_notWork.setTypeface(font);

        caoutch_good.setTypeface(font);
        caoutch_normal.setTypeface(font);
        caoutch_bad.setTypeface(font);
        second_coutuch_notfound.setTypeface(font);

        second_coutuch_good.setTypeface(font);
        second_coutuch_normal.setTypeface(font);
        second_coutuch_bad.setTypeface(font);

        new_color_yes.setTypeface(font);
        new_color_no.setTypeface(font);

        budy_good.setTypeface(font);
        budy_hit.setTypeface(font);
        budy_bad.setTypeface(font);

        color_good.setTypeface(font);
        color_normal.setTypeface(font);
        color_bad.setTypeface(font);

        doors_good.setTypeface(font);
        doors_bad.setTypeface(font);

        external_clean_yes.setTypeface(font);
        external_clean_no.setTypeface(font);



		




        battry.setOnCheckedChangeListener(new OnCheckedChangeListener()
	    {
	        public void onCheckedChanged(RadioGroup group, int checkedId) {
	            switch(checkedId){
	                case R.id.radio0:

	                	OtherActivity.this.battry = 23 ;

	                break;

	                case R.id.radio1:
	                	OtherActivity.this.battry = 24 ;

	                break;
	            }//


	        }
	    });

        caoutch.setOnCheckedChangeListener(new OnCheckedChangeListener()
	    {
	        public void onCheckedChanged(RadioGroup group, int checkedId) {
	            switch(checkedId){
	                case R.id.radio2:

	                	OtherActivity.this.caoutch = 20 ;

	                break;

	                case R.id.radio3:
	                	OtherActivity.this.caoutch = 21 ;

	                break;

                    case R.id.radio4:
                        OtherActivity.this.caoutch = 22 ;

                        break;
	            }//


	        }
	    });



        second_coutuch.setOnCheckedChangeListener(new OnCheckedChangeListener()
	    {
	        public void onCheckedChanged(RadioGroup group, int checkedId) {
	            switch(checkedId){
	                case R.id.radio5:

	                	OtherActivity.this.second_coutuch = 115 ;

	                break;

	                case R.id.radio6:
	                	OtherActivity.this.second_coutuch = 116 ;

	                break;

                    case R.id.radio7:
                        OtherActivity.this.second_coutuch = 117 ;

                        break;

                    case R.id.radio77:
                        OtherActivity.this.second_coutuch = 118 ;

                        break;
	            }//


	        }
	    });

        new_color.setOnCheckedChangeListener(new OnCheckedChangeListener()
	    {
	        public void onCheckedChanged(RadioGroup group, int checkedId) {
	            switch(checkedId){
	                case R.id.radio8:

	                	OtherActivity.this.new_color = 119 ;

	                break;

	                case R.id.radio9:
	                	OtherActivity.this.new_color = 120 ;

	                break;
	            }//


	        }
	    });

        budy.setOnCheckedChangeListener(new OnCheckedChangeListener()
	    {
	        public void onCheckedChanged(RadioGroup group, int checkedId) {
	            switch(checkedId){
	                case R.id.radio10:

	                	OtherActivity.this.budy = 29 ;

	                break;

	                case R.id.radio11:
	                	OtherActivity.this.budy = 30 ;

	                break;

                    case R.id.radio12:
                        OtherActivity.this.budy = 31 ;

                        break;
	            }//


	        }
	    });

        color.setOnCheckedChangeListener(new OnCheckedChangeListener()
	    {
	        public void onCheckedChanged(RadioGroup group, int checkedId) {
	            switch(checkedId){
	                case R.id.radio13:

	                	OtherActivity.this.color = 32 ;

	                break;

	                case R.id.radio14:
                        OtherActivity.this.color = 33 ;

                        break;

                    case R.id.radio15:
                        OtherActivity.this.color = 34 ;

                        break;
	            }//


	        }
	    });

        doors.setOnCheckedChangeListener(new OnCheckedChangeListener()
	    {
	        public void onCheckedChanged(RadioGroup group, int checkedId) {
	            switch(checkedId){
	                case R.id.radio18:

	                	OtherActivity.this.doors = 47 ;

	                break;

	                case R.id.radio17:
                        OtherActivity.this.doors = 48 ;

                        break;
	            }//


	        }
	    });



        external_clean.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){

                    case R.id.radio21:
                        OtherActivity.this.external_clean = 121 ;

                        break;
                    case R.id.radio20:
                        OtherActivity.this.external_clean = 122 ;

                        break;
                }//


            }
        });
		
				

	}


	
	
	


		@Override
		protected void onPause() {
            super.onPause();

            if(battry == 0 || caoutch == 0 || second_coutuch == 0 || new_color == 0 || budy == 0 || color == 0 || doors == 0 || external_clean==0) {

                Toast.makeText(getApplicationContext(), "اختر اجابة اولا", Toast.LENGTH_LONG).show();
            }



                if(num.getText().toString().isEmpty()) {

                    num.setText("0");
                }

                ((MyApplication) OtherActivity.this.getApplication())
                        .setAnswerAndSection(10, OtherActivity.this.battry);
                ((MyApplication) OtherActivity.this.getApplication())
                        .setAnswerAndSection(9, OtherActivity.this.caoutch);
                ((MyApplication) OtherActivity.this.getApplication())
                        .setAnswerAndSection(48, OtherActivity.this.second_coutuch);
                ((MyApplication) OtherActivity.this.getApplication())
                        .setAnswerAndSection(49, OtherActivity.this.new_color);
                ((MyApplication) OtherActivity.this.getApplication())
                        .setAnswerAndSection(13, OtherActivity.this.budy);
                ((MyApplication) OtherActivity.this.getApplication())
                        .setAnswerAndSection(14, OtherActivity.this.color);
                ((MyApplication) OtherActivity.this.getApplication())
                        .setAnswerAndSection(21, OtherActivity.this.doors);
                ((MyApplication) OtherActivity.this.getApplication())
                        .setAnswerAndSection(50, OtherActivity.this.external_clean);

                ((MyApplication) OtherActivity.this.getApplication())
                        .setBatteryVoltage(Integer.parseInt(num.getText().toString()));

            SharedPreferences prefs = PreferenceManager
                    .getDefaultSharedPreferences(this);
            prefs.edit().putBoolean("OtherActivity", true).commit();

        }
	}

