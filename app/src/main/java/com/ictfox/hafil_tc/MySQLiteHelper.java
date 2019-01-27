package com.ictfox.hafil_tc;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class MySQLiteHelper extends SQLiteOpenHelper {

// Database Version
private static final int DATABASE_VERSION = 5;
int fleetCheckListid;
int id;
int result = 0;
String ActionDate;
// Database Name
private static final String DATABASE_NAME = "HafilSTC";


private static final String TABLE_NAME1 = "CheckLists";
private static final String TABLE_NAME2 = "FleetCheckLists";
private static final String TABLE_NAME3 = "Images";
private static final String TABLE_NAME4 = "Locations";
private static final String TABLE_NAME5 = "schools";
private static final String TABLE_NAME6 = "fleetmaster";
private static final String TABLE_NAME7 = "drivers";
private static final String TABLE_NAME8 = "schoolfleetdrivers";
private static final String TABLE_NAME9 = "schoolmaster";
private static final String TABLE_NAME10 = "CheckPoints";
private static final String TABLE_NAME11 = "UsersMaster";
private static final String TABLE_NAME12 = "CheckPointsDetails";
private static SQLiteDatabase sqliteDB;

public MySQLiteHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
}


@Override
public void onCreate(SQLiteDatabase db) {

    // SQL statement to create CheckLists table
    String CREATE_CheckLists_TABLE = "CREATE TABLE CheckLists ( " +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "FleetPartsId INTEGER, " +
            "FleetPartsStatusId INTEGER, " +
            "FleetCheckListsId INTEGER," +
            "Note TEXT)";


    // SQL statement to create FleetCheckLists table
    String CREATE_FleetCheckLists_TABLE = "CREATE TABLE FleetCheckLists ( " +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "BusId INTEGER, " +
            "Address TEXT, " +
            "UserId TEXT," +
            "ActionDate DEFAULT CURRENT_TIMESTAMP," +
            "longitude TEXT, " +
            "Latitude TEXT," +
            "GoodSeatsCount INTEGER," +
            "BadSeatsCount INTEGER," +
            "NASeatsCounts INTEGER," +
            "KMCounter  INTEGER," +
            "SeatBeltsCount INTEGER," +
            "NASeatBeltsCount   INTEGER," +
            "BatteryVoltage INTEGER," +
            "TestDrive TEXT," +
            "GeneralNotes TEXT," +
            "status INTEGER" +

            ")";

    // SQL statement to create Images table
    String CREATE_Images_TABLE = "CREATE TABLE Images ( " +
            "Imgid INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "FleetPartsId  INTEGER, " +
            "Localpath TEXT, " +
            "OnlinePath TEXT, " +
            "FleetCheckListsId INTEGER)";


    // SQL statement to create Locations table
    String CREATE_Locations_TABLE = "CREATE TABLE Locations ( " +
            "id INTEGER  , " +
            "parentid INTEGER, " +
            "name TEXT)";

    // SQL statement to create schools table
    String CREATE_schools_TABLE = "CREATE TABLE schools ( " +
            "schoolid INTEGER , " +
            "name TEXT, " +
            "ministryno INTEGER," +
            "cityid INTEGER)";

    // SQL statement to create fleetmaster table
    String CREATE_fleetmaster_TABLE = "CREATE TABLE fleetmaster ( " +
            "busid INTEGER ," +
            "fleetnumber INTEGER, " +
            "platenumber TEXT," +
            "model TEXT," +
            "modelyear TEXT," +
            "seat1 INTEGER)";

    // SQL statement to create drivers table
    String CREATE_drivers_TABLE = "CREATE TABLE drivers ( " +
            "id INTEGER  , " +
            "nationalid TEXT, " +
            "name TEXT," +
            "cell TEXT)";


    // SQL statement to create schoolfleetdrivers table
    String CREATE_schoolfleetdrivers_TABLE = "CREATE TABLE schoolfleetdrivers ( " +
            "schoolid INTEGER , " +
            "fleetnumber INTEGER, " +
            "driverid TEXT)";


    // SQL statement to create schoolmaster table
    String CREATE_schoolmaster_TABLE = "CREATE TABLE schoolmaster ( " +
            "schoolid TEXT , " +
            "name TEXT, " +
            "ministryno TEXT," +
            "locationid TEXT," +
            "TSMCurrent TEXT," +
            "adminname TEXT)";

    // SQL statement to create CheckPoints table
    String CREATE_CheckPoints_TABLE = "CREATE TABLE CheckPoints ( " +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT , " +
            "FleetNumber INTEGER, " +
            "CheckPointID INTEGER," +
            "NoOFStudents INTEGER," +
            "MistryNumber INTEGER," +
            "Location_Longitude TEXT," +
            "Location_Latitude TEXT," +
            "PathStatus TEXT," +
            "ActionDate TEXT," +
            "Rad INTEGER)";

    // SQL statement to create UsersMaster table
    String CREATE_UsersMaster_TABLE = "CREATE TABLE UsersMaster ( " +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT , " +
            "code TEXT, " +
            "password TEXT," +
            "name TEXT)";

    // SQL statement to create UsersMaster table
    String CREATE_CheckPointsDetails_TABLE = "CREATE TABLE CheckPointsDetails ( " +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT , " +
            "FleetNumber INTEGER, " +
            "SchoolMinistryNo TEXT," +
            "Notes  TEXT," +
            "Action_Date TEXT" +
            ")";


    String CREATE_Setting_TABLE = " CREATE TABLE setting ( LastDate TEXT )";

    String CREATE_Taskeen_TABLE = " CREATE TABLE Taskeen ( ID INTEGER PRIMARY KEY AUTOINCREMENT , userName INTEGER, minstryNumber INTEGER, FleetNumber INTEGER,  NationalId  TEXT ,plateNumber TEXT, schoolName  TEXT , schoolAdress TEXT, driverName  TEXT , driverMobile TEXT , NumberOforders INTEGER, ActionDate TEXT , status INTEGER  ,  type INTEGER , note TEXT , TaskeenArea TEXT, TaskeenCity TEXT) ";

    // create CheckLists table
    db.execSQL(CREATE_CheckLists_TABLE);

    // create FleetCheckLists table
    db.execSQL(CREATE_FleetCheckLists_TABLE);
    //
    db.execSQL(CREATE_Images_TABLE);

    // create Locations table
    db.execSQL(CREATE_Locations_TABLE);


    // create schools table
    db.execSQL(CREATE_schools_TABLE);

    // create fleetmaster table
    db.execSQL(CREATE_fleetmaster_TABLE);

    // create drivers table
    db.execSQL(CREATE_drivers_TABLE);

    // create schoolmaster table
    db.execSQL(CREATE_schoolmaster_TABLE);

    // create schoolfleetdrivers table
    db.execSQL(CREATE_schoolfleetdrivers_TABLE);

    // create schoolfleetdrivers table
    db.execSQL(CREATE_CheckPoints_TABLE);


    // create UsersMaster table
    db.execSQL(CREATE_UsersMaster_TABLE);

    // create UsersMaster table
    db.execSQL(CREATE_CheckPointsDetails_TABLE);

    // create Setting table
    db.execSQL(CREATE_Setting_TABLE);

    // create Taskeen table
    db.execSQL(CREATE_Taskeen_TABLE);


}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
   // String upgradeQuery = "ALTER TABLE CheckPoints ADD COLUMN Rad INTEGER";
   // String upgradeQuery2 = "CREATE TABLE setting ( LastDate TEXT )";
   // String upgradeQuery3 = " ALTER TABLE FleetCheckLists ADD COLUMN status INTEGER";
    String upgradeQuery4 = "ALTER TABLE Taskeen ADD COLUMN note TEXT)";
    if(newVersion == 5) {
        //db.execSQL(upgradeQuery);
       // db.execSQL(upgradeQuery2);
       // db.execSQL(upgradeQuery3);
        db.execSQL(upgradeQuery4);
        //onCreate(db);
    }
}


