package com.example.android.busstop20;

public class Direction {

    protected Integer StopID;
    protected String properName;

    // Getters

    public Integer getDestinationID(){
        return StopID;
    }

    public String getProperName(){
        return properName;
    }

    // Setters

    public void setID(Integer StopID){
        this.StopID = StopID;
    }

    public void setProperName(String properName){
        this.properName = properName;
    }
}
