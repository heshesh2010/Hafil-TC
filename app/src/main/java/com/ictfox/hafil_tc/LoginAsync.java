package com.ictfox.hafil_tc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;


public class LoginAsync extends AsyncTask<Void, Void, String> {

	Activity mActivity;
	Context context;
	ProgressDialog progressDialog;
	String responseStr;
	public LoginAsync(Activity activity, ProgressDialog progressDialog,
			Context context) {
		super();
		this.progressDialog = progressDialog;
		this.mActivity = activity;
		this.context = context;
	}
	
	@Override
	protected String doInBackground(Void... voids) {

        HttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
        // Creating HTTP Post
        HttpPost httpPost = new HttpPost(
                "http://ictfox.com/demo/Hafil_Updates/buscheck_update.aspx?BusId=mesho");

 
        // Making HTTP Request
        try {
            HttpResponse response = httpClient.execute(httpPost);
          
            response.getEntity().getContentLength(); 
            
            
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader reader = 
                       new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line = null;

                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            }
            catch (IOException e) { e.printStackTrace(); }
            catch (Exception e) { e.printStackTrace(); }
            Log.d("Http Response:", sb.toString());

            return sb.toString();
            
            
            
            

            // writing response to log
          
        } catch (ClientProtocolException e) {
            // writing exception to log
            e.printStackTrace();
        } catch (IOException e) {
            // writing exception to log
            e.printStackTrace();
 
        }
		
return responseStr;
    }


	

	@Override
	protected void onPostExecute(String result) {
		progressDialog.dismiss();
		Toast.makeText(context.getApplicationContext(), result, Toast.LENGTH_SHORT).show();
	}
}