package com.cg.hcs.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class Patient {
	@Id
	@Column(name="id")
	int id;
	@Column(name="name",length=20)
	String name;
	@Column(name="phoneNo",length=10)
	String phoneNo;
	@Column(name="age")
	int age;
	@Column(name="gender",length=10)
	String gender;
	
	//@JsonIgnoreProperties("patient")
	//@OneToOne(targetEntity=Appointment.class,cascade = CascadeType.REMOVE, orphanRemoval = true)
	
@ManyToOne(targetEntity=Appointment.class,cascade = CascadeType.ALL)
	@JoinTable(name="patient_appointments")
	Appointment appointment;
	
	public Patient() {
		super();
	}

	public Patient(int id, String name, String phoneNo, int age, String gender, Appointment appointment) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.age = age;
		this.gender = gender;
		this.appointment = appointment;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", phoneNo=" + phoneNo + ", age=" + age + ", gender=" + gender
				+ ", appointment=" + appointment + "]";
	}

		
	

	


}