public void open() {

    sqliteDB = this.getWritableDatabase();


}

public void begin() {

    sqliteDB.beginTransaction();

}


// Close Database
public void close() {
    if(sqliteDB != null)
        sqliteDB.close();
}

// Close Database
public void setsucss() {


    sqliteDB.setTransactionSuccessful();

}


// Close Database
public void end() {


    sqliteDB.endTransaction();

}

////===MASTERS ECXEL INSERT===/////

public void insertUserInfo(String id, String parentid, String name) {
    ContentValues contentValues = new ContentValues();
    sqliteDB = this.getWritableDatabase();
    contentValues.put("id", id);
    contentValues.put("parentid", parentid);
    contentValues.put("name", name);

    sqliteDB.insert(TABLE_NAME4, null, contentValues);
}


public void insertSchools(String schoolid, String name, String ministryno, String cityid) {
    ContentValues contentValues = new ContentValues();
    sqliteDB = this.getWritableDatabase();

    contentValues.put("schoolid", schoolid);
    contentValues.put("name", name);
    contentValues.put("ministryno", ministryno);
    contentValues.put("cityid", cityid);


    sqliteDB.insert(TABLE_NAME5, null, contentValues);
}


public void insertFleetMaster(String busid, String fleetnumber, String platenumber, String model, String modelyear, String seat1) {
    ContentValues contentValues = new ContentValues();
    sqliteDB = this.getWritableDatabase();

    contentValues.put("busid", busid);
    contentValues.put("fleetnumber", fleetnumber);
    contentValues.put("platenumber", platenumber);
    contentValues.put("model", model);
    contentValues.put("modelyear", modelyear);
    contentValues.put("seat1", seat1);


    sqliteDB.insert(TABLE_NAME6, null, contentValues);
}


