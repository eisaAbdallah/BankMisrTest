package com.example.bankmisr.Test.domain;

import com.example.bankmisr.Test.domain.PlotData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlotModelRepository extends JpaRepository<PlotData,Integer> {
}
