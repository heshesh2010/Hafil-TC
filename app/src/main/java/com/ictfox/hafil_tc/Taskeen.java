package com.ictfox.hafil_tc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by heshe_000 on 6/30/2014.
 */
public class Taskeen extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

TextView view1;
TextView view2;
TextView view3;
TextView view34;
TextView view4;
TextView view5;
TextView view6;
TextView view7;
TextView view8;
TextView view9;
TextView view10;
TextView view11;
TextView view12;



TextView plateNumber;
TextView userName;
TextView schoolName;
TextView Adress;


EditText FleetNumber;
EditText MinstyNumber;
EditText driverName;
EditText DriverID;
EditText DriverMobile;
EditText NomOfOrder;
EditText Note;



 Button searchMinstry = null;
 Button searchFleetNumber= null;
 Button searchDriver= null;
 Button SAVE= null;
 Button SYNC= null;


String theNUM="0";
String Mistrynum="0";
String DriverIDString="0";

int Answer=0;
int type =0;
int ok = 1;
Cursor cursor;
MySQLiteHelper dbHandler;
Spinner s1,s2;
 Spinner spinnertech;




String TaskeenArea="المدينة المنورة";

String TaskeenCity="مهد الذهب";
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_taskeen);

    FleetNumber = (EditText) findViewById(R.id.editText1);
    searchFleetNumber = (Button) findViewById(R.id.search1);

    DriverID   = (EditText) findViewById(R.id.editText2);
    searchDriver = (Button) findViewById(R.id.search2);

MinstyNumber = (EditText) findViewById(R.id.editText34);
    searchMinstry = (Button) findViewById(R.id.search34);


    SAVE = (Button) findViewById(R.id.button2);
    SYNC = (Button) findViewById(R.id.button3);

    Typeface font = Typeface.createFromAsset(getAssets(),
            "HelveticaNeueW23-Reg.ttf");


    view1 = (TextView) findViewById(R.id.textView1);
    view2 = (TextView) findViewById(R.id.textView2);
    view3 = (TextView) findViewById(R.id.textView3);
    view34 = (TextView) findViewById(R.id.textView34);
    view4 = (TextView) findViewById(R.id.textView4);
    view5 = (TextView) findViewById(R.id.textView5);
    view6 = (TextView) findViewById(R.id.textView6);
    view7= (TextView) findViewById(R.id.textView7);
    view8= (TextView) findViewById(R.id.textView8);
    view9= (TextView) findViewById(R.id.textView9);
    view10 = (TextView) findViewById(R.id.textView10);
    view11 = (TextView) findViewById(R.id.textView11);
    view12 = (TextView) findViewById(R.id.textView12);


    plateNumber = (TextView) findViewById(R.id.textView13);
    userName = (TextView) findViewById(R.id.textView14);
    schoolName = (TextView) findViewById(R.id.textView15);
    Adress = (TextView) findViewById(R.id.textView16);

    driverName = (EditText) findViewById(R.id.editText3);
    DriverMobile=(EditText) findViewById(R.id.editText4);
    NomOfOrder=(EditText) findViewById(R.id.editText5);
    Note = (EditText) findViewById(R.id.editText6);


    FleetNumber.setTypeface(font);
    MinstyNumber.setTypeface(font);
    DriverID.setTypeface(font);

    view1.setTypeface(font);
    view2.setTypeface(font);
    view3.setTypeface(font);
    view34.setTypeface(font);
    view4.setTypeface(font);
    view5.setTypeface(font);
    view6.setTypeface(font);
    view7.setTypeface(font);
    view8.setTypeface(font);
    view9.setTypeface(font);
    view10.setTypeface(font);
    view11.setTypeface(font);
    view12.setTypeface(font);


    plateNumber.setTypeface(font);
    userName.setTypeface(font);
    schoolName.setTypeface(font);
    Adress.setTypeface(font);


    driverName.setTypeface(font);
    DriverMobile.setTypeface(font);
    NomOfOrder.setTypeface(font);
    Note.setTypeface(font);

    SharedPreferences mPrefs= PreferenceManager
            .getDefaultSharedPreferences(Taskeen.this);
    userName.setText(mPrefs.getString("UserID", "0"));

    String[] technology = {"حافلة عاملة", "حافلة احتياطى بالسائق ", "حافلة احتياطى بدون سائق ", "تنزيل"};
   // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, technology);
