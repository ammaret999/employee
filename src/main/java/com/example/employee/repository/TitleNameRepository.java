package com.example.employee.repository;

import com.example.employee.model.EmployeeModel;
import com.example.employee.model.TitleNameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleNameRepository extends JpaRepository<TitleNameModel,Long> {
    TitleNameModel findByCode(String query);
}
