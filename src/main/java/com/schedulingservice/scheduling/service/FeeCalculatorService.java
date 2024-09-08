package com.schedulingservice.scheduling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
@Component
public class FeeCalculatorService {

    private List<FeeCalculator> listOfInterfaces;

    public FeeCalculatorService(List<FeeCalculator> listOfInterfaces){
        this.listOfInterfaces = listOfInterfaces;
    }
    public int diffDates(LocalDate startDate, LocalDate endDate){
        int diffDates = (int) DAYS.between(startDate,endDate);
        return diffDates;
    }
    public FeeCalculator getFeeCaulculator(LocalDate startDate, LocalDate endDate){
        for(FeeCalculator feeCalculator: listOfInterfaces){
            if(diffDates(startDate, endDate) >= feeCalculator.getStartRange() && diffDates( startDate, endDate) <= feeCalculator.getEndRange()) {
                return feeCalculator;
            }
        }
        throw new RuntimeException("Data out of range");
    }
}
