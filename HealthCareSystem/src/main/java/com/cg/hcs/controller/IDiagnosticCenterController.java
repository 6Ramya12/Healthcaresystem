package com.cg.hcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hcs.dto.DiagnosticCenter;
import com.cg.hcs.exception.DiagnosticCenterException;
import com.cg.hcs.service.IDiagnosticCenterServiceImpl;

@RestController
@RequestMapping("/diagnostic_center")
public class IDiagnosticCenterController {
	@Autowired
	IDiagnosticCenterServiceImpl service;

	@GetMapping("/centers")
	public List<DiagnosticCenter>getAllDiagnosticCenters(){

		List<DiagnosticCenter> centers = service.getAllDiagnosticCenters();
		return centers;
	}

	@PostMapping("/addcenter")
	public DiagnosticCenter addDiagnosticCenter( @RequestBody DiagnosticCenter diagnosticCenter) {
	     service.addDiagnosticCenter(diagnosticCenter);
		return diagnosticCenter;
	}

	@GetMapping("/getcenter/{diagnosticCenterId}")
	public DiagnosticCenter getAllDiagnosticCenterById(@PathVariable("diagnosticCenterId") int diagnosticCenterId) throws DiagnosticCenterException {
		DiagnosticCenter center=service.getAllDiagnosticCenterById(diagnosticCenterId);
		return center;
	}

	@PutMapping("/updatecenter")
	public DiagnosticCenter updateDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter) {
		   DiagnosticCenter center=service.updateDiagnosticCenter(diagnosticCenter);
		   return center;
		}
	

	@PostMapping("/updatetest")
	public DiagnosticCenter updateDiagnosticTest(DiagnosticCenter diagnosticCenter) {
		   DiagnosticCenter center = service.updateDiagnosticCenter(diagnosticCenter);
		   return center;
		}

	@GetMapping( "/center/{centerName}")
	public DiagnosticCenter getAllDiagnosticCenterById(@PathVariable String centerName) {
		DiagnosticCenter center = service.getDiagnosticCenter(centerName);
		return center;
	}
	

	@DeleteMapping("/delcenter/id")
	public DiagnosticCenter removeDiagnosticCenter(@PathVariable int id)  {
		return service.removeDiagnosticCenter(id);
	}

	/*@GetMapping("/center/centerName")
	public List<Appointment> viewTestDetails(@PathVariable String centerName)  {
		List<Appointment> center = service.getListOfAppointments(centerName);
		return center;
	}*/


}


