package com.cg.hcs.service;

import java.util.Set;

import com.cg.hcs.dto.Patient;
import com.cg.hcs.dto.TestResult;

public interface ITestResultService {
	public TestResult addTestResult(TestResult tr);
	public TestResult removeTestResult(int id);
	public TestResult updateTestResult(TestResult tr);
	public Set<TestResult> viewResultsByPatient(Patient patient);


}
