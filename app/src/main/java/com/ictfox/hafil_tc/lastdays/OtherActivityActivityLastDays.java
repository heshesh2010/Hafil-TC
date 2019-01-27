package com.ictfox.hafil_tc.lastdays;


import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings.Secure;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.ictfox.hafil_tc.MySQLiteHelper;
import com.ictfox.hafil_tc.R;
import com.ictfox.hafil_tc.MyApplication;

public class OtherActivityActivityLastDays extends Activity  {




	int resultOfsection10 = 0  ;
	int resultOfsection9= 0;
	int resultOfsection48=0;
	int resultOfsection49=0;
	int resultOfsection13=0;
	int resultOfsection14=0;
	int resultOfsection21=0;
    int resultOfsection50=0;

	private String android_id;
 EditText num;

String mydate;
String result ="-1";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);

      num = (EditText) findViewById(R.id.editText);





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




        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(OtherActivityActivityLastDays.this);

        result = prefs.getString("BusId","0");
        mydate = prefs.getString("Date","0");


        final MySQLiteHelper my = new MySQLiteHelper(OtherActivityActivityLastDays.this);

        num.setText(my.getLastDaysValuesEditTexts(result,mydate,"BatteryVoltage"));
        

        resultOfsection10= my.getLastDaysValues(result, 10 ,mydate);
        if(resultOfsection10==23){
            battry_work.setChecked(true);
            battry_notWork.setEnabled(false);
        }
        else if(resultOfsection10==24){
            battry_notWork.setChecked(true);
            battry_work.setEnabled(false);

        }


        resultOfsection9 = my.getLastDaysValues(result, 9 ,mydate);
        if(resultOfsection9==20){
            caoutch_good.setChecked(true);
            caoutch_normal.setEnabled(false);
            caoutch_bad.setEnabled(false);
        }
        else if(resultOfsection9==21){
            caoutch_normal.setChecked(true);
            caoutch_bad.setEnabled(false);
            caoutch_good.setEnabled(false);
        }

        else{
            caoutch_bad.setChecked(true);
            caoutch_normal.setChecked(false);
            caoutch_good.setEnabled(false);
        }





        resultOfsection48 = my.getLastDaysValues(result, 48 ,mydate);
        if(resultOfsection48==115){
            second_coutuch_good.setChecked(true);
            second_coutuch_normal.setEnabled(false);
            second_coutuch_bad.setEnabled(false);
            second_coutuch_notfound.setEnabled(false);
        }
        else if(resultOfsection48==116){
            second_coutuch_normal.setChecked(true);
            second_coutuch_good.setEnabled(false);
            second_coutuch_bad.setEnabled(false);
            second_coutuch_notfound.setEnabled(false);
        }

        else if(resultOfsection48==117) {
            second_coutuch_bad.setChecked(true);
            second_coutuch_good.setEnabled(false);
            second_coutuch_normal.setEnabled(false);
            second_coutuch_notfound.setEnabled(false);
        }
        else{
            second_coutuch_good.setEnabled(false);
            second_coutuch_normal.setEnabled(false);
            second_coutuch_bad.setEnabled(false);
            second_coutuch_notfound.setChecked(true);

        }



        resultOfsection49 = my.getLastDaysValues(result, 49 ,mydate);
        if(resultOfsection49==119){
            new_color_yes.setChecked(true);
            new_color_no.setEnabled(false);
        }
        else if(resultOfsection49==120){
            new_color_no.setChecked(true);
            new_color_yes.setEnabled(false);

        }


        resultOfsection13 = my.getLastDaysValues(result, 13 ,mydate);
        if(resultOfsection13==29){
            budy_good.setChecked(true);
            budy_hit.setEnabled(false);
            budy_bad.setEnabled(false);
        }
        else if(resultOfsection13==30){
            budy_hit.setChecked(true);
            budy_good.setEnabled(false);
            budy_bad.setEnabled(false);
        }

        else{
            budy_bad.setChecked(true);
            budy_good.setChecked(false);
            budy_hit.setEnabled(false);
        }


        resultOfsection14 = my.getLastDaysValues(result, 14 ,mydate);
        if(resultOfsection14==32){
            color_good.setChecked(true);
            color_normal.setEnabled(false);
            color_bad.setEnabled(false);
        }
        else if(resultOfsection14==33){
            color_normal.setChecked(true);
            color_good.setEnabled(false);
            color_bad.setEnabled(false);
        }

        else{
            color_bad.setChecked(true);
            color_good.setChecked(false);
            color_normal.setEnabled(false);
        }

        resultOfsection21 = my.getLastDaysValues(result, 21 ,mydate);
        if(resultOfsection21==47){
            doors_good.setChecked(true);
            doors_bad.setEnabled(false);
        }
        else if(resultOfsection21==48){
            doors_bad.setChecked(true);
            doors_good.setEnabled(false);

        }


        resultOfsection50 = my.getLastDaysValues(result, 50 ,mydate);
        if(resultOfsection50==121){
            external_clean_yes.setChecked(true);
            external_clean_no.setEnabled(false);
        }
        else if(resultOfsection50==122){
            external_clean_no.setChecked(true);
            external_clean_yes.setEnabled(false);

        }





	}


	
	
	


		@Override
		protected void onPause() {
			super.onPause();


            ((MyApplication) OtherActivityActivityLastDays.this.getApplication())
                    .setAnswerAndSection(10, OtherActivityActivityLastDays.this.resultOfsection10);
            ((MyApplication) OtherActivityActivityLastDays.this.getApplication())
                    .setAnswerAndSection(9, OtherActivityActivityLastDays.this.resultOfsection9);
            ((MyApplication) OtherActivityActivityLastDays.this.getApplication())
                    .setAnswerAndSection(48, OtherActivityActivityLastDays.this.resultOfsection48);
            ((MyApplication) OtherActivityActivityLastDays.this.getApplication())
                    .setAnswerAndSection(49, OtherActivityActivityLastDays.this.resultOfsection49);
            ((MyApplication) OtherActivityActivityLastDays.this.getApplication())
                    .setAnswerAndSection(13, OtherActivityActivityLastDays.this.resultOfsection13);
            ((MyApplication) OtherActivityActivityLastDays.this.getApplication())
                    .setAnswerAndSection(14, OtherActivityActivityLastDays.this.resultOfsection14);
            ((MyApplication) OtherActivityActivityLastDays.this.getApplication())
                    .setAnswerAndSection(21, OtherActivityActivityLastDays.this.resultOfsection21);
            ((MyApplication) OtherActivityActivityLastDays.this.getApplication())
                    .setAnswerAndSection(50, OtherActivityActivityLastDays.this.resultOfsection50);
            if(num.getText().toString().isEmpty()||num.getText().toString().equals("NA")){

                num.setText("0");

            }
            ((MyApplication) OtherActivityActivityLastDays.this.getApplication())
                    .setBatteryVoltage(Integer.parseInt(num.getText().toString()));

		}
		
	}

