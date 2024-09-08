package com.schedulingservice.scheduling.controller;

import com.schedulingservice.scheduling.dto.ScheduleResponse;
import com.schedulingservice.scheduling.dto.ScheduleRequest;
import com.schedulingservice.scheduling.service.SchedullingService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/scheduling")
public class ScheduleController {
    SchedullingService schedullingService;
    public ScheduleController(SchedullingService schedullingService){
        this.schedullingService = schedullingService;
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping()
    public ScheduleResponse scheduleTransferAttempt(@RequestBody ScheduleRequest scheduleRequest) {
        return schedullingService.scheduleTransfer(scheduleRequest);
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})

    public List<ScheduleResponse> getAllScheduledTransfers() {
        System.out.println(schedullingService.getAllTransfers());
        return schedullingService.getAllTransfers();
    }

}
