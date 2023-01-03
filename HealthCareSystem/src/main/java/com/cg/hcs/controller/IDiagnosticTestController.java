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
import com.cg.hcs.dto.DiagnosticTest;
import com.cg.hcs.exception.DiagnosticTestException;
import com.cg.hcs.service.IDiagnosticTestService;
import com.cg.hcs.service.IDiagnosticTestServiceImpl;




@RestController
@RequestMapping("/diagnostic_test")
public class IDiagnosticTestController {
	@Autowired
	IDiagnosticTestServiceImpl diagnostictestrepository;

	@GetMapping("/alltests")
	public List<DiagnosticTest> getAllTest(){
		List<DiagnosticTest> tests = diagnostictestrepository.getAllTest();
		return tests;
	}
	
	@PostMapping("/addnewtest")
	public DiagnosticTest addNewTest(@RequestBody DiagnosticTest test) {
		return diagnostictestrepository.addNewTest(test);
		
		
	}
	
	@PutMapping("/updatetestdetails")
	public DiagnosticTest updateTestDetail(@RequestBody DiagnosticTest test) {
		return diagnostictestrepository.updateTestDetails(test);
	}
	
	@DeleteMapping("/deltest/{id}")
	public DiagnosticTest delTest(@PathVariable("id") int id) {
		
		return diagnostictestrepository.removeTest(id);
		
	}
	@GetMapping("/test/{id}")
	public DiagnosticTest getDiagnosticTestById(@PathVariable("id") int id) throws DiagnosticTestException {
		return diagnostictestrepository.getTest(id);
	}
	
	
	
}
