package com.example.android.busstop20;

public class Locations {

    private int ID;
    private int stopNum;
    private String nickname;
    private String properName;
    private double latitude;
    private double longitude;

    public Locations(int ID, int stopNum, String nickname, String properName,
                     double latitude, double longitude){
        this.ID = ID;
        this.stopNum = stopNum;
        this.nickname = nickname;
        this.properName = properName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters

    public int getID(){
        return ID;
    }

    public int getStopNum(){
        return stopNum;
    }

    public String getNickname(){
        return nickname;
    }

    public String getProperName(){
        return properName;
    }

    public double getLatitude(){
        return latitude;
    }

    public double getLongitude(){
        return longitude;
    }


    // Setters

    public void setStopNum(byte stopNum){
        this.stopNum = stopNum;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public void setProperName(String properName){
        this.properName = properName;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

}
