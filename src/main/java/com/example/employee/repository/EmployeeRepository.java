package com.example.employee.repository;

import com.example.employee.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel,Long> {

    EmployeeModel findByCode(String code);
    @Query(value = "SELECT e FROM EmployeeModel e WHERE e.firstName LIKE CONCAT('%',:query3,'%') OR e.lastName LIKE CONCAT('%',:query3,'%')")
    List<EmployeeModel> searchEmployee(String query3);

}
