package com.example.android.busstop20;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class BusData extends SQLiteOpenHelper{

    // Logcat name
    private static final String LOG = BusData.class.getName();

    // Database Info
    private static final String DATABASE_NAME = "Bus_Stops";
    private static final int DATABASE_VERSION = 1;

    // Location Table
    private static final String TABLE_LOCATION = "Stop_Locations";
    private static final String BUS_STOP_NUM = "Bus_Stop_Number";
    private static final String NICK = "Nickname";
    private static final String LONG = "Longitude";
    private static final String LAT = "Latitude";

    // Buses Table
    private static final String TABLE_BUSES = "Buses";
    private static final String BUS_NUM = "Bus_Number";

    // Direction Table
    private static final String TABLE_DIRECTION = "Direction";

    // Bus Location Table
    private static final String TABLE_BUS_LOCATION = "Bus_Location";
    private static final String ID_BUS = "Bus_ID";
    private static final String ID_START_LOCATION = "Start_Location_ID";
    private static final String ID_DIRECTION = "Stop_Location_ID";

    // Common Column Names Location and Direction Table
    private static final String PROP = "Proper_Name";

    // Common Column Names
    private static final String ID = "ID";

    public BusData(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //EFFECTS: Creates four tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createLocationsTable());
        db.execSQL(createBusesTable());
        db.execSQL(createDirectionTable());
        db.execSQL(createBusLocationTable());
    }

    // EFFECTS: returns SQL statement to create the locations table
    private String createLocationsTable(){
        String myDB = "CREATE TABLE " + TABLE_LOCATION + "("
                + ID + " INTEGER PRIMARY KEY," + BUS_STOP_NUM + "INT,"
                + NICK + " TEXT," + PROP + "TEXT," + LONG + " DOUBLE," +
                LAT + "DOUBLE" + ")";
        return myDB;
    }

    // EFFECTS: returns SQL statement to create the Direction table
    private String createDirectionTable(){
        String myDB = "CREATE TABLE " + TABLE_DIRECTION + "("
                + ID + " INTEGER PRIMARY KEY," + PROP + "TEXT" + ")";
        return myDB;
    }

    // EFFECTS: returns SQL statement to create the buses table
    private String createBusesTable(){
        String myDB = "CREATE TABLE " + TABLE_BUSES + "("
                + ID + " INTEGER PRIMARY KEY," + BUS_NUM + "SMALLINT" + ")";
        return myDB;
    }

    // EFFECTS: returns SQL statement to create the bus location table
    private String createBusLocationTable(){
        String myDB = "CREATE TABLE " + TABLE_BUS_LOCATION + "("
                + ID + " INTEGER PRIMARY KEY," + ID_BUS + "INT," + ID_START_LOCATION
                + "INT," + ID_DIRECTION + "INT" + ")";
        return myDB;
    }

    //EFFECTS: Replaces old database if it exists
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUSES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUS_LOCATION);
        onCreate(db);
    }

    // EFFECTS: Creates new destination in Direction table
    public long newDestination(Direction direction){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PROP, direction.getProperName());
        return db.insert(TABLE_DIRECTION, null, values);
    }

    // EFFECTS: Updates selected destination in Direction table
    public int updateDestination(Direction direction){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PROP, direction.getProperName());
        return db.update(TABLE_DIRECTION, values, ID + " = ?",
                new String[] {String.valueOf(direction.getDestinationID())});
    }

    // EFFECTS: Deletes selected destination in Direction table
    public int deleteDestination(Direction direction){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_DIRECTION, ID + " = ?",
                new String[] {String.valueOf(direction.getDestinationID())});
    }

    // EFFECTS: Returns list of all destinations in Direction table
    public ArrayList<Direction> selectAllDirection(){
        ArrayList<Direction> directions = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_DIRECTION;
        Log.e(LOG, query);
        Cursor cursor = db.rawQuery(query, null);
        for (cursor.moveToFirst(); cursor.isAfterLast(); cursor.moveToNext()){
            Direction direction = new Direction();
            direction.setID(cursor.getInt(cursor.getColumnIndex(ID)));
            direction.setProperName(cursor.getString(cursor.getColumnIndex(PROP)));
            directions.add(direction);
        }
        return directions;
    }

    // EFFECTS: Creates new bus in Buses Table
    public long newBus(Buses bus){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BUS_NUM, bus.getBusNum());
        return db.insert(TABLE_BUSES, null, values);
    }

    // EFFECTS: Updates selected bus in Buses Table
    public int updateBus(Buses bus){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BUS_NUM, bus.getBusNum());
        return db.update(TABLE_BUSES, values, ID + " = ?",
                new String[] {String.valueOf(bus.getbusID())});
    }

    // EFFECTS: Deletes selected bus from Buses Table
    public int deleteBus(Buses bus){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_BUSES, ID + " = ?",
                new String[] {String.valueOf(bus.getbusID())});
    }

    // EFFECTS: returns a list of all buses from Buses Table
    public ArrayList<Buses> selectAllBuses(){
        ArrayList<Buses> buses = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_BUSES;
        Log.e(LOG, query);
        Cursor cursor = db.rawQuery(query, null);
        for (cursor.moveToFirst(); cursor.isAfterLast(); cursor.moveToNext()){
            Buses bus = new Buses();
            bus.setBusID(cursor.getInt(cursor.getColumnIndex(ID)));
            bus.setBusNum(cursor.getInt(cursor.getColumnIndex(BUS_NUM)));
            buses.add(bus);
        }
        return buses;
    }

    // EFFECTS: Creates new location in Location Table
    public long newLocation(Locations location){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BUS_STOP_NUM, location.getStopNum());
        values.put(NICK, location.getNickname());
        values.put(PROP, location.getProperName());
        values.put(LAT, location.getLatitude());
        values.put(LONG, location.getLongitude());

        return db.insert(TABLE_LOCATION, null, values);
    }

    // EFFECTS: Updates selected location in Location Table
    public int updateLocation(Locations location){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BUS_STOP_NUM, location.getStopNum());
        values.put(NICK, location.getNickname());
        values.put(PROP, location.getProperName());
        values.put(LAT, location.getLatitude());
        values.put(LONG, location.getLongitude());

        return db.update(TABLE_LOCATION, values, ID + "= ?",
                new String[] {String.valueOf(location.getDestinationID())});
    }

    //EFFECTS: Deletes selected location from Location Table
    public int deleteLocation(Locations location){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_LOCATION, ID + " = ?",
                new String[] {String.valueOf(location.getDestinationID())});
    }

    //EFFECTS: returns a list of all Locations from Locations Table
    public ArrayList<Locations> selectAllLocations(){
        ArrayList<Locations> locations = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_LOCATION;
        Log.e(LOG, query);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            Locations location = new Locations();
            location.setID(cursor.getInt(cursor.getColumnIndex(ID)));
            location.setStopNum(cursor.getInt(cursor.getColumnIndex(BUS_STOP_NUM)));
            location.setNickname(cursor.getString(cursor.getColumnIndex(NICK)));
            location.setProperName(cursor.getString(cursor.getColumnIndex(PROP)));
            location.setLatitude(cursor.getDouble(cursor.getColumnIndex(LAT)));
            location.setLongitude(cursor.getDouble(cursor.getColumnIndex(LONG)));
            locations.add(location);
        }

        return locations;
    }

}
