package com.example.bankmisr.Test.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class PlotModel  {
    int id;
    Long plotArea;
    String plotLocation;
    int plotDataConfig;
    public PlotModel( Long plotArea, String plotLocation,int plotDataConfig) {

        this.plotDataConfig=plotDataConfig;
        this.plotArea = plotArea;
        this.plotLocation = plotLocation;


    }
    public PlotModel( Long plotArea, String plotLocation) {

        this.plotArea = plotArea;
        this.plotLocation = plotLocation;


    }
    public PlotModel() {


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPlotLocation() {
        return plotLocation;
    }

    public void setPlotLocation(String plotLocation) {
        this.plotLocation = plotLocation;
    }


    public Long getPlotArea() {
        return plotArea;
    }

    public void setPlotArea(Long plotArea) {
        this.plotArea = plotArea;
    }

    public Integer getPlotDataConfig() {
        return plotDataConfig;
    }

    public void setPlotDataConfig(Integer plotDataConfig) {
        this.plotDataConfig = plotDataConfig;
    }
}