spinnertech = (Spinner) findViewById(R.id.spinner0);

    s1 = (Spinner)findViewById(R.id.spinner1);
    s2 = (Spinner)findViewById(R.id.spinner2);
    s1.setOnItemSelectedListener(this);

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item,technology);


    spinnertech.setAdapter(adapter);
    spinnertech.setOnItemSelectedListener(this);
    s1.setOnItemSelectedListener(this);
    s2.setOnItemSelectedListener(this);

    s1.setGravity(Gravity.CENTER);
s2.setGravity(Gravity.CENTER);

    s1.setVisibility(View.INVISIBLE);
    s2.setVisibility(View.INVISIBLE);


    s1.setEnabled(false);
    s2.setEnabled(false);



    List<String> list20 = new ArrayList<String>();
    list20.add("المدينة المنورة");
    list20.add("الرياض");
    list20.add("الشرقية");
    list20.add("مكة المكرمة");
    list20.add("القصيم");


    ArrayAdapter<String> dataAdapter10 = new ArrayAdapter<String>(this,
            R.layout.spinner_item,list20);
    s1.setAdapter(dataAdapter10);





    SYNC.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

/*
            if(driverName.getText().toString().isEmpty()|| driverName.getText().toString().equals("null")){

                Toast.makeText(Taskeen.this.getApplicationContext(), "فضلا ادخل اسم السائق", Toast.LENGTH_SHORT).show();


            }




            else  if( DriverMobile.getText().toString().isEmpty()|| DriverMobile.getText().toString().equals("null")){


                Toast.makeText(Taskeen.this.getApplicationContext(), "فضلا ادخل رقم الجوال", Toast.LENGTH_SHORT).show();



            }


            else  if(DriverMobile.getText().toString().length()<10)  {
                Toast.makeText(Taskeen.this.getApplicationContext(), "فضلا ادخل رقم الجوال كاملا", Toast.LENGTH_SHORT).show();


            }

            else  if(Integer.parseInt(NomOfOrder.getText().toString())<0||
            (NomOfOrder.getText().toString())>99||NomOfOrder.getText().toString().isEmpty()||NomOfOrder.getText().toString()==null){

                Toast.makeText(Taskeen.this.getApplicationContext(), "برجاء ادخال عدد الطالبات بين 1 و99 فقط", Toast.LENGTH_SHORT).show();

            }

            else if(plateNumber.getText().toString().isEmpty()|| plateNumber.getText().toString().equals("null") ||
                    schoolName.getText().toString().isEmpty()|| schoolName.getText().toString().equals("null")||
                    Adress.getText().toString().isEmpty()|| Adress.getText().toString().equals("null")||
                    driverName.getText().toString().isEmpty()|| driverName.getText().toString().equals("null")||
                    DriverMobile.getText().toString().isEmpty()|| DriverMobile.getText().toString().equals("null")||
                    NomOfOrder.getText().toString().isEmpty()||DriverID.getText().toString().isEmpty()
                    ){


                Toast.makeText(Taskeen.this.getApplicationContext(), "البيانات ناقصة , تأكد من استكمال البيانات", Toast.LENGTH_SHORT).show();

            }

            else {
            */
              String  ActionDate =  new SimpleDateFormat("yyyy-MM-ddHH:mm:ss", Locale.getDefault()).format(new Date());

                ProgressDialog progressDialog;
                progressDialog = new ProgressDialog(
                        Taskeen.this);
                progressDialog.setMessage("جاري مزامنة البيانات");
                progressDialog.show();
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(false);
if(type==0) {
    if(MinstyNumber.getText().toString() == null || MinstyNumber.getText().toString().equals("0") || MinstyNumber.getText().toString().isEmpty()) {
        TaskeenSyncTask MyTask = new TaskeenSyncTask(
                Taskeen.this, progressDialog, getApplicationContext(), userName.getText().toString(), plateNumber.getText().toString(), schoolName.getText().toString(), Adress.getText().toString(), driverName.getText().toString(), DriverMobile.getText().toString(), "0", FleetNumber.getText().toString(), DriverID.getText().toString(), "0", ActionDate, type, Note.getText().toString(), "0", "0");

        MyTask.execute();

    } else {

        TaskeenSyncTask MyTask = new TaskeenSyncTask(
                Taskeen.this, progressDialog, getApplicationContext(), userName.getText().toString(), plateNumber.getText().toString(), schoolName.getText().toString(), Adress.getText().toString(), driverName.getText().toString(), DriverMobile.getText().toString(), MinstyNumber.getText().toString(), FleetNumber.getText().toString(), DriverID.getText().toString(), NomOfOrder.getText().toString(), ActionDate, type, Note.getText().toString(), "0", "0");

        MyTask.execute();

    }
}


        else {

    if(MinstyNumber.getText().toString() == null || MinstyNumber.getText().toString().equals("0") || MinstyNumber.getText().toString().isEmpty()) {
        TaskeenSyncTask MyTask = new TaskeenSyncTask(
                Taskeen.this, progressDialog, getApplicationContext(), userName.getText().toString(), plateNumber.getText().toString(), schoolName.getText().toString(), Adress.getText().toString(), driverName.getText().toString(), DriverMobile.getText().toString(), "0", FleetNumber.getText().toString(), DriverID.getText().toString(), "0", ActionDate, type, Note.getText().toString(), TaskeenArea, TaskeenCity);

        MyTask.execute();

    } else {

        TaskeenSyncTask MyTask = new TaskeenSyncTask(
                Taskeen.this, progressDialog, getApplicationContext(), userName.getText().toString(), plateNumber.getText().toString(), schoolName.getText().toString(), Adress.getText().toString(), driverName.getText().toString(), DriverMobile.getText().toString(), MinstyNumber.getText().toString(), FleetNumber.getText().toString(), DriverID.getText().toString(), NomOfOrder.getText().toString(), ActionDate, type, Note.getText().toString(), TaskeenArea, TaskeenCity);

        MyTask.execute();

    }



}



            }
      //  }
    });

    SAVE.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

