package com.example.employee.repository;

import com.example.employee.model.PositionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<PositionModel,Long> {
    PositionModel findByCode(String query);
}
