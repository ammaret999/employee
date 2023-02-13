package com.example.employee.repository;

import com.example.employee.model.EducationHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationHistoryRepository extends JpaRepository<EducationHistoryModel,Long> {

}
