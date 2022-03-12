package com.example.bankmisr.Test.service;

import com.example.bankmisr.Test.domain.PlotData;
import com.example.bankmisr.Test.domain.PlotDataConfig;
import com.example.bankmisr.Test.domain.PlotModelConfigRepository;
import com.example.bankmisr.Test.domain.PlotModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PlotReadPlatformServiceImp implements PlotReadPlatformService {
    private PlotModelRepository plotModelRepository;
    private PlotModelConfigRepository plotModelConfigRepository;
    @Autowired
    public PlotReadPlatformServiceImp(PlotModelRepository plotModelRepository,PlotModelConfigRepository plotModelConfigRepository) {
        this.plotModelRepository = plotModelRepository;
        this.plotModelConfigRepository=plotModelConfigRepository;
    }



    @Override
    @Transactional
    public List<PlotData> getAllPlots( ) {

        List<PlotData>plotDataList=this.plotModelRepository.findAll();

        return plotDataList;
    }
    @Override
    @Transactional
    public Set<PlotData> getAllPlotSchedueled() {
        List<PlotData>plotDataList=this.plotModelRepository.findAll();
Set<PlotData> plotDataSet=new HashSet<>();

for(PlotData result:plotDataList){

    PlotDataConfig configurationResultData= this.plotModelConfigRepository.findById(result.getPlotDataConfig().getId()).orElseThrow();

    PlotData plotData=new PlotData(result.getId(),result.getPlotArea(),result.getPlotLocation(),configurationResultData);

    plotDataSet.add(plotData);
}


        return plotDataSet;
    }
}
