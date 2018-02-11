package com.example.android.busstop20;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BusData extends SQLiteOpenHelper{

    // Database Info
    private static final String DATABASE_NAME = "Bus_Stops";
    private static final int DATABASE_VERSION = 1;

    // Location Table
    private static final String TABLE_LOCATION = "Stop_Locations";
    private static final String BUS_STOP_NUM = "Bus_Stop_Number";
    private static final String NICK = "Nickname";
    private static final String PROP = "Proper_Name";
    private static final String LONG = "Longitude";
    private static final String LAT = "Latitude";

    // Buses Table
    private static final String TABLE_BUSES = "Buses";
    private static final String BUS_NUM = "Bus_Number";

    // Bus Location Table
    private static final String TABLE_BUS_LOCATION ="Bus_Location";
    private static final String LATITUDE = "Latitude";
    private static final String LONGITUDE = "Longitude";

    // Common Column Names
    private static final String ID = "ID";



    public BusData(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //EFFECTS: Creates a database with given fields and data types, auto generated IDs
    @Override
    public void onCreate(SQLiteDatabase db) {
        String myDB = "CREATE TABLE " + DATABASE_NAME + "("
        + ID + " INTEGER PRIMARY KEY," + BUS_NUM + " SMALLINT," + BUS_STOP_NUM + "SMALLINT,"
                + NICK_FROM + " TEXT," + PROP_FROM + "TEXT," + PROP_TO + "TEXT,"
                + LONG + " DECIMAL(9,6)," + LAT + "DECIMAL(9,6)" + ")";
        db.execSQL(myDB);
    }

    //EFFECTS: Replaces old database if it exists
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(db);
    }


}
