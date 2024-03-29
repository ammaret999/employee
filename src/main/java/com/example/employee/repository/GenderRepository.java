package com.example.employee.repository;

import com.example.employee.model.GenderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<GenderModel,Long> {

    GenderModel findByCode(String query);

    GenderModel findByGender(GenderModel query);
}
