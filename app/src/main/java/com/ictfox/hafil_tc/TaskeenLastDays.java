package com.ictfox.hafil_tc;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by heshe_000 on 7/5/2014.
 */
public class TaskeenLastDays extends Activity {


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
TextView view600;
TextView view700;


TextView FleetNumber;
TextView MinstyNumber;
TextView driverName;
TextView DriverID;
TextView DriverMobile;
TextView NomOfOrder;
TextView Note;
TextView TaskeenArea;
TextView TaskeenCity;

TextView BusType;

String theNUM="0";
String Mistrynum="0";
String DriverIDString="0";
String TaskeenType="";

int Answer=0;
protected LocationManager locationManager;
protected LocationListener locationListener;
Cursor cursor;
MySQLiteHelper dbHandler;
SharedPreferences mPrefs;
int type=0;
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_taskeen_lastdays);

    FleetNumber = (TextView) findViewById(R.id.editText1);
    MinstyNumber = (TextView) findViewById(R.id.editText2);
    DriverID   = (TextView) findViewById(R.id.editText3);
    Note = (TextView) findViewById(R.id.editText34);


    final Button searchMinstry = (Button) findViewById(R.id.button01);
    final Button searchFleetNumber = (Button) findViewById(R.id.button1);
    final Button searchDriver = (Button) findViewById(R.id.button02);
    final Button SAVE = (Button) findViewById(R.id.button2);
    final Button SYNC = (Button) findViewById(R.id.button3);

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


    FleetNumber = (TextView) findViewById(R.id.editText1);
    DriverID   = (TextView) findViewById(R.id.editText2);
    MinstyNumber = (TextView) findViewById(R.id.editText34);

    plateNumber = (TextView) findViewById(R.id.textView13);
    userName = (TextView) findViewById(R.id.textView14);
    schoolName = (TextView) findViewById(R.id.textView15);
    Adress = (TextView) findViewById(R.id.textView16);



    driverName = (TextView) findViewById(R.id.editText3);
    DriverMobile=(TextView) findViewById(R.id.editText4);
    NomOfOrder=(TextView) findViewById(R.id.editText5);
    Note = (TextView) findViewById(R.id.editText6);

    BusType=(TextView) findViewById(R.id.spinner0);
    TaskeenArea=(TextView) findViewById(R.id.spinner1);
    TaskeenCity=(TextView) findViewById(R.id.spinner2);

    SharedPreferences prefs;

    prefs = PreferenceManager
            .getDefaultSharedPreferences(TaskeenLastDays.this);


    view1.setTypeface(font);
    view2.setTypeface(font);
    view3.setTypeface(font);
    view4.setTypeface(font);
    view5.setTypeface(font);
    view6.setTypeface(font);
    view7.setTypeface(font);
    view8.setTypeface(font);
    view9.setTypeface(font);
    view10.setTypeface(font);
    view11.setTypeface(font);
    view12.setTypeface(font);
    view34.setTypeface(font);

    plateNumber.setTypeface(font);
    userName.setTypeface(font);
    driverName.setTypeface(font);
    schoolName.setTypeface(font);
    DriverMobile.setTypeface(font);
    Adress.setTypeface(font);
    TaskeenArea.setTypeface(font);
    TaskeenCity.setTypeface(font);


    plateNumber.setText(prefs.getString("plateNumber", "null"));
    userName.setText(prefs.getString("userName", "null"));
    driverName.setText(prefs.getString("DriverName", "null"));
    schoolName.setText(prefs.getString("schoolName", "null"));
    DriverMobile.setText(prefs.getString("DriverMobile", "null"));
    Adress.setText(prefs.getString("SchoolAdress", "null"));
    MinstyNumber.setText(prefs.getString("MinstaryNumber", "null"));
    FleetNumber.setText(prefs.getString("fleetNumber", "null"));
    DriverID.setText(prefs.getString("NATID", "null"));
    NomOfOrder.setText(prefs.getString("numOfOrders", "null"));
    Note.setText(prefs.getString("note", "null"));

    TaskeenArea.setText(prefs.getString("TaskeenArea", "null"));
    TaskeenCity.setText(prefs.getString("TaskeenCity", "null"));
    type=prefs.getInt("TaskeenType", 0);




    FleetNumber.setTypeface(font);
    MinstyNumber.setTypeface(font);
    DriverID.setTypeface(font);
    Note.setTypeface(font);








     mPrefs= PreferenceManager
            .getDefaultSharedPreferences(TaskeenLastDays.this);
    userName.setText(mPrefs.getString("UserID", "0"));



    if(prefs.getInt("TaskeenType",0)==0){


                TaskeenType="حافلة عاملة";

    }
    else if (prefs.getInt("TaskeenType",0)==1){

        TaskeenType="احتياطي بالسائق";
    }

    else if (prefs.getInt("TaskeenType",0)==2){
        TaskeenType="احتياطي بدون سائق";

    }
    else if (prefs.getInt("TaskeenType",0)==3){
        TaskeenType="تنزيل";

    }


    BusType.setText(TaskeenType);

    SYNC.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView DriverID = (TextView) findViewById(R.id.editText3);
           /* if(driverName.getText().toString().isEmpty()|| driverName.getText().toString().equals("null")){

                Toast.makeText(TaskeenLastDays.this.getApplicationContext(), "فضلا ادخل اسم السائق", Toast.LENGTH_SHORT).show();


            }




            else  if( DriverMobile.getText().toString().isEmpty()|| DriverMobile.getText().toString().equals("null")){


                Toast.makeText(TaskeenLastDays.this.getApplicationContext(), "فضلا ادخل رقم الجوال", Toast.LENGTH_SHORT).show();



            }


            else  if(DriverMobile.getText().toString().length()<10)  {
                Toast.makeText(TaskeenLastDays.this.getApplicationContext(), "فضلا ادخل رقم الجوال كاملا", Toast.LENGTH_SHORT).show();


            }

            else  if(Integer.parseInt(NomOfOrder.getText().toString())<0||Integer.parseInt(NomOfOrder.getText().toString())>99||NomOfOrder.getText().toString().isEmpty()||NomOfOrder.getText().toString()==null){

                Toast.makeText(TaskeenLastDays.this.getApplicationContext(), "برجاء ادخال عدد الطالبات بين 1 و99 فقط", Toast.LENGTH_SHORT).show();

            }

            else if(plateNumber.getText().toString().isEmpty()|| plateNumber.getText().toString().equals("null") ||
                    schoolName.getText().toString().isEmpty()|| schoolName.getText().toString().equals("null")||
                    Adress.getText().toString().isEmpty()|| Adress.getText().toString().equals("null")||
                    driverName.getText().toString().isEmpty()|| driverName.getText().toString().equals("null")||
                    DriverMobile.getText().toString().isEmpty()|| DriverMobile.getText().toString().equals("null")||
                    NomOfOrder.getText().toString().isEmpty()||DriverID.getText().toString().isEmpty()
                    ){


                Toast.makeText(TaskeenLastDays.this.getApplicationContext(), "البيانات ناقصة , تأكد من استكمال البيانات", Toast.LENGTH_SHORT).show();

            }
            else {*/
            //  String  ActionDate =  new SimpleDateFormat("yyyy-MM-ddHH:mm:ss", Locale.getDefault()).format(new Date());

            SharedPreferences Prefs;
            Prefs = PreferenceManager
                    .getDefaultSharedPreferences(TaskeenLastDays.this);
            FleetNumber = (TextView) findViewById(R.id.editText1);
            DriverID   = (TextView) findViewById(R.id.editText2);
            MinstyNumber = (TextView) findViewById(R.id.editText34);

            plateNumber = (TextView) findViewById(R.id.textView13);
            userName = (TextView) findViewById(R.id.textView14);
            schoolName = (TextView) findViewById(R.id.textView15);
            Adress = (TextView) findViewById(R.id.textView16);



            driverName = (TextView) findViewById(R.id.editText3);
            DriverMobile=(TextView) findViewById(R.id.editText4);
            NomOfOrder=(TextView) findViewById(R.id.editText5);
            Note = (TextView) findViewById(R.id.editText6);

            BusType=(TextView) findViewById(R.id.spinner0);
            TaskeenArea=(TextView) findViewById(R.id.spinner1);
            TaskeenCity=(TextView) findViewById(R.id.spinner2);
            ProgressDialog progressDialog;
            progressDialog = new ProgressDialog(
                    TaskeenLastDays.this);
            progressDialog.setMessage("جاري مزامنة البيانات");
            progressDialog.show();
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);


            if(MinstyNumber.getText().toString() == null || MinstyNumber.getText().toString().equals("null")||MinstyNumber.getText().toString().equals("0")) {
                TaskeenSyncTaskLastDays MyTask = new TaskeenSyncTaskLastDays(
                        TaskeenLastDays.this, progressDialog, getApplicationContext(), userName.getText().toString(), plateNumber.getText().toString(), schoolName.getText().toString(), Adress.getText().toString(), driverName.getText().toString(), DriverMobile.getText().toString(), "0", FleetNumber.getText().toString(), DriverID.getText().toString(), "0", Prefs.getString("Date", "null"), TaskeenType ,Note.getText().toString(),Prefs.getString("TaskeenArea", "null"),Prefs.getString("TaskeenCity", "null"));

                MyTask.execute();

            } else {
                TaskeenSyncTaskLastDays MyTask = new TaskeenSyncTaskLastDays(
                        TaskeenLastDays.this, progressDialog, getApplicationContext(), Prefs.getString("userName", "null"), plateNumber.getText().toString(), schoolName.getText().toString(), Adress.getText().toString(), driverName.getText().toString(), DriverMobile.getText().toString(), MinstyNumber.getText().toString(), FleetNumber.getText().toString(), DriverID.getText().toString(), NomOfOrder.getText().toString(), Prefs.getString("Date", "null"), TaskeenType , Note.getText().toString(),Prefs.getString("TaskeenArea", "null"),Prefs.getString("TaskeenCity", "null"));

                MyTask.execute();

            }

        }
       // }
    });



