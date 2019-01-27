package com.ictfox.hafil_tc.buscheck;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.*;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.ictfox.hafil_tc.MyApplication;
import com.ictfox.hafil_tc.R;

public class MotorActivity extends Activity {
int oilLevel = 0;
int oilQuilty = 0;
int waterLevel = 0;
int cold = 0;
int motor = 0;
int seior = 0;
int geripex = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    setContentView(R.layout.activity_motor);

    Button MotorGellary = (Button) findViewById(R.id.button1);
    Button Save = (Button) findViewById(R.id.button4);
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

    //
    waterLevel.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio0:

                    MotorActivity.this.waterLevel = 6;

                    break;

                case R.id.radio1:
                    MotorActivity.this.waterLevel = 7;

                    break;

            }//

        }
    });

    //
    oilQuilty.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio2:

                    MotorActivity.this.oilQuilty = 3;

                    break;

                case R.id.radio3:
                    MotorActivity.this.oilQuilty = 4;

                    break;
                case R.id.radio4:
                    MotorActivity.this.oilQuilty = 5;

                    break;
            }//

        }
    });

    oilLevel.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio5:

                    MotorActivity.this.oilLevel = 1;

                    break;

                case R.id.radio6:
                    MotorActivity.this.oilLevel = 2;

                    break;


                case R.id.radio7:
                    MotorActivity.this.oilLevel = 3;

                    break;

            }//

        }
    });


    //
    cold.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio8:

                    MotorActivity.this.cold = 9;

                    break;

                case R.id.radio9:
                    MotorActivity.this.cold = 10;

                    break;
            }//

        }
    });

    //
    motor.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio10:

                    MotorActivity.this.motor = 11;

                    break;

                case R.id.radio11:
                    MotorActivity.this.motor = 12;

                    break;

                case R.id.radio12:
                    MotorActivity.this.motor = 13;

                    break;
            }//

        }
    });

    //
    seior.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio13:

                    MotorActivity.this.seior = 14;

                    break;

                case R.id.radio14:
                    MotorActivity.this.seior = 15;

                    break;

                case R.id.radio15:
                    MotorActivity.this.seior = 16;

                    break;

            }//

        }
    });

    geripex.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio18:

                    MotorActivity.this.geripex = 25;

                    break;

                case R.id.radio17:
                    MotorActivity.this.geripex = 26;

                    break;


            }//

        }
    });


}


@Override
public void onPause() {
    super.onPause();  // Always call the superclass method first
    EditText Note = (EditText) findViewById(R.id.editText1);

    if(oilLevel == 0 || oilQuilty == 0 || waterLevel == 0 || cold == 0 || motor == 0 || seior == 0 || geripex == 0) {

        Toast.makeText(getApplicationContext(), "اختر اجابة اولا", Toast.LENGTH_LONG).show();
    }
        ((MyApplication) MotorActivity.this.getApplication())
                .setAnswerAndSection(4, MotorActivity.this.waterLevel);
        ((MyApplication) MotorActivity.this.getApplication())
                .setAnswerAndSection(51, MotorActivity.this.oilQuilty);
        ((MyApplication) MotorActivity.this.getApplication())
                .setAnswerAndSection(3, MotorActivity.this.oilLevel);
        ((MyApplication) MotorActivity.this.getApplication())
                .setAnswerAndSection(5, MotorActivity.this.cold);
        ((MyApplication) MotorActivity.this.getApplication())
                .setAnswerAndSection(6, MotorActivity.this.motor);
        ((MyApplication) MotorActivity.this.getApplication())
                .setAnswerAndSection(7, MotorActivity.this.seior);
        ((MyApplication) MotorActivity.this.getApplication())
                .setAnswerAndSection(11, MotorActivity.this.geripex);

    SharedPreferences prefs = PreferenceManager
            .getDefaultSharedPreferences(this);
    prefs.edit().putBoolean("MotorActivity", true).commit();

    }
}

