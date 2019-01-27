package com.ictfox.hafil_tc.lastdays;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.ictfox.hafil_tc.MainBoardActivity;
import com.ictfox.hafil_tc.MyApplication;
import com.ictfox.hafil_tc.MySQLiteHelper;
import com.ictfox.hafil_tc.R;
import com.ictfox.hafil_tc.buscheck.BusCheckServerSyncforLastDate;

import java.util.Map;

/**
 * Created by heshe_000 on 8/25/2014.
 */
public class GeneralNotesActivityLastDays extends Activity implements LocationListener {
TextView txtLat;
TextView txtLag;
SharedPreferences prefs;
String android_id;

String mydate;
String result ="-1";
 EditText Note;
EditText Note2;
protected LocationManager locationManager;
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_notes);
    final Button Save = (Button) findViewById(R.id.button4);
    Button Sync = (Button) findViewById(R.id.button3);


    txtLat = (TextView) findViewById(R.id.TextView15);
    txtLag = (TextView) findViewById(R.id.TextView16);

    TextView  textView1 = (TextView) findViewById(R.id.textView1);
    TextView  textView2 = (TextView) findViewById(R.id.textView2);

    Typeface font = Typeface.createFromAsset(getAssets(), "HelveticaNeueW23-Reg.ttf");
    textView1.setTypeface(font);
    textView2.setTypeface(font);


   Note = (EditText) findViewById(R.id.autoCompleteTextView1);
   Note2 = (EditText) findViewById(R.id.autoCompleteTextView2);



    android_id = Settings.Secure.getString(this.getContentResolver(),
            Settings.Secure.ANDROID_ID);

    txtLat.setText("0.0");
    txtLag.setText("0.0");

    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

    prefs = PreferenceManager
            .getDefaultSharedPreferences(GeneralNotesActivityLastDays.this);

    mydate = prefs.getString("Date","0");
    result = prefs.getString("BusId","0");

    final MySQLiteHelper my = new MySQLiteHelper(GeneralNotesActivityLastDays.this);

    String GeneralNote = my.getLastDaysValuesGeneralNote(result,mydate);
    Note2.setText(GeneralNote);

    String TestDrive = my.getLastDaysValuesTestDrive(result, mydate);
    Note.setText(TestDrive);
		// SAVE ===============================================
		Save.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(
                        GeneralNotesActivityLastDays.this);
                progressDialog.setMessage("جاري حفظ البيانات");
                progressDialog.show();
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(false);

                int hitit = 0;

                for(Map.Entry<Integer, Integer> entry : ((MyApplication) GeneralNotesActivityLastDays.this.getApplication()).AnswerAndQuestion.entrySet()) {
                    Integer section2 = entry.getKey();
                    Integer answer2 = entry.getValue();
                    if(answer2==0) {

                        hitit=-1;

                    }

                }

                if(hitit==-1){

                    Toast.makeText(getApplicationContext(), "تاكد من الاجابه على جميع الاسئلة", Toast.LENGTH_LONG).show();

                }
