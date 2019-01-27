package com.ictfox.hafil_tc.buscheck;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;
import com.ictfox.hafil_tc.MainBoardActivity;
import com.ictfox.hafil_tc.MyApplication;
import com.ictfox.hafil_tc.MySQLiteHelper;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class BusCheckServerSync extends AsyncTask<Void, Void, String>{
	Activity mActivity;
	Context context;
	ProgressDialog progressDialog;
	String responseStr;
	int fleetNumber;
	String android_id;
	String Date;
	HashMap<Integer, Integer> answerAndQuestion;
	String AnswerToTal="";
	String SectionToTal="";
	String TestDrive="";
String GeneralNotes="";

String lat="";
String lag="";
private final String NAMESPACE = "http://tempuri.org/";
private final String URL = "http://hsts.hafilstc.com/HSTCWebServices/WS_Update_BusCheck_New.asmx";
private final String SOAP_ACTION = "http://tempuri.org/WS_Update_BusCheck_New";
private final String METHOD_NAME = "WS_Update_BusCheck_New";
	
	public BusCheckServerSync(Activity otherActivity, ProgressDialog progressDialog2,
                              Context applicationContext, int fleetNumber,
                              HashMap<Integer, Integer> answerAndQuestion,
                              String Date, String android_id, String lat, String lag ,String TestDrive,String GeneralNotes) {
		
		this.mActivity=otherActivity;
		this.progressDialog=progressDialog2;
		this.context=applicationContext;
		this.fleetNumber=fleetNumber;
		this.answerAndQuestion=answerAndQuestion;
		this.Date=Date;
		this.android_id=android_id;
        this.lat=lat;
        this.lag=lag;
        this.TestDrive=TestDrive;
        this.GeneralNotes=GeneralNotes;

	}


	@Override
	protected String doInBackground(Void... voids) {

		for ( Map.Entry<Integer, Integer> myMap1 :  answerAndQuestion.entrySet()) {
			Integer  section = myMap1.getKey();
			Integer   answer = myMap1.getValue();
			
			AnswerToTal=AnswerToTal+answer+",";
			SectionToTal=SectionToTal+section+",";
		}

    int i=  answerAndQuestion.size();


        try {
		    SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(this.mActivity);

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);


            PropertyInfo pro =new PropertyInfo();
            pro.setName("fleetNumber");
            pro.setValue(this.fleetNumber);
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
            pro4.setValue(Date);
            pro4.setType(String.class);

            PropertyInfo pro5 =new PropertyInfo();
            pro5.setName("AndroidID");
            pro5.setValue(android_id);
            pro5.setType(String.class);

            PropertyInfo pro6 =new PropertyInfo();
            pro6.setName("TotalFleetPartsID");
            pro6.setValue(SectionToTal);
            pro6.setType(String.class);

            PropertyInfo pro7 =new PropertyInfo();
            pro7.setName("TotalFleetPartsStatusID");
            pro7.setValue(AnswerToTal);
            pro7.setType(String.class);


            PropertyInfo pro8 =new PropertyInfo();
            pro8.setName("Latitude");
            pro8.setValue(this.lat);
            pro8.setType(String.class);


            PropertyInfo pro9 =new PropertyInfo();
            pro9.setName("longitude");
            pro9.setValue(this.lag);
            pro9.setType(String.class);


            PropertyInfo pro10 =new PropertyInfo();
            pro10.setName("GoodSeatsCount");

            pro10.setValue(((MyApplication) this.mActivity.getApplication()).GoodSeatsCount);
            pro10.setType(Integer.class);

            PropertyInfo pro11 =new PropertyInfo();
            pro11.setName("BadSeatsCount");
            pro11.setValue(((MyApplication) this.mActivity.getApplication()).BadSeatsCount);
            pro11.setType(Integer.class);

            PropertyInfo pro12 =new PropertyInfo();
            pro12.setName("NASeatsCounts");
            pro12.setValue(((MyApplication) this.mActivity.getApplication()).NASeatsCounts);
            pro12.setType(Integer.class);

            PropertyInfo pro13 =new PropertyInfo();
            pro13.setName("KMCounter");
            pro13.setValue(((MyApplication) this.mActivity.getApplication()).KMCounter);
            pro13.setType(Integer.class);


            PropertyInfo pro14 =new PropertyInfo();
            pro14.setName("SeatBeltsCount");
            pro14.setValue(((MyApplication) this.mActivity.getApplication()).SeatBeltsCount);
            pro14.setType(Integer.class);

            PropertyInfo pro15 =new PropertyInfo();
            pro15.setName("NASeatBeltsCount");
            pro15.setValue(((MyApplication) this.mActivity.getApplication()).NASeatBeltsCount);
            pro15.setType(Integer.class);


            PropertyInfo pro16 =new PropertyInfo();
            pro16.setName("BatteryVoltage");
            pro16.setValue(((MyApplication) this.mActivity.getApplication()).BatteryVoltage);
            pro16.setType(Integer.class);

            PropertyInfo pro17 =new PropertyInfo();
            pro17.setName("TestDrive");
            pro17.setValue(this.TestDrive);
            pro17.setType(String.class);

            PropertyInfo pro18 =new PropertyInfo();
            pro18.setName("GeneralNotes");
            pro18.setValue(this.GeneralNotes);
            pro18.setType(String.class);

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
            request.addProperty(pro13);
            request.addProperty(pro14);
            request.addProperty(pro15);
            request.addProperty(pro16);
            request.addProperty(pro17);
            request.addProperty(pro18);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);



            androidHttpTransport.call(SOAP_ACTION, envelope);
            SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
            responseStr = response.toString();
            Log.i("myApp", response.toString());

        }
        catch (UnknownHostException e) {//POST & GET section
            e.printStackTrace();
            return"0";
        }
        catch (ConnectException e) {//POST & GET section
            e.printStackTrace();
            return"0";
        }
        catch (NullPointerException e) {//POST & GET section
            e.printStackTrace();
            return"0";
        }
        catch (IOException e) { // POST & GET section
            e.printStackTrace();
            return"0";
        }

        catch (Exception e) {
            e.printStackTrace();
            return"0";
        }


		
