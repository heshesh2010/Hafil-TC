package com.ictfox.hafil_tc;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.provider.MediaStore.Images;
import android.provider.Settings.Secure;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LocationsActivity extends Activity implements LocationListener{
	protected LocationManager locationManager;
	protected LocationListener locationListener;
	protected Context context;
	TextView txtLat;
	TextView txtLag;
	EditText Notes;
	ProgressDialog progressDialogGPS;
	String picturePath="null"; // path of local Img from android device 
	String NotesString="لايوجد";
	int TAKE_PHOTO_CODE = 0;
	public static int count=0;
	private static int RESULT_LOAD_IMAGE = 1;
	private static final int CAMERA_REQUEST = 1888; 
	 private String android_id ;
	 String MinstruNum;
	 String WebServicePath="null";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_locations);
		
		final EditText minstryNum = (EditText) findViewById(R.id.editText1);
		  android_id = Secure.getString(this.getContentResolver(),
                 Secure.ANDROID_ID);
		  Button camera = (Button) findViewById(R.id.button2);
		Button BatrreyGallery = (Button) findViewById(R.id.button4);
		Button      search  = (Button) findViewById(R.id.button1);
		Button      sync  = (Button) findViewById(R.id.button3);
		txtLat = (TextView) findViewById(R.id.textView11);
		txtLag = (TextView) findViewById(R.id.textView9);
		
		TextView txt100 = (TextView) findViewById(R.id.textView1);
		TextView txt2 = (TextView) findViewById(R.id.textView4);
		TextView txt3 = (TextView) findViewById(R.id.textView6);
		TextView txt4 = (TextView) findViewById(R.id.textView8);
		TextView txt5 = (TextView) findViewById(R.id.textView10);
		Notes = (EditText) findViewById(R.id.editText3);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "HelveticaNeueW23-Reg.ttf");
		txt2.setTypeface(font);
		txt3.setTypeface(font);
		txt4.setTypeface(font);
		txt5.setTypeface(font);
		txt100.setTypeface(font);
		
		txtLat.setText("0.0");
		txtLag.setText("0.0");
		
		
		
		
		
		
		
		
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
		
		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
           
			txtLat = (TextView) findViewById(R.id.textView11);
			txtLag = (TextView) findViewById(R.id.textView9);
			txtLat.setText("0.0");
			txtLag.setText("0.0");
			
			
        }
		
		search.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				EditText minstryNum = (EditText) findViewById(R.id.editText1);
				LocationsActivity.this.MinstruNum = String.valueOf(minstryNum.getText());
				if(minstryNum.getText().toString()==null||minstryNum.getText().toString().isEmpty()){
					
					Toast.makeText(getApplicationContext(), "برجاء ادخال رقم الوزاره اولا ", Toast.LENGTH_SHORT).show();
					
				}
				
				else{

				ProgressDialog progressDialog = new ProgressDialog(
						LocationsActivity.this);
				progressDialog.setMessage("جاري جلب البيانات .. برجاء الانتظار");
				progressDialog.show();
				progressDialog.setCancelable(false);
				progressDialog.setCanceledOnTouchOutside(false);
				
				
				LocationsDataBase MyTask = new LocationsDataBase(
						LocationsActivity.this, progressDialog,
						getApplicationContext(), minstryNum.getText().toString());
				MyTask.execute();
				}
			}
		});
		
		sync.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

		if(txtLat.getText().equals("0.0")){
				
			Toast.makeText(getApplicationContext(), "قم بتشغيل الجي بي اس اولا", Toast.LENGTH_SHORT).show();
		}

		else if (LocationsActivity.this.MinstruNum.isEmpty()||LocationsActivity.this.MinstruNum.contains(" ")) {
			
			Toast.makeText(getApplicationContext(), "قم بادخال رقم الوزاره اولا", Toast.LENGTH_SHORT).show();
		}
		
		else{
			Notes = (EditText) findViewById(R.id.editText3);
			LocationsActivity.this.NotesString=Notes.getText().toString();
				if (LocationsActivity.this.NotesString.toString().isEmpty()){
						
					LocationsActivity.this.NotesString = "لايوجد";
				}
			
			ProgressDialog progressDialog = new ProgressDialog(
					LocationsActivity.this);
			progressDialog.setMessage("جاري مزامنة البيانات");
			progressDialog.show();
			progressDialog.setCancelable(false);
			progressDialog.setCanceledOnTouchOutside(false);	
		
			LocationServerSync MyTask = new LocationServerSync(
        		LocationsActivity.this, progressDialog,
        		LocationsActivity.this.getApplicationContext(), LocationsActivity.this.txtLat.getText().toString() , LocationsActivity.this.txtLag.getText().toString(), picturePath,WebServicePath,LocationsActivity.this.NotesString);
		MyTask.execute();
		
		}
			}
		});

	    BatrreyGallery.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
            	
            	if(LocationsActivity.this.MinstruNum==null){
            		Toast.makeText(getApplicationContext(), "قم بوضع رقم الوزاره اولا", Toast.LENGTH_SHORT).show();
            	}
            	
            	else	if (LocationsActivity.this.MinstruNum.isEmpty()) {
        			
        			Toast.makeText(getApplicationContext(), "قم بوضع رقم الوزاره اولا", Toast.LENGTH_SHORT).show();
        		}
            	else{
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                 
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }}
        });
		
	    
	    camera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
            	
            	if(LocationsActivity.this.MinstruNum==null){
            		Toast.makeText(getApplicationContext(), "قم بوضع رقم الوزاره اولا", Toast.LENGTH_SHORT).show();
            	}
            	
            else if (LocationsActivity.this.MinstruNum.isEmpty()) {
        			
        			Toast.makeText(getApplicationContext(), "قم بوضع رقم الوزاره اولا", Toast.LENGTH_SHORT).show();
        		}
            	else{
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
                startActivityForResult(cameraIntent, CAMERA_REQUEST); 
            	}
            	
            }
        });
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    Notes = (EditText) findViewById(R.id.editText3);
	    if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) { 
	    
			 Bitmap photo = (Bitmap) data.getExtras().get("data"); 
    		 ImageView imageView = (ImageView) findViewById(R.id.imageView1);
    		 imageView.setImageBitmap(photo);
             // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
             Uri tempUri = getImageUri(getApplicationContext(), photo);

             // CALL THIS METHOD TO GET THE ACTUAL PATH
             File finalFile = new File(getRealPathFromURI(tempUri));
             Toast.makeText(getApplicationContext(), finalFile.getAbsolutePath() , Toast.LENGTH_SHORT).show();
             String ActionDate =  new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault()).format(new Date());
             WebServicePath= android_id+"_"+ActionDate+"_"+LocationsActivity.this.MinstruNum+".jpg";
             picturePath=finalFile.getPath();
	    }
	    
	    
	    
	    
	    
	    
	    else  if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
	    	
	        Uri selectedImage = data.getData();
	        String[] filePathColumn = { MediaStore.Images.Media.DATA };

	        Cursor cursor = getContentResolver().query(selectedImage,
	                filePathColumn, null, null, null);
	        cursor.moveToFirst();

	        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
	         picturePath = cursor.getString(columnIndex);
		        cursor.close();
		        String ActionDate =  new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault()).format(new Date());
	          WebServicePath= android_id+"_"+ActionDate+"_"+LocationsActivity.this.MinstruNum+".jpg";
	        ImageView imageView = (ImageView) findViewById(R.id.imageView1);

imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
	    	}
	    }
	
	
	@Override
	public void onLocationChanged(Location location) {
		
	txtLat = (TextView) findViewById(R.id.textView11);
	txtLag = (TextView) findViewById(R.id.textView9);
	txtLat.setText(""+location.getLatitude());
	txtLag.setText(""+location.getLongitude());
	}
	 
	@Override
	public void onProviderDisabled(String provider) {

		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
	      
        // Setting Dialog Title
        alertDialog.setTitle("خطأ ");
  
        // Setting Dialog Message
        alertDialog.setMessage("يجب تشغيل الجي بي اس اولا");
  
        // On pressing Settings button
        alertDialog.setPositiveButton("صفحة الاعدادت", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
               startActivity(intent);
            }
        });
 
  
        // Showing Alert Message
        alertDialog.show();
    }	
//	Log.d("Latitude","disable");
	
	 
	@Override
	public void onProviderEnabled(String provider) {
	}
	 
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
	}
	
	
    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        //inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null); 
        cursor.moveToFirst(); 
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA); 
        return cursor.getString(idx); 
    }
    
	boolean isOnline() {
		ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

		if (netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()) {

			return false;
		}
		return true;
	}

}
