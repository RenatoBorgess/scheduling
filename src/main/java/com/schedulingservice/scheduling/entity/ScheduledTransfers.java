package com.schedulingservice.scheduling.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class
ScheduledTransfers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int originAccount;
    private int targetAccount;
    private BigDecimal amount;
    private LocalDate dateOfTransfer;
    private LocalDate dateOfSchedule;
    private BigDecimal fee;
}
