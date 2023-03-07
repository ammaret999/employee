package com.example.employee.repository;

import com.example.employee.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentModel,Long> {
    DepartmentModel findByCode(String query);
}
