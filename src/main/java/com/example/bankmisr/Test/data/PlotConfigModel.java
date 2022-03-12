package com.example.bankmisr.Test.data;


import java.time.LocalTime;

public class PlotConfigModel {
    int id;
LocalTime timeSlot;
    Long waterAmount;

    public PlotConfigModel( LocalTime timeSlot, Long waterAmount) {

        this.timeSlot = timeSlot;
        this.waterAmount = waterAmount;
    }
    public PlotConfigModel( ) {
;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(LocalTime timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Long getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(Long waterAmount) {
        this.waterAmount = waterAmount;
    }
}
