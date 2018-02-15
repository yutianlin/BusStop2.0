package com.example.android.busstop20;

public class Buses{

    private Integer busID;
    private Integer busNum;

    public Buses(){

    }

    public Buses(Integer busID, Integer busNum){
        this.busID = busID;
        this.busNum = busNum;
    }

    // Getters

    public long getbusID(){
        return busID;
    }

    public Integer getBusNum(){
        return busNum;
    }

    // Setters

    public void setBusID(Integer busID){
        this.busID = busID;
    }

    public void setBusNum(Integer busNum){
        this.busNum = busNum;
    }
}
