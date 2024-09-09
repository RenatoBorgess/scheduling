package com.schedulingservice.scheduling.service.feecalculator;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public interface FeeCalculator {

    public BigDecimal calculateFee(BigDecimal amount);
    public int getStartRange();
    public int getEndRange();

    public BigDecimal getValorAdicional();

    public BigDecimal getPorcentagem();
}
