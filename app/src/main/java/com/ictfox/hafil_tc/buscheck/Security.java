package com.ictfox.hafil_tc.buscheck;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.*;
import com.ictfox.hafil_tc.MyApplication;
import com.ictfox.hafil_tc.R;

/**
 * Created by heshe_000 on 8/18/2014.
 */
public class Security extends Activity {

int aid=0;
int fire=0;
int exit=0;
int bus=0;
int guid=0;
int tringle=0;


 EditText num ;
 EditText num2;
 EditText num3 ;

 EditText num4 ;
 EditText num5 ;

public Security() {
}

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_ssecuirty);
    TextView textView1 = (TextView) findViewById(R.id.textView1);
    TextView textView2 = (TextView) findViewById(R.id.textView2);
    TextView textView3 = (TextView) findViewById(R.id.TextView3);
    TextView textView4 = (TextView) findViewById(R.id.TextView4);
    TextView textView5 = (TextView) findViewById(R.id.TextView5);
    TextView textView6 = (TextView) findViewById(R.id.TextView6);
    TextView textView7 = (TextView) findViewById(R.id.TextView7);
    TextView textView8 = (TextView) findViewById(R.id.TextView8);




    RadioGroup aid = (RadioGroup) findViewById(R.id.radioGroup1);
    RadioGroup fire = (RadioGroup) findViewById(R.id.radioGroup2);
 //   RadioGroup seats = (RadioGroup) findViewById(R.id.radioGroup3);
  //  RadioGroup seat = (RadioGroup) findViewById(R.id.radioGroup4);
    RadioGroup exit = (RadioGroup) findViewById(R.id.radioGroup5);
    RadioGroup  bus = (RadioGroup) findViewById(R.id.radioGroup6);
    RadioGroup  guid = (RadioGroup) findViewById(R.id.radioGroup7);
    RadioGroup tringle= (RadioGroup) findViewById(R.id.radioGroup8);


    num = (EditText) findViewById(R.id.editText);
   num2 = (EditText) findViewById(R.id.editText2);
    num3 = (EditText) findViewById(R.id.editText3);

 num4 = (EditText) findViewById(R.id.editText4);
