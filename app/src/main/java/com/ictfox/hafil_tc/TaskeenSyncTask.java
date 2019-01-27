package com.ictfox.hafil_tc;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;
import org.apache.http.client.ClientProtocolException;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

public class TaskeenSyncTask extends AsyncTask<Void, Void, String>{
	Activity mActivity;
	Context context;
	ProgressDialog progressDialog;
	String responseStr="";
String        Username="";
String        minstryNumber="0";
String        plateNumber="";
String        schoolName="";
String        address="";
String        driverName="";
String        driverMobile="";
String        FleetNumber="0";
String        NationalId="";
String        NumberOfStudent="0";
String note = "";
String ActionDate;
String  android_id;
int type=0;
String TaskeenArea="";
String TaskeenCity="";
String TaskeenType="";
private final String NAMESPACE = "http://tempuri.org/";
	 private final String URL = "http://hsts.hafilstc.com/HSTCWebServices/WS_Update_Taskeen.asmx";
	 private final String SOAP_ACTION = "http://tempuri.org/WS_Update_Taskeen";
	 private final String METHOD_NAME = "WS_Update_Taskeen";


	public TaskeenSyncTask(Activity activity, ProgressDialog progressDialog,
                           Context context , String Username,String plateNumber, String schoolName,String address, String driverName, String driverMobile ,String MinstyNumber , String FleetNumber, String DriverID, String NumberOfStudent , String ActionDate,int type , String note , String TaskeenArea, String TaskeenCity) {
		super();
        this.mActivity = activity;
		this.progressDialog = progressDialog;
		this.context = context;
        this.Username=Username;
        this.plateNumber=plateNumber;
        this.schoolName=schoolName;
        this.address=address;
        this.driverName=driverName;
        this.driverMobile=driverMobile;
        this.minstryNumber=MinstyNumber;
        this.FleetNumber=FleetNumber;
        this.NationalId=DriverID;
        this.NumberOfStudent=NumberOfStudent;
        this.ActionDate=ActionDate;
        this.type=type;
        this.note=note;
        this.TaskeenArea=TaskeenArea;
        this.TaskeenCity=TaskeenCity;




	}
	
	
	@Override
	protected String doInBackground(Void... voids) {
        MySQLiteHelper dbHandler = new MySQLiteHelper(context);
        try {
          android_id = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID)+"-"+dbHandler.getIDofTaskeenRow(ActionDate);

           SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.mActivity);

				   SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);




				   PropertyInfo pro =new PropertyInfo();
				   pro.setName("userName");
				   pro.setValue(Integer.parseInt(this.Username));
				   pro.setType(Integer.class);
				   
				   PropertyInfo pro2 =new PropertyInfo();
				   pro2.setName("minstryNumber");
				   pro2.setValue(Integer.parseInt(this.minstryNumber));
				   pro2.setType(Integer.class);
				   
				   PropertyInfo pro3 =new PropertyInfo();
				   pro3.setName("FleetNumber");
				   pro3.setValue(Integer.parseInt(this.FleetNumber));
				   pro3.setType(Integer.class);
				   
				   PropertyInfo pro4 =new PropertyInfo();
				   pro4.setName("NationalId");
				   pro4.setValue(this.NationalId);
				   pro4.setType(String.class);
				   
				   PropertyInfo pro5 =new PropertyInfo();
				   pro5.setName("driverName");
				   pro5.setValue(this.driverName);
				   pro5.setType(String.class);
				   
				   PropertyInfo pro6 =new PropertyInfo();
				   pro6.setName("driverMobile");
				   pro6.setValue(this.driverMobile);
				   pro6.setType(String.class);
				   
				   PropertyInfo pro7 =new PropertyInfo();
				   pro7.setName("NumberOfStudent");
				   pro7.setValue(Integer.parseInt(this.NumberOfStudent));
				   pro7.setType(Integer.class);
				   
	   
				   PropertyInfo pro8 =new PropertyInfo();
				   pro8.setName("Action_Date");
				   pro8.setValue(this.ActionDate);
				   pro8.setType(String.class);
				   
				   PropertyInfo pro9 =new PropertyInfo();
				   pro9.setName("AndroidID");
				   pro9.setValue(String.valueOf(this.android_id));
				   pro9.setType(String.class);


            if(type==0){


                TaskeenType="حافلة عاملة";

            }
            else if (type==1){

                TaskeenType="احتياطي بالسائق";
            }

            else if (type==2){
                TaskeenType="احتياطي بدون سائق";

            }
            else if (type==3){
                TaskeenType="تنزيل";

            }

        PropertyInfo pro10 =new PropertyInfo();
        pro10.setName("TaskeenType");
        pro10.setValue(this.TaskeenType);
        pro10.setType(String.class);




        PropertyInfo pro11 =new PropertyInfo();
        pro11.setName("TaskeenArea");
        pro11.setValue(this.TaskeenArea);
        pro11.setType(String.class);

        PropertyInfo pro12 =new PropertyInfo();
        pro12.setName("TaskeenCity");
        pro12.setValue(this.TaskeenCity);
        pro12.setType(String.class);

        PropertyInfo pro13 =new PropertyInfo();
        pro13.setName("TaskeenNote");
        pro13.setValue(this.note);
        pro13.setType(String.class);


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

				   SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				   envelope.dotNet = true;
				   envelope.setOutputSoapObject(request);
				   HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);



				       androidHttpTransport.call(SOAP_ACTION, envelope);
				       SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
				       Log.i("myApp", response.toString());

				       return response.toString();

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
                   catch (ClientProtocolException e) {//POST section
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



            MySQLiteHelper dbHandler = new MySQLiteHelper(this.mActivity);

            dbHandler.InsertIntoTaskeen(this.Username,this.plateNumber, this.schoolName, this.address,this.driverName, this.driverMobile , this.minstryNumber , this.FleetNumber, this.NationalId , this.NumberOfStudent , this.ActionDate,1,this.type,this.note,TaskeenArea, TaskeenCity);
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
