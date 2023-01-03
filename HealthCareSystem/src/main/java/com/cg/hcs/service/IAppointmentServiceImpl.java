package com.cg.hcs.service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cg.hcs.dto.Appointment;
import com.cg.hcs.dto.Patient;
import com.cg.hcs.exception.AppointmentException;
import com.cg.hcs.repository.IAppointmentRepository;
import com.cg.hcs.repository.IPatientRepository;
@Service
public class IAppointmentServiceImpl implements IAppointmentService{
//public class AppointmentServiceImpl extends JpaRepository<Appointment,Integer>{

	@Autowired 
	private IAppointmentRepository repo;
	
    @Override
	public Appointment addAppointment(Appointment appointment) throws AppointmentException {
    	if(repo.existsById(appointment.getId())) {
   		 throw new AppointmentException("Id already exist");
   	   }
    	else {
    		repo.save(appointment);
    	}
	 
		return appointment;
	}
   @Override
	public Set<Appointment> viewAppointments(String patientName) {
	   List<Appointment> appointment =repo.findAll();
       Set<Appointment> apo =new HashSet<Appointment>();
	   for(int i=0;i<appointment.size();i++)
	   {
		   Appointment a =appointment.get(i);
		   if(patientName.equals(a.getPatient().getName())) {
  		   apo.add(a);
	   }
	  }
	   return apo;
   }
		
   @Override
   public Appointment updateAppointment(Appointment appointment) throws AppointmentException {
	   Appointment appointment2;
	  if(repo.existsById(appointment.getId())) {
		  appointment2=repo.save(appointment);
	   		 
	   	   }
	    	else {
	    		throw new AppointmentException(" Update unsuccessful. Id does not exist.");	  
	    	}
	
	  return appointment2;
}
@Override
public Appointment viewAppointment(int id)throws AppointmentException {
	 Appointment appointment=repo.findById(id).get();
	if(appointment!=null) {
		return appointment;
	}
	else {
		throw new AppointmentException("Id does not exist.");	  
	}
	 
	
}
@Override
public Appointment removeAppointment(Appointment appointment)throws AppointmentException {
		if(repo.existsById(appointment.getId())) {
			repo.delete(appointment);
		}
		else {
			throw new AppointmentException("Delete Failed. Id does not exist.");	  
		}
	return appointment;
	
	
}
   



	

}


