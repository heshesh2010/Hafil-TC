package com.ictfox.hafil_tc.lastdays;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.*;
import com.ictfox.hafil_tc.MySQLiteHelper;
import com.ictfox.hafil_tc.R;
import com.ictfox.hafil_tc.MyApplication;

public class MotorActivityActivityLastDays extends Activity {
	int resultOfsection4=0;
	int resultOfsection51=0;
	int resultOfsection3=0;
	int resultOfsection5=0;
	int resultOfsection6=0;
	int resultOfsection7=0;
int resultOfsection11=0;

String mydate;
String result ="-1";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.activity_motor);

		Button MotorGellary = (Button) findViewById(R.id.button1);
		Button Save= (Button) findViewById(R.id.button4);
	    Button capture = (Button) findViewById(R.id.button2);

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.TextView3);
        TextView textView4 = (TextView) findViewById(R.id.TextView4);
        TextView textView5 = (TextView) findViewById(R.id.TextView5);
        TextView textView6 = (TextView) findViewById(R.id.TextView6);
        TextView textView7 = (TextView) findViewById(R.id.TextView7);

        RadioGroup waterLevel = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioGroup oilQuilty = (RadioGroup) findViewById(R.id.radioGroup2);
		RadioGroup oilLevel = (RadioGroup) findViewById(R.id.radioGroup3);
		RadioGroup cold = (RadioGroup) findViewById(R.id.radioGroup4);
		RadioGroup motor = (RadioGroup) findViewById(R.id.radioGroup5);
		RadioGroup seior = (RadioGroup) findViewById(R.id.radioGroup6);
        RadioGroup geripex = (RadioGroup) findViewById(R.id.radioGroup7);

        // for radioButton 0
        RadioButton radio0 = (RadioButton) findViewById(R.id.radio0);
        // for radioButton 1
        RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);

        // for radioButton 2
        RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);
        // for radioButton 3
        RadioButton radio3 = (RadioButton) findViewById(R.id.radio3);
        // for radioButton 4
        RadioButton radio4 = (RadioButton) findViewById(R.id.radio4);


        // for radioButton 5
        RadioButton radio5 = (RadioButton) findViewById(R.id.radio5);

        // for radioButton 6
        RadioButton radio6 = (RadioButton) findViewById(R.id.radio6);
        // for radioButton 7
        RadioButton radio7 = (RadioButton) findViewById(R.id.radio7);


        // for radioButton 8
        RadioButton radio8 = (RadioButton) findViewById(R.id.radio8);
        // for radioButton 9
        RadioButton radio9 = (RadioButton) findViewById(R.id.radio9);


        // for radioButton 10
        RadioButton radio10 = (RadioButton) findViewById(R.id.radio10);
        // for radioButton 11
        RadioButton radio11 = (RadioButton) findViewById(R.id.radio11);
        // for radioButton 12
        RadioButton radio12 = (RadioButton) findViewById(R.id.radio12);

        // for radioButton 13
        RadioButton radio13 = (RadioButton) findViewById(R.id.radio13);
        // for radioButton 14
        RadioButton radio14 = (RadioButton) findViewById(R.id.radio14);
        // for radioButton 15
        RadioButton radio15 = (RadioButton) findViewById(R.id.radio15);


        // for radioButton 18
        RadioButton radio18 = (RadioButton) findViewById(R.id.radio18);
        // for radioButton 17
        RadioButton radio17 = (RadioButton) findViewById(R.id.radio17);

		Typeface font = Typeface.createFromAsset(getAssets(), "HelveticaNeueW23-Reg.ttf");
		

		
		
		textView1.setTypeface(font);
		textView2.setTypeface(font);
		textView3.setTypeface(font);
		textView4.setTypeface(font);
		textView5.setTypeface(font);
		textView6.setTypeface(font);
        textView7.setTypeface(font);

        radio0.setTypeface(font);
        radio1.setTypeface(font);
        radio2.setTypeface(font);
        radio3.setTypeface(font);
        radio4.setTypeface(font);
        radio5.setTypeface(font);
        radio6.setTypeface(font);
        radio7.setTypeface(font);
        radio8.setTypeface(font);
        radio9.setTypeface(font);
        radio10.setTypeface(font);
        radio11.setTypeface(font);
        radio12.setTypeface(font);
        radio13.setTypeface(font);
        radio14.setTypeface(font);
        radio15.setTypeface(font);
        radio18.setTypeface(font);
        radio17.setTypeface(font);
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(MotorActivityActivityLastDays.this);

        result = prefs.getString("BusId","0");
        mydate = prefs.getString("Date","0");
        final MySQLiteHelper my = new MySQLiteHelper(MotorActivityActivityLastDays.this);





        resultOfsection4 = my.getLastDaysValues(result, 4 ,mydate);
        if(resultOfsection4==6){
            radio0.setChecked(true);
            radio1.setEnabled(false);
        }
        else if(resultOfsection4==7){
            radio1.setChecked(true);
            radio0.setEnabled(false);
        }



        resultOfsection51 = my.getLastDaysValues(result, 51 ,mydate);
        if(resultOfsection51==3){
            radio2.setChecked(true);
            radio3.setEnabled(false);
            radio4.setEnabled(false);
        }
        else if(resultOfsection51==4){
            radio3.setChecked(true);
            radio2.setEnabled(false);
            radio4.setEnabled(false);
        }

        else{
            radio4.setChecked(true);
            radio2.setChecked(false);
            radio3.setEnabled(false);
        }



        resultOfsection3 = my.getLastDaysValues(result, 3 ,mydate);
        if(resultOfsection3==1){
            radio5.setChecked(true);
            radio6.setEnabled(false);
            radio7.setEnabled(false);
        }
        else if(resultOfsection3==2){
            radio6.setChecked(true);
            radio5.setEnabled(false);
            radio7.setEnabled(false);
        }

        else{
            radio7.setChecked(true);
            radio5.setChecked(false);
            radio6.setEnabled(false);
        }


        resultOfsection5 = my.getLastDaysValues(result,5 ,mydate);
        if(resultOfsection5==9){
            radio8.setChecked(true);
            radio9.setEnabled(false);
        }
        else if(resultOfsection5==10){
            radio9.setChecked(true);
            radio8.setEnabled(false);
        }




        resultOfsection6 = my.getLastDaysValues(result, 6 ,mydate);
        if(resultOfsection6==11){
            radio10.setChecked(true);
            radio11.setEnabled(false);
            radio12.setEnabled(false);
        }
        else if(resultOfsection6==12){
            radio11.setChecked(true);
            radio10.setEnabled(false);
            radio12.setEnabled(false);
        }

        else{
            radio12.setChecked(true);
            radio10.setChecked(false);
            radio11.setEnabled(false);
        }



        resultOfsection7 = my.getLastDaysValues(result, 7 ,mydate);
        if(resultOfsection7==14){
            radio13.setChecked(true);
            radio14.setEnabled(false);
            radio15.setEnabled(false);
        }
        else if(resultOfsection7==15){
            radio14.setChecked(true);
            radio13.setEnabled(false);
            radio15.setEnabled(false);
        }

        else{
            radio15.setChecked(true);
            radio13.setChecked(false);
            radio14.setEnabled(false);
        }




        resultOfsection11 = my.getLastDaysValues(result,11 ,mydate);
        if(resultOfsection11==25){
            radio18.setChecked(true);
            radio17.setEnabled(false);
        }
        else if(resultOfsection11==26){
            radio17.setChecked(true);
            radio18.setEnabled(false);
        }




    }



	@Override
	public void onPause() {
	    super.onPause();  // Always call the superclass method first
	    EditText Note = (EditText) findViewById(R.id.editText1);



        ((MyApplication) MotorActivityActivityLastDays.this.getApplication())
                .setAnswerAndSection(4, MotorActivityActivityLastDays.this.resultOfsection4);
        ((MyApplication) MotorActivityActivityLastDays.this.getApplication())
                .setAnswerAndSection(51, MotorActivityActivityLastDays.this.resultOfsection51);
((MyApplication) MotorActivityActivityLastDays.this.getApplication())
		.setAnswerAndSection(3, MotorActivityActivityLastDays.this.resultOfsection3);
((MyApplication) MotorActivityActivityLastDays.this.getApplication())
		.setAnswerAndSection(5, MotorActivityActivityLastDays.this.resultOfsection5);
((MyApplication) MotorActivityActivityLastDays.this.getApplication())
		.setAnswerAndSection(6, MotorActivityActivityLastDays.this.resultOfsection6);
((MyApplication) MotorActivityActivityLastDays.this.getApplication())
		.setAnswerAndSection(7, MotorActivityActivityLastDays.this.resultOfsection7);
        ((MyApplication) MotorActivityActivityLastDays.this.getApplication())
                .setAnswerAndSection(11, MotorActivityActivityLastDays.this.resultOfsection11);

	    }
	}