ok=1;

// set data/*
           /* if(type==0){
                MinstyNumber.setText("0");
                schoolName.setText("NA");
                Adress.setText("NA");
                NomOfOrder.setText("0");
            }

            else if(type==1){
                MinstyNumber.setText("0");
                DriverID.setText("NA");
                schoolName.setText("NA");
                Adress.setText("NA");
                driverName.setText("NA");
                DriverMobile.setText("NA");
                NomOfOrder.setText("0");
            }

            else if(type==2){
                MinstyNumber.setText("0");
                DriverID.setText("NA");
                schoolName.setText("NA");
                Adress.setText("NA");
                driverName.setText("NA");
                DriverMobile.setText("NA");
                NomOfOrder.setText("0");
            }

            else if(type==3){
                MinstyNumber.setText("0");
                DriverID.setText("NA");
                schoolName.setText("NA");
                Adress.setText("NA");
                driverName.setText("NA");
                DriverMobile.setText("NA");
                NomOfOrder.setText("0");
            }*/

            if(type==0){

            if(driverName.getText().toString().isEmpty() || driverName.getText().toString().equals("null")) {
                ok=0;
                    Toast.makeText(Taskeen.this.getApplicationContext(), "فضلا ادخل اسم السائق", Toast.LENGTH_SHORT).show();


                } else if(DriverMobile.getText().toString().isEmpty() || DriverMobile.getText().toString().equals("null")) {
                ok=0;

                    Toast.makeText(Taskeen.this.getApplicationContext(), "فضلا ادخل رقم الجوال", Toast.LENGTH_SHORT).show();


                } else if(DriverMobile.getText().toString().length() < 10) {
                ok=0;
                    Toast.makeText(Taskeen.this.getApplicationContext(), "فضلا ادخل رقم الجوال كاملا", Toast.LENGTH_SHORT).show();


                } else if(NomOfOrder.getText().toString().isEmpty()) {
                ok=0;
                    NomOfOrder.setText("0");
                    Toast.makeText(Taskeen.this.getApplicationContext(), "برجاء ادخال عدد الطلبة", Toast.LENGTH_SHORT).show();

                } else if(Integer.parseInt(NomOfOrder.getText().toString()) < 0 || Integer.parseInt(NomOfOrder.getText().toString()) > 99) {
                ok=0;
                    Toast.makeText(Taskeen.this.getApplicationContext(), "برجاء ادخال عدد الطالبات بين 1 و99 فقط", Toast.LENGTH_SHORT).show();

                } else if(plateNumber.getText().toString().isEmpty() || plateNumber.getText().toString().equals("null") ||
                        schoolName.getText().toString().isEmpty() || schoolName.getText().toString().equals("null") ||
                        Adress.getText().toString().isEmpty() || Adress.getText().toString().equals("null") ||
                        driverName.getText().toString().isEmpty() || driverName.getText().toString().equals("null") ||
                        DriverMobile.getText().toString().isEmpty() || DriverMobile.getText().toString().equals("null") ||
                        NomOfOrder.getText().toString().isEmpty() || DriverID.getText().toString().isEmpty()
                        ) {

                ok=0;
                    Toast.makeText(Taskeen.this.getApplicationContext(), "البيانات ناقصة , تأكد من استكمال البيانات", Toast.LENGTH_SHORT).show();

                }
            }




             if(type==1){



                if(driverName.getText().toString().isEmpty()|| driverName.getText().toString().equals("null")){
                    ok=0;
                    Toast.makeText(Taskeen.this.getApplicationContext(), "فضلا ادخل اسم السائق", Toast.LENGTH_SHORT).show();


                }




                else  if( DriverMobile.getText().toString().isEmpty()|| DriverMobile.getText().toString().equals("null")){

                    ok=0;
                    Toast.makeText(Taskeen.this.getApplicationContext(), "فضلا ادخل رقم الجوال", Toast.LENGTH_SHORT).show();



                }


                else  if(DriverMobile.getText().toString().length()<10)  {
                    ok=0;
                    Toast.makeText(Taskeen.this.getApplicationContext(), "فضلا ادخل رقم الجوال كاملا", Toast.LENGTH_SHORT).show();


                }


                else if(plateNumber.getText().toString().isEmpty()|| plateNumber.getText().toString().equals("null") ||
                        driverName.getText().toString().isEmpty()|| driverName.getText().toString().equals("null")||
                        DriverMobile.getText().toString().isEmpty()|| DriverMobile.getText().toString().equals("null")
                        ){

                    ok=0;
                    Toast.makeText(Taskeen.this.getApplicationContext(), "البيانات ناقصة , تأكد من استكمال البيانات", Toast.LENGTH_SHORT).show();

                }


            }


            else if(type==2) {

                if(plateNumber.getText().toString().isEmpty() || plateNumber.getText().toString().equals("null")) {
                    ok = 0;
                    Toast.makeText(Taskeen.this.getApplicationContext(), "البيانات ناقصة , تأكد من استكمال البيانات", Toast.LENGTH_SHORT).show();
                }

                else if (FleetNumber.getText().toString().isEmpty()){
                     ok=0;
                    Toast.makeText(Taskeen.this.getApplicationContext(), "تاكد من رقم الشركة", Toast.LENGTH_SHORT).show();


                }
            }


            else if(type==3){




                if(plateNumber.getText().toString().isEmpty() || plateNumber.getText().toString().equals("null")) {
                    ok = 0;
                    Toast.makeText(Taskeen.this.getApplicationContext(), "البيانات ناقصة , تأكد من استكمال البيانات", Toast.LENGTH_SHORT).show();
                }
                else if (FleetNumber.getText().toString().isEmpty()){
                     ok=0;
                    Toast.makeText(Taskeen.this.getApplicationContext(), "تاكد من رقم الشركة", Toast.LENGTH_SHORT).show();


                }


            }




