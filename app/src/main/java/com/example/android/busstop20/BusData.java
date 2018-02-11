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
    private static final String TABLE_BUS_LOCATION = "Bus_Location";
    private static final String ID_BUS = "Bus_ID";
    private static final String ID_START_LOCATION = "Start_Location_ID";
    private static final String ID_STOP_LOCATION = "Stop_Location_ID";

    // Common Column Names
    private static final String ID = "ID";



    public BusData(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //EFFECTS: Creates a database with given fields and data types, auto generated IDs
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createLocationsTable());
        db.execSQL(createBusesTable());
        db.execSQL(createBusLocationTable());
    }

    private String createLocationsTable(){
        String myDB = "CREATE TABLE " + TABLE_LOCATION + "("
                + ID + " INTEGER PRIMARY KEY," + BUS_STOP_NUM + "INT,"
                + NICK + " TEXT," + PROP + "TEXT," + LONG + " DECIMAL(9,6)," +
                LAT + "DECIMAL(9,6)" + ")";
        return myDB;
    }

    private String createBusesTable(){
        String myDB = "CREATE TABLE " + TABLE_BUSES + "("
                + ID + " INTEGER PRIMARY KEY," + BUS_NUM + "SMALLINT" + ")";
        return myDB;
    }

    private String createBusLocationTable(){
        String myDB = "CREATE TABLE " + TABLE_BUS_LOCATION + "("
                + ID + " INTEGER PRIMARY KEY," + ID_BUS + "INT," + ID_START_LOCATION
                + "INT," + ID_STOP_LOCATION + "INT" + ")";
        return myDB;
    }

    //EFFECTS: Replaces old database if it exists
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(db);
    }



}
