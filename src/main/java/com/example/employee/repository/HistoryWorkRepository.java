package com.example.employee.repository;

import com.example.employee.model.HistoryWorkModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryWorkRepository extends JpaRepository<HistoryWorkModel,Long> {
}
