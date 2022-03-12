package com.example.bankmisr.Test.service;

import com.example.bankmisr.Test.domain.PlotData;

import java.util.List;
import java.util.Set;

public interface PlotReadPlatformService {

    Set<PlotData> getAllPlotSchedueled();
    List<PlotData> getAllPlots();
}