public void insertDrivers(String id, String nationalid, String cell, String name) {
    ContentValues contentValues = new ContentValues();
    sqliteDB = this.getWritableDatabase();
    contentValues.put("id", id);
    contentValues.put("nationalid", nationalid);
    contentValues.put("name", name);
    contentValues.put("cell", cell);
    sqliteDB.insert(TABLE_NAME7, null, contentValues);
}

public void insertSchoolFleetDrivers(String schoolid, String fleetnumber, String driverid) {
    ContentValues contentValues = new ContentValues();
    sqliteDB = this.getWritableDatabase();
    contentValues.put("schoolid", schoolid);
    contentValues.put("fleetnumber", fleetnumber);
    contentValues.put("driverid", driverid);

    sqliteDB.insert(TABLE_NAME8, null, contentValues);
}


public void insertSchoolMaster(String schoolid, String name, String ministryno, String locationid, String TSMCurrent, String adminname) {
    ContentValues contentValues = new ContentValues();
    sqliteDB = this.getWritableDatabase();
    contentValues.put("schoolid", schoolid);
    contentValues.put("name", name);
    contentValues.put("ministryno", ministryno);
    contentValues.put("locationid", locationid);
    contentValues.put("TSMCurrent", TSMCurrent);
    contentValues.put("adminname", adminname);
    sqliteDB.insert(TABLE_NAME9, null, contentValues);
}


public void insertUsersMaster(String code, String password) {
    ContentValues contentValues = new ContentValues();
    sqliteDB = this.getWritableDatabase();
    contentValues.put("code", code);
    contentValues.put("password", password);
    sqliteDB.insert(TABLE_NAME11, null, contentValues);
}


//==== Delete all records ====//

public void deletall() {

    sqliteDB = this.getWritableDatabase();

    sqliteDB.delete(TABLE_NAME4, null, null);
    sqliteDB.delete(TABLE_NAME5, null, null);
    sqliteDB.delete(TABLE_NAME6, null, null);
    sqliteDB.delete(TABLE_NAME7, null, null);
    sqliteDB.delete(TABLE_NAME8, null, null);
    sqliteDB.delete(TABLE_NAME9, null, null);
    sqliteDB.delete(TABLE_NAME11, null, null);
    sqliteDB.delete("setting", null, null);


}
//===SEARCH FRO LOCATION ACTIVITY ===///

public Cursor getAlllocationInfo(String minstryNum) {


    sqliteDB = this.getWritableDatabase();

    String qq = "select schoolId, name, adminname from schoolmaster where ministryno ='" + minstryNum+"'";
    Cursor cursor = sqliteDB.rawQuery(qq, null);

    return cursor;
}

//for gird view for bus check

public Cursor GiridView() {

    String ActionDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    sqliteDB = this.getWritableDatabase();

    String qq = "Select fleetmaster.platenumber, fleetmaster.fleetnumber, FleetCheckLists.ActionDate , fleetmaster.BusId , FleetCheckLists.status from FleetCheckLists join fleetmaster on fleetmaster.BusId =  FleetCheckLists.BusId where date(FleetCheckLists.ActionDate) = '" + ActionDate + "' order by FleetCheckLists.ActionDate desc";
    Cursor cursor = sqliteDB.rawQuery(qq, null);

    return cursor;
}

// for taskeen girdview

public Cursor GiridViewTaskeen() {
    Cursor cursor;
    String ActionDate = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss", Locale.getDefault()).format(new Date());
    SQLiteDatabase db = this.getWritableDatabase();


    String qq = "Select minstryNumber , NationalId ,  ActionDate , fleetNumber, status , type from Taskeen ";
    cursor = db.rawQuery(qq, null);

    return cursor;
}


//======== SEARCH FOR BUS ACTIVITY  ======//
public Cursor getAllBusInfo(int fleetnumber) {

    sqliteDB = this.getWritableDatabase();

    String qq = "Select FleetMaster.BusId, FleetMaster.PlateNumber,  FleetMaster.Model,  FleetMaster.ModelYear,  FleetMaster.Seat1, Schoolfleetdrivers.driverid, drivers.name from FleetMaster left join Schoolfleetdrivers on FleetMaster.fleetnumber = Schoolfleetdrivers.fleetnumber left join drivers on Schoolfleetdrivers.driverid = drivers.nationalid where FleetMaster.fleetnumber =" + fleetnumber;
    Cursor cursor = sqliteDB.rawQuery(qq, null);

    return cursor;
}


