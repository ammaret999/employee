package com.example.employee.repository;

import com.example.employee.model.CertificateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<CertificateModel,Long> {
}
