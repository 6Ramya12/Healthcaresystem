package com.cg.hcs.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TestResult")

public class TestResult {
	@Id
	@Column(name="id")
	int id;
	@Column(name="testReading")
	double testReading;
	@Column(name="condition",length=20)
	String condition;
     
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_appointment_id",referencedColumnName = "id")
	Appointment appointment; 
	
	public TestResult() {
		super();
	}

	public TestResult(int id, double testReading, String condition, Appointment appointment) {
		super();
		this.id = id;
		this.testReading = testReading;
		this.condition = condition;
		this.appointment = appointment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTestReading() {
		return testReading;
	}

	public void setTestReading(double testReading) {
		this.testReading = testReading;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "TestResult [id=" + id + ", testReading=" + testReading + ", condition=" + condition + ", appointment="
				+ appointment + "]";
	}

	
	
	
}



