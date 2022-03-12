package com.example.bankmisr.Test.domain;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name="plot_data")
public class PlotData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
    @Column(name="plot_area")
    Long plotArea;
    @Column(name="plot_location")
    String plotLocation;
    @Column(name="is_Active")
    boolean isActive;
    @Column(name="time_of_last_irrigation")
    LocalTime timeOfLastIrrigation;
    @Column(name="irrigattion_required")
    boolean irrigationRequired;
    @JoinColumn(name="irrigation_id")
    @ManyToOne
    PlotDataConfig plotDataConfig;

    public PlotData() {}
    public PlotData(Long plotArea, String plotLocation,PlotDataConfig plotDataConfig,LocalTime timeOfLastIrrigation,boolean irrigationRequired) {
        this.id = id;
        this.plotDataConfig = plotDataConfig;
        this.plotArea = plotArea;
        this.plotLocation = plotLocation;
        this.timeOfLastIrrigation=timeOfLastIrrigation;
        this.irrigationRequired=irrigationRequired;
    }
    public PlotData(int id,Long plotArea, String plotLocation,PlotDataConfig plotDataConfig) {
        this.id = id;
          this.plotArea = plotArea;
        this.plotLocation = plotLocation;
        this.plotDataConfig=plotDataConfig;

    }
    public PlotData(Long plotArea, String plotLocation,PlotDataConfig plotDataConfig) {
        this.id = id;
        this.plotArea = plotArea;
        this.plotLocation = plotLocation;
        this.plotDataConfig=plotDataConfig;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getPlotArea() {
        return plotArea;
    }

    public void setPlotArea(Long plotArea) {
        this.plotArea = plotArea;
    }

    public String getPlotLocation() {
        return plotLocation;
    }

    public void setPlotLocation(String plotLocation) {
        this.plotLocation = plotLocation;
    }

    public PlotDataConfig getPlotDataConfig() {
        return plotDataConfig;
    }

    public void setPlotDataConfig(PlotDataConfig plotDataConfig) {
        this.plotDataConfig = plotDataConfig;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalTime getTimeOfLastIrrigation() {
        return timeOfLastIrrigation;
    }

    public void setTimeOfLastIrrigation(LocalTime timeOfLastIrrigation) {
        this.timeOfLastIrrigation = timeOfLastIrrigation;
    }

    public boolean isIrrigationRequired() {
        return irrigationRequired;
    }

    public void setIrrigationRequired(boolean irrigationRequired) {
        this.irrigationRequired = irrigationRequired;
    }
}
