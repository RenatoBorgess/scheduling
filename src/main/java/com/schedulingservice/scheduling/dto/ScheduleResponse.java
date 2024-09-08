package com.schedulingservice.scheduling.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class ScheduleResponse {
    private Integer id;
    private int originAccount;
    private int targetAccount;
    private BigDecimal fee;
    private BigDecimal amount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfTransfer;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfSchedule;
}



