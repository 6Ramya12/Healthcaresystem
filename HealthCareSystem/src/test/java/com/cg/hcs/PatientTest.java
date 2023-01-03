package com.cg.hcs;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.hcs.dto.Patient;
import com.cg.hcs.service.IPatientService;

import jakarta.transaction.Transactional;
@Transactional
@SpringBootTest
public class PatientTest {

	@Autowired
	 private IPatientService patientService;


	    @Test
	    public void registerTestPass() {

	        Patient patient=new Patient();
	        Patient patient2=new Patient();

	       Assert.assertEquals(patient,patientService.registerPatient(patient));
	        Assert.assertEquals(patient2,patientService.registerPatient(patient2));

	    }
	    @Test
	    public void registerTestFails() {

	        Patient patient=new Patient();
	        Patient patient2=new Patient();
	        Patient patient3=new Patient();
	        Assert.assertEquals(patient,patientService.registerPatient(patient));
	        Assert.assertEquals(patient,patientService.registerPatient(patient2));
	        Assert.assertEquals(patient,patientService.registerPatient(patient3));

	    }
	    @Test
	    public void updateTestDetailsPass(){

	    }

	    @Test
	    public void viewTestPass() {
	        Patient patient=new Patient(1,"rishi","");
	        patient.setAppointmentList(null);
	        patient.setPatientid(2);
	        Assert.assertEquals(patient,patientService.viewPatient(2));

	    }
	    @Test
	    public void viewTestFail() {
	        Patient patient=new Patient("rish","388292929",24,"male");
	        patient.setAppointmentList(null);
	        patient.setPatientid(3);
	        Assert.assertEquals(patient,patientService.viewPatient(3));
	    }
	    @Test
	    public void viewTestResultPass() {

	    }

	    @Test
	    public void getAllTestResultPass(){

	    }
	    @Test
	    public void PatientNotFoundExcetion(){
	        Patient patient=new Patient("grhv","9948844994",31,null);

	        Assert.assertEquals(patient,patientService.updatePatientDetails(93,patient));

	    }
	
	}


