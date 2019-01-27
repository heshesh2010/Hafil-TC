package com.ictfox.hafil_tc.buscheck;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.ictfox.hafil_tc.MyApplication;
import com.ictfox.hafil_tc.R;
/**
 * Created by heshe_000 on 8/18/2014.
 */
public class ExternalBus extends Activity {
int front_light = 0 ;
int back_light = 0 ;
int signals = 0 ;
int front_glass = 0 ;
int back_glass = 0 ;
int side_glass = 0 ;
int cleaner = 0 ;
int bus_mazaya= 0 ;
int  block = 0 ;



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


    front_light.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio0:

                    ExternalBus.this.front_light = 35;

                    break;

                case R.id.radio1:
                    ExternalBus.this.front_light = 36;


                    break;
            }//

        }
    });

    back_light.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio2:

                    ExternalBus.this.back_light = 37;

                    break;

                case R.id.radio3:
                    ExternalBus.this.back_light = 38;


                    break;
            }//

        }
    });

    signals.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio5:

                    ExternalBus.this.signals = 111;

                    break;

                case R.id.radio6:
                    ExternalBus.this.signals = 112;


                    break;
            }//

        }
    });

    front_glass.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio8:

                    ExternalBus.this.front_glass = 39;

                    break;

                case R.id.radio9:
                    ExternalBus.this.front_glass = 40;


                    break;
            }//

        }
    });

    back_glass.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio10:

                    ExternalBus.this.back_glass = 41;

                    break;

                case R.id.radio11:
                    ExternalBus.this.back_glass = 42;


                    break;
            }//

        }
    });

    side_glass.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio13:

                    ExternalBus.this.side_glass = 43;

                    break;

                case R.id.radio14:
                    ExternalBus.this.side_glass = 44;


                    break;
            }//

        }
    });

    cleaner.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio18:

                    ExternalBus.this.cleaner = 45;

                    break;

                case R.id.radio17:
                    ExternalBus.this.cleaner = 46;


                    break;
            }//

        }
    });

    bus_mazaya.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio21:

                    ExternalBus.this.bus_mazaya = 108;

                    break;

                case R.id.radio20:
                    ExternalBus.this.bus_mazaya = 109;


                    break;

                case R.id.radio19:
                    ExternalBus.this.bus_mazaya = 110;


                    break;
            }//

        }
    });

    block.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio24:

                    ExternalBus.this.block = 113;

                    break;

                case R.id.radio23:
                    ExternalBus.this.block = 114;


                    break;
            }//

        }
    });

}

public void onPause() {
    super.onPause();


    if(front_light == 0 || back_light == 0 || signals == 0 || front_glass == 0 || back_glass == 0 || side_glass == 0 || cleaner == 0 || bus_mazaya == 0 || block==0) {

        Toast.makeText(getApplicationContext(), "اختر اجابة اولا", Toast.LENGTH_LONG).show();
    }

        ((MyApplication) ExternalBus.this.getApplication())
                .setAnswerAndSection(15, ExternalBus.this.front_light);
        ((MyApplication) ExternalBus.this.getApplication())
                .setAnswerAndSection(16, ExternalBus.this.back_light);
        ((MyApplication) ExternalBus.this.getApplication())

                .setAnswerAndSection(46, ExternalBus.this.signals);
        ((MyApplication) ExternalBus.this.getApplication())
                .setAnswerAndSection(17, ExternalBus.this.front_glass);
        ((MyApplication) ExternalBus.this.getApplication())
                .setAnswerAndSection(18, ExternalBus.this.back_glass);
        ((MyApplication) ExternalBus.this.getApplication())
                .setAnswerAndSection(19, ExternalBus.this.side_glass);
        ((MyApplication) ExternalBus.this.getApplication())
                .setAnswerAndSection(20, ExternalBus.this.cleaner);
        ((MyApplication) ExternalBus.this.getApplication())
                .setAnswerAndSection(45, ExternalBus.this.bus_mazaya);
        ((MyApplication) ExternalBus.this.getApplication())
                .setAnswerAndSection(47, ExternalBus.this.block);
    SharedPreferences prefs = PreferenceManager
            .getDefaultSharedPreferences(this);
    prefs.edit().putBoolean("ExternalBus", true).commit();
}

}
