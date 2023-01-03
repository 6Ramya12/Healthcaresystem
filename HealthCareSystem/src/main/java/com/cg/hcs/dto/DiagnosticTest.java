package com.cg.hcs.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="DiagnosticTest_tbl")

public class DiagnosticTest {
	@Id
	@Column(name="id")
	int id;
	@Column(name="testName",length=30)
	String testName;
	@Column(name="testPrice")
	double testPrice;
	@Column(name="normalValue",length=20)
	String normalValue;
	@Column(name="units",length=20)
	String units;
	
	@ManyToOne
	
	//@JoinTable(name="DiagnosticCenter_DiagnoticTest")
	DiagnosticCenter diagnosticCenters;
	
	public DiagnosticTest() {
		super(); 
	}

	public DiagnosticTest(int id, String testName, double testPrice, String normalValue, String units,
			DiagnosticCenter diagnosticCenters) {
		super();
		this.id = id;
		this.testName = testName;
		this.testPrice = testPrice;
		this.normalValue = normalValue;
		this.units = units;
		this.diagnosticCenters = diagnosticCenters;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public double getTestPrice() {
		return testPrice;
	}

	public void setTestPrice(double testPrice) {
		this.testPrice = testPrice;
	}

	public String getNormalValue() {
		return normalValue;
	}

	public void setNormalValue(String normalValue) {
		this.normalValue = normalValue;
	}



	public String getUnits() {
		return units;
	}



	public void setUnits(String units) {
		this.units = units;
	}



	public DiagnosticCenter getDiagnosticCenters() {
		return diagnosticCenters;
	}



	public void setDiagnosticCenters(DiagnosticCenter diagnosticCenters) {
		this.diagnosticCenters = diagnosticCenters;
	}


	@Override
	public String toString() {
		return "DiagnosticTest [id=" + id + ", testName=" + testName + ", testPrice=" + testPrice + ", normalValue="
				+ normalValue + ", units=" + units + ", diagnosticCenters=" + diagnosticCenters + "]";
	}


	
	
	
}

