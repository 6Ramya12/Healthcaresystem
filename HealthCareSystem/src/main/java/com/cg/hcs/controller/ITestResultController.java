package com.cg.hcs.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hcs.dto.Patient;
import com.cg.hcs.dto.TestResult;
import com.cg.hcs.service.ITestResultService;
@RestController
@RequestMapping("/test")
public class ITestResultController {
	@Autowired
	
	private ITestResultService iTestResultService;

	@PostMapping("/addtestresult")
	public ResponseEntity<TestResult> addTestResult(@RequestBody TestResult testResult){
		TestResult tr=iTestResultService.addTestResult(testResult);
		ResponseEntity<TestResult> responseEntity=new ResponseEntity<>(tr,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/removetestresult/{id}")
	public ResponseEntity<TestResult> removeTestResult(@PathVariable("id") int trId){
		TestResult tr=iTestResultService.removeTestResult(trId);
		ResponseEntity<TestResult> responseEntity=new ResponseEntity<>(tr,HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping("/updatetestresult")
	public ResponseEntity<TestResult> updateResult(@RequestBody TestResult testResult){
		TestResult tr=iTestResultService.updateTestResult(testResult);
		ResponseEntity<TestResult> responseEntity=new ResponseEntity<>(tr,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/viewresultsbypatient")
	public ResponseEntity<Set<TestResult>> viewResultsByPatient(@RequestBody Patient patient){
		Set<TestResult> tr=iTestResultService.viewResultsByPatient(patient);
		ResponseEntity<Set<TestResult>> responseEntity=new ResponseEntity<>(tr,HttpStatus.OK);
		return responseEntity;
	}
}


