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
public class Documents extends Activity {

int sir=0;
int always_check=0;
int cerficate=0;
int driver=0;
int cart=0;
int stop=0;
int free_number=0;
int logo=0;

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


    sir.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio0:

                    Documents.this.sir =60;

                    break;

                case R.id.radio1:
                    Documents.this.sir =61;

                    break;
                case R.id.radio211:
                    Documents.this.sir =62;

                    break;
            }//

        }
    });



    always_check.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio2:

                    Documents.this.always_check =63;

                    break;

                case R.id.radio3:
                    Documents.this.always_check =64;

                    break;
                case R.id.radio4:
                    Documents.this.always_check =65;

                    break;
            }//

        }
    });


    cerficate.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio5:

                    Documents.this.cerficate =66;

                    break;

                case R.id.radio6:
                    Documents.this.cerficate =67;

                    break;
                case R.id.radio7:
                    Documents.this.cerficate =68;

                    break;
            }//

        }
    });


    driver.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio8:

                    Documents.this.driver =69;

                    break;

                case R.id.radio9:
                    Documents.this.driver =70;

                    break;
                case R.id.radio89:
                    Documents.this.driver =71;

                    break;
            }//

        }
    });


    cart.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio10:

                    Documents.this.cart =72;

                    break;

                case R.id.radio11:
                    Documents.this.cart =73;

                    break;
                case R.id.radio12:
                    Documents.this.cart =74;

                    break;
            }//

        }
    });


    stop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio13:

                    Documents.this.stop =75;

                    break;

                case R.id.radio14:
                    Documents.this.stop =76;

                    break;
                case R.id.radio15:
                    Documents.this.stop =77;

                    break;
            }//

        }
    });


    free_number.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio18:

                    Documents.this.free_number =78;

                    break;

                case R.id.radio17:
                    Documents.this.free_number =79;

                    break;
                case R.id.radio16:
                    Documents.this.free_number =80;

                    break;
            }//

        }
    });


    logo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radio21:

                    Documents.this.logo =81;

                    break;

                case R.id.radio20:
                    Documents.this.logo =82;

                    break;
                case R.id.radio19:
                    Documents.this.logo =83;

                    break;
            }//

        }
    });


}


@Override
public void onPause() {
    super.onPause();

    if(sir ==0 || always_check ==0 || cerficate==0 || driver ==0|| cart ==0|| stop ==0 || free_number==0 || logo==0){

        Toast.makeText(getApplicationContext(), "اختر اجابة اولا", Toast.LENGTH_LONG).show();
    }


        ((MyApplication) Documents.this.getApplication())
                .setAnswerAndSection(27, Documents.this.sir);

        ((MyApplication) Documents.this.getApplication())
                .setAnswerAndSection(28, Documents.this.always_check);

        ((MyApplication) Documents.this.getApplication())
                .setAnswerAndSection(29, Documents.this.cerficate);

        ((MyApplication) Documents.this.getApplication())
                .setAnswerAndSection(30, Documents.this.driver);

        ((MyApplication) Documents.this.getApplication())
                .setAnswerAndSection(31, Documents.this.cart);


        ((MyApplication) Documents.this.getApplication())
                .setAnswerAndSection(32, Documents.this.stop);


        ((MyApplication) Documents.this.getApplication())
                .setAnswerAndSection(33, Documents.this.free_number);


        ((MyApplication) Documents.this.getApplication())
                .setAnswerAndSection(34, Documents.this.logo);
    SharedPreferences prefs = PreferenceManager
            .getDefaultSharedPreferences(this);
    prefs.edit().putBoolean("Documents", true).commit();

    }

}
