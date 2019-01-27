package com.ictfox.hafil_tc;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshe_000 on 7/4/2014.
 */
public class MainTaskeen extends ListActivity {
Cursor cursor;

List<String> Dates = new ArrayList<String>();
List<LastTaskeenHelper> mistaryNumber = new ArrayList<LastTaskeenHelper>();
List<LastTaskeenHelper> natID = new ArrayList<LastTaskeenHelper>();
List<LastTaskeenHelper> FleetNumber = new ArrayList<LastTaskeenHelper>();
List<LastTaskeenHelper> status = new ArrayList<LastTaskeenHelper>();
List<LastTaskeenHelper> types = new ArrayList<LastTaskeenHelper>();



public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_last_taskeen);

    final Button newFourm = (Button) findViewById(R.id.button1);
    MySQLiteHelper dbHandler = new MySQLiteHelper(MainTaskeen.this);

    cursor =    dbHandler.GiridViewTaskeen();

    if(cursor.getCount() >= 1){
        if (cursor.moveToFirst()) {
            do {

                mistaryNumber.add(get(String.valueOf(cursor.getInt(0))));
                natID.add(get(cursor.getString(1)));
                Dates.add(cursor.getString(2));
                FleetNumber.add(get(String.valueOf(cursor.getInt(3))));
                status.add(get(String.valueOf(cursor.getInt(4))));
                types.add(get(String.valueOf(cursor.getInt(5))));
            }while (cursor.moveToNext());
        }
        cursor.close();
    }

    LastTaskeenAdapter adapter = new LastTaskeenAdapter(this, natID , mistaryNumber , FleetNumber,status,types );

    setListAdapter(adapter);

    newFourm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainTaskeen.this,
                    Taskeen.class);
            startActivity(i);

        }
    });
}
private LastTaskeenHelper get(String s) {

    return new LastTaskeenHelper(s);

}

@Override
protected void onListItemClick(ListView l, View v, int position, long id) {
    TextView date = (TextView) v.findViewById(R.id.TextView1);
    TextView myView2 = (TextView) v.findViewById(R.id.textView2);
    TextView type = (TextView) v.findViewById(R.id.textView5);

    String text = date.getText().toString();
    String text2 = myView2.getText().toString();
String typetext = type.getText().toString();

    SharedPreferences prefs = PreferenceManager
            .getDefaultSharedPreferences(MainTaskeen.this);

    prefs.edit().putString("Date", text).apply();
    prefs.edit().putString("type", typetext).apply();

    ProgressDialog progressDialog = new ProgressDialog(
            MainTaskeen.this);

    progressDialog.setMessage("جاري جلب البيانات برجاء الانتظار");
    progressDialog.show();
    progressDialog.setCancelable(false);
    progressDialog.setCanceledOnTouchOutside(false);

    LastTaskeenAsyncTask MyTask = new LastTaskeenAsyncTask(
            MainTaskeen.this, progressDialog, Dates.get(position),
            MainTaskeen.this.getApplicationContext());
    MyTask.execute();


}

}