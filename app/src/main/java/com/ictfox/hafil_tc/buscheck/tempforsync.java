package com.ictfox.hafil_tc.buscheck;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by heshe_000 on 8/10/2014.
 */
public class tempforsync  extends AsyncTask<Void, Void, String> {


Activity mActivity;
Context context;

int fleetNumber;
int UserID;
String ActionDate;
String androiid;
String sectiontotal;
String AnswerTotal;
String NoteTotal;
String lat;
String lag;
int busId=0;
private final String NAMESPACE = "http://tempuri.org/";
private final String URL = "http://hsts.hafilstc.com/HSTCWebServices/WS_Update_BusCheck.asmx";
private final String SOAP_ACTION = "http://tempuri.org/WS_Update_BusCheck";
private final String METHOD_NAME = "WS_Update_BusCheck";

public tempforsync(Activity mActivity ,Context context ,String ActionDate , String androiid, String sectiontotal, String AnswerTotal, String NoteTotal , String lat ,String lag , int busId ){
    this.mActivity=mActivity;
    this.context=context;
    this.ActionDate=ActionDate;
    this.androiid=androiid;
    this.sectiontotal=sectiontotal;
    this.AnswerTotal=AnswerTotal;
    this.NoteTotal=NoteTotal;
    this.lat=lat;
    this.lag=lag;
    this.busId=busId;
}


@Override
protected String doInBackground(Void... voids) {


    try {
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this.mActivity);

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);


        PropertyInfo pro =new PropertyInfo();
        pro.setName("fleetNumber");
        pro.setValue(this.busId);
        pro.setType(Integer.class);

        PropertyInfo pro2 =new PropertyInfo();
        pro2.setName("Address");
        pro2.setValue("Jed");
        pro2.setType(String.class);

        PropertyInfo pro3 =new PropertyInfo();
        pro3.setName("UserId");
        pro3.setValue(Integer.parseInt(prefs.getString("UserID", "0")));
        pro3.setType(Integer.class);

        PropertyInfo pro4 =new PropertyInfo();
        pro4.setName("ActionDate");
        pro4.setValue(ActionDate);
        pro4.setType(String.class);

        PropertyInfo pro5 =new PropertyInfo();
        pro5.setName("AndroidID");
        pro5.setValue("Old data");
        pro5.setType(String.class);

        PropertyInfo pro6 =new PropertyInfo();
        pro6.setName("TotalFleetPartsID");
        pro6.setValue(sectiontotal);
        pro6.setType(String.class);

        PropertyInfo pro7 =new PropertyInfo();
        pro7.setName("TotalFleetPartsStatusID");
        pro7.setValue(AnswerTotal);
        pro7.setType(String.class);

        PropertyInfo pro8 =new PropertyInfo();
        pro8.setName("TotalNotes");
        pro8.setValue(NoteTotal);
        pro8.setType(String.class);


        PropertyInfo pro9 =new PropertyInfo();
        pro9.setName("TotalImgs");
        pro9.setValue("null");
        pro9.setType(String.class);


        PropertyInfo pro10 =new PropertyInfo();
        pro10.setName("TotalImgsPartID");
        pro10.setValue("null");
        pro10.setType(String.class);


        PropertyInfo pro11 =new PropertyInfo();
        pro11.setName("Latitude");
        pro11.setValue(this.lat);
        pro11.setType(String.class);


        PropertyInfo pro12 =new PropertyInfo();
        pro12.setName("longitude");
        pro12.setValue(this.lag);
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
        SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
       // responseStr = response.toString();
        Log.i("myApp", response.toString());

    } catch (Exception e) {
        e.printStackTrace();
        return e.toString();
    }



    return "" ;


}



@Override
protected void onPostExecute(String result) {

    Toast.makeText(context.getApplicationContext(), "تم المزامنة بنجاح", Toast.LENGTH_SHORT).show();
/*
 Intent ii=new Intent(this.mActivity, MainBoardActivity.class);
    ii.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(ii);*/
    this.mActivity.finish();

}
}
