package com.ictfox.hafil_tc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class DatabaseHandlerExcel {

	
	private static final String DB_NAME = "HafilExcel";
	private static final String TABLE_NAME = "Locations";
	private static final String TABLE_NAME2 = "schools";
	private static final String TABLE_NAME3 = "fleetmaster";
	private static final String TABLE_NAME4 = "drivers";
	private static final String TABLE_NAME5 = "schoolfleetdrivers";
	
	private static final int DATABASE_VERSION = 2;
	private static SQLiteDatabase sqliteDB;
	private static MySQLiteHelperExcel dbHelper;
	
	
	public DatabaseHandlerExcel(Context context)
	{
		
		dbHelper=new MySQLiteHelperExcel(context, DB_NAME, null, DATABASE_VERSION);
		
	}
	// Open Database 
	public void open()
	{
		sqliteDB=dbHelper.getWritableDatabase();
		
	}
	
	// Close Database 
    public void close() {
        if (sqliteDB != null)
            sqliteDB.close();
    }
    
    
	public Cursor getUserInfo() {
		
		Cursor cursor = sqliteDB.query(TABLE_NAME, null, null, null, null, null,
				null);
		cursor.moveToFirst();
//		while(cursor.moveToNext())
//		{
//		Log.e("In getUserInfo()", "name:"+cursor.getString(1)+", age:"+cursor.getString(2));
//		}
		return cursor;
	}
	public long insertUserInfo(String id , String parentid, String name  )
	{
		ContentValues contentValues=new ContentValues();
		sqliteDB=dbHelper.getWritableDatabase();
		contentValues.put("id", id);
		contentValues.put("parentid", parentid);
		contentValues.put("name", name);
		
		return  sqliteDB.insert(TABLE_NAME, null, contentValues);
	}
	
	
	
	public long insertSchools(String schoolid ,String name, String ministryno , String cityid)
	{
		ContentValues contentValues=new ContentValues();
		sqliteDB=dbHelper.getWritableDatabase();
		
		contentValues.put("schoolid", schoolid);
		contentValues.put("name", name);
		contentValues.put("ministryno", ministryno);
		contentValues.put("cityid", cityid);
		
		
		return  sqliteDB.insert(TABLE_NAME2, null, contentValues);
	}
	
	
	public long insertFleetMaster(String busid ,String fleetnumber, String platenumber , String model, String modelyear, String seat1)
	{
		ContentValues contentValues=new ContentValues();
		sqliteDB=dbHelper.getWritableDatabase();
		
		contentValues.put("busid", busid);
		contentValues.put("fleetnumber", fleetnumber);
		contentValues.put("platenumber", platenumber);
		contentValues.put("model", model);
		contentValues.put("modelyear", modelyear);
		contentValues.put("seat1", seat1);
		
		
		return  sqliteDB.insert(TABLE_NAME3, null, contentValues);
	}
	
	
	
	
	public long insertDrivers(String id , String nationalid, String name  )
	{
		ContentValues contentValues=new ContentValues();
		sqliteDB=dbHelper.getWritableDatabase();
		contentValues.put("id", id);
		contentValues.put("nationalid", nationalid);
		contentValues.put("name", name);
		
		return  sqliteDB.insert(TABLE_NAME4, null, contentValues);
	}
	
	public long insertSchoolFleetDrivers(String schoolid , String fleetnumber, String driverid  )
	{
		ContentValues contentValues=new ContentValues();
		sqliteDB=dbHelper.getWritableDatabase();
		contentValues.put("schoolid", schoolid);
		contentValues.put("fleetnumber", fleetnumber);
		contentValues.put("driverid", driverid);
		
		return  sqliteDB.insert(TABLE_NAME5, null, contentValues);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
