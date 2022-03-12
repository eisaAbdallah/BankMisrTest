package com.example.bankmisr.Test.service;

import com.example.bankmisr.Test.domain.PlotData;
import com.example.bankmisr.Test.domain.PlotDataConfig;
import com.example.bankmisr.Test.data.PlotModel;
import com.example.bankmisr.Test.domain.PlotModelConfigRepository;
import com.example.bankmisr.Test.domain.PlotModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PlotWritPlatformServiceImpl implements PlotWritPlatformService {
    private PlotModelConfigRepository plotModelConfigRepository;
    private PlotModelRepository plotModelRepository;
@Autowired
    public PlotWritPlatformServiceImpl(PlotModelRepository plotModelRepository,PlotModelConfigRepository plotModelConfigRepository) {
        this.plotModelRepository = plotModelRepository;
        this.plotModelConfigRepository=plotModelConfigRepository;
    }

    @Override
    @Transactional
    public void savePlot(PlotModel plotModel) {


        PlotDataConfig plotDataConfig= this.plotModelConfigRepository.findById(plotModel.getPlotDataConfig()).orElseThrow();


        PlotData plotData =new PlotData(plotModel.getPlotArea(),plotModel.getPlotLocation(),plotDataConfig);


      this.plotModelRepository.saveAndFlush(plotData);
    }

    @Override
    @Transactional
    public void editPlot(int id,PlotModel plotModel) {
        PlotData plotModelResult= this.plotModelRepository.findById(id).orElseThrow();

       if(plotModel.getPlotArea()!=null){ plotModelResult.setPlotArea(plotModel.getPlotArea());}
        if(plotModel.getPlotLocation()!=null){  plotModelResult.setPlotLocation(plotModel.getPlotLocation());}

        PlotDataConfig configurationResultData= this.plotModelConfigRepository.findById(plotModel.getPlotDataConfig()).orElseThrow();

        if(configurationResultData!=null){  plotModelResult.setPlotDataConfig(configurationResultData);}


            this.plotModelRepository.saveAndFlush(plotModelResult);

    }


}
