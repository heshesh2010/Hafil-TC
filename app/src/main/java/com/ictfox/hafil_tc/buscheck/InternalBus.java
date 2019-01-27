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
public class InternalBus extends Activity {

int internal_clean = 0 ;
int takeef = 0 ;
int speaker = 0 ;
int driveruniform = 0 ;
int driver_clean = 0 ;
int numbers = 0 ;
int ttabo3 = 0 ;
int hand_framel= 0 ;
int  framel = 0 ;

 EditText num;

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_inetrnal_bus);

    num = (EditText) findViewById(R.id.editText);

   // num.setText("0");
    TextView textView1 = (TextView) findViewById(R.id.textView1);
    TextView textView2 = (TextView) findViewById(R.id.TextView3);
    TextView textView9 = (TextView) findViewById(R.id.TextView7);
    TextView textView10 = (TextView) findViewById(R.id.TextView77);


    TextView textView3 = (TextView) findViewById(R.id.TextView4);
    TextView textView4 = (TextView) findViewById(R.id.TextView44);
    TextView textView5 = (TextView) findViewById(R.id.TextView45);
    TextView textView6 = (TextView) findViewById(R.id.TextView5);
    TextView textView7 = (TextView) findViewById(R.id.TextView6);
    TextView textView8 = (TextView) findViewById(R.id.TextView8);


    RadioGroup framel = (RadioGroup) findViewById(R.id.radioGroup44);
    RadioGroup hand_framel = (RadioGroup) findViewById(R.id.radioGroup45);

    RadioGroup internal_clean = (RadioGroup) findViewById(R.id.radioGroup1);
    RadioGroup takeef = (RadioGroup) findViewById(R.id.radioGroup3);
    RadioGroup speaker = (RadioGroup) findViewById(R.id.radioGroup4);



    RadioGroup driveruniform = (RadioGroup) findViewById(R.id.radioGroup5);



    RadioGroup  numbers = (RadioGroup) findViewById(R.id.radioGroup7);

    RadioGroup  driver_clean = (RadioGroup) findViewById(R.id.radioGroup6);
    RadioGroup ttabo3= (RadioGroup) findViewById(R.id.radioGroup8);





    RadioButton radio_internal_clean_yes = (RadioButton) findViewById(R.id.radio0);
    RadioButton radio_internal_clean_no = (RadioButton) findViewById(R.id.radio1);

    RadioButton radio_takeef_cold = (RadioButton) findViewById(R.id.radio5);
    RadioButton radio_takeef_hot = (RadioButton) findViewById(R.id.radio6);
    RadioButton radio_takeef_notworking = (RadioButton) findViewById(R.id.radio7);

    RadioButton radio_numbers_works = (RadioButton) findViewById(R.id.radio18);
    RadioButton radio_numbers_notworking = (RadioButton) findViewById(R.id.radio17);



    RadioButton radio_speaker_work = (RadioButton) findViewById(R.id.radio8);
    RadioButton radio_speaker_notWorking = (RadioButton) findViewById(R.id.radio9);
    RadioButton radio_speaker_notFound = (RadioButton) findViewById(R.id.radio89);


    RadioButton radio_framel_strong = (RadioButton) findViewById(R.id.radio899);
    RadioButton radio_framel_bad = (RadioButton) findViewById(R.id.radio99);


    RadioButton radio_framelhand_good = (RadioButton) findViewById(R.id.radio8999);
    RadioButton radio_framelhand_bad = (RadioButton) findViewById(R.id.radio999);
    RadioButton radio_framelhand_notwoking = (RadioButton) findViewById(R.id.radio89988);

    RadioButton radio_driveruniform_yes = (RadioButton) findViewById(R.id.radio10);
    RadioButton radio_driveruniform_no = (RadioButton) findViewById(R.id.radio11);

    RadioButton radio_driver_clean_yes = (RadioButton) findViewById(R.id.radio13);
    RadioButton radio_driver_clean_no = (RadioButton) findViewById(R.id.radio14);

    RadioButton radio_ttab3_found = (RadioButton) findViewById(R.id.radio21);
    RadioButton radio_ttab3_notfound = (RadioButton) findViewById(R.id.radio20);



    Typeface font = Typeface.createFromAsset(getAssets(), "HelveticaNeueW23-Reg.ttf");

    textView1.setTypeface(font);
    textView2.setTypeface(font);
    textView3.setTypeface(font);
    textView4.setTypeface(font);
    textView5.setTypeface(font);
    textView6.setTypeface(font);
    textView7.setTypeface(font);
    textView8.setTypeface(font);
    textView9.setTypeface(font);
    textView10.setTypeface(font);


    radio_internal_clean_yes.setTypeface(font);
    radio_internal_clean_no.setTypeface(font);

    radio_takeef_cold.setTypeface(font);
    radio_takeef_notworking.setTypeface(font);
    radio_takeef_hot.setTypeface(font);

    radio_numbers_works.setTypeface(font);
    radio_numbers_notworking.setTypeface(font);

    radio_speaker_work.setTypeface(font);
    radio_speaker_notWorking.setTypeface(font);
    radio_speaker_notFound.setTypeface(font);

    radio_framel_strong.setTypeface(font);
    radio_framel_bad.setTypeface(font);

    radio_framelhand_good.setTypeface(font);
    radio_framelhand_bad.setTypeface(font);
    radio_framelhand_notwoking.setTypeface(font);

    radio_driveruniform_yes.setTypeface(font);
    radio_driveruniform_no.setTypeface(font);

    radio_driver_clean_yes.setTypeface(font);
    radio_driver_clean_yes.setTypeface(font);

    radio_ttab3_found.setTypeface(font);
    radio_ttab3_notfound.setTypeface(font);



    internal_clean.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio0:

                    InternalBus.this.internal_clean =49;

                    break;

                case R.id.radio1:
                    InternalBus.this.internal_clean =50;


                    break;
            }//

        }
    });




    takeef.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio5:

                    InternalBus.this.takeef =17;

                    break;

                case R.id.radio6:
                    InternalBus.this.takeef =18;

                    break;

                case R.id.radio7:
                    InternalBus.this.takeef =19;

                    break;
            }//

        }
    });


    numbers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio18:

                    InternalBus.this.numbers =53;

                    break;

                case R.id.radio17:
                    InternalBus.this.numbers =54;


                    break;
            }//

        }
    });

    speaker.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio8:

                    InternalBus.this.speaker =101;

                    break;

                case R.id.radio9:
                    InternalBus.this.speaker =102;

                    break;
                case R.id.radio89:
                    InternalBus.this.speaker =103;

                    break;
            }//

        }
    });

    framel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio899:

                    InternalBus.this.framel =55;

                    break;

                case R.id.radio99:
                    InternalBus.this.framel =56;


                    break;
            }//

        }
    });

    hand_framel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio8999:

                    InternalBus.this.hand_framel = 57;

                    break;

                case R.id.radio999:
                    InternalBus.this.hand_framel =58;

                    break;
                case R.id.radio89988:
                    InternalBus.this.hand_framel =59;

                    break;
            }//

        }
    });

    driveruniform.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio10:

                    InternalBus.this.driveruniform =104;

                    break;

                case R.id.radio11:
                    InternalBus.this.driveruniform =105;

                    break;


            }//

        }
    });

    driver_clean.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio13:

                    InternalBus.this.driver_clean =106;

                    break;

                case R.id.radio14:
                    InternalBus.this.driver_clean =107;


                    break;
            }//

        }
    });



    ttabo3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio21:

                    InternalBus.this.ttabo3 =27;

                    break;

                case R.id.radio20:
                    InternalBus.this.ttabo3 =28;


                    break;
            }//

        }
    });



}


