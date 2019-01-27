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
public class DocumentsActivityLastDays extends Activity {

int resultOfsection27=0;
int resultOfsection28=0;
int resultOfsection29=0;
int resultOfsection30=0;
int resultOfsection31=0;
int resultOfsection32=0;
int resultOfsection33=0;
int resultOfsection34=0;

String mydate;
String result ="-1";



public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_documents);



    TextView textView1 = (TextView) findViewById(R.id.textView1);
    TextView textView2 = (TextView) findViewById(R.id.textView2);
    TextView textView3 = (TextView) findViewById(R.id.TextView3);
    TextView textView4 = (TextView) findViewById(R.id.TextView4);
    TextView textView5 = (TextView) findViewById(R.id.TextView5);
    TextView textView6 = (TextView) findViewById(R.id.TextView6);
    TextView textView7 = (TextView) findViewById(R.id.TextView7);
    TextView textView8 = (TextView) findViewById(R.id.TextView8);

    SharedPreferences prefs = PreferenceManager
            .getDefaultSharedPreferences(DocumentsActivityLastDays.this);

    result = prefs.getString("BusId","0");
    mydate = prefs.getString("Date","0");

    RadioGroup sir = (RadioGroup) findViewById(R.id.radioGroup1);
    RadioGroup always_check = (RadioGroup) findViewById(R.id.radioGroup2);
    RadioGroup cerficate = (RadioGroup) findViewById(R.id.radioGroup3);
    RadioGroup driver = (RadioGroup) findViewById(R.id.radioGroup4);
    RadioGroup cart = (RadioGroup) findViewById(R.id.radioGroup5);
    RadioGroup  stop = (RadioGroup) findViewById(R.id.radioGroup6);
    RadioGroup  free_number = (RadioGroup) findViewById(R.id.radioGroup7);
    RadioGroup logo= (RadioGroup) findViewById(R.id.radioGroup8);

    RadioButton radio_sir_ok = (RadioButton) findViewById(R.id.radio0);
    RadioButton radio_sir_expired = (RadioButton) findViewById(R.id.radio1);
    RadioButton radio_sir_notFound = (RadioButton) findViewById(R.id.radio211);



    RadioButton radio_always_check_ok = (RadioButton) findViewById(R.id.radio2);
    RadioButton radio_always_check_expired = (RadioButton) findViewById(R.id.radio3);
    RadioButton radio_always_check_notFound  = (RadioButton) findViewById(R.id.radio4);


    RadioButton radio_cerficate_ok = (RadioButton) findViewById(R.id.radio5);
    RadioButton radio_cerficate_expired = (RadioButton) findViewById(R.id.radio6);
    RadioButton radio_cerficate_notFound = (RadioButton) findViewById(R.id.radio7);


    RadioButton radio_driver_ok = (RadioButton) findViewById(R.id.radio8);
    RadioButton radio_driver_expired  = (RadioButton) findViewById(R.id.radio9);
    RadioButton radio_driver_notFound  = (RadioButton) findViewById(R.id.radio89);


    RadioButton radio_cart_ok = (RadioButton) findViewById(R.id.radio10);
    RadioButton radio_cart_expired = (RadioButton) findViewById(R.id.radio11);
    RadioButton radio_cart_notFound  = (RadioButton) findViewById(R.id.radio12);


    RadioButton radio_stop_ok = (RadioButton) findViewById(R.id.radio13);
    RadioButton radio_stop_expired = (RadioButton) findViewById(R.id.radio14);
    RadioButton radio_stop_notFound = (RadioButton) findViewById(R.id.radio15);


    RadioButton radio_free_number_ok = (RadioButton) findViewById(R.id.radio18);
    RadioButton radio_free_number_expired = (RadioButton) findViewById(R.id.radio17);
    RadioButton radio_free_number_notFound = (RadioButton) findViewById(R.id.radio16);


    RadioButton radio_logo_ok = (RadioButton) findViewById(R.id.radio21);
    RadioButton radio_logo_expired = (RadioButton) findViewById(R.id.radio20);
    RadioButton radio_logo_notFound = (RadioButton) findViewById(R.id.radio19);

    Typeface font = Typeface.createFromAsset(getAssets(), "HelveticaNeueW23-Reg.ttf");

    textView1.setTypeface(font);
    textView2.setTypeface(font);
    textView3.setTypeface(font);
    textView4.setTypeface(font);
    textView5.setTypeface(font);
    textView6.setTypeface(font);
    textView7.setTypeface(font);
    textView8.setTypeface(font);

    radio_sir_ok.setTypeface(font);
    radio_sir_expired.setTypeface(font);
    radio_sir_notFound.setTypeface(font);

    radio_always_check_ok.setTypeface(font);
    radio_always_check_expired.setTypeface(font);
    radio_always_check_notFound.setTypeface(font);
    radio_cerficate_ok.setTypeface(font);
    radio_cerficate_expired.setTypeface(font);
    radio_cerficate_notFound.setTypeface(font);
    radio_driver_ok.setTypeface(font);
    radio_driver_expired.setTypeface(font);
    radio_driver_notFound.setTypeface(font);
    radio_cart_ok.setTypeface(font);
    radio_cart_expired.setTypeface(font);
    radio_cart_notFound.setTypeface(font);
    radio_stop_ok.setTypeface(font);
    radio_stop_expired.setTypeface(font);
    radio_stop_notFound.setTypeface(font);
    radio_free_number_ok.setTypeface(font);
    radio_free_number_expired.setTypeface(font);
    radio_free_number_notFound.setTypeface(font);
    radio_logo_ok.setTypeface(font);
    radio_logo_expired.setTypeface(font);
    radio_logo_notFound.setTypeface(font);

    final MySQLiteHelper my = new MySQLiteHelper(DocumentsActivityLastDays.this);

    resultOfsection27 = my.getLastDaysValues(result, 27 ,mydate);
    if(resultOfsection27==60){
        radio_sir_ok.setChecked(true);
        radio_sir_expired.setEnabled(false);
        radio_sir_notFound.setEnabled(false);
    }
    else if(resultOfsection27==61){
        radio_sir_expired.setChecked(true);
        radio_sir_ok.setEnabled(false);
        radio_sir_notFound.setEnabled(false);
    }

    else{
        radio_sir_notFound.setChecked(true);
        radio_sir_expired.setChecked(false);
        radio_sir_ok.setEnabled(false);
    }



    resultOfsection28 = my.getLastDaysValues(result, 28 ,mydate);
    if(resultOfsection28==63){
        radio_always_check_ok.setChecked(true);
        radio_always_check_expired.setEnabled(false);
        radio_always_check_notFound.setEnabled(false);
    }
    else if(resultOfsection28==64){
        radio_always_check_expired.setChecked(true);
        radio_always_check_ok.setEnabled(false);
        radio_always_check_notFound.setEnabled(false);
    }

    else{
        radio_always_check_notFound.setChecked(true);
        radio_always_check_ok.setChecked(false);
        radio_always_check_expired.setEnabled(false);
    }



    resultOfsection29 = my.getLastDaysValues(result, 29 ,mydate);
    if(resultOfsection29==66){
        radio_cerficate_ok.setChecked(true);
        radio_cerficate_expired.setEnabled(false);
        radio_cerficate_notFound.setEnabled(false);
    }
    else if(resultOfsection29==67){
        radio_cerficate_expired.setChecked(true);
        radio_cerficate_ok.setEnabled(false);
        radio_cerficate_notFound.setEnabled(false);
    }

    else{
        radio_cerficate_notFound.setChecked(true);
        radio_cerficate_ok.setChecked(false);
        radio_cerficate_expired.setEnabled(false);
    }


    resultOfsection30 = my.getLastDaysValues(result, 30 ,mydate);
    if(resultOfsection30==69){
        radio_driver_ok.setChecked(true);
        radio_driver_expired.setEnabled(false);
        radio_driver_notFound.setEnabled(false);
    }
    else if(resultOfsection30==70){
        radio_driver_expired.setChecked(true);
        radio_driver_ok.setEnabled(false);
        radio_driver_notFound.setEnabled(false);
    }

    else{
        radio_driver_notFound.setChecked(true);
        radio_driver_ok.setChecked(false);
        radio_driver_expired.setEnabled(false);
    }



    resultOfsection31 = my.getLastDaysValues(result, 31 ,mydate);
    if(resultOfsection31==72){
        radio_cart_ok.setChecked(true);
        radio_cart_expired.setEnabled(false);
        radio_cart_notFound.setEnabled(false);
    }
    else if(resultOfsection31==73){
        radio_cart_expired.setChecked(true);
        radio_cart_ok.setEnabled(false);
        radio_cart_notFound.setEnabled(false);
    }

    else{
        radio_cart_notFound.setChecked(true);
        radio_cart_ok.setChecked(false);
        radio_cart_expired.setEnabled(false);
    }


    resultOfsection32 = my.getLastDaysValues(result, 32 ,mydate);
    if(resultOfsection32==75){
        radio_stop_ok.setChecked(true);
        radio_stop_expired.setEnabled(false);
        radio_stop_notFound.setEnabled(false);
    }
    else if(resultOfsection32==76){
        radio_stop_expired.setChecked(true);
        radio_stop_ok.setEnabled(false);
        radio_stop_notFound.setEnabled(false);
    }

    else{
        radio_stop_notFound.setChecked(true);
        radio_stop_ok.setChecked(false);
        radio_stop_expired.setEnabled(false);
    }


    resultOfsection33 = my.getLastDaysValues(result, 33 ,mydate);
    if(resultOfsection33==78){
        radio_free_number_ok.setChecked(true);
        radio_free_number_expired.setEnabled(false);
        radio_free_number_notFound.setEnabled(false);
    }
    else if(resultOfsection33==79){
        radio_free_number_expired.setChecked(true);
        radio_free_number_ok.setEnabled(false);
        radio_free_number_notFound.setEnabled(false);
    }

    else{
        radio_free_number_notFound.setChecked(true);
        radio_free_number_ok.setChecked(false);
        radio_free_number_expired.setEnabled(false);
    }


    resultOfsection34 = my.getLastDaysValues(result, 34 ,mydate);
    if(resultOfsection34==81){
        radio_logo_ok.setChecked(true);
        radio_logo_expired.setEnabled(false);
        radio_logo_notFound.setEnabled(false);
    }
    else if(resultOfsection34==82){
        radio_logo_expired.setChecked(true);
        radio_logo_ok.setEnabled(false);
        radio_logo_notFound.setEnabled(false);
    }

    else{
        radio_logo_notFound.setChecked(true);
        radio_logo_ok.setChecked(false);
        radio_logo_expired.setEnabled(false);
    }
}


