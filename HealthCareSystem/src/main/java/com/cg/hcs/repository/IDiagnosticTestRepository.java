package com.cg.hcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hcs.dto.DiagnosticTest;

public interface IDiagnosticTestRepository extends JpaRepository<DiagnosticTest, Integer> {

}
