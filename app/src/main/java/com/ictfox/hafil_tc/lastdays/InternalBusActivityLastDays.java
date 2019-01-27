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

/**
 * Created by heshe_000 on 8/18/2014.
 */
public class InternalBusActivityLastDays extends Activity {

int resultOfsection22 = 0 ;
int resultOfsection8 = 0 ;
int resultOfsection24 = 0 ;
int resultOfsection42 = 0 ;
int resultOfsection25 = 0 ;
int resultOfsection26 = 0 ;
int resultOfsection43 = 0 ;
int resultOfsection44= 0 ;
int  resultOfsection12 = 0 ;

 EditText num;
String mydate;
String result ="-1";
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


    SharedPreferences prefs = PreferenceManager
            .getDefaultSharedPreferences(InternalBusActivityLastDays.this);
    result = prefs.getString("BusId","0");
    mydate = prefs.getString("Date","0");
    final MySQLiteHelper my = new MySQLiteHelper(InternalBusActivityLastDays.this);


    num.setText(my.getLastDaysValuesEditTexts(result,mydate,"KMCounter"));

    resultOfsection22 = my.getLastDaysValues(result, 22 ,mydate);
    if(resultOfsection22==49){
        radio_internal_clean_yes.setChecked(true);
        radio_internal_clean_no.setEnabled(false);
    }
    else if(resultOfsection22==50){
        radio_internal_clean_no.setChecked(true);
        radio_internal_clean_yes.setEnabled(false);
    }

    resultOfsection8 = my.getLastDaysValues(result, 8 ,mydate);
    if(resultOfsection8==17){
        radio_takeef_cold.setChecked(true);
        radio_takeef_notworking.setEnabled(false);
        radio_takeef_hot.setEnabled(false);
    }
    else if(resultOfsection8==18){
        radio_takeef_hot.setChecked(true);
        radio_takeef_cold.setEnabled(false);
        radio_takeef_notworking.setEnabled(false);
    }

    else{
        radio_takeef_notworking.setChecked(true);
        radio_takeef_cold.setChecked(false);
        radio_takeef_hot.setEnabled(false);
    }


    resultOfsection24 = my.getLastDaysValues(result, 24 ,mydate);
    if(resultOfsection24==53){
        radio_numbers_works.setChecked(true);
        radio_numbers_notworking.setEnabled(false);
    }
    else if(resultOfsection24==54){
        radio_numbers_notworking.setChecked(true);
        radio_numbers_works.setEnabled(false);
    }


    resultOfsection42 = my.getLastDaysValues(result, 42 ,mydate);
    if(resultOfsection42==101){
        radio_speaker_work.setChecked(true);
        radio_speaker_notWorking.setEnabled(false);
        radio_speaker_notFound.setEnabled(false);
    }
    else if(resultOfsection42==102){
        radio_speaker_notWorking.setChecked(true);
        radio_speaker_work.setEnabled(false);
        radio_speaker_notFound.setEnabled(false);
    }

    else{
        radio_speaker_notFound.setChecked(true);
        radio_speaker_work.setChecked(false);
        radio_speaker_notWorking.setEnabled(false);
    }



    resultOfsection25 = my.getLastDaysValues(result, 25 ,mydate);
    if(resultOfsection25==55){
        radio_framel_strong.setChecked(true);
        radio_framel_bad.setEnabled(false);
    }
    else if(resultOfsection25==56){
        radio_framel_bad.setChecked(true);
        radio_framel_strong.setEnabled(false);
    }

    resultOfsection26 = my.getLastDaysValues(result, 26 ,mydate);
    if(resultOfsection26==57){
        radio_framelhand_good.setChecked(true);
        radio_framelhand_bad.setEnabled(false);
        radio_framelhand_notwoking.setEnabled(false);
    }
    else if(resultOfsection26==58){
        radio_framelhand_bad.setChecked(true);
        radio_framelhand_good.setEnabled(false);
        radio_framelhand_notwoking.setEnabled(false);
    }

    else{
        radio_framelhand_notwoking.setChecked(true);
        radio_framelhand_good.setChecked(false);
        radio_framelhand_bad.setEnabled(false);
    }


    resultOfsection43 = my.getLastDaysValues(result, 43 ,mydate);
    if(resultOfsection43==104){
        radio_driveruniform_yes.setChecked(true);
        radio_driveruniform_no.setEnabled(false);
    }
    else if(resultOfsection43==105){
        radio_driveruniform_no.setChecked(true);
        radio_driveruniform_yes.setEnabled(false);
    }

    resultOfsection44 = my.getLastDaysValues(result, 44 ,mydate);
    if(resultOfsection44==106){
        radio_driver_clean_yes.setChecked(true);
        radio_driver_clean_no.setEnabled(false);
    }
    else if(resultOfsection44==107){
        radio_driver_clean_no.setChecked(true);
        radio_driver_clean_yes.setEnabled(false);
    }

    resultOfsection12 = my.getLastDaysValues(result, 12 ,mydate);
    if(resultOfsection12==27){
        radio_ttab3_found.setChecked(true);
        radio_ttab3_notfound.setEnabled(false);
    }
    else if(resultOfsection12==28){
        radio_ttab3_notfound.setChecked(true);
        radio_ttab3_found.setEnabled(false);
    }

}





public void onPause() {
    super.onPause();


    ((MyApplication) InternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(22, InternalBusActivityLastDays.this.resultOfsection22);

    ((MyApplication) InternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(8, InternalBusActivityLastDays.this.resultOfsection8);
    ((MyApplication) InternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(24, InternalBusActivityLastDays.this.resultOfsection24);
    ((MyApplication) InternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(42, InternalBusActivityLastDays.this.resultOfsection42);
    ((MyApplication) InternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(25, InternalBusActivityLastDays.this.resultOfsection25);
    ((MyApplication) InternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(26, InternalBusActivityLastDays.this.resultOfsection26);
    ((MyApplication) InternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(43, InternalBusActivityLastDays.this.resultOfsection43);
    ((MyApplication) InternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(44, InternalBusActivityLastDays.this.resultOfsection44);
    ((MyApplication) InternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(12, InternalBusActivityLastDays.this.resultOfsection12);

    if(num.getText().toString().isEmpty()||num.getText().toString().equals("NA")){

        num.setText("0");

    }



    ((MyApplication) InternalBusActivityLastDays.this.getApplication())
            .setKMCounter(Integer.parseInt(num.getText().toString()));
}
        }