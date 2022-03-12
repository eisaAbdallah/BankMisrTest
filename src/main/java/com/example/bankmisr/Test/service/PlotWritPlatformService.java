package com.example.bankmisr.Test.service;

import com.example.bankmisr.Test.data.PlotModel;

public interface PlotWritPlatformService {


    void savePlot(PlotModel plotModel);
    void editPlot(int id,PlotModel plotModel);

}
