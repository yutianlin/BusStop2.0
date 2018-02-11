package com.example.android.busstop20;

import static android.R.attr.direction;

public class Locations extends Direction{

    private Integer StopID;
    private Integer stopNum;
    private String nickname;
    private Double latitude;
    private Double longitude;

    public Locations(){
    }

    public Locations(Integer StopID, Integer stopNum, String nickname, String properName,
                     Double latitude, Double longitude){
        this.StopID = StopID;
        this.stopNum = stopNum;
        this.nickname = nickname;
        this.properName = properName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters

    public Integer getID(){
        return StopID;
    }

    public Integer getStopNum(){
        return stopNum;
    }

    public String getNickname(){
        return nickname;
    }

//    public String getProperName(){
//        return properName;
//    }


    public Double getLatitude(){
        return latitude;
    }

    public Double getLongitude(){
        return longitude;
    }


    // Setters

    public void setID(Integer StopID){
        this.StopID = StopID;
    }

    public void setStopNum(Integer stopNum){
        this.stopNum = stopNum;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

//    public void setProperName(String properName){
//        this.properName = properName;
//    }

    public void setLatitude(Double latitude){
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude){
        this.longitude = longitude;
    }

}
