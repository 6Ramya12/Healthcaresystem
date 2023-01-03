package com.cg.hcs.service;

import java.util.List;

import com.cg.hcs.dto.Appointment;
import com.cg.hcs.dto.DiagnosticCenter;
import com.cg.hcs.dto.DiagnosticTest;
import com.cg.hcs.exception.DiagnosticCenterException;

public interface IDiagnosticCenterService {
	public List<DiagnosticCenter> getAllDiagnosticCenters();
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter);
	public DiagnosticCenter getAllDiagnosticCenterById(int diagnosticCenterId) throws DiagnosticCenterException;
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter);
	public DiagnosticTest viewTestDetails(int diagnosticCenterId,String testName);
	public DiagnosticTest addTest(int diagnosticCenterId,int testid);
	public DiagnosticCenter getDiagnosticCenter(String centername);
	public DiagnosticCenter removeDiagnosticCenter(int id);
	public List<Appointment> getListOfAppointments(String centerName);
	
	

}
