package com.ictfox.hafil_tc;

import org.apache.http.client.ClientProtocolException;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

public class PathLastDaysSync extends AsyncTask<Void, Void, String> {
Activity mActivity;
Context context;
ProgressDialog progressDialog;
String responseStr = "";
String fleetNumber = "";
String CheckPointID = "";
String numOfStudent = "";
String longitudae = "";
String laituade = "";
String Date = "";
String Action_date = "";
Cursor cursor;
String Status = "";
String Notes = "لايوجد";
int MinstryNumber = 0;
String FleetNumber = "";
String Answer = "";
private final String NAMESPACE = "http://tempuri.org/";
private final String URL = "http://hsts.hafilstc.com/HSTCWebServices/WS_Update_CheckPoints.asmx";
private final String SOAP_ACTION = "http://tempuri.org/Update_CheckPoints";
private final String METHOD_NAME = "Update_CheckPoints";


public PathLastDaysSync(Activity activity, ProgressDialog progressDialog,
                        String fleetNumber, Context context, String Status, String Notes) {
    super();
    this.progressDialog = progressDialog;
    this.mActivity = activity;
    this.context = context;
    this.FleetNumber = fleetNumber;
    this.Status = Status;
    this.Notes = Notes;
}


@Override
protected String doInBackground(Void... voids) {
    try {
        MySQLiteHelper dbHandler = new MySQLiteHelper(context);
        cursor = dbHandler.getAllClosedPaths(this.FleetNumber);
        if(cursor.getCount() >= 1) {
            if(cursor.moveToFirst()) {
                do {
                    CheckPointID = CheckPointID + String.valueOf(cursor.getInt(0)) + ",";
                    numOfStudent = numOfStudent + String.valueOf(cursor.getInt(1)) + ",";
                    longitudae = longitudae + cursor.getString(2) + ",";
                    laituade = laituade + cursor.getString(3) + ",";
                    Action_date = Action_date + cursor.getString(4) + ",";//���
                    Date = dbHandler.getPathDate(this.FleetNumber);//���
                    MinstryNumber = cursor.getInt(5);
                    Answer = Answer + String.valueOf(cursor.getInt(6)) + ",";
                } while(cursor.moveToNext());
            }
            cursor.close();
        }


        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this.mActivity);


        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);


        PropertyInfo pro = new PropertyInfo();
        pro.setName("FleetNumber");
        pro.setValue(this.FleetNumber);
        pro.setType(Integer.class);

        PropertyInfo pro2 = new PropertyInfo();
        pro2.setName("CheckPointID");
        pro2.setValue(CheckPointID);
        pro2.setType(String.class);

        PropertyInfo pro3 = new PropertyInfo();
        pro3.setName("NoOfStudents");
        pro3.setValue(numOfStudent);
        pro3.setType(String.class);

        PropertyInfo pro4 = new PropertyInfo();
        pro4.setName("Location_Longitude");
        pro4.setValue(longitudae);
        pro4.setType(String.class);

        PropertyInfo pro5 = new PropertyInfo();
        pro5.setName("Location_Latitude");
        pro5.setValue(laituade);
        pro5.setType(String.class);

        PropertyInfo pro6 = new PropertyInfo();
        pro6.setName("Action_Date");
        pro6.setValue(Action_date);
        pro6.setType(String.class);

        PropertyInfo pro7 = new PropertyInfo();
        pro7.setName("PathStatus");
        pro7.setValue(Status);
        pro7.setType(String.class);


        PropertyInfo pro8 = new PropertyInfo();
        pro8.setName("SchoolMinistryNo");
        pro8.setValue(String.valueOf(this.MinstryNumber));
        pro8.setType(String.class);

        PropertyInfo pro9 = new PropertyInfo();
        pro9.setName("Notes");
        pro9.setValue(Notes);
        pro9.setType(String.class);

        PropertyInfo pro10 = new PropertyInfo();
        pro10.setName("Insert_Date");
        pro10.setValue(Date);
        pro10.setType(String.class);

        PropertyInfo pro11 = new PropertyInfo();
        pro11.setName("UserID");
        pro11.setValue(Integer.parseInt(prefs.getString("UserID", "0")));
        pro11.setType(Integer.class);

        PropertyInfo pro12 = new PropertyInfo();
        pro12.setName("Rad");
        pro12.setValue(Answer);
        pro12.setType(String.class);

        request.addProperty(pro);
        request.addProperty(pro2);
        request.addProperty(pro3);
        request.addProperty(pro4);
        request.addProperty(pro5);
        request.addProperty(pro6);
        request.addProperty(pro7);
        request.addProperty(pro8);
        request.addProperty(pro9);
        request.addProperty(pro10);
        request.addProperty(pro11);
        request.addProperty(pro12);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);


        androidHttpTransport.call(SOAP_ACTION, envelope);
        SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
        Log.i("myApp", response.toString());


    } catch(UnknownHostException e) {//POST & GET section
        e.printStackTrace();
        return "0";
    } catch(ConnectException e) {//POST & GET section
        e.printStackTrace();
        return "0";
    } catch(NullPointerException e) {//POST & GET section
        e.printStackTrace();
        return "0";
    } catch(ClientProtocolException e) {//POST section
        e.printStackTrace();
        return "0";
    } catch(IOException e) { // POST & GET section
        e.printStackTrace();
        return "0";
    } catch(Exception e) {
        e.printStackTrace();
        return "0";
    }

    return responseStr;
}


@Override
protected void onPostExecute(String result) {


    if(result.equals("0")) {

        Toast.makeText(context.getApplicationContext(), "خطأ لم تتم مزامنة البيانات", Toast.LENGTH_SHORT).show();
        if((this.progressDialog != null) && this.progressDialog.isShowing()) {
            this.progressDialog.dismiss();


        }
    } else {


        try {
            if((this.progressDialog != null) && this.progressDialog.isShowing()) {
                this.progressDialog.dismiss();
            }
        } catch(final IllegalArgumentException e) {
            // Handle or log or ignore
        } catch(final Exception e) {
            // Handle or log or ignore
        } finally {

            if(this.Status.equals("Closed")){

                MySQLiteHelper dbHandler = new MySQLiteHelper(this.mActivity);
                dbHandler.endPath(String.valueOf(this.FleetNumber));
            }

            else {
                MySQLiteHelper dbHandler = new MySQLiteHelper(this.mActivity);
                dbHandler.updateNotesIntoCheckPoint(Notes, this.FleetNumber);
                this.progressDialog = null;
                Intent ii = new Intent(this.mActivity, Tjamo3Points.class);
                Toast.makeText(context.getApplicationContext(), "تم مزامنة البيانات ", Toast.LENGTH_SHORT).show();
                ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(ii);
            }
        }
        this.mActivity.finish();
    }

}
}
