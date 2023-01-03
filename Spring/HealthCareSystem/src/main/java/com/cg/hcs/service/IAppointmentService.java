package com.cg.hcs.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.cg.hcs.dto.Appointment;
import com.cg.hcs.exception.AppointmentException;

public interface IAppointmentService {

	public Appointment addAppointment(Appointment appointmentt) throws AppointmentException;
	
	public Set<Appointment> viewAppointments(String patientName);
	
	public Appointment viewAppointment(int  id) throws AppointmentException;
	
	public Appointment updateAppointment(Appointment appointment) throws AppointmentException;
	
	public Appointment removeAppointment(Appointment appointment) throws AppointmentException;
	
	
	
	
	
}	    