public void onPause() {
    super.onPause();


    if(internal_clean == 0 || takeef == 0 || numbers == 0 || speaker == 0 || framel == 0 || hand_framel == 0 || driveruniform == 0 || driver_clean == 0 || ttabo3 == 0) {

        Toast.makeText(getApplicationContext(), "اختر اجابة اولا", Toast.LENGTH_LONG).show();
    }

        if(num.getText().toString().isEmpty()) {

            num.setText("0");
        }

        ((MyApplication) InternalBus.this.getApplication())
                .setAnswerAndSection(22, InternalBus.this.internal_clean);

        ((MyApplication) InternalBus.this.getApplication())
                .setAnswerAndSection(8, InternalBus.this.takeef);
        ((MyApplication) InternalBus.this.getApplication())
                .setAnswerAndSection(24, InternalBus.this.numbers);
        ((MyApplication) InternalBus.this.getApplication())
                .setAnswerAndSection(42, InternalBus.this.speaker);
        ((MyApplication) InternalBus.this.getApplication())
                .setAnswerAndSection(25, InternalBus.this.framel);
        ((MyApplication) InternalBus.this.getApplication())
                .setAnswerAndSection(26, InternalBus.this.hand_framel);


        ((MyApplication) InternalBus.this.getApplication())
                .setAnswerAndSection(43, InternalBus.this.driveruniform);
        ((MyApplication) InternalBus.this.getApplication())
                .setAnswerAndSection(44, InternalBus.this.driver_clean);
        ((MyApplication) InternalBus.this.getApplication())
                .setAnswerAndSection(12, InternalBus.this.ttabo3);

        ((MyApplication) InternalBus.this.getApplication())
                .setKMCounter(Integer.parseInt(num.getText().toString()));

    SharedPreferences prefs = PreferenceManager
            .getDefaultSharedPreferences(this);
    prefs.edit().putBoolean("InternalBus", true).commit();
    }
}
