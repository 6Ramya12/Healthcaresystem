package com.cg.hcs.controller;
import java.util.List;
import java.util.Set;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hcs.dto.Appointment;
import com.cg.hcs.exception.AppointmentException;
import com.cg.hcs.service.IAppointmentService;
import com.cg.hcs.service.IAppointmentServiceImpl;
import com.cg.hcs.service.IAppointmentServiceImpl;


@RestController
@RequestMapping("/appointments")
public class IAppointmentController {
	@Autowired
	
	private IAppointmentServiceImpl service;
	
	
	@PostMapping("/addappointment")
	public Appointment addAppointment(@RequestBody Appointment app) throws AppointmentException {
		service.addAppointment(app);
		return app;
	}
	@GetMapping("/viewappointment/{patientName}")
	public Set<Appointment> viewAppointment( @PathVariable("patientName") String patientName) {
		Set<Appointment> cd =service.viewAppointments(patientName);
		return cd;
	}
	@GetMapping("/viewappointment/id/{id}")
	public Appointment viewAppointment(@PathVariable("id") int appointmentid) throws AppointmentException {
         return service.viewAppointment(appointmentid);
	}
	@PutMapping("/updateappointment")
	public Appointment updateAppointment(@RequestBody Appointment appointment) throws AppointmentException {
		service.updateAppointment(appointment);
		return appointment;
		
	}
	@DeleteMapping("/deleteAppointment")
	public Appointment deleteAppointment(@RequestBody Appointment appointment) throws AppointmentException {
		service.removeAppointment(appointment);
		return appointment;
		
	}
}
	
	
