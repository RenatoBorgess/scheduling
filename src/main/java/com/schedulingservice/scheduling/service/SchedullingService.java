package com.schedulingservice.scheduling.service;

import com.schedulingservice.scheduling.dto.ScheduleResponse;
import com.schedulingservice.scheduling.dto.ScheduleRequest;
import com.schedulingservice.scheduling.entity.ScheduledTransfers;
import com.schedulingservice.scheduling.repository.SchedulesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchedullingService {

    List<ScheduleResponse> listOfSchedules = new ArrayList<>();

    private SchedulesRepository schedulesRepository;
    private FeeCalculatorService feeCalculatorService;


    public SchedullingService(SchedulesRepository schedulesRepository, FeeCalculatorService feeCalculatorService){
        this.schedulesRepository = schedulesRepository;
        this.feeCalculatorService = feeCalculatorService;
    }
    public List<ScheduleResponse> getAllTransfers(){
        List<ScheduledTransfers> list = schedulesRepository.findAll();
        List<ScheduleResponse> dtoList = new ArrayList<>();
        for (ScheduledTransfers st: list){
            ScheduleResponse newScheduleDTO = new ScheduleResponse();
            BeanUtils.copyProperties(st, newScheduleDTO);
            dtoList.add(newScheduleDTO);
        }
        return dtoList;

    }
    public ScheduleResponse scheduleTransfer(ScheduleRequest scheduleRequest){

        FeeCalculator feeCalculator = feeCalculatorService.getFeeCaulculator(scheduleRequest.getDateOfSchedule(),scheduleRequest.getDateOfTransfer());
        BigDecimal fee = feeCalculator.calculateFee(scheduleRequest.getAmount());

        ScheduledTransfers scheduledTransfer = new ScheduledTransfers();

        BeanUtils.copyProperties(scheduleRequest,scheduledTransfer);
        scheduledTransfer.setFee(fee);

        ScheduledTransfers st = schedulesRepository.save(scheduledTransfer);
        ScheduleResponse scheduleResponse = new ScheduleResponse();
        BeanUtils.copyProperties(st, scheduleResponse);



        return scheduleResponse;
    }
    public void cancelTransfer(ScheduledTransfers scheduledTransfer){
        schedulesRepository.delete(scheduledTransfer);
    }
}
