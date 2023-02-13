package com.example.employee.repository;

import com.example.employee.model.LevelModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<LevelModel,Long> {
}
