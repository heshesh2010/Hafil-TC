package com.ictfox.hafil_tc.buscheck;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * Created by heshe_000 on 8/25/2014.
 */
public class GeneralNotes extends Activity implements LocationListener {
TextView txtLat;
TextView txtLag;
SharedPreferences prefs;
String android_id;
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






    android_id = Settings.Secure.getString(this.getContentResolver(),
            Settings.Secure.ANDROID_ID);

    txtLat.setText("0.0");
    txtLag.setText("0.0");

    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

    prefs = PreferenceManager
            .getDefaultSharedPreferences(GeneralNotes.this);

		// SAVE ===============================================
		Save.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

                int hitit = 0;
                ProgressDialog progressDialog = new ProgressDialog(
                        GeneralNotes.this);
                progressDialog.setMessage("جاري مزامنة البيانات ");
                progressDialog.show();
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(false);


                if(prefs.getBoolean("Documents",false)&&prefs.getBoolean("ExternalBus",false) &&prefs.getBoolean("InternalBus",false)    &&prefs.getBoolean("MotorActivity",false)   &&prefs.getBoolean("OtherActivity",false)  &&prefs.getBoolean("Security",false)) {

                    for(Map.Entry<Integer, Integer> entry : ((MyApplication) GeneralNotes.this.getApplication()).AnswerAndQuestion.entrySet()) {
                        Integer section2 = entry.getKey();
                        Integer answer2 = entry.getValue();
                        if(answer2==0) {

                            hitit=-1;

                        }

                    }

                    if(hitit==-1){

                        Toast.makeText(getApplicationContext(), "تاكد من الاجابه على جميع الاسئله السابقه ", Toast.LENGTH_LONG).show();

                    }
                    else {
                        if(txtLat.getText().equals("0.0")) {
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(GeneralNotes.this);

                            // Setting Dialog Title
                            alertDialog.setTitle("خطأ!");

                            // Setting Dialog Message
                            alertDialog.setMessage("الرجاء تشغيل الجي بي اس وانتظر البيانات ");

                            // On pressing Settings button
                            alertDialog.setPositiveButton(" صفحة الاعدادات", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                    startActivity(intent);
                                }
                            });

                            // Showing Alert Message
                            alertDialog.show();
                        } else if(((MyApplication) GeneralNotes.this.getApplication()).BusId == 0) {

                            Toast.makeText(getApplicationContext(), "الرجاء ادخال رقم الباص اولا ", Toast.LENGTH_SHORT).show();
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


                            final MySQLiteHelper my = new MySQLiteHelper(GeneralNotes.this);

                            my.insertINTOfleetCheckList(((MyApplication) GeneralNotes.this.getApplication()).BusId, txtLat.getText().toString(), txtLag.getText().toString(), 0, Note.getText().toString(), Note2.getText().toString(), ((MyApplication) GeneralNotes.this.getApplication()).GoodSeatsCount, ((MyApplication) GeneralNotes.this.getApplication()).BadSeatsCount, ((MyApplication) GeneralNotes.this.getApplication()).NASeatsCounts, ((MyApplication) GeneralNotes.this.getApplication()).KMCounter, ((MyApplication) GeneralNotes.this.getApplication()).SeatBeltsCount, ((MyApplication) GeneralNotes.this.getApplication()).NASeatBeltsCount, ((MyApplication) GeneralNotes.this.getApplication()).BatteryVoltage);
                            my.insert(((MyApplication) GeneralNotes.this.getApplication()).AnswerAndQuestion);

                            //my.insertNotes(((MyApplication) GeneralNotes.this.getApplication()).NotesMap ,String.valueOf(((MyApplication) OtherActivity.this.getApplication()).BusId));
                            GeneralNotes.this.getSharedPreferences("Date", 0).edit().clear().commit();
                            GeneralNotes.this.getSharedPreferences("BusId", 0).edit().clear().commit();
                            GeneralNotes.this.getSharedPreferences("fleetnumber", 0).edit().clear().commit();
                            ((MyApplication) GeneralNotes.this.getApplication()).AnswerAndQuestion.clear();


                            Intent ii = new Intent(GeneralNotes.this, MainBoardActivity.class);
                            Toast.makeText(GeneralNotes.this, "تم مزامنة البيانات ", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            progressDialog = null;
                            ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            GeneralNotes.this.startActivity(ii);
                            GeneralNotes.this.finish();
                        }
                    }



                }

                else{


                    Toast.makeText(getApplicationContext(), "تاكد من الاجابه على جميع الاسئله السابقه ", Toast.LENGTH_LONG).show();

                }

			}
		});




		Sync.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                int hitit = 0;
