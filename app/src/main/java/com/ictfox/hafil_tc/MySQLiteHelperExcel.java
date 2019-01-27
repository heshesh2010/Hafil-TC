package com.ictfox.hafil_tc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class MySQLiteHelperExcel extends SQLiteOpenHelper{


    
    // Database Name
    private static final String DB_NAME = "HafilExcel";
	private static final String TABLE_NAME = "Locations";
	private static final String TABLE_NAME2 = "schools";
	private static final String TABLE_NAME3 = "fleetmaster";
	private static final String TABLE_NAME4 = "drivers";
	private static final String TABLE_NAME5 = "schoolfleetdrivers";
	
	
	public MySQLiteHelperExcel(Context context, String db_name,
			CursorFactory factory, int version) {
		super(context, DB_NAME, factory, version);
	}
    
    @Override
    public void onCreate(SQLiteDatabase db) {
    	
    	
        // SQL statement to create CheckLists table
        String CREATE_Locations_TABLE = "CREATE TABLE Locations ( " +
                "id INTEGER PRIMARY KEY , " +
                "parentid INTEGER, "+
                "name TEXT)";
    	
        // SQL statement to create CheckLists table
        String CREATE_schools_TABLE = "CREATE TABLE schools ( " +
                "schoolid INTEGER PRIMARY KEY , " +
                "name TEXT, "+
                "ministryno INTEGER," +
                "cityid INTEGER)" ;
    	
        String CREATE_fleetmaster_TABLE = "CREATE TABLE fleetmaster ( " +
                "busid INTEGER PRIMARY KEY," +
                "fleetnumber INTEGER, "+
                "platenumber TEXT," +
                "model TEXT,"+
                "modelyear TEXT," +
                "seat1 INTEGER)";
        
        // SQL statement to create CheckLists table
        String CREATE_drivers_TABLE = "CREATE TABLE drivers ( " +
                "id INTEGER PRIMARY KEY , " +
                "nationalid TEXT, "+
                "name TEXT)";
        
        
        // SQL statement to create CheckLists table
        String CREATE_schoolfleetdrivers_TABLE = "CREATE TABLE schoolfleetdrivers ( " +
                "schoolid INTEGER PRIMARY KEY , " +
                "fleetnumber INTEGER, "+
                "driverid TEXT)";
        
        
        // create Locations table
        db.execSQL(CREATE_Locations_TABLE);
    	
    	
        // create schools table
        db.execSQL(CREATE_schools_TABLE);
    	
        // create fleetmaster table
        db.execSQL(CREATE_fleetmaster_TABLE);
    	
        // create drivers table
        db.execSQL(CREATE_drivers_TABLE);
    	
        // create schoolfleetdrivers table
        db.execSQL(CREATE_schoolfleetdrivers_TABLE);
        
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME2);
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME3);
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME4);
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME5);
		onCreate(db);
		
	}
	
    
}
