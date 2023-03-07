package com.example.employee.repository;

import com.example.employee.model.EducationHistoryModel;
import com.example.employee.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationHistoryRepository extends JpaRepository<EducationHistoryModel,Long> {

    List<EducationHistoryModel> findAllByEmployeeId(EmployeeModel employeeModel);

    EducationHistoryModel findByCode(String query);
}
