package com.cg.hcs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;




import com.cg.hcs.dto.*;
import com.cg.hcs.repository.*;
import com.cg.hcs.service.IAppointmentServiceImpl;
import com.cg.hcs.exception.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class AppointmentTest {

	@Mock
	IAppointmentRepository appointmentRepositoryMock;
    
	@Mock
	IAppointmentServiceImpl appointmentserviceimpl;
	
	@Test
	public void testAppointmentById() throws AppointmentException{
	
		Appointment a = new Appointment();
        when(appointmentserviceimpl.viewAppointment(1)).thenReturn(a).thenThrow(AppointmentException.class);
		
		assertNotNull(a);
}
	@Test
	public void addAppointment() throws AppointmentException  {
		Appointment a = new Appointment();
		a.setId(1);
		when(appointmentserviceimpl.addAppointment(a)).thenReturn(a);
		assertEquals(1,appointmentserviceimpl.addAppointment(a).getId());
			
	}


	


	
}