@Override
public void onPause() {
    super.onPause();

    ((MyApplication) DocumentsActivityLastDays.this.getApplication())
            .setAnswerAndSection(27, DocumentsActivityLastDays.this.resultOfsection27);
    ((MyApplication) DocumentsActivityLastDays.this.getApplication())
            .setAnswerAndSection(28, DocumentsActivityLastDays.this.resultOfsection28);
    ((MyApplication) DocumentsActivityLastDays.this.getApplication())
            .setAnswerAndSection(29, DocumentsActivityLastDays.this.resultOfsection29);
    ((MyApplication) DocumentsActivityLastDays.this.getApplication())
            .setAnswerAndSection(30, DocumentsActivityLastDays.this.resultOfsection30);
    ((MyApplication) DocumentsActivityLastDays.this.getApplication())
            .setAnswerAndSection(31, DocumentsActivityLastDays.this.resultOfsection30);
    ((MyApplication) DocumentsActivityLastDays.this.getApplication())
            .setAnswerAndSection(32, DocumentsActivityLastDays.this.resultOfsection32);
    ((MyApplication) DocumentsActivityLastDays.this.getApplication())
            .setAnswerAndSection(33, DocumentsActivityLastDays.this.resultOfsection33);
    ((MyApplication) DocumentsActivityLastDays.this.getApplication())
            .setAnswerAndSection(34, DocumentsActivityLastDays.this.resultOfsection34);



}
}