package com.cg.hcs.service;

import java.util.Set;



import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hcs.dto.Patient;
import com.cg.hcs.dto.TestResult;
import com.cg.hcs.exception.NotFoundException;
import com.cg.hcs.exception.NotFoundException;
import com.cg.hcs.repository.IPatientRepository;
import com.cg.hcs.repository.ITestResultRepository;
@Service
public class ITestResultServiceImpl implements ITestResultService {

	@Autowired
	private ITestResultRepository iTestResultRepository;

	@Autowired
	private IPatientRepository iPatientRepository;
	 /*@author :
	 * @return :Diagnostic Test
	 * @description :This method get tests of diagnostic center to the repository and return test 
	 */


	@Override
	public TestResult addTestResult(TestResult tr) {
		return iTestResultRepository.save(tr);
	}

	@Override
	public TestResult removeTestResult(int id) {
		Optional<TestResult> optionalTestResult = iTestResultRepository.findById(id);
		if (optionalTestResult.isEmpty()) {
			throw new NotFoundException("There is no Test Result for the Id: " + id);
		}
		TestResult testResult = optionalTestResult.get();
		iTestResultRepository.deleteById(id);
		return testResult;
	}

	@Override
	public TestResult updateTestResult(TestResult tr) {
		Optional<TestResult> optionalTestResult = iTestResultRepository.findById(tr.getId());
		if (optionalTestResult.isEmpty()) {
			throw new NotFoundException("There is no such Result to update");
		}
		return iTestResultRepository.save(tr);
	}

	@Override
	public Set<TestResult> viewResultsByPatient(Patient patient) {
		Optional<Patient> optionalPatient = iPatientRepository.findById(patient.getId());
		if (optionalPatient.isEmpty()) {
			throw new NotFoundException("There is no such Patient");
		}

		return null;
	}

} 
	


