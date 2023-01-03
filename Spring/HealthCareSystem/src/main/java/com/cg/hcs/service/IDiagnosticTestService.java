package com.cg.hcs.service;

import java.util.List;


import com.cg.hcs.dto.DiagnosticTest;
import com.cg.hcs.exception.DiagnosticTestException;

public interface IDiagnosticTestService {

	public List<DiagnosticTest> getAllTest();
	public DiagnosticTest addNewTest(DiagnosticTest test);
	public DiagnosticTest updateTestDetails(DiagnosticTest test);
	public DiagnosticTest removeTest(int id);
	public DiagnosticTest getTest(int id) throws DiagnosticTestException;

}



