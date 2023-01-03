package com.cg.hcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hcs.dto.Patient;
import com.cg.hcs.dto.TestResult;
import com.cg.hcs.service.IPatientService;
@RestController
@RequestMapping("/patient")
public class IPatientController {
	@Autowired
	private IPatientService service;

	@PostMapping(value = "/register")
	public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
		Patient patient2 = service.registerPatient(patient);
		return ResponseEntity.ok().body(patient2);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Patient> updateDiagnosticCenter(@RequestBody Patient patient)
			throws Exception {
		Patient pat = service.updatePatientDetails(patient);
		return ResponseEntity.ok().body(pat);
	}

	@GetMapping(value = "/viewpatientsByName/{name}")
	public ResponseEntity<List<Patient>> viewPatient(@PathVariable String name) throws Exception {
	
		return ResponseEntity.ok().body(service.viewPatient(name));
	}

	@GetMapping(value = "/patient/{name}/results")
	public ResponseEntity<List<TestResult>> getAllTestResult(@PathVariable String name) throws Exception {
		List<TestResult> result = service.getAllTestResult(name);
		return ResponseEntity.ok().body(result);
	}
	@GetMapping(value = "/patient/testresult/{id}")
	public ResponseEntity<TestResult> viewPatient(@PathVariable int id) throws Exception {
		TestResult res = service.viewTestResult(id);
		return ResponseEntity.ok().body(res);
	}

}



