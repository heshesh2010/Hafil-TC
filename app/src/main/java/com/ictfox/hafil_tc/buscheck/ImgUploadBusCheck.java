	package com.ictfox.hafil_tc.buscheck;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import org.jibble.simpleftp.SimpleFTP;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class ImgUploadBusCheck extends AsyncTask<Void, Void, String>{
	Activity mActivity;
	Context context;
	ProgressDialog progressDialog;
	String responseStr;
String picturePath="NA";
String WebServicePath="NA";
HashMap<String, String> ImgUpload = new HashMap<String, String>();
	
	public ImgUploadBusCheck(Activity activity, ProgressDialog progressDialog,
			Context context, HashMap<String, String> ImgUpload) {
		super();
		this.progressDialog = progressDialog;
		this.mActivity = activity;
		this.context = context;
		this.ImgUpload=ImgUpload;

	}
	

	@Override
	protected String doInBackground(Void... voids) {
		
		for(Entry<String, String> entry : this.ImgUpload.entrySet()) {
			  WebServicePath = entry.getKey();
			 picturePath = entry.getValue();
		SimpleFTP ftp = new SimpleFTP();
          //  FTPClient client = new FTPClient();

        // Connect to an FTP server on port 21.
        try {
			ftp.connect("hsts.hafilstc.com", 21, "hstcftp", "P@ssw0rd");


        // Set binary mode.
        ftp.bin();

        // Change to a new working directory on the FTP server.
        File file = new File(this.picturePath);
        FileInputStream fileInputStream = new FileInputStream(file);

       // ftp.cwd("4_0_30319");
        ftp.stor(fileInputStream, this.WebServicePath);
        // Upload some files.             

        // Quit from the FTP server.
        ftp.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
	
return responseStr;
	

	}
	
	
	
	@Override
	protected void onPostExecute(String result) {
		//Toast.makeText(this.context, "", Toast.LENGTH_SHORT).show();
		progressDialog.dismiss();
		this.mActivity.finish();
		
	}
	
	
}


