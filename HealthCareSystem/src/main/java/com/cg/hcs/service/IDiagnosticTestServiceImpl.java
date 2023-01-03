package com.cg.hcs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cg.hcs.dto.DiagnosticCenter;
import com.cg.hcs.dto.DiagnosticTest;
import com.cg.hcs.exception.DiagnosticTestException;
import com.cg.hcs.repository.IDiagnosticTestRepository;

@Service

public class IDiagnosticTestServiceImpl implements IDiagnosticTestService {

	@Autowired
	private IDiagnosticTestRepository diagnostictestrepository;
	
	public DiagnosticTest addNewTest(DiagnosticTest test) {
		diagnostictestrepository.save(test);
		return test;
		
		
	}
	
	public DiagnosticTest updateTestDetails(DiagnosticTest test) {
		diagnostictestrepository.save(test);
		return test;
		
		
	}
	
	public List<DiagnosticTest> getAllTest(){
	return	diagnostictestrepository.findAll();
	
	}

	

	@Override
	public DiagnosticTest removeTest(int id) {
		DiagnosticTest test= diagnostictestrepository.findById(id).get();
		diagnostictestrepository.deleteById(id);
		return test;
		
		
	}

	@Override
	public DiagnosticTest getTest(int id) throws DiagnosticTestException {
		if(diagnostictestrepository.existsById(id)) 
			return diagnostictestrepository.findById(id).get();
			else {
				throw new DiagnosticTestException("Test does not exist");
			}
	}
	
	


	
}
