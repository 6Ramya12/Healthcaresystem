package com.cg.hcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hcs.dto.DiagnosticCenter;

public interface IDiagnosticCenterRepository extends JpaRepository<DiagnosticCenter,Integer> {
	//List<Appointment> findByCenterName(String centerName);
	DiagnosticCenter findByName(String name);
	 

}
