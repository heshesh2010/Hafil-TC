package com.ictfox.hafil_tc.lastdays;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.ictfox.hafil_tc.MySQLiteHelper;
import com.ictfox.hafil_tc.R;
import com.ictfox.hafil_tc.MyApplication;

/**
 * Created by heshe_000 on 8/18/2014.
 */
public class SecurityActivityLastDays extends Activity {

int resultOfsection35=0;
int resultOfsection36=0;
int resultOfsection38=0;
int resultOfsection39=0;
int resultOfsection40=0;
int resultOfsection41=0;


 EditText num ;
 EditText num2;
 EditText num3 ;

 EditText num4 ;
 EditText num5 ;
String mydate;
String result ="-1";

    public void onCreate (Bundle savedInstanceState){
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
       // RadioGroup seats = (RadioGroup) findViewById(R.id.radioGroup3);
       // RadioGroup seat = (RadioGroup) findViewById(R.id.radioGroup4);
        RadioGroup exit = (RadioGroup) findViewById(R.id.radioGroup5);
        RadioGroup bus = (RadioGroup) findViewById(R.id.radioGroup6);
        RadioGroup guid = (RadioGroup) findViewById(R.id.radioGroup7);
        RadioGroup tringle = (RadioGroup) findViewById(R.id.radioGroup8);


        num = (EditText) findViewById(R.id.editText);
        num2 = (EditText) findViewById(R.id.editText2);
        num3 = (EditText) findViewById(R.id.editText3);

        num4 = (EditText) findViewById(R.id.editText4);
        num5 = (EditText) findViewById(R.id.editText5);
/*
        num.setText("0");
        num2.setText("0");
        num3.setText("0");
        num4.setText("0");
        num5.setText("0");*/


        RadioButton radio_aid_ok = (RadioButton) findViewById(R.id.radio0);
        RadioButton radio_aid_expired = (RadioButton) findViewById(R.id.radio1);
        RadioButton radio_aid_notFound = (RadioButton) findViewById(R.id.radio211);

        RadioButton radio_fire_ok = (RadioButton) findViewById(R.id.radio2);
        RadioButton radio_fire_expired = (RadioButton) findViewById(R.id.radio3);
        RadioButton radio_fire_notFound = (RadioButton) findViewById(R.id.radio4);
/*
        RadioButton radio_seats_ok = (RadioButton) findViewById(R.id.radio5);
        RadioButton radio_seats_expired = (RadioButton) findViewById(R.id.radio6);
        RadioButton radio_seats_notFound = (RadioButton) findViewById(R.id.radio7);

        //
        RadioButton radio_seat_Found = (RadioButton) findViewById(R.id.radio8);
        RadioButton radio_seat_notFound = (RadioButton) findViewById(R.id.radio9);
*/
        RadioButton radio_exit_open = (RadioButton) findViewById(R.id.radio10);
        RadioButton radio_exit_notOpen = (RadioButton) findViewById(R.id.radio11);

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
      /*  radio_seats_ok.setTypeface(font);
        radio_seats_expired.setTypeface(font);
        radio_seats_notFound.setTypeface(font);
        radio_seat_Found.setTypeface(font);
        radio_seat_notFound.setTypeface(font);*/
        radio_exit_open.setTypeface(font);
        radio_exit_notOpen.setTypeface(font);
        radio_bus_Yes.setTypeface(font);
        radio_bus_No.setTypeface(font);
        radio_guid_Yes.setTypeface(font);
        radio_guid_No.setTypeface(font);
        radio_tringle_Yes.setTypeface(font);
        radio_tringle_No.setTypeface(font);

        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(SecurityActivityLastDays.this);
        result = prefs.getString("BusId","0");
        mydate = prefs.getString("Date","0");
        final MySQLiteHelper my = new MySQLiteHelper(SecurityActivityLastDays.this);




        resultOfsection35 = my.getLastDaysValues(result, 35 ,mydate);
        if(resultOfsection35==84){
            radio_aid_ok.setChecked(true);
            radio_aid_expired.setEnabled(false);
            radio_aid_notFound.setEnabled(false);
        }
        else if(resultOfsection35==85){
            radio_aid_expired.setChecked(true);
            radio_aid_ok.setEnabled(false);
            radio_aid_notFound.setEnabled(false);
        }

        else{
            radio_aid_notFound.setChecked(true);
            radio_aid_ok.setChecked(false);
            radio_aid_expired.setEnabled(false);
        }



        resultOfsection36 = my.getLastDaysValues(result, 36 ,mydate);
        if(resultOfsection36==87){
            radio_fire_ok.setChecked(true);
            radio_fire_expired.setEnabled(false);
            radio_fire_notFound.setEnabled(false);
        }
        else if(resultOfsection36==88){
            radio_fire_expired.setChecked(true);
            radio_fire_ok.setEnabled(false);
            radio_fire_notFound.setEnabled(false);
        }

        else{
            radio_fire_notFound.setChecked(true);
            radio_fire_ok.setChecked(false);
            radio_fire_expired.setEnabled(false);
        }


        resultOfsection38 = my.getLastDaysValues(result, 38 ,mydate);
        if(resultOfsection38==93){
            radio_exit_open.setChecked(true);
            radio_exit_notOpen.setEnabled(false);
        }
        else if(resultOfsection38==94){
            radio_exit_notOpen.setChecked(true);
            radio_exit_open.setEnabled(false);

        }


        resultOfsection39 = my.getLastDaysValues(result, 39 ,mydate);
        if(resultOfsection39==95){
            radio_bus_Yes.setChecked(true);
            radio_bus_No.setEnabled(false);
        }
        else if(resultOfsection39==96){
            radio_bus_No.setChecked(true);
            radio_bus_Yes.setEnabled(false);

        }



        resultOfsection40 = my.getLastDaysValues(result, 40 ,mydate);
        if(resultOfsection40==97){
            radio_guid_Yes.setChecked(true);
            radio_guid_No.setEnabled(false);
        }
        else if(resultOfsection40==98){
            radio_guid_No.setChecked(true);
            radio_guid_Yes.setEnabled(false);
        }


        resultOfsection41 = my.getLastDaysValues(result, 41 ,mydate);
        if(resultOfsection41==99){
            radio_tringle_Yes.setChecked(true);
            radio_tringle_No.setEnabled(false);
        }
        else if(resultOfsection41==100){
            radio_tringle_No.setChecked(true);
            radio_tringle_Yes.setEnabled(false);
        }

        num.setText(my.getLastDaysValuesEditTexts(result,mydate,"GoodSeatsCount"));
        num2.setText(my.getLastDaysValuesEditTexts(result,mydate,"BadSeatsCount"));
        num3.setText(my.getLastDaysValuesEditTexts(result,mydate,"NASeatsCounts"));
        num4.setText(my.getLastDaysValuesEditTexts(result,mydate,"SeatBeltsCount"));
        num5.setText(my.getLastDaysValuesEditTexts(result,mydate,"NASeatBeltsCount"));



    }

public void onPause() {
    super.onPause();
    num = (EditText) findViewById(R.id.editText);
    num2 = (EditText) findViewById(R.id.editText2);
    num3 = (EditText) findViewById(R.id.editText3);
    num4 = (EditText) findViewById(R.id.editText4);
    num5 = (EditText) findViewById(R.id.editText5);

    if(num.getText().toString().isEmpty()){
        num.setText("0");
    }
     if (num2.getText().toString().isEmpty()){
        num2.setText("0");
    }
     if (num3.getText().toString().isEmpty()){
        num3.setText("0");
    }

     if (num4.getText().toString().isEmpty()){
        num4.setText("0");
    }

     if (num5.getText().toString().isEmpty()){
        num5.setText("0");
    }


    ((MyApplication) SecurityActivityLastDays.this.getApplication())
            .setAnswerAndSection(35, SecurityActivityLastDays.this.resultOfsection35);

    ((MyApplication) SecurityActivityLastDays.this.getApplication())
            .setAnswerAndSection(36, SecurityActivityLastDays.this.resultOfsection36);
    ((MyApplication) SecurityActivityLastDays.this.getApplication())
            .setAnswerAndSection(38, SecurityActivityLastDays.this.resultOfsection38);
    ((MyApplication) SecurityActivityLastDays.this.getApplication())
            .setAnswerAndSection(39, SecurityActivityLastDays.this.resultOfsection39);
    ((MyApplication) SecurityActivityLastDays.this.getApplication())
            .setAnswerAndSection(40, SecurityActivityLastDays.this.resultOfsection40);
    ((MyApplication) SecurityActivityLastDays.this.getApplication())
            .setAnswerAndSection(41, SecurityActivityLastDays.this.resultOfsection41);


    ((MyApplication) SecurityActivityLastDays.this.getApplication())
            .setfirstThreeCounts(Integer.parseInt(num.getText().toString()), Integer.parseInt(num2.getText().toString()), Integer.parseInt(num3.getText().toString()), Integer.parseInt(num4.getText().toString()), Integer.parseInt(num5.getText().toString()));

}


}