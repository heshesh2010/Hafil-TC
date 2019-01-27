package com.ictfox.hafil_tc;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainBoardActivity extends Activity {
String android_id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_board);


        android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
		
		
		Button CheckBusButtin = (Button) findViewById(R.id.button1);
        Button TaskeenButton = (Button) findViewById(R.id.button2);
		Button Tjmo3Buttin = (Button) findViewById(R.id.button3);
		Button BusLocationButtin = (Button) findViewById(R.id.button4);
		
		
		
		CheckBusButtin.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {

			Intent intent1 = new Intent(MainBoardActivity.this, LastDaysActivity.class);
			startActivity(intent1);


}

});
		Tjmo3Buttin.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {

			Intent intent1 = new Intent(MainBoardActivity.this, Tjamo3Points.class);
			startActivity(intent1);
           /* Cursor cursor;
            Cursor cursor2;

            MySQLiteHelper dbHandler = new MySQLiteHelper(MainBoardActivity.this);
            cursor = dbHandler.getAllFleetCheckList();
            int IDofFleetCheckList=0;
            if (cursor.getCount() >= 1) {
                if (cursor.moveToFirst()) {
                    do {

                        cursor2=dbHandler.getAllAnswer(cursor
                                .getInt(0));
                        String sectionList="";
                        String answerList="";
                        String noteList="";
                        if (cursor2.getCount() >= 1) {
                            if(cursor2.moveToFirst()) {
                                do {

                                    sectionList=sectionList+String.valueOf(cursor2.getInt(1)+",");
                                    answerList  =answerList+String.valueOf(cursor2.getInt(2)+",");
                                    noteList  =noteList+String.valueOf(cursor2.getString(3)+",");
                                } while(cursor2.moveToNext());
                            }

                            tempforsync MyTask = new tempforsync(MainBoardActivity.this,MainBoardActivity.this.getApplicationContext() ,cursor
                                    .getString(4) , android_id, sectionList,answerList,  noteList , cursor.getString(6) ,cursor.getString(5) ,cursor.getInt(1) );


                            MyTask.execute();
                            cursor2.close();

                        }

                    } while (cursor.moveToNext());
                }
                cursor.close();
            }*/
}

});	
		
		BusLocationButtin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
		
				Intent intent1 = new Intent(MainBoardActivity.this, LocationsActivity.class);
				startActivity(intent1);			
	}

	});


        TaskeenButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(MainBoardActivity.this, MainTaskeen.class);
                startActivity(intent1);
            }

        });
		
		
		
	}

	  @Override
	    public void onBackPressed() {
		 
		  AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainBoardActivity.this);

			// Setting Dialog Title
			alertDialog.setTitle("تحذير");

			// Setting Dialog Message
			alertDialog.setMessage("هل تود غلق البرنامج ");

			// On pressing Settings button
			alertDialog.setPositiveButton("نعم",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							android.os.Process.killProcess(android.os.Process.myPid());
						}
					});
			alertDialog.setNegativeButton("لا", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							
							
						}
			});
			alertDialog.show();
		  
		  
		  
		  
		  
		  
	       return;
	    }
	
	  
}