//======== GET ALL BUS INFO LASTDATE	
public Cursor getAllBusInfoLastDate(String Date) {

    int BUSID = 0;
    sqliteDB = this.getWritableDatabase();

    String q1 = " select busid from FleetCheckLists where ActionDate ='" + Date + "'";
    Cursor cursor = sqliteDB.rawQuery(q1, null);
    if(cursor != null && cursor.moveToFirst()) {

        BUSID = cursor.getInt(0);


    }

    String qq = "Select FleetMaster.Busid, FleetMaster.FleetNumber, FleetMaster.PlateNumber, FleetMaster.Model, FleetMaster.ModelYear, FleetMaster.Seat1, Schoolfleetdrivers.driverid, drivers.name from FleetMaster left join Schoolfleetdrivers on FleetMaster.fleetnumber = Schoolfleetdrivers.fleetnumber left join drivers on Schoolfleetdrivers.driverid = drivers.nationalid where FleetMaster.Busid =" + BUSID + "";

    Cursor cursor2 = sqliteDB.rawQuery(qq, null);

    return cursor2;
}


//======== GET ALL Taskeen INFO LASTDATE
public Cursor getAllTaskeenInfoLastDate(String Date) {

    Cursor cursor2;

    sqliteDB = this.getWritableDatabase();


    String qq = "Select minstryNumber, FleetNumber, NationalId ,plateNumber, userName, schoolName, schoolAdress, driverName, driverMobile, NumberOforders , ActionDate ,type ,note , TaskeenArea, TaskeenCity from Taskeen where ActionDate='" + Date + "'";


    cursor2 = sqliteDB.rawQuery(qq, null);

    return cursor2;
}

public String getLastModifitedDate() {
    SQLiteDatabase db = this.getWritableDatabase();
    String LastDate = "0";
    String qq = "select LastDate from setting ";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {

        LastDate = cursor.getString(0);


    }
    return LastDate;
}


public String getIDofTaskeenRow(String date) {
    SQLiteDatabase db = this.getWritableDatabase();
    String ID = "0";
    String qq = "select ID from Taskeen where ActionDate='" + date + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {

        ID = String.valueOf(cursor.getInt(0));


    }
    return ID;
}


public void InsertLastModifidedDate(String date) {
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put("LastDate", date);
    db.insert("setting", null, values);

}


//======================INSERTSTATMENTS===================================
public void insertINTOfleetCheckList(int busId, String longitude, String Latitude, int status, String Note1,String Note2,int GoodSeatsCount, int BadSeatsCount, int NASeatsCounts, int KMCounter, int SeatBeltsCount, int NASeatBeltsCount, int BatteryVoltage) {
    String ActionDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

    SQLiteDatabase db = this.getWritableDatabase();

    db.delete("FleetCheckLists", "BusId=" + busId + " and date(ActionDate)='" + ActionDate + "'", null);
    String ActionDate2 = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss", Locale.getDefault()).format(new Date());
    ContentValues values = new ContentValues();
    values.put("BusId", busId);
    values.put("longitude", longitude);
    values.put("Latitude", Latitude);
    values.put("ActionDate", ActionDate2);
    values.put("status", status);


    values.put("TestDrive", Note1);
    values.put("GeneralNotes", Note2);

    values.put("GoodSeatsCount", GoodSeatsCount);
    values.put("BadSeatsCount", BadSeatsCount);
    values.put("NASeatsCounts", NASeatsCounts);
    values.put("KMCounter", KMCounter);
    values.put("SeatBeltsCount", SeatBeltsCount);
    values.put("NASeatBeltsCount", NASeatBeltsCount);
    values.put("BatteryVoltage", BatteryVoltage);



    db.insert("FleetCheckLists",
            null,
            values);


    String qq = "select id  from FleetCheckLists where ActionDate ='" + ActionDate2 + "'" + " and BusId ='" + busId + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {

        fleetCheckListid = cursor.getInt(0);


    }

    db.close();

}


public void updateinsertINTOfleetCheckList(int busId, String longitude, String Latitude, int status, String Note1,String Note2,int GoodSeatsCount, int BadSeatsCount, int NASeatsCounts, int KMCounter, int SeatBeltsCount, int NASeatBeltsCount, int BatteryVoltage , String date) {
    {

        SQLiteDatabase db = this.getWritableDatabase();



        ContentValues values = new ContentValues();
        values.put("longitude", longitude);
        values.put("Latitude", Latitude);
        values.put("status", status);
        values.put("TestDrive", Note1);
        values.put("GeneralNotes", Note2);
        values.put("GoodSeatsCount", GoodSeatsCount);
        values.put("BadSeatsCount", BadSeatsCount);
        values.put("NASeatsCounts", NASeatsCounts);
        values.put("KMCounter", KMCounter);
        values.put("SeatBeltsCount", SeatBeltsCount);
        values.put("NASeatBeltsCount", NASeatBeltsCount);
        values.put("BatteryVoltage", BatteryVoltage);





        db.update("FleetCheckLists",
                values, "id" + " = " + getFleetCheckListsIDforLastDays(date) +  " and busID =" + busId, null);



        // 4. close
        db.close();
    }
}


