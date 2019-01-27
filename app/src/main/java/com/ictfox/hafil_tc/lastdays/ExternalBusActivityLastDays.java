package com.ictfox.hafil_tc.lastdays;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.ictfox.hafil_tc.MySQLiteHelper;
import com.ictfox.hafil_tc.R;
import com.ictfox.hafil_tc.MyApplication;

/**
 * Created by heshe_000 on 8/18/2014.
 */
public class ExternalBusActivityLastDays extends Activity {
int resultOfsection15 = 0 ;
int resultOfsection16 = 0 ;
int resultOfsection46 = 0 ;
int resultOfsection17 = 0 ;
int resultOfsection18 = 0 ;
int resultOfsection19 = 0 ;
int resultOfsection20 = 0 ;
int resultOfsection45= 0 ;
int  resultOfsection47 = 0 ;

String mydate;
String result ="-1";

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_external_bus);

    TextView textView1 = (TextView) findViewById(R.id.textView1);
    TextView textView2 = (TextView) findViewById(R.id.textView2);
    TextView textView3 = (TextView) findViewById(R.id.TextView3);
    TextView textView4 = (TextView) findViewById(R.id.TextView4);
    TextView textView5 = (TextView) findViewById(R.id.TextView5);
    TextView textView6 = (TextView) findViewById(R.id.TextView6);
    TextView textView7 = (TextView) findViewById(R.id.TextView7);
    TextView textView8 = (TextView) findViewById(R.id.TextView8);
    TextView textView9 = (TextView) findViewById(R.id.TextView9);

    RadioGroup front_light = (RadioGroup) findViewById(R.id.radioGroup1);
    RadioGroup back_light = (RadioGroup) findViewById(R.id.radioGroup2);
    RadioGroup signals = (RadioGroup) findViewById(R.id.radioGroup3);
    RadioGroup front_glass = (RadioGroup) findViewById(R.id.radioGroup4);
    RadioGroup back_glass = (RadioGroup) findViewById(R.id.radioGroup5);
    RadioGroup side_glass = (RadioGroup) findViewById(R.id.radioGroup6);
    RadioGroup cleaner = (RadioGroup) findViewById(R.id.radioGroup7);
    RadioGroup bus_mazaya = (RadioGroup) findViewById(R.id.radioGroup8);
    RadioGroup block = (RadioGroup) findViewById(R.id.radioGroup9);

    RadioButton radio_front_light_works = (RadioButton) findViewById(R.id.radio0);
    RadioButton radio_front_light_notworking = (RadioButton) findViewById(R.id.radio1);

    RadioButton radio_back_light_works = (RadioButton) findViewById(R.id.radio2);
    RadioButton radio_back_light_notworking = (RadioButton) findViewById(R.id.radio3);

    RadioButton radio_signals_works = (RadioButton) findViewById(R.id.radio5);
    RadioButton radio_signals_notworking = (RadioButton) findViewById(R.id.radio6);

    RadioButton radio_front_glass_good = (RadioButton) findViewById(R.id.radio8);
    RadioButton radio_front_glass_broken = (RadioButton) findViewById(R.id.radio9);

    RadioButton radio_back_glass_good = (RadioButton) findViewById(R.id.radio10);
    RadioButton radio_back_glass_broken = (RadioButton) findViewById(R.id.radio11);

    RadioButton radio_side_glass_good = (RadioButton) findViewById(R.id.radio13);
    RadioButton radio_side_glass_broken = (RadioButton) findViewById(R.id.radio14);

    RadioButton radio_cleaner_good = (RadioButton) findViewById(R.id.radio18);
    RadioButton radio_cleaner_bad = (RadioButton) findViewById(R.id.radio17);

    RadioButton radio_bus_mazaya_good = (RadioButton) findViewById(R.id.radio21);
    RadioButton radio_bus_mazaya_bad = (RadioButton) findViewById(R.id.radio20);
    RadioButton radio_bus_mazaya_notfound = (RadioButton) findViewById(R.id.radio19);

    RadioButton radio_block_yes = (RadioButton) findViewById(R.id.radio24);
    RadioButton radio_block_no = (RadioButton) findViewById(R.id.radio23);

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

    radio_front_light_works.setTypeface(font);
    radio_front_light_notworking.setTypeface(font);

    radio_back_light_works.setTypeface(font);
    radio_back_light_notworking.setTypeface(font);

    radio_signals_works.setTypeface(font);
    radio_signals_notworking.setTypeface(font);

    radio_front_glass_good.setTypeface(font);
    radio_front_glass_broken.setTypeface(font);

    radio_back_glass_good.setTypeface(font);
    radio_back_glass_broken.setTypeface(font);

    radio_side_glass_good.setTypeface(font);
    radio_side_glass_broken.setTypeface(font);

    radio_cleaner_good.setTypeface(font);
    radio_cleaner_bad.setTypeface(font);

    radio_bus_mazaya_good.setTypeface(font);
    radio_bus_mazaya_bad.setTypeface(font);
    radio_bus_mazaya_notfound.setTypeface(font);

    radio_block_yes.setTypeface(font);
    radio_block_no.setTypeface(font);

    SharedPreferences prefs = PreferenceManager
            .getDefaultSharedPreferences(ExternalBusActivityLastDays.this);
    final MySQLiteHelper my = new MySQLiteHelper(ExternalBusActivityLastDays.this);

    result = prefs.getString("BusId","0");
    mydate = prefs.getString("Date","0");




    resultOfsection15 = my.getLastDaysValues(result, 15 ,mydate);
    if(resultOfsection15==35){
        radio_front_light_works.setChecked(true);
        radio_front_light_notworking.setEnabled(false);
    }
    else if(resultOfsection15==36){
        radio_front_light_notworking.setChecked(true);
        radio_front_light_works.setEnabled(false);

    }



    resultOfsection16 = my.getLastDaysValues(result, 16 ,mydate);
    if(resultOfsection16==37){
        radio_back_light_works.setChecked(true);
        radio_back_light_notworking.setEnabled(false);
    }
    else if(resultOfsection16==38){
        radio_back_light_notworking.setChecked(true);
        radio_back_light_works.setEnabled(false);

    }


    resultOfsection46 = my.getLastDaysValues(result, 46 ,mydate);
    if(resultOfsection46==111){
        radio_signals_works.setChecked(true);
        radio_signals_notworking.setEnabled(false);
    }
    else if(resultOfsection46==112){
        radio_signals_notworking.setChecked(true);
        radio_signals_works.setEnabled(false);

    }


    resultOfsection17 = my.getLastDaysValues(result, 17 ,mydate);
    if(resultOfsection17==39){
        radio_front_glass_good.setChecked(true);
        radio_front_glass_broken.setEnabled(false);
    }
    else if(resultOfsection17==40){
        radio_front_glass_broken.setChecked(true);
        radio_front_glass_good.setEnabled(false);

    }


    resultOfsection18 = my.getLastDaysValues(result, 18 ,mydate);
    if(resultOfsection18==41){
        radio_back_glass_good.setChecked(true);
        radio_back_glass_broken.setEnabled(false);
    }
    else if(resultOfsection18==42){
        radio_back_glass_broken.setChecked(true);
        radio_back_glass_good.setEnabled(false);

    }


    resultOfsection19 = my.getLastDaysValues(result, 19 ,mydate);
    if(resultOfsection19==43){
        radio_side_glass_good.setChecked(true);
        radio_side_glass_broken.setEnabled(false);
    }
    else if(resultOfsection19==44){
        radio_side_glass_broken.setChecked(true);
        radio_side_glass_good.setEnabled(false);

    }


    resultOfsection20 = my.getLastDaysValues(result, 20 ,mydate);
    if(resultOfsection20==45){
        radio_cleaner_good.setChecked(true);
        radio_cleaner_bad.setEnabled(false);
    }
    else if(resultOfsection20==46){
        radio_cleaner_bad.setChecked(true);
        radio_cleaner_good.setEnabled(false);

    }




    resultOfsection45 = my.getLastDaysValues(result, 45 ,mydate);
    if(resultOfsection45==108){
        radio_bus_mazaya_good.setChecked(true);
        radio_bus_mazaya_bad.setEnabled(false);
        radio_bus_mazaya_notfound.setEnabled(false);
    }
    else if(resultOfsection45==109){
        radio_bus_mazaya_bad.setChecked(true);
        radio_bus_mazaya_good.setEnabled(false);
        radio_bus_mazaya_notfound.setEnabled(false);
    }

    else{
        radio_bus_mazaya_notfound.setChecked(true);
        radio_bus_mazaya_good.setChecked(false);
        radio_bus_mazaya_bad.setEnabled(false);
    }










    resultOfsection47 = my.getLastDaysValues(result, 47 ,mydate);
    if(resultOfsection47==113){
        radio_block_yes.setChecked(true);
        radio_block_no.setEnabled(false);
    }
    else if(resultOfsection47==114){
        radio_block_no.setChecked(true);
        radio_block_yes.setEnabled(false);

    }











}

public void onPause() {
    super.onPause();

    ((MyApplication) ExternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(15, ExternalBusActivityLastDays.this.resultOfsection15);
    ((MyApplication) ExternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(16, ExternalBusActivityLastDays.this.resultOfsection16);
    ((MyApplication) ExternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(46, ExternalBusActivityLastDays.this.resultOfsection46);
    ((MyApplication) ExternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(17, ExternalBusActivityLastDays.this.resultOfsection17);
    ((MyApplication) ExternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(18, ExternalBusActivityLastDays.this.resultOfsection18);
    ((MyApplication) ExternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(19, ExternalBusActivityLastDays.this.resultOfsection19);
    ((MyApplication) ExternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(20, ExternalBusActivityLastDays.this.resultOfsection20);
    ((MyApplication) ExternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(45, ExternalBusActivityLastDays.this.resultOfsection45);
    ((MyApplication) ExternalBusActivityLastDays.this.getApplication())
            .setAnswerAndSection(47, ExternalBusActivityLastDays.this.resultOfsection47);
}

}
