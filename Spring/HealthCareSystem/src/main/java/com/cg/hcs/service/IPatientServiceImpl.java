package com.cg.hcs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hcs.dto.DiagnosticCenter;
import com.cg.hcs.dto.Patient;
import com.cg.hcs.dto.TestResult;
import com.cg.hcs.exception.PatientNotFoundException;
import com.cg.hcs.repository.IPatientRepository;
import com.cg.hcs.service.IPatientService;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class IPatientServiceImpl implements IPatientService {
	@Autowired
	private IPatientRepository repo;

	@Override
	public Patient registerPatient(Patient patient) {
		
		
	return 	repo.save(patient);
	}

	@Override
	public Patient updatePatientDetails(Patient patient) {
		
		
	Optional<Patient> existingPatient =	repo.findById(patient.getId());
	
	  if(existingPatient.isPresent())
	  {
		  return repo.save(patient);
	  }
	  else
	  {
		  throw new PatientNotFoundException("No Patient Found to Upadte");
	  }
	}

	

	@Override
	public List<TestResult> getAllTestResult(String patientUserName) {
		// TODO Auto-generated method stub
		List<TestResult> testResults = new ArrayList();
		testResults = ((IPatientService) repo).getAllTestResult(patientUserName);
		return testResults;
	}

	@Override
	public TestResult viewTestResult(int testResultId) {
		// TODO Auto-generated method stub
		TestResult result = new TestResult();
		result = ((IPatientService) repo).viewTestResult(testResultId);
		return result;
		
		
	}

	@Override
	public List<Patient> viewPatient(String patientUserName) {
		
		
		return repo.findByNameIgnoreCase(patientUserName);
	//	List<Patient> patientsList = repo.findAll();
	//	return patientsList.stream().filter(patient->patient.getName().equalsIgnoreCase(patientUserName)).collect(Collectors.toList());
	}
}
	
	