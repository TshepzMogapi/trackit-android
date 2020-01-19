package com.example.trackit;

public class Trip {

    private String startLocation;
    private String endLocation;

    private double startTime;
    private double endTime;


    public Trip() {

    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getStartTime(){
        return this.startTime;
    }


    public double getElapsedTime(String startTime, String endTime) {
        return 10.0;
    }
}