num5 = (EditText) findViewById(R.id.editText5);

    num.setText("");
    num2.setText("");
    num3.setText("");
    num4.setText("");
    num5.setText("");


    RadioButton radio_aid_ok = (RadioButton) findViewById(R.id.radio0);
    RadioButton radio_aid_expired = (RadioButton) findViewById(R.id.radio1);
    RadioButton radio_aid_notFound = (RadioButton) findViewById(R.id.radio211);

    RadioButton radio_fire_ok = (RadioButton) findViewById(R.id.radio2);
    RadioButton radio_fire_expired = (RadioButton) findViewById(R.id.radio3);
    RadioButton radio_fire_notFound = (RadioButton) findViewById(R.id.radio4);

    RadioButton radio_exit_open = (RadioButton) findViewById(R.id.radio10);
    RadioButton radio_exit_notOpen= (RadioButton) findViewById(R.id.radio11);

    RadioButton radio_bus_Yes = (RadioButton) findViewById(R.id.radio13);
    RadioButton radio_bus_No = (RadioButton) findViewById(R.id.radio14);

    RadioButton radio_guid_Yes = (RadioButton) findViewById(R.id.radio18);
    RadioButton radio_guid_No = (RadioButton) findViewById(R.id.radio17);

    RadioButton radio_tringle_Yes = (RadioButton) findViewById(R.id.radio21);
    RadioButton radio_tringle_No = (RadioButton) findViewById(R.id.radio20);

    Typeface font = Typeface.createFromAsset(getAssets(), "HelveticaNeueW23-Reg.ttf");

    textView1.setTypeface(font);
    textView2.setTypeface(font);
    textView3.setTypeface(font);
    textView4.setTypeface(font);
    textView5.setTypeface(font);
    textView6.setTypeface(font);
    textView7.setTypeface(font);
    textView8.setTypeface(font);



    radio_aid_ok.setTypeface(font);
    radio_aid_expired.setTypeface(font);
    radio_aid_notFound.setTypeface(font);
    radio_fire_ok.setTypeface(font);
    radio_fire_expired.setTypeface(font);
    radio_fire_notFound.setTypeface(font);
    radio_exit_open.setTypeface(font);
    radio_exit_notOpen.setTypeface(font);
    radio_bus_Yes.setTypeface(font);
    radio_bus_No.setTypeface(font);
    radio_guid_Yes.setTypeface(font);
    radio_guid_No.setTypeface(font);
    radio_tringle_Yes.setTypeface(font);
    radio_tringle_No.setTypeface(font);


    aid.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio0:

                    Security.this.aid =84;

                    break;

                case R.id.radio1:
                    Security.this.aid =85;

                    break;
                case R.id.radio211:
                    Security.this.aid =86;

                    break;
            }//

        }
    });


    fire.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio2:

                    Security.this.fire =87;

                    break;

                case R.id.radio3:
                    Security.this.fire =88;

                    break;
                case R.id.radio4:
                    Security.this.fire =89;

                    break;
            }//

        }
    });

    exit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio10:

                    Security.this.exit =93;

                    break;

                case R.id.radio11:
                    Security.this.exit =94;

                    break;
            }//

        }
    });


    bus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio13:

                    Security.this.bus =95;

                    break;

                case R.id.radio14:
                    Security.this.bus =96;

                    break;

            }//

        }
    });


    guid.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio18:

                    Security.this.guid =97;

                    break;

                case R.id.radio17:
                    Security.this.guid =98;

                    break;

            }//

        }
    });


    tringle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio21:

                    Security.this.tringle =99;

                    break;

                case R.id.radio20:
                    Security.this.tringle =100;

                    break;

            }//

        }
    });

}

public void onPause() {
    super.onPause();
    if(aid == 0 || fire == 0  || exit == 0 || bus == 0 || guid == 0 || tringle == 0) {

        Toast.makeText(getApplicationContext(), "اختر اجابة اولا", Toast.LENGTH_LONG).show();
    }


        ((MyApplication) Security.this.getApplication())
                .setAnswerAndSection(35, Security.this.aid);

        ((MyApplication) Security.this.getApplication())
                .setAnswerAndSection(36, Security.this.fire);

        ((MyApplication) Security.this.getApplication())
                .setAnswerAndSection(38, Security.this.exit);
        ((MyApplication) Security.this.getApplication())
                .setAnswerAndSection(39, Security.this.bus);
        ((MyApplication) Security.this.getApplication())
                .setAnswerAndSection(40, Security.this.guid);
        ((MyApplication) Security.this.getApplication())
                .setAnswerAndSection(41, Security.this.tringle);


        if(num.getText().toString().isEmpty()) {
            num.setText("0");
        }
        if(num2.getText().toString().isEmpty()) {
            num2.setText("0");
        }
        if(num3.getText().toString().isEmpty()) {
            num3.setText("0");
        }

        if(num4.getText().toString().isEmpty()) {
            num4.setText("0");
        }

        if(num5.getText().toString().isEmpty()) {
            num5.setText("0");
        }


        ((MyApplication) Security.this.getApplication())
                .setfirstThreeCounts(Integer.parseInt(num.getText().toString()), Integer.parseInt(num2.getText().toString()), Integer.parseInt(num3.getText().toString()), Integer.parseInt(num4.getText().toString()), Integer.parseInt(num5.getText().toString()));
    SharedPreferences prefs = PreferenceManager
            .getDefaultSharedPreferences(this);
    prefs.edit().putBoolean("Security", true).commit();

    }
/*
if(radio_seats_ok.isChecked()){


}
else if (radio_seats_expired.isChecked()){

}
  else if(radio_seats_notFound.isChecked()){

}

if(radio_seat_Found.isChecked()){

}

   else if(radio_seat_notFound.isChecked()){


}*/

}