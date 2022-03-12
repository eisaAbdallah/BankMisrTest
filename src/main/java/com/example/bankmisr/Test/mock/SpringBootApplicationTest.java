package com.example.bankmisr.Test.mock;

import com.example.bankmisr.Test.api.ApiIrrigationResource;
import com.example.bankmisr.Test.data.PlotConfigModel;
import com.example.bankmisr.Test.data.PlotModel;

import com.example.bankmisr.Test.domain.PlotDataConfig;
import com.example.bankmisr.Test.domain.PlotModelConfigRepository;
import com.example.bankmisr.Test.domain.PlotModelRepository;
import com.example.bankmisr.Test.service.PlotConfigWritPlatformService;
import com.example.bankmisr.Test.service.PlotReadPlatformService;
import com.example.bankmisr.Test.service.PlotWritPlatformService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.time.*;

import static java.time.ZoneOffset.UTC;
import static junit.framework.TestCase.assertEquals;

import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class SpringBootApplicationTest {
    @Autowired
    ApiIrrigationResource apiIrrigationResource;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private PlotWritPlatformService plotWritPlatformService;
    @MockBean
    private PlotReadPlatformService plotReadPlatformService;
    @MockBean
    private PlotModelRepository plotModelRepository;
    @MockBean
    private PlotConfigWritPlatformService plotConfigWritPlatformService;
    @MockBean
    private PlotModelConfigRepository plotModelConfigRepository;
    @Test
    public void addplot() throws Exception {
        ResponseEntity response = apiIrrigationResource.AddAplot(plotModel());
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        ObjectMapper map=new ObjectMapper();
        String jsonString= map.writeValueAsString(plotModel());

        this.mockMvc.perform(post("/addPlot").contentType(MediaType.APPLICATION_JSON).content(jsonString)).andExpect(status().isCreated());

    }


    @Test
    public void addcConfiguration() throws Exception {
        ObjectMapper map=new ObjectMapper();
        String jsonString= map.writeValueAsString(plotDataConfig());
        ResponseEntity response = apiIrrigationResource.addConfigurationOfPlot(plotDataConfigModel());
        assertEquals(response.getStatusCode(), HttpStatus.OK);


        this.mockMvc.perform(post("/addConfiguration").contentType(MediaType.APPLICATION_JSON).content(jsonString)).andExpect(status().isOk());

    }


 @Test
    public void editAplot() throws Exception {
ObjectMapper map=new ObjectMapper();
String jsonString= map.writeValueAsString(plotModel());
        ResponseEntity response = apiIrrigationResource.editAplot(plotModel(),plotModel().getId());
        assertEquals(response.getStatusCode(), HttpStatus.OK);


        this.mockMvc.perform(put("/editPlot/2").contentType(MediaType.APPLICATION_JSON).content(jsonString)).andExpect(status().isOk());
    }

    @Test
    public void sendRequestsToSensor() throws Exception {

        ObjectMapper map=new ObjectMapper();
        String jsonString= map.writeValueAsString(plotModel());
        ResponseEntity response = apiIrrigationResource.getAllPlotsScheduled();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        this.mockMvc.perform(get("/senesor").contentType(MediaType.APPLICATION_JSON).content(jsonString)).andExpect(status().isOk());


    }

  public PlotModel plotModel(){
      PlotModel plotModel=new PlotModel();
      plotModel.setPlotArea(2L);
      plotModel.setId(2);
      plotModel.setPlotArea(120L);
      plotModel.setPlotLocation("cairo");
      plotModel.setPlotDataConfig(2);

      return plotModel;


  }
    public PlotConfigModel plotDataConfigModel(){
        PlotConfigModel plotConfigModel=new PlotConfigModel();

        plotConfigModel.setId(2);

        plotConfigModel.setWaterAmount(300L);


          return plotConfigModel;


    }
    public PlotDataConfig plotDataConfig(){
        PlotDataConfig plotDataConfig=new PlotDataConfig();

        plotDataConfig.setId(2);


        plotDataConfig.setWaterAmount(300L);


        return plotDataConfig;


    }
}