if(ok==1||type==0) {


    String ActionDate = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss", Locale.getDefault()).format(new Date());

    MySQLiteHelper dbHandler = new MySQLiteHelper(Taskeen.this);

    dbHandler.InsertIntoTaskeen(userName.getText().toString(), plateNumber.getText().toString(), schoolName.getText().toString(), Adress.getText().toString(), driverName.getText().toString(), DriverMobile.getText().toString(), MinstyNumber.getText().toString(), FleetNumber.getText().toString(), DriverID.getText().toString(), NomOfOrder.getText().toString(), ActionDate, 0, type, Note.getText().toString(),"0", "0");
    //Toast.makeText(Taskeen.this.getApplicationContext(), "تم حفظ البيانات بنجاح", Toast.LENGTH_SHORT).show();
    new AlertDialog.Builder(Taskeen.this)
            .setTitle("تم حفظ البيانات بنجاح ")
            .setMessage("هل تود الذهاب الى صفحة الرئيسية")
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                    Intent intent1 = new Intent(Taskeen.this, MainBoardActivity.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent1);
                }
            }).setIcon(R.drawable.checked)
            .show();
}


            else if(ok==1){

    String ActionDate = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss", Locale.getDefault()).format(new Date());

    MySQLiteHelper dbHandler = new MySQLiteHelper(Taskeen.this);

    dbHandler.InsertIntoTaskeen(userName.getText().toString(), plateNumber.getText().toString(), schoolName.getText().toString(), Adress.getText().toString(), driverName.getText().toString(), DriverMobile.getText().toString(), MinstyNumber.getText().toString(), FleetNumber.getText().toString(), DriverID.getText().toString(), NomOfOrder.getText().toString(), ActionDate, 0, type, Note.getText().toString(),TaskeenArea, TaskeenCity);
    //Toast.makeText(Taskeen.this.getApplicationContext(), "تم حفظ البيانات بنجاح", Toast.LENGTH_SHORT).show();
    new AlertDialog.Builder(Taskeen.this)
            .setTitle("تم حفظ البيانات بنجاح ")
            .setMessage("هل تود الذهاب الى صفحة الرئيسية")
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                    Intent intent1 = new Intent(Taskeen.this, MainBoardActivity.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent1);
                }
            }).setIcon(R.drawable.checked)
            .show();



            }
            }


    });


            searchMinstry.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {



            if(MinstyNumber.getText().toString()==null||MinstyNumber.getText().toString().isEmpty()||MinstyNumber.getText().toString().equals("0")){

                Toast.makeText(getApplicationContext(), "برجاء إدخال رقم الوزارة", Toast.LENGTH_SHORT).show();

            }


            else{
                EditText MinstyNumber = (EditText) findViewById(R.id.editText34);
                Taskeen.this.Mistrynum=MinstyNumber.getText().toString() ;
                ProgressDialog progressDialog = new ProgressDialog(
                        Taskeen.this);
                progressDialog.setMessage("جاري جلب لبيانات برجاء الانتظار");
                progressDialog.show();
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(false);
                MinstryTaskeenDataBase MyTask = new MinstryTaskeenDataBase(
                        Taskeen.this, progressDialog,
                        getApplicationContext(),  MinstyNumber.getText().toString());
                MyTask.execute();
            }
        }
    });









    searchFleetNumber.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {


            if(FleetNumber==null || String.valueOf(FleetNumber.getText()).isEmpty() ){

                Toast.makeText(Taskeen.this, "برجاء إدخال رقم الشركة", Toast.LENGTH_SHORT).show();

            }


            else{
                EditText FleetNumber = (EditText) findViewById(R.id.editText1);
                Taskeen.this.theNUM= FleetNumber.getText().toString() ;

                ProgressDialog progressDialog = new ProgressDialog(
                        Taskeen.this);
                progressDialog
                        .setMessage("جاري البحث عن البيانات برجاء الانتظار");
                progressDialog.show();
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(false);
                FleetNumberTaskeenDataBase MyTask = new FleetNumberTaskeenDataBase(
                        Taskeen.this, progressDialog, Taskeen.this.theNUM,
                        getApplicationContext());
                MyTask.execute();

            }
        }
    });






    searchDriver.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {


            if(DriverID==null || String.valueOf(DriverID.getText()).isEmpty()|| DriverID.getText().toString().equals("0") ){

                Toast.makeText(Taskeen.this, "برجاء أدخال رقم الهوية", Toast.LENGTH_SHORT).show();

            }

            else if (DriverID.getText().toString().length()<10){

                Toast.makeText(Taskeen.this, "برجاء إدخال رقم الهوية كامل", Toast.LENGTH_SHORT).show();
            }

            else{
                EditText DriverID = (EditText) findViewById(R.id.editText2);
                Taskeen.this.DriverIDString= String.valueOf(DriverID.getText()) ;

                ProgressDialog progressDialog = new ProgressDialog(
                        Taskeen.this);
                progressDialog
                        .setMessage("جاري البحث عن البيانات برجاء الانتظار");
                progressDialog.show();
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(false);
                DriverTaskeenDataBase MyTask = new DriverTaskeenDataBase(
                        Taskeen.this, progressDialog, Taskeen.this.DriverIDString,
                        getApplicationContext());
                MyTask.execute();

            }
        }
    });






}