public void update(HashMap<Integer, Integer> section, String BusID, String Date) {

    SQLiteDatabase db = this.getWritableDatabase();
    for(Entry<Integer, Integer> entry : section.entrySet()) {
        Integer section2 = entry.getKey();
        Integer answer2 = entry.getValue();

        ContentValues values = new ContentValues();
        values.put("FleetPartsId", section2);
        values.put("FleetPartsStatusId", answer2);
        //values.put("FleetCheckListsId", getFleetCheckListsIDforLastDays(Date));

        db.update("CheckLists",
                values, "FleetCheckListsId" + " = " + getFleetCheckListsIDforLastDays(Date) + " and FleetPartsId =" + section2, null);

    }

    // 4. close
    db.close();
}













public int getFleetCheckListsID(String busID) {

    SQLiteDatabase db = this.getWritableDatabase();

    String qq = "select id  from FleetCheckLists where ActionDate ='" + ActionDate + "'" + " and BusId ='" + busID + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {

        fleetCheckListid = cursor.getInt(0);
    }

    return fleetCheckListid;

}


public int getFleetCheckListsIDforLastDays(String date) {

    SQLiteDatabase db = this.getWritableDatabase();

    String qq = "select id  from FleetCheckLists where ActionDate ='" + date + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {

        fleetCheckListid = cursor.getInt(0);
    }

    return fleetCheckListid;

}


public void insert(HashMap<Integer, Integer> section) {

    SQLiteDatabase db = this.getWritableDatabase();


    for(Entry<Integer, Integer> entry : section.entrySet()) {
        Integer section2 = entry.getKey();
        Integer answer2 = entry.getValue();

        db.delete("CheckLists", "FleetPartsId=" + section2 + " and FleetPartsStatusId=" + answer2 + " and FleetCheckListsId=" + fleetCheckListid, null);

        ContentValues values = new ContentValues();
        values.put("FleetPartsId", section2);
        values.put("FleetPartsStatusId", answer2);
        values.put("FleetCheckListsId", fleetCheckListid);
        db.insert("CheckLists",
                null,
                values);
    }
    // 4. close
    db.close();
}

public void insertNotes(HashMap<Integer, String> notes, String BusID) {

    SQLiteDatabase db = this.getWritableDatabase();

    for(Entry<Integer, String> entry : notes.entrySet()) {
        String Note = entry.getValue();
        Integer section = entry.getKey();
        //db.delete("CheckLists", "FleetCheckListsId="+getFleetCheckListsID(BusID)+" and FleetPartsId='"+section , null);
        ContentValues values = new ContentValues();
        values.put("Note", Note);
        db.update("CheckLists",
                values, "FleetCheckListsId" + "='" + getFleetCheckListsID(BusID) + "'" + " and FleetPartsId =" + section, null);

    }
    // 4. close
    db.close();
}


public void updateNotes(HashMap<Integer, String> notes, String BusID) {

    SQLiteDatabase db = this.getWritableDatabase();

    for(Entry<Integer, String> entry : notes.entrySet()) {
        String Note = entry.getValue();
        Integer section = entry.getKey();

        ContentValues values = new ContentValues();
        values.put("Note", Note);
        db.update("CheckLists",
                values, "FleetCheckListsId" + "='" + getFleetCheckListsID(BusID) + "'" + " and FleetPartsId =" + section, null);

    }
    // 4. close
    db.close();
}


public void InsertImg(HashMap<Integer, String> myMap, String BusID) {
    SQLiteDatabase db = this.getWritableDatabase();
    for(Map.Entry<Integer, String> myMap1 : myMap.entrySet()) {
        String path = myMap1.getValue();
        Integer section = myMap1.getKey();

        ContentValues values = new ContentValues();
        db.delete("Images", "FleetPartsId=" + section + " and Localpath='" + path + "'" + " and FleetCheckListsId=" + getFleetCheckListsID(BusID), null);
        values.put("FleetPartsId", section);
        values.put("Localpath", path);
        values.put("FleetCheckListsId", getFleetCheckListsID(BusID));

        db.insert("Images",
                null,
                values);
    }
    db.close();
}


public void UpdateTaskeen(String Username, String plateNumber, String schoolName, String address, String driverName, String DriverMobile, String MinstyNumber, String FleetNumber, String DriverID, String numOfOrders, String date, int status) {

    SQLiteDatabase db = this.getWritableDatabase();


    //db.delete("Taskeen", "minstryNumber="+MinstyNumber+" and FleetNumber="+FleetNumber + " and NationalId='" + DriverID +"' and ActionDate='" + date +"'", null);
    ContentValues values = new ContentValues();
    values.put("ActionDate", date);
    values.put("status", status);





    db.update("Taskeen",
            values, " ActionDate = '" + date + "'", null);


    db.close();
}





public void updateStatus(int status, String Date) {
    ContentValues values = new ContentValues();
    values.put("status", status);
    SQLiteDatabase db = this.getWritableDatabase();
    db.update("FleetCheckLists",
            values, "id = " + getFleetCheckListsIDforLastDays(Date), null);

    // 4. close
    db.close();
}


