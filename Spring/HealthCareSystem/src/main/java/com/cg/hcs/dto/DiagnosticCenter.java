package com.cg.hcs.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="DiagnosticCenter_tbl")
public class DiagnosticCenter {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="name",length=30)
	private String name;
	@Column(name="contactNo",length=10)
	String contactNo;
	@Column(name="address",length=50)
	private String address;
	@Column(name="contactEmail",length=30)
	private String contactEmail;
	@Column(name="servicesOffered")
	@ElementCollection(targetClass=String.class)
	private List<String> servicesOffered1=new ArrayList<String>();
 
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	//@JsonIgnore
	//@JoinTable(name="DiagnosticCenter_DiagnoticTest")
	private Set<DiagnosticTest> tests=new HashSet<DiagnosticTest>();
	
	
	public DiagnosticCenter() {
		super();
	}


	public DiagnosticCenter(int id, String name, String contactNo, String address, String contactEmail,
			List<String> servicesOffered1, Set<DiagnosticTest> tests) {
		super();
		this.id = id;
		this.name = name;
		this.contactNo = contactNo;
		this.address = address;
		this.contactEmail = contactEmail;
		this.servicesOffered1 = servicesOffered1;
		this.tests = tests;
	}
 

	public DiagnosticCenter(int id, String name, String contactNo, String address, String contactEmail) {
		super();
		this.id = id;
		this.name = name;
		this.contactNo = contactNo;
		this.address = address;
		this.contactEmail = contactEmail;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getContactEmail() {
		return contactEmail;
	}


	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}


	public List<String> getServicesOffered1() {
		return servicesOffered1;
	}


	public void setServicesOffered1(List<String> servicesOffered1) {
		this.servicesOffered1 = servicesOffered1;
	}


	public Set<DiagnosticTest> getTests() {
		return tests;
	}


	public void setTests(Set<DiagnosticTest> tests) {
		this.tests = tests;
	}


	@Override
	public String toString() {
		return "DiagnosticCenter [id=" + id + ", name=" + name + ", contactNo=" + contactNo + ", address=" + address
				+ ", contactEmail=" + contactEmail + ", servicesOffered1=" + servicesOffered1 + ", tests=" + tests
				+ "]";
	}


}


