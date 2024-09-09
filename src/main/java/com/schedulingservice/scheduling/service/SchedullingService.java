package com.schedulingservice.scheduling.service;

import com.schedulingservice.scheduling.dto.ScheduleResponse;
import com.schedulingservice.scheduling.dto.ScheduleRequest;
import com.schedulingservice.scheduling.entity.ScheduledTransfers;
import com.schedulingservice.scheduling.repository.SchedulesRepository;
import com.schedulingservice.scheduling.service.feecalculator.FeeCalculator;
import com.schedulingservice.scheduling.service.feecalculator.FeeCalculatorService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchedullingService {


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
            ScheduleResponse newScheduleDTO = fromEntityToResponse(st);
            dtoList.add(newScheduleDTO);
        }
        return dtoList;

    }
    public ScheduleResponse scheduleTransfer(ScheduleRequest scheduleRequest){

        FeeCalculator feeCalculator = feeCalculatorService.getFeeCaulculator(scheduleRequest.getDateOfSchedule(),scheduleRequest.getDateOfTransfer());

        ScheduledTransfers scheduledTransfer = fromRequestToEntity(scheduleRequest);
        scheduledTransfer.setFee(feeCalculator.calculateFee(scheduledTransfer.getAmount()));
        ScheduledTransfers st = schedulesRepository.save(scheduledTransfer);

        ScheduleResponse scheduleResponse = fromEntityToResponse(st);

        return scheduleResponse;
    }
    public ScheduledTransfers fromRequestToEntity(ScheduleRequest request){
        ScheduledTransfers scheduledTransfer = new ScheduledTransfers();
        BeanUtils.copyProperties(request,scheduledTransfer);
        return scheduledTransfer;
    }
    public ScheduleResponse fromEntityToResponse(ScheduledTransfers scheduledTransfer) {
        ScheduleResponse scheduleResponse = new ScheduleResponse();
        BeanUtils.copyProperties(scheduledTransfer, scheduleResponse);
        return scheduleResponse;
    }
}