public void updateImg(HashMap<Integer, String> myMap, String Date) {
    SQLiteDatabase db = this.getWritableDatabase();
    for(Map.Entry<Integer, String> myMap1 : myMap.entrySet()) {
        String path = myMap1.getValue();
        int section = myMap1.getKey();

        ContentValues values = new ContentValues();
        values.put("FleetPartsId", section);
        values.put("Localpath", path);
        db.update("Images",
                values, "FleetCheckListsId" + " = " + getFleetCheckListsIDforLastDays(Date) + " and FleetPartsId =" + section, null);

    }

    // 4. close
    db.close();
}


private LastDaysHelper get(String s) {

    return new LastDaysHelper(s);

}


public int getLastDaysValues(String BusID, int section, String Date) {


    SQLiteDatabase db = this.getWritableDatabase();
    String qq = "select id from FleetCheckLists where BusId = '" + BusID + "' and ActionDate ='" + Date + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        id = cursor.getInt(0);

        cursor.close();

    }
    String qq2 = "select FleetPartsStatusId from CheckLists where FleetPartsId = '" + section + "'" + "and FleetCheckListsId=" + id;
    Cursor cursor2 = db.rawQuery(qq2, null);

    if(cursor2 != null && cursor2.moveToFirst()) {
        this.result = cursor2.getInt(0);
    }
    db.close();

    return this.result;
}



public String getLastDaysValuesGeneralNote(String BusID, String Date) {

    String note="NA";
    SQLiteDatabase db = this.getWritableDatabase();
    String qq = "select GeneralNotes from FleetCheckLists where BusId = '" + BusID + "' and ActionDate ='" + Date + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        note = cursor.getString(0);

        cursor.close();
    }

    db.close();

    return note;
}




public String getLastDaysValuesTestDrive(String BusID, String Date) {

    String note="NA";
    SQLiteDatabase db = this.getWritableDatabase();
    String qq = "select TestDrive from FleetCheckLists where BusId = '" + BusID + "' and ActionDate ='" + Date + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        note = cursor.getString(0);

        cursor.close();
    }

    db.close();

    return note;
}




public String getLastDaysValuesEditTexts(String BusID, String Date, String pra) {

    String note="NA";
    SQLiteDatabase db = this.getWritableDatabase();
    String qq = "select " + pra + " from FleetCheckLists where BusId = '" + BusID + "' and ActionDate ='" + Date + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        note = cursor.getString(0);

        cursor.close();
    }

    db.close();

    return note;
}


public int getSpecialDaysValues(String Date, int section) {

    SQLiteDatabase db = this.getWritableDatabase();
    String qq = "select FleetPartsStatusId from CheckLists where FleetPartsId = " + section + " and ActionDate ='" + Date + "'and FleetPartsStatusId IN (0, 3, 4, 5)";
    Cursor cursor = db.rawQuery(qq, null);
    if(cursor != null && cursor.moveToFirst()) {
        return cursor.getInt(0);
    }
    cursor.close();
    db.close();
    return section;


}


public String CheckforPathIsExsits(String FleetNumber) {
    SQLiteDatabase db = this.getWritableDatabase();
    String ActionDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    String qq = "select CheckPointID from CheckPoints where FleetNumber = " + FleetNumber + " and date(ActionDate)='" + ActionDate + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        cursor.close();
        return "error";
    } else {
        cursor.close();
        return "NoPath";
    }
}


public int CheckPoint(String fleetNumber) {
    int CheckPointID = 0;
    SQLiteDatabase db = this.getWritableDatabase();
    String ActionDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    String qq = "select MAX(CheckPointID) from CheckPoints where FleetNumber = " + fleetNumber + " and date(ActionDate)='" + ActionDate + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        CheckPointID = cursor.getInt(0) + 1;
    } else {
        CheckPointID = 1;
    }

    cursor.close();
    //db.close();
    return CheckPointID;
}

public long addCheckPoint(String fleetNumber, String NoOFStudents, String Location_Longitude, String Location_Latitude, String MinstryNumber, int answer) {

    SQLiteDatabase db = this.getWritableDatabase();
    String ActionDate = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss", Locale.getDefault()).format(new Date());

    ContentValues values = new ContentValues();
    values.put("FleetNumber", fleetNumber);
    values.put("CheckPointID", CheckPoint(fleetNumber));
    values.put("NoOFStudents", NoOFStudents);
    values.put("Location_Longitude", Location_Longitude);
    values.put("Location_Latitude", Location_Latitude);
    values.put("ActionDate", ActionDate);
    values.put("PathStatus", "Open");
    values.put("MistryNumber", MinstryNumber);
    values.put("Rad", answer);

    return db.insert("CheckPoints", null, values);
}


