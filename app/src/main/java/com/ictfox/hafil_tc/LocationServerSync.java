	package com.ictfox.hafil_tc;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.provider.Settings.Secure;
import android.util.Log;
import android.widget.Toast;
import org.apache.http.client.ClientProtocolException;
import org.jibble.simpleftp.*;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LocationServerSync extends AsyncTask<Void, Void, String> {
Activity mActivity;
Context context;
ProgressDialog progressDialog;
String responseStr;
String txtLat;
String txtLag;
String picturePath = "NA";
String WebServicePath = "NA";
String Note = "لايوجد";
private final String NAMESPACE = "http://tempuri.org/";
private final String URL = "http://hsts.hafilstc.com/HSTCWebServices/WS_Update_SchoolLocation.asmx";
private final String SOAP_ACTION = "http://tempuri.org/WS_Update_SchoolLocation";
private final String METHOD_NAME = "WS_Update_SchoolLocation";


public LocationServerSync(Activity activity, ProgressDialog progressDialog,
                          Context context, String txtLat, String txtLag, String picturePath, String WebServicePath, String Note) {
    super();
    this.progressDialog = progressDialog;
    this.mActivity = activity;
    this.context = context;
    this.txtLat = txtLat;
    this.txtLag = txtLag;
    this.picturePath = picturePath;
    this.WebServicePath = WebServicePath;
    this.Note = Note;
}


@Override
protected String doInBackground(Void... voids) {

    if(this.WebServicePath.equals("null")) {

        this.WebServicePath = "Na";

    }
    SimpleFTP ftp = new SimpleFTP();


    // Connect to an FTP server on port 21.
    try {
        ftp.connect("hsts.hafilstc.com", 21, "hstcftp", "P@ssw0rd");


        // Set binary mode.
        ftp.bin();

        // Change to a new working directory on the FTP server.
        File file = new File(picturePath);
        FileInputStream fileInputStream = new FileInputStream(file);

        // ftp.cwd("4_0_30319");
        ftp.stor(fileInputStream, WebServicePath);
        // Upload some files.

        // Quit from the FTP server.
        ftp.disconnect();
    } catch(IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    try {
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this.mActivity);

        String ActionDate = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss", Locale.getDefault()).format(new Date());

        String android_id = Secure.getString(context.getContentResolver(),
                Secure.ANDROID_ID);

        PropertyInfo pro = new PropertyInfo();
        pro.setName("schoolId");
        pro.setValue(Integer.parseInt(((MyApplication) mActivity.getApplication()).schoolNum));
        pro.setType(Integer.class);

        PropertyInfo pro2 = new PropertyInfo();
        pro2.setName("Location_Longitude");
        pro2.setValue(this.txtLag);
        pro2.setType(String.class);

        PropertyInfo pro3 = new PropertyInfo();
        pro3.setName("Location_Latitude");
        pro3.setValue(this.txtLat);
        pro3.setType(String.class);

        PropertyInfo pro4 = new PropertyInfo();
        pro4.setName("Location_Image");
        pro4.setValue(WebServicePath);
        pro4.setType(String.class);

        PropertyInfo pro5 = new PropertyInfo();
        pro5.setName("Action_Date");
        pro5.setValue(ActionDate);
        pro5.setType(String.class);

        PropertyInfo pro6 = new PropertyInfo();
        pro6.setName("UserID");
        pro6.setValue(Integer.parseInt(prefs.getString("UserID", "0")));
        pro6.setType(Integer.class);


        PropertyInfo pro7 = new PropertyInfo();
        pro7.setName("Notes");
        pro7.setValue(Note);
        pro7.setType(String.class);

        PropertyInfo pro8 = new PropertyInfo();
        pro8.setName("AndroidID");
        pro8.setValue(android_id);
        pro8.setType(String.class);

        request.addProperty(pro);
        request.addProperty(pro2);
        request.addProperty(pro3);
        request.addProperty(pro4);
        request.addProperty(pro5);
        request.addProperty(pro6);
        request.addProperty(pro7);
        request.addProperty(pro8);
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
                this.progressDialog = null;
                Intent ii = new Intent(this.mActivity, MainBoardActivity.class);
                Toast.makeText(context.getApplicationContext(), "تم مزامنة البيانات ", Toast.LENGTH_SHORT).show();
                ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(ii);

            }
            this.mActivity.finish();
        }
    }
}
}


