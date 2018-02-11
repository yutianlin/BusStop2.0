package com.example.android.busstop20;

public class Buses {
    private int ID;
    private short busNum;

    public Buses(int ID, short busNum){
        this.ID = ID;
        this.busNum = busNum;
    }

    // Getters

    public int getID(){
        return ID;
    }

    public short getBusNum(){
        return busNum;
    }

    // Setters

    public void setBusNum(short busNum){
        this.busNum = busNum;
    }
}