public long InsertIntoTaskeen(String Username, String plateNumber, String schoolName, String address, String driverName, String DriverMobile, String MinstyNumber, String FleetNumber, String DriverID, String numOfOrders, String ActionDate, int status, int type, String note, String TaskeenArea , String TaskeenCity) {

//String ActionDate =  new SimpleDateFormat("yyyy-MM-ddHH:mm:ss",Locale.getDefault()).format(new Date());
    ContentValues values = new ContentValues();

    SQLiteDatabase db = this.getWritableDatabase();
    values.put("userName", Username);
    values.put("minstryNumber", MinstyNumber);
    values.put("FleetNumber", FleetNumber);
    values.put("NationalId", DriverID);
    values.put("PlateNumber", plateNumber);
    values.put("schoolName", schoolName);
    values.put("schoolAdress", address);
    values.put("driverName", driverName);
    values.put("driverMobile", DriverMobile);
    values.put("NumberOforders", numOfOrders);
    values.put("ActionDate", ActionDate);
    values.put("status", status);
    values.put("type", type);
    values.put("note", note);
    values.put("TaskeenArea", TaskeenArea);
    values.put("TaskeenCity", TaskeenCity);


    db.insert("Taskeen", null, values);

    return 10;


}


public long InsertNoresToCheckPoints(String Notes, String fleetNumber, String MinstryNumber) {

    SQLiteDatabase db = this.getWritableDatabase();
    String ActionDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());


//String qq = "delete from CheckPointsDetails where FleetNumber="+fleetNumber+" and date(Action_Date)='"+ActionDate+"'";

    //db.execSQL(qq, null);
    db.delete("CheckPointsDetails", "FleetNumber=" + fleetNumber + " and date(Action_Date)='" + ActionDate + "'", null);


    ContentValues values = new ContentValues();
    values.put("FleetNumber", fleetNumber);
    values.put("Notes", Notes);
    values.put("Action_Date", ActionDate);
    values.put("SchoolMinistryNo", MinstryNumber);
    return db.insert("CheckPointsDetails", null, values);
}


public void updateNotesIntoCheckPoint(String Notes, String fleetNumber) {

    SQLiteDatabase db = this.getWritableDatabase();
    String ActionDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

    ContentValues values = new ContentValues();
    values.put("Notes", Notes);
    db.update("CheckPointsDetails",
            values, "date(Action_Date)" + "='" + ActionDate + "' " + " and FleetNumber =" + fleetNumber, null);
    db.close();
}


public String getCheckPointNote(String fleetNumber) {
    SQLiteDatabase db = this.getWritableDatabase();
    String ActionDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    String qq = "select Notes from CheckPointsDetails where FleetNumber = " + fleetNumber + " and date(Action_Date)='" + ActionDate + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        return cursor.getString(0);
    }

    db.close();
    return "������";

}


public Cursor getCheckPointRows(String fleetNumber) {
    SQLiteDatabase db = this.getWritableDatabase();
    String ActionDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    String qq = "select CheckPointID , FleetNumber, NoOFStudents , ActionDate , MistryNumber from CheckPoints where FleetNumber = " + fleetNumber + " and date(ActionDate)='" + ActionDate + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        return cursor;
    }

    db.close();
    return cursor;

}

public Cursor getCheckPointPathRows() {
    SQLiteDatabase db = this.getWritableDatabase();
    String ActionDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    String qq = "select CheckPoints.FleetNumber, FleetMaster.PlateNumber, CheckPoints.ActionDate, CheckPoints.PathStatus  from CheckPoints left join FleetMaster on CheckPoints.FleetNumber = FleetMaster.FleetNumber where date(CheckPoints.ActionDate)='" + ActionDate + "' GROUP BY CheckPoints.FleetNumber ORDER BY CheckPoints.ActionDate DESC";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        return cursor;
    }

    db.close();
    return cursor;

}


public Cursor getSchoolInfoForCheckPoints(int minstyuNumber) {
    SQLiteDatabase db = this.getWritableDatabase();
    String ActionDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    String qq = "Select adminname , name from schoolmaster where ministryno = '" + minstyuNumber+"'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        return cursor;
    }

    db.close();
    return cursor;

}

public Cursor getBusInfoForCheckPoints(String flateNumber) {
    SQLiteDatabase db = this.getWritableDatabase();
    //String ActionDate =  new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault()).format(new Date());
    String qq = "Select FleetMaster.PlateNumber, FleetMaster.BusId, drivers.name from FleetMaster left join Schoolfleetdrivers on FleetMaster.fleetnumber = Schoolfleetdrivers.fleetnumber left join drivers on Schoolfleetdrivers.driverid = drivers.nationalid where FleetMaster.fleetnumber=" + flateNumber;
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        return cursor;
    }

    db.close();
    return cursor;

}