return responseStr;
	

	}
	
	
	
	@Override
	protected void onPostExecute(String result) {

        if(result.equals("0")){

            Toast.makeText(context.getApplicationContext(), "خطأ لم تتم مزامنة البيانات", Toast.LENGTH_SHORT).show();
            if ((this.progressDialog != null) && this.progressDialog.isShowing()) {
                this.progressDialog.dismiss();



            }
        }

        else {


            final MySQLiteHelper my = new MySQLiteHelper(this.mActivity);

            my.insertINTOfleetCheckList(((MyApplication) this.mActivity.getApplication()).BusId,  this.lat,  this.lag, 1, this.TestDrive, this.GeneralNotes, ((MyApplication) this.mActivity.getApplication()).GoodSeatsCount, ((MyApplication) this.mActivity.getApplication()).BadSeatsCount, ((MyApplication) this.mActivity.getApplication()).NASeatsCounts, ((MyApplication) this.mActivity.getApplication()).KMCounter, ((MyApplication) this.mActivity.getApplication()).SeatBeltsCount, ((MyApplication) this.mActivity.getApplication()).NASeatBeltsCount, ((MyApplication) this.mActivity.getApplication()).BatteryVoltage);
            my.insert(((MyApplication) this.mActivity.getApplication()).AnswerAndQuestion);
            this.mActivity.getSharedPreferences("Date", 0).edit().clear().commit();
            this.mActivity.getSharedPreferences("BusId", 0).edit().clear().commit();
            this.mActivity.getSharedPreferences("fleetnumber", 0).edit().clear().commit();
            ((MyApplication) this.mActivity.getApplication()).AnswerAndQuestion.clear();
            ((MyApplication) this.mActivity.getApplication()).AnswerAndQuestion.clear();

            try {
                if ((this.progressDialog != null) && this.progressDialog.isShowing()) {
                    this.progressDialog.dismiss();
                }
            } catch (final IllegalArgumentException e) {
                // Handle or log or ignore
            } catch (final Exception e) {
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