/*

    SAVE.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          /*  if(driverName.getText().toString().isEmpty()|| driverName.getText().toString().equals("null")){

                Toast.makeText(TaskeenLastDays.this.getApplicationContext(), "فضلا ادخل اسم السائق", Toast.LENGTH_SHORT).show();


            }




            else  if( DriverMobile.getText().toString().isEmpty()|| DriverMobile.getText().toString().equals("null")){


                Toast.makeText(TaskeenLastDays.this.getApplicationContext(), "فضلا ادخل رقم الجوال", Toast.LENGTH_SHORT).show();



            }


            else  if(DriverMobile.getText().toString().length()<10)  {
                Toast.makeText(TaskeenLastDays.this.getApplicationContext(), "فضلا ادخل رقم الجوال كاملا", Toast.LENGTH_SHORT).show();


            }

            else  if(Integer.parseInt(NomOfOrder.getText().toString())<0||Integer.parseInt(NomOfOrder.getText().toString())>99||NomOfOrder.getText().toString().isEmpty()||NomOfOrder.getText().toString()==null){

                Toast.makeText(TaskeenLastDays.this.getApplicationContext(), "برجاء ادخال عدد الطالبات بين 1 و99 فقط", Toast.LENGTH_SHORT).show();

            }

            else if(plateNumber.getText().toString().isEmpty()|| plateNumber.getText().toString().equals("null") ||
                    schoolName.getText().toString().isEmpty()|| schoolName.getText().toString().equals("null")||
                    Adress.getText().toString().isEmpty()|| Adress.getText().toString().equals("null")||
                    driverName.getText().toString().isEmpty()|| driverName.getText().toString().equals("null")||
                    DriverMobile.getText().toString().isEmpty()|| DriverMobile.getText().toString().equals("null")||
                    NomOfOrder.getText().toString().isEmpty()||DriverID.getText().toString().isEmpty()
                    ){


                Toast.makeText(TaskeenLastDays.this.getApplicationContext(), "البيانات ناقصة , تأكد من استكمال البيانات", Toast.LENGTH_SHORT).show();

            }

            else {
                SharedPreferences mPrefs= PreferenceManager
                        .getDefaultSharedPreferences(TaskeenLastDays.this);
                MySQLiteHelper dbHandler = new MySQLiteHelper(TaskeenLastDays.this);
                //String  ActionDate =  new SimpleDateFormat("yyyy-MM-ddHH:mm:ss", Locale.getDefault()).format(new Date());
                dbHandler.UpdateTaskeen(userName.getText().toString(), plateNumber.getText().toString(), schoolName.getText().toString(), Adress.getText().toString(), driverName.getText().toString(), DriverMobile.getText().toString(), MinstyNumber.getText().toString(), FleetNumber.getText().toString(), DriverID.getText().toString(), NomOfOrder.getText().toString(), mPrefs.getString("Date", "null"),0);
                Toast.makeText(TaskeenLastDays.this.getApplicationContext(), "تم حفظ البيانات بنجاح", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(TaskeenLastDays.this)
                        .setTitle("تم حفظ البيانات بنجاح ")
                        .setMessage("هل تود الذهاب الى صفحة الرئيسية")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent1 = new Intent(TaskeenLastDays.this, MainBoardActivity.class);
                                startActivity(intent1);
                            }
                        }).setIcon(R.drawable.checked)
                        .show();


            }

       // }
    });*/

