package com.example.employee.repository;

import com.example.employee.model.EmployeeModel;
import com.example.employee.model.HistoryWorkModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryWorkRepository extends JpaRepository<HistoryWorkModel,Long> {
    List<HistoryWorkModel> findAllByEmployeeId(EmployeeModel employeeModel);

    HistoryWorkModel findByCode(String query);
}