else {
                    if(txtLat.getText().equals("0.0")) {
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(GeneralNotesActivityLastDays.this);

                        // Setting Dialog Title
                        alertDialog.setTitle("خطا!");

                        // Setting Dialog Message
                        alertDialog.setMessage("يجب الحصول على نقاط الجي بي اس اولا يرجى الانتظار قليلا");

                        // On pressing Settings button
                        alertDialog.setPositiveButton("الذهاب الى صفحة الاعدادت", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(intent);
                            }
                        });

                        // Showing Alert Message
                        alertDialog.show();
                    } else if(((MyApplication) GeneralNotesActivityLastDays.this.getApplication()).BusId == 0) {

                        Toast.makeText(getApplicationContext(), "تاكد من رقم الباص", Toast.LENGTH_SHORT).show();
                    } else {
                        final EditText Note = (EditText) findViewById(R.id.autoCompleteTextView1);
                        final EditText Note2 = (EditText) findViewById(R.id.autoCompleteTextView2);
                        //   Typeface font = Typeface.createFromAsset(getAssets(), "HelveticaNeueW23-Reg.ttf");

                        if(Note.getText().toString().isEmpty()) {
                            Note.setText("NA");
                        }
                        if(Note2.getText().toString().isEmpty()) {
                            Note2.setText("NA");

                        }


                        final MySQLiteHelper my = new MySQLiteHelper(GeneralNotesActivityLastDays.this);
                        my.update(((MyApplication) GeneralNotesActivityLastDays.this.getApplication()).AnswerAndQuestion, String.valueOf(((MyApplication) GeneralNotesActivityLastDays.this.getApplication()).BusId), mydate);
                        //my.insert();
                        my.updateStatus(0, mydate);
                        //my.insertNotes(((MyApplication) GeneralNotes.this.getApplication()).NotesMap ,String.valueOf(((MyApplication) OtherActivity.this.getApplication()).BusId));
                        GeneralNotesActivityLastDays.this.getSharedPreferences("Date", 0).edit().clear().commit();
                        GeneralNotesActivityLastDays.this.getSharedPreferences("fleetnumber", 0).edit().clear().commit();
                        GeneralNotesActivityLastDays.this.getSharedPreferences("BusId", 0).edit().clear().commit();
                        ((MyApplication) GeneralNotesActivityLastDays.this.getApplication()).AnswerAndQuestion.clear();


                        Intent ii = new Intent(GeneralNotesActivityLastDays.this, MainBoardActivity.class);
                        Toast.makeText(GeneralNotesActivityLastDays.this, "تم الحفظ بنجاح", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        progressDialog = null;
                        ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        GeneralNotesActivityLastDays.this.startActivity(ii);
                        GeneralNotesActivityLastDays.this.finish();
                    }}}
		});




		Sync.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                int hitit = 0;

                for(Map.Entry<Integer, Integer> entry : ((MyApplication) GeneralNotesActivityLastDays.this.getApplication()).AnswerAndQuestion.entrySet()) {
                    Integer section2 = entry.getKey();
                    Integer answer2 = entry.getValue();
                    if(answer2 == 0) {

                        hitit = -1;

                    }

                }

                if(hitit == -1) {

                    Toast.makeText(getApplicationContext(), "تاكد من الاجابه على جميع الاسئلة اولا", Toast.LENGTH_LONG).show();

                } else {


                    if(Integer.parseInt(prefs.getString("BusId", "0")) == 0) {

                        Toast.makeText(getApplicationContext(), "تاكد من رقم الباص", Toast.LENGTH_SHORT).show();
                    } else {

                        if(txtLat.getText().equals("0.0")) {
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(GeneralNotesActivityLastDays.this);

                            // Setting Dialog Title
                            alertDialog.setTitle("خطا!");

                            // Setting Dialog Message
                            alertDialog.setMessage("يجب الحصول على بيانات الجي بي اس اولا يرجى الانتظار");

                            // On pressing Settings button
                            alertDialog.setPositiveButton("الذهاب الى صفحة الاعدادت", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                    startActivity(intent);
                                }
                            });

                            // Showing Alert Message
                            alertDialog.show();
                        }
                        else {
                            final EditText Note = (EditText) findViewById(R.id.autoCompleteTextView1);
                            final EditText Note2 = (EditText) findViewById(R.id.autoCompleteTextView2);

                            if(Note.getText().toString().isEmpty()) {
                                Note.setText("NA");
                            }
                            if(Note2.getText().toString().isEmpty()) {
                                Note2.setText("NA");

                            }


                            ProgressDialog progressDialog = new ProgressDialog(
                                    GeneralNotesActivityLastDays.this);
                            progressDialog.setMessage("جاري المزامنة");
                            progressDialog.show();
                            progressDialog.setCancelable(false);
                            progressDialog.setCanceledOnTouchOutside(false);


                            // String ActionDate = new SimpleDateFormat("yyyy-MM-ddhh:mm:ss", Locale.getDefault()).format(new Date());


                            Cursor cursor = my.getAllAnswer(my.getFleetCheckListsIDforLastDays(mydate));
                            String sectionList = "";
                            String answerList = "";
                            int i=0;
                            if(cursor.getCount() >= 1) {
                                if(cursor.moveToFirst()) {
                                    do {
                                        sectionList = sectionList + String.valueOf(cursor.getInt(1) + ",");
                                        answerList = answerList + String.valueOf(cursor.getInt(2) + ",");
                                        i++;
                                    } while(cursor.moveToNext());
                                }
                                cursor.close();
                            }


                            BusCheckServerSyncforLastDate MyTask = new BusCheckServerSyncforLastDate(
                                    GeneralNotesActivityLastDays.this, progressDialog,
                                    GeneralNotesActivityLastDays.this.getApplicationContext(), prefs.getInt("fleetnumber", 0), sectionList, answerList, prefs.getString("Date", "0"), android_id, txtLat.getText().toString(), txtLag.getText().toString(), Note.getText().toString(), Note2.getText().toString(),i);
                            MyTask.execute();


                        }
                    }


                }
            }
        });


}
@Override
public void onLocationChanged(Location location) {
    txtLat = (TextView) findViewById(R.id.TextView15);
    txtLag = (TextView) findViewById(R.id.TextView16);
    txtLat.setText(""+location.getLatitude());
    txtLag.setText(""+location.getLongitude());
}

@Override
public void onProviderDisabled(String provider) {
    //Toast.makeText(getApplicationContext(), "قم بتشغيل الجي بي اس", Toast.LENGTH_LONG).show();

    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

    // Setting Dialog Title
    alertDialog.setTitle("خطأ");

    // Setting Dialog Message
    alertDialog.setMessage("الجي بي اس غير مفعل يجب تفعيله اولا ");

    // On pressing Settings button
    alertDialog.setPositiveButton("الذهاب لصفحة الاعدادت", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog,int which) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
    });

    // on pressing cancel button
    alertDialog.setNegativeButton("اغلاق الرسالة", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    });

    // Showing Alert Message
    alertDialog.show();
}



@Override
public void onProviderEnabled(String provider) {
}

@Override
public void onStatusChanged(String provider, int status, Bundle extras) {
}
}