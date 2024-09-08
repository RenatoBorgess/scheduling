package com.schedulingservice.scheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleRequest {
    private int originAccount;
    private int targetAccount;
    private BigDecimal amount;
    private LocalDate dateOfTransfer;
    private LocalDate dateOfSchedule;

}
