package com.ictfox.hafil_tc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.widget.EditText;

public class DriverTaskeenDataBase extends AsyncTask<Void, Void, String> {


Activity mActivity;
Context context;
ProgressDialog progressDialog;
String drivrsNid = " ";
String name = " ";
String mobile = "";
MySQLiteHelper dbHandler;

Cursor test;

public DriverTaskeenDataBase(Activity activity, ProgressDialog progressDialog,
                             String NAT, Context context) {
    super();
    this.progressDialog = progressDialog;
    this.mActivity = activity;
    this.context = context;
    this.drivrsNid = NAT;
}

@Override
protected String doInBackground(Void... voids) {

    MySQLiteHelper dbHandler = new MySQLiteHelper(this.context);

    test = dbHandler.getDriverInfo(this.drivrsNid);

    if(test.getCount() >= 1) {
        do {

            name = test.getString(0);
            mobile = test.getString(2);

        } while(test.moveToNext());

    } else if(test.getCount() == 0) {


        return "error";

    }

    return "ok";

}

@Override
protected void onPostExecute(String result) {
    if(result.equals("error")) {
        progressDialog.dismiss();


        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.mActivity);

        // Setting Dialog Title
        alertDialog.setTitle("خطأ");

        // Setting Dialog Message
        alertDialog.setMessage("لا يوجد بيانات .. برجاء التأكد من رقم الهوية او قم بتعديل البيانات يدويا");

        // On pressing Settings button
        alertDialog.setPositiveButton("المحاوله مجددا", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });


        // Showing Alert Message
        alertDialog.show();
    } else {
/*
         else if (mobile.length()<10){
             progressDialog.dismiss();
             AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.mActivity);

             // Setting Dialog Title
             alertDialog.setTitle("خطأ");

             // Setting Dialog Message
             alertDialog.setMessage("برجاء إدخال رقم الجوال كامل");

             // On pressing Settings button
             alertDialog.setPositiveButton("المحاوله مجددا", new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog,int which) {
                 }
             });
             alertDialog.show();

         }

         else if (mobile.isEmpty()||mobile.equalsIgnoreCase("0")||mobile.equalsIgnoreCase("null")){

             progressDialog.dismiss();
             AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.mActivity);

             // Setting Dialog Title
             alertDialog.setTitle("خطأ");

             // Setting Dialog Message
             alertDialog.setMessage("برجاء ادخال رقم الجوال");

             // On pressing Settings button
             alertDialog.setPositiveButton("حسنا", new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog,int which) {
                 }
             });
             alertDialog.show();

         }



         else if (name.isEmpty()||name.equalsIgnoreCase("0")||name.equalsIgnoreCase("null")){

             progressDialog.dismiss();
             AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.mActivity);

             // Setting Dialog Title
             alertDialog.setTitle("خطأ");

             // Setting Dialog Message
             alertDialog.setMessage("برجاء ادخال اسم السائق");

             // On pressing Settings button
             alertDialog.setPositiveButton("حسنا", new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog,int which) {
                 }
             });
             alertDialog.show();

         }

		 else{*/
        // using coustom font
        Typeface font = Typeface.createFromAsset(mActivity.getAssets(), "HelveticaNeueW23-Reg.ttf");

        EditText DriverName = (EditText) mActivity.findViewById(R.id.editText3);
        DriverName.setText(name);
        DriverName.setTypeface(font);


        EditText Mobile = (EditText) mActivity.findViewById(R.id.editText4);
        Mobile.setText(mobile);
        Mobile.setTypeface(font);

        progressDialog.dismiss();
        // ((MyApplication) mActivity.getApplication()).setall(fleetnumber, platenumber, model, seat1, drivrsNid, name,busType,busID );
    }
}


}

