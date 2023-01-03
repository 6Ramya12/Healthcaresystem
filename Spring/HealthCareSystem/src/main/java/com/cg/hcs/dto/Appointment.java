package com.cg.hcs.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Appointment")
public class Appointment {

	@Id
	@Column(name="id")
	int id;
	@Column(name="appointment_date")
	LocalDate appointmentDate;
	@Column(name="approval_status",length=8)
	String approvalStatus;
	
	@JsonIgnore
	@OneToMany(targetEntity=DiagnosticTest.class,cascade = CascadeType.ALL)
	Set<DiagnosticTest> diagnosticTests=new HashSet<DiagnosticTest>();
	
	//@JsonIgnoreProperties("appointment")
	@JsonIgnore
	@OneToOne(mappedBy="appointment",cascade = CascadeType.REMOVE,orphanRemoval = true)
	Patient patient;
	

	@OneToOne(targetEntity =DiagnosticCenter.class,cascade = CascadeType.MERGE)
	@JoinColumn(name="fk_diagnosticCenter_id",referencedColumnName = "id")
	DiagnosticCenter diagnosticCenter;
	
	@JsonIgnore
	@OneToMany(mappedBy="appointment",cascade = CascadeType.ALL,orphanRemoval = true)
	Set<TestResult> testResult=new HashSet<TestResult>();

	public Appointment() {
		super();
	}

	public Appointment(int id, LocalDate appointmentDate, String approvalStatus, Set<DiagnosticTest> diagnosticTests,
			Patient patient, DiagnosticCenter diagnosticCenter, Set<TestResult> testResult) {
		super();
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.approvalStatus = approvalStatus;
		this.diagnosticTests = diagnosticTests;
		this.patient = patient;
		this.diagnosticCenter = diagnosticCenter;
		this.testResult = testResult;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Set<DiagnosticTest> getDiagnosticTests() {
		return diagnosticTests;
	}

	public void setDiagnosticTests(Set<DiagnosticTest> diagnosticTests) {
		this.diagnosticTests = diagnosticTests;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public DiagnosticCenter getDiagnosticCenter() {
		return diagnosticCenter;
	}

	public void setDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		this.diagnosticCenter = diagnosticCenter;
	}

	public Set<TestResult> getTestResult() {
		return testResult;
	}

	public void setTestResult(Set<TestResult> testResult) {
		this.testResult = testResult;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointmentDate=" + appointmentDate + ", approvalStatus=" + approvalStatus
				+ ", diagnosticTests=" + diagnosticTests + ", patient=" + patient + ", diagnosticCenter="
				+ diagnosticCenter + ", testResult=" + testResult + "]";
	}


}