/*
    searchMinstry.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {



            if(MinstyNumber.getText().toString()==null||MinstyNumber.getText().toString().isEmpty()){

                Toast.makeText(getApplicationContext(), "يجب ادخال رقم الوزاره اولا ", Toast.LENGTH_SHORT).show();

            }

            else{
                TextView MinstyNumber = (TextView) findViewById(R.id.editText2);
                TaskeenLastDays.this.Mistrynum=String.valueOf(MinstyNumber.getText()) ;
                ProgressDialog progressDialog = new ProgressDialog(
                        TaskeenLastDays.this);
                progressDialog.setMessage("جاري جلب لبيانات برجاء الانتظار");
                progressDialog.show();
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(false);


                MinstryTaskeenDataBase MyTask = new MinstryTaskeenDataBase(
                        TaskeenLastDays.this, progressDialog,
                        getApplicationContext(),  String.valueOf(MinstyNumber.getText()));
                MyTask.execute();
            }
        }
    });









    searchFleetNumber.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {


            if(FleetNumber==null || String.valueOf(FleetNumber.getText()).isEmpty() ){

                Toast.makeText(TaskeenLastDays.this, "يجب أدخال رقم الشركة أولا", Toast.LENGTH_SHORT).show();

            }


            else{
                TextView FleetNumber = (TextView) findViewById(R.id.editText1);
                TaskeenLastDays.this.theNUM= String.valueOf(FleetNumber.getText()) ;

                ProgressDialog progressDialog = new ProgressDialog(
                        TaskeenLastDays.this);
                progressDialog
                        .setMessage("جاري البحث عن البيانات برجاء الانتظار");
                progressDialog.show();
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(false);
                FleetNumberTaskeenDataBase MyTask = new FleetNumberTaskeenDataBase(
                        TaskeenLastDays.this, progressDialog, TaskeenLastDays.this.theNUM,
                        getApplicationContext());
                MyTask.execute();

            }
        }
    });






    searchDriver.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {


            if(DriverID==null || String.valueOf(DriverID.getText()).isEmpty() ){

                Toast.makeText(TaskeenLastDays.this, "يجب ادخال رقم الشركة اولا", Toast.LENGTH_SHORT).show();

            }


            else{
                TextView DriverID = (TextView) findViewById(R.id.editText3);
                TaskeenLastDays.this.DriverIDString= String.valueOf(DriverID.getText()) ;

                ProgressDialog progressDialog = new ProgressDialog(
                        TaskeenLastDays.this);
                progressDialog
                        .setMessage("جاري البحث عن البيانات برجاء الانتظار");
                progressDialog.show();
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(false);
                DriverTaskeenDataBase MyTask = new DriverTaskeenDataBase(
                        TaskeenLastDays.this, progressDialog, TaskeenLastDays.this.DriverIDString,
                        getApplicationContext());
                MyTask.execute();

            }
        }
    });*/






}








}
