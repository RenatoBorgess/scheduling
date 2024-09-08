package com.schedulingservice.scheduling.service;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
@Component
public class FeeCalculatorImpl1 implements FeeCalculator {
    public static BigDecimal VALOR_ADICIONAL = new BigDecimal("3.00");
    public static BigDecimal PORCENTAGEM = new BigDecimal("2.5");
    public static int START_RANGE = 0;
    public static int END_RANGE = 0;

    public BigDecimal percentOf(BigDecimal percentage, BigDecimal total) {
        return percentage.multiply(total).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
    }
    @Override
    public BigDecimal calculateFee(BigDecimal amount) {
        BigDecimal porcentagem = percentOf(getPorcentagem(),amount);
            return amount.add(porcentagem).add(getValorAdicional());
    }

    @Override
    public int getStartRange() {
        return START_RANGE;
    }

    @Override
    public int getEndRange() {
        return END_RANGE;
    }

    @Override
    public BigDecimal getValorAdicional() {
        return VALOR_ADICIONAL;
    }

    @Override
    public BigDecimal getPorcentagem() {
        return PORCENTAGEM;
    }
}
