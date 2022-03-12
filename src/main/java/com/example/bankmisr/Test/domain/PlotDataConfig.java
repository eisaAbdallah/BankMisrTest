package com.example.bankmisr.Test.domain;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name="irrigation_period_details")
public class PlotDataConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
    @Column(name="water_amount")
    Long waterAmount;
    @Column(name="time_slot")
    LocalTime timeSlot;
    public PlotDataConfig( ) {}
    public PlotDataConfig( LocalTime timeSlot,Long waterAmount) {

        this.waterAmount = waterAmount;
        this.timeSlot = timeSlot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(Long waterAmount) {
        this.waterAmount = waterAmount;
    }

    public LocalTime getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(LocalTime timeSlot) {
        this.timeSlot = timeSlot;
    }
}
