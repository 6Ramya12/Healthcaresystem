package com.cg.hcs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hcs.dto.Patient;
import com.cg.hcs.dto.TestResult;

public interface IPatientRepository extends JpaRepository<Patient,Integer> {


	public List<Patient> findByNameIgnoreCase(String name);
	

}