@Override
public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                           long arg3) {



    int position = arg0.getSelectedItemPosition();


    Spinner spinner = (Spinner) arg0;
    if(spinner.getId() == R.id.spinner0) {
        //do this


        if(position == 0) {

             s1.setEnabled(false);
             s2.setEnabled(false);

            plateNumber.setText("");
            schoolName.setText("");
            Adress.setText("");
            driverName.setText("");
            DriverMobile.setText("");
            NomOfOrder.setText("");
            Note.setText("");
            FleetNumber.setText("");
            DriverID.setText("");
            MinstyNumber.setText("");
            type = 0;
            view1.setEnabled(true);
            view2.setEnabled(true);
            view3.setEnabled(true);
            view34.setEnabled(true);
            view4.setEnabled(true);
            view5.setEnabled(true);
            view6.setEnabled(true);
            view7.setEnabled(true);
            view8.setEnabled(true);
            view9.setEnabled(true);
            view10.setEnabled(true);
            view11.setEnabled(true);
            view12.setEnabled(true);

//


            plateNumber.setEnabled(true);
            plateNumber.setText("");


            userName.setEnabled(true);
            schoolName.setEnabled(true);
            schoolName.setText("");
            Adress.setEnabled(true);
            Adress.setText("");
            FleetNumber.setEnabled(true);
            FleetNumber.setText("");
            MinstyNumber.setEnabled(true);
            MinstyNumber.setText("");
            driverName.setEnabled(true);
            driverName.setText("");
            DriverID.setEnabled(true);
            DriverID.setText("");
            DriverMobile.setEnabled(true);
            DriverMobile.setText("");
            NomOfOrder.setEnabled(true);
            NomOfOrder.setText("");

            searchMinstry.setEnabled(true);
            searchFleetNumber.setEnabled(true);
            searchDriver.setEnabled(true);
            SAVE.setEnabled(true);
            SYNC.setEnabled(true);

        } else if(position == 1) {
            s1.setVisibility(View.VISIBLE);
            s2.setVisibility(View.VISIBLE);
            s1.setEnabled(true);
            s2.setEnabled(true);

            plateNumber.setText("");
            schoolName.setText("");
            Adress.setText("");
            driverName.setText("");
            DriverMobile.setText("");
            NomOfOrder.setText("");
            Note.setText("");
            FleetNumber.setText("");
            DriverID.setText("");
            MinstyNumber.setText("");


            type = 1;
            view3.setEnabled(true);
            driverName.setEnabled(true);
            driverName.setText("");
            view10.setEnabled(true);
            DriverID.setEnabled(true);
            DriverID.setText("");
            searchDriver.setEnabled(true);

// mainstry number false
            view34.setEnabled(false);
            MinstyNumber.setEnabled(false);
            MinstyNumber.setText("");
            searchMinstry.setEnabled(false);



            view7.setEnabled(false);
            schoolName.setEnabled(false);
            schoolName.setText("");

            view8.setEnabled(false);
            Adress.setEnabled(false);
            Adress.setText("");

            view7.setEnabled(false);
            NomOfOrder.setEnabled(false);
            NomOfOrder.setText("");

        } else if(position == 2) {
            s1.setVisibility(View.VISIBLE);
            s2.setVisibility(View.VISIBLE);
            s1.setEnabled(true);
            s2.setEnabled(true);

            plateNumber.setText("");
            schoolName.setText("");
            Adress.setText("");
            driverName.setText("");
            DriverMobile.setText("");
            NomOfOrder.setText("");
            Note.setText("");
            FleetNumber.setText("");
            DriverID.setText("");
            MinstyNumber.setText("");

            type = 2;
// mainstry number false
            view34.setEnabled(false);
            MinstyNumber.setEnabled(false);
            MinstyNumber.setText("");
            searchMinstry.setEnabled(false);


            view3.setEnabled(false);
            searchDriver.setEnabled(false);
            DriverID.setEnabled(false);
            DriverID.setText("");

            view7.setEnabled(false);
            schoolName.setEnabled(false);
            schoolName.setText("");

            view8.setEnabled(false);
            Adress.setEnabled(false);
            Adress.setText("");

            driverName.setEnabled(false);
            driverName.setText("");

            DriverMobile.setEnabled(false);
            DriverMobile.setText("");

            NomOfOrder.setEnabled(false);
            NomOfOrder.setText("");


        } else if(position == 3) {
            s1.setVisibility(View.INVISIBLE);
            s2.setVisibility(View.INVISIBLE);
            s1.setEnabled(false);
            s2.setEnabled(false);

            type = 3;
            plateNumber.setText("");
            schoolName.setText("");
            Adress.setText("");
            driverName.setText("");
            DriverMobile.setText("");
            NomOfOrder.setText("");
            Note.setText("");
            FleetNumber.setText("");
            DriverID.setText("");
            MinstyNumber.setText("");


            view34.setEnabled(false);
            MinstyNumber.setEnabled(false);
            searchMinstry.setEnabled(false);
            MinstyNumber.setText("");

            view3.setEnabled(false);
            searchDriver.setEnabled(false);
            DriverID.setEnabled(false);
            DriverID.setText("");

            view7.setEnabled(false);
            schoolName.setEnabled(false);
            schoolName.setText("");


            view8.setEnabled(false);
            Adress.setEnabled(false);
            Adress.setText("");

            driverName.setEnabled(false);
            driverName.setText("");

            DriverMobile.setEnabled(false);
            DriverMobile.setText("");

            NomOfOrder.setEnabled(false);
            NomOfOrder.setText("");
        }

    }


        if(spinner.getId() == R.id.spinner1) {

           /* s1.setVisibility(View.VISIBLE);
            s2.setVisibility(View.VISIBLE);
            s1.setEnabled(true);
            s2.setEnabled(true);*/



            String sp1 = String.valueOf(s1.getSelectedItem());

            TaskeenArea= sp1;
            if(sp1.contentEquals("المدينة المنورة")) {
                List<String> list = new ArrayList<String>();
                list.add("مهد الذهب");
                list.add("المدينة المنورة");
                list.add("محافظة ينبع");
                list.add("محافظة العلا");


                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                        R.layout.spinner_item, list);


                dataAdapter.notifyDataSetChanged();
                s2.setAdapter(dataAdapter);
            }
            if(sp1.contentEquals("الرياض")) {
                List<String> list2 = new ArrayList<String>();
                list2.add("الخرج");
                list2.add("الحوطة/الحريق");
                list2.add("الافلاج");
                list2.add("وادي الدواسر");
                list2.add("المجمعة");
                list2.add("الغاط");
                list2.add("الزلفي");
                list2.add("شقراء");
                list2.add("الدوادمي");
                list2.add("عفيف");
                list2.add("القويعية");
                list2.add("مدينة الرياض");

                ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
                        R.layout.spinner_item, list2);

                dataAdapter3.notifyDataSetChanged();
                s2.setAdapter(dataAdapter3);
            }


            if(sp1.contentEquals("الشرقية")) {
                List<String> list3 = new ArrayList<String>();
                list3.add("الدمام");
                list3.add("الإحساء");
                list3.add("حفر الباطن");
                ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this,
                        R.layout.spinner_item, list3);

                dataAdapter4.notifyDataSetChanged();
                s2.setAdapter(dataAdapter4);
            }

            if(sp1.contentEquals("مكة المكرمة")) {
                List<String> list4 = new ArrayList<String>();
                list4.add("مكة المكرمة");
                list4.add("جدة");
                list4.add("الطائف");
                list4.add("القنفذه");
                list4.add("الليث");


                ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(this,
                        R.layout.spinner_item, list4);

                dataAdapter5.notifyDataSetChanged();
                s2.setAdapter(dataAdapter5);
            }

            if(sp1.contentEquals("القصيم")) {
                List<String> list5 = new ArrayList<String>();
                list5.add("بريدة");
                list5.add("عنيزة");
                list5.add("المذنب");
                list5.add("البكيرية");
                list5.add("الراس");

                ArrayAdapter<String> dataAdapter6 = new ArrayAdapter<String>(this,
                        R.layout.spinner_item, list5);

                dataAdapter6.notifyDataSetChanged();
                s2.setAdapter(dataAdapter6);
            }

        }

    if(spinner.getId() == R.id.spinner2) {
        String sp2 = String.valueOf(s2.getSelectedItem());

        TaskeenCity= sp2;
    }





}
@Override
public void onNothingSelected(AdapterView<?> arg0) {

}

@Override
public void onClick(View v) {

}
}