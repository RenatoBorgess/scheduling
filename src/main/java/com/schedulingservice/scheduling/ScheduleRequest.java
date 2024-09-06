package com.schedulingservice.scheduling;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ScheduleRequest {
    private int originAccount;
    private int targetAccount;
    private BigDecimal amount;
    private LocalDate dateOfTransfer;
    private LocalDate dateOfSchedule;
    private float fee;
}