//int i=(MyApplication) GeneralNotes.this.getApplication().AnswerAndQuestion.entrySet().size();
                if(prefs.getBoolean("Documents",false)&&prefs.getBoolean("ExternalBus",false) &&prefs.getBoolean("InternalBus",false)    &&prefs.getBoolean("MotorActivity",false)   &&prefs.getBoolean("OtherActivity",false)  &&prefs.getBoolean("Security",false)) {

                    for(Map.Entry<Integer, Integer> entry : ((MyApplication) GeneralNotes.this.getApplication()).AnswerAndQuestion.entrySet()) {
                        Integer section2 = entry.getKey();
                        Integer answer2 = entry.getValue();

                        if(answer2 == 0) {

                            hitit = -1;

                        }
                    }
                        if(hitit==-1){

                            Toast.makeText(getApplicationContext(), "تاكد من الاجابه على جميع الاسئله السابقه ", Toast.LENGTH_LONG).show();

                        }



                        else {



                            if(((MyApplication) GeneralNotes.this.getApplication()).BusId == 0) {

                                Toast.makeText(getApplicationContext(), "ادخل رقم الباص اولا ", Toast.LENGTH_SHORT).show();
                            } else {
                                final EditText Note = (EditText) findViewById(R.id.autoCompleteTextView1);
                                final EditText Note2 = (EditText) findViewById(R.id.autoCompleteTextView2);

                                if(Note.getText().toString().isEmpty()) {
                                    Note.setText("NA");
                                }
                                if(Note2.getText().toString().isEmpty()) {
                                    Note2.setText("NA");

                                }

                                if(txtLat.getText().equals("0.0")) {
                                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(GeneralNotes.this);

                                    // Setting Dialog Title
                                    alertDialog.setTitle("خطأ!");

                                    // Setting Dialog Message
                                    alertDialog.setMessage("الرجاء تفعيل الجي بي اس وانتظار البيانات ");

                                    // On pressing Settings button
                                    alertDialog.setPositiveButton("صفحة الاعدادت", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                            startActivity(intent);
                                        }
                                    });

                                    // Showing Alert Message
                                    alertDialog.show();
                                }

                                else {

                                    ProgressDialog progressDialog = new ProgressDialog(
                                            GeneralNotes.this);
                                    progressDialog.setMessage("جاري مزامنة البيانات ");
                                    progressDialog.show();
                                    progressDialog.setCancelable(false);
                                    progressDialog.setCanceledOnTouchOutside(false);


                                    //	my.InsertImg(((MyApplication) GeneralNotes.this.getApplication()).getImageToDataBase(),String.valueOf(((MyApplication) OtherActivity.this.getApplication()).BusId));
                                    //	my.insertNotes(((MyApplication) GeneralNotes.this.getApplication()).NotesMap ,String.valueOf(((MyApplication) OtherActivity.this.getApplication()).BusId));


                                    String ActionDate = new SimpleDateFormat("yyyy-MM-ddhh:mm:ss", Locale.getDefault()).format(new Date());
                                    BusCheckServerSync MyTask = new BusCheckServerSync(
                                            GeneralNotes.this, progressDialog,
                                            GeneralNotes.this.getApplicationContext(), prefs.getInt("fleetnumber", 0), ((MyApplication) GeneralNotes.this.getApplication()).AnswerAndQuestion, ActionDate, android_id, txtLat.getText().toString(), txtLag.getText().toString(),
                                            Note.getText().toString(), Note2.getText().toString());
                                    MyTask.execute();

                                }
                            }

                        }

                }

                else{
                    Toast.makeText(getApplicationContext(), "تاكد من الاجابه على جميع الاسئله السابقه ", Toast.LENGTH_LONG).show();

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
    Toast.makeText(getApplicationContext(), "قم بتشغيل الجي بي اس", Toast.LENGTH_LONG).show();

    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

    // Setting Dialog Title
    alertDialog.setTitle("انتباه");

    // Setting Dialog Message
    alertDialog.setMessage("يجب تشغيل الجي بي اس اولا");

    // On pressing Settings button
    alertDialog.setPositiveButton("صفحة الاعدادات", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog,int which) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
    });

    // on pressing cancel button
    alertDialog.setNegativeButton("العودة للصفحة الرئيسية", new DialogInterface.OnClickListener() {
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