public int CheckPointLastDate(String fleetNumber, String Date) throws ParseException {
    int CheckPointID = 0;
    SQLiteDatabase db = this.getWritableDatabase();

    String ActionDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());


    String qq = "select MAX(CheckPointID) from CheckPoints where FleetNumber = " + fleetNumber + " and date(ActionDate)='" + ActionDate + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        CheckPointID = cursor.getInt(0) + 1;
    } else {
        CheckPointID = 1;
    }

    return CheckPointID;
}

public void addCheckPointLastDays(String fleetNumber, String NoOFStudents, String Location_Longitude, String Location_Latitude, String Date, int MistryNumber, int Answer) throws ParseException {

    SQLiteDatabase db = this.getWritableDatabase();
    String ActionDate = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss", Locale.getDefault()).format(new Date());

    ContentValues values = new ContentValues();
    values.put("FleetNumber", fleetNumber);
    values.put("CheckPointID", CheckPointLastDate(fleetNumber, Date));
    values.put("NoOFStudents", NoOFStudents);
    values.put("Location_Longitude", Location_Longitude);
    values.put("Location_Latitude", Location_Latitude);
    values.put("ActionDate", ActionDate);
    values.put("PathStatus", "Open");
    values.put("MistryNumber", MistryNumber);
    values.put("Rad", Answer);
    db.insert("CheckPoints",
            null,
            values);


    db.close();
}


public void endPath(String fleetNumber) {

    SQLiteDatabase db = this.getWritableDatabase();
    String ActionDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

    ContentValues values = new ContentValues();
    values.put("PathStatus", "Closed");
    db.update("CheckPoints",
            values, "date(ActionDate)" + "='" + ActionDate + "' " + " and FleetNumber =" + fleetNumber, null);
    db.close();
}


public Cursor getAllClosedPaths(String fleetNumber) throws ParseException {
    SQLiteDatabase db = this.getWritableDatabase();
    String ActionDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());


    String qq = "select CheckPointID, NoOFStudents, Location_Longitude, Location_Latitude, ActionDate ,MistryNumber , Rad from CheckPoints where FleetNumber = " + fleetNumber + " and date(ActionDate)='" + ActionDate + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        return cursor;
    }

    cursor.close();
    return cursor;
}


public Cursor getDriverInfo(String NAT) {
    SQLiteDatabase db = this.getWritableDatabase();
    String qq = "select name , nationalid , cell from drivers  where nationalid='" + NAT + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        return cursor;
    }

    return cursor;
}

public String getPathDate(String fleetNumber) throws ParseException {
    SQLiteDatabase db = this.getWritableDatabase();
    String ActionDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());


    String qq = "select  date(ActionDate)  from CheckPoints where FleetNumber = " + fleetNumber + " and date(ActionDate)='" + ActionDate + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        return cursor.getString(0);
    }

    cursor.close();
    return "null";
}


public String getPathStatus(String flateNumber) throws ParseException {
    SQLiteDatabase db = this.getWritableDatabase();
    String ActionDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());


    String qq = "select  PathStatus  from CheckPoints where FleetNumber = " + flateNumber + " and date(ActionDate)='" + ActionDate + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        return cursor.getString(0);
    }

    cursor.close();
    return "null";
}

public String CheckLogin(String user, String pass) throws ParseException {
    SQLiteDatabase db = this.getWritableDatabase();

    String qq = "select  code  from UsersMaster where code = '" + user + "' and password = '" + pass + "'";
    Cursor cursor = db.rawQuery(qq, null);

    if(cursor != null && cursor.moveToFirst()) {
        return cursor.getString(0);
    }

    cursor.close();
    db.close();
    return "0";

}





public String getNote(int section, String Date) {
    SQLiteDatabase db = this.getWritableDatabase();
    String qq = "select note from checklists where FleetPartsId = " + section + " and FleetCheckListsId =" + getFleetCheckListsIDforLastDays(Date);
    Cursor cursor = db.rawQuery(qq, null);
    if(cursor != null && cursor.moveToFirst()) {
        return cursor.getString(0);
    }
    cursor.close();
    db.close();
    return "0";
}

public Cursor isBusExists(int BusId) {
    String ActionDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    SQLiteDatabase db = this.getWritableDatabase();

    String qq = "select * from FleetCheckLists where BusId =" + BusId + " and date(ActionDate) = date('now')";
    Cursor cursor = db.rawQuery(qq, null);

    return cursor;
}


/// temp
public Cursor getAllFleetCheckList() {
    SQLiteDatabase db = this.getWritableDatabase();
    String Query = "select * from FleetCheckLists";
    Cursor cursor = db.rawQuery(Query, null);
    return cursor;
}

public Cursor getAllAnswer(int fleetCheckListid) {
    SQLiteDatabase db = this.getWritableDatabase();
    String Query = "select * from CheckLists where FleetCheckListsId="+fleetCheckListid;
    Cursor cursor = db.rawQuery(Query, null);
    return cursor;
}

}