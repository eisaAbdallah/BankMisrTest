package com.example.bankmisr.Test.service;

import com.example.bankmisr.Test.data.PlotConfigModel;
import com.example.bankmisr.Test.domain.PlotDataConfig;
import com.example.bankmisr.Test.domain.PlotModelConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PlotConfigWritPlatformServiceImpl implements PlotConfigWritPlatformService {

    private PlotModelConfigRepository plotModelConfigRepository;
@Autowired
    public PlotConfigWritPlatformServiceImpl(PlotModelConfigRepository plotModelConfigRepository) {
        this.plotModelConfigRepository = plotModelConfigRepository;
    }


    @Override
    @Transactional
    public void savePlotConfig(PlotConfigModel plotConfigModel) {
        PlotDataConfig plotDataConfig=new PlotDataConfig(plotConfigModel.getTimeSlot(),plotConfigModel.getWaterAmount());
           this.plotModelConfigRepository.saveAndFlush(plotDataConfig);


            }
}
