package com.schedulingservice.scheduling.repository;

import com.schedulingservice.scheduling.entity.ScheduledTransfers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulesRepository extends JpaRepository<ScheduledTransfers, Integer> {
}
