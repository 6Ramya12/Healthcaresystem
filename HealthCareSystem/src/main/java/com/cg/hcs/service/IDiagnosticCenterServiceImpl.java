package com.cg.hcs.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hcs.dto.Appointment;
import com.cg.hcs.dto.DiagnosticCenter;
import com.cg.hcs.dto.DiagnosticTest;
import com.cg.hcs.exception.DiagnosticCenterException;
import com.cg.hcs.repository.IDiagnosticCenterRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class IDiagnosticCenterServiceImpl implements IDiagnosticCenterService{
		@Autowired
		public IDiagnosticCenterRepository repo;
		/*@author :saigeetha
		 * @return :diagnosticCenter
		 * @description :This method gives all daignostic center to the repository and return daignostic center
		 */
		@Override
		public List<DiagnosticCenter> getAllDiagnosticCenters(){
			List<DiagnosticCenter> dc=repo.findAll();
			return dc;
		}
		/*@author :saigeetha
		 * @return :diagnosticCenter
		 * @description :This method gives add daignostic center to the repository and return daignostic center
		 */
		@Override
		public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
			
			System.out.println(diagnosticCenter);
			repo.save(diagnosticCenter);
			return diagnosticCenter;
		}
		
		/*@author :saigeetha
		 * @return :diagnosticCenter
		 * @description :This method gives getAll diagnosticCenterById to the repository and return daignostic center
		 */
		@Override	
		public DiagnosticCenter getAllDiagnosticCenterById(int diagnosticCenterId) throws DiagnosticCenterException {
			if(repo.existsById(diagnosticCenterId)) {
				return repo.findById(diagnosticCenterId).get();
			}
			else{
				throw new DiagnosticCenterException("center does not exist");
			}
			
		}

		/*@Override
		public DiagnosticCenter getAllDiagnosticCenterById(int diagnosticCenterId){
			Optional<DiagnosticCenter> diagnosticCenterOptional = IDiagnosticCenterRepository.findById(diagnosticCenterId);
			return diagnosticCenterOptional.orElseThrow(()-> new DiagnosticCenterException("DiagonsticCenter with id: "+diagnosticCenterId+" is not found"));
		}*/
		/*@author :saigeetha
		 * @return :diagnosticCenter
		 * @description :This method update daignostic center to the repository and return daignostic center
		 */
		@Override
		public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		   repo.save(diagnosticCenter);
		   return diagnosticCenter;
		}
		/*@author :saigeetha
		 * @return :diagnosticCenter
		 * @description :This method gives view test details to the repository and return daignostic center
		 */
		@Override
		public DiagnosticTest viewTestDetails(int diagnosticCenterId, String testName) {
			return null;
		}
		/*@author :saigeetha
		 * @return :diagnosticCenter
		 * @description :This method add test  to the repository and return daignostic center
		 */
		@Override
		public DiagnosticTest addTest(int diagnosticCenterId, int testid) {
		      DiagnosticTest diagnosticTest=new DiagnosticTest();
			return null;
		}
		/*@author :saigeetha
		 * @return :diagnosticCenter
		 * @description :This method get daignostic center to the repository and return daignostic center
		 */

		@Override
		public DiagnosticCenter getDiagnosticCenter(String centerName) {
			return repo.findByName(centerName);
			
	    }
		/*@author :saigeetha
		 * @return :diagnosticCenter
		 * @description :This method removes daignostic center to the repository and return daignostic center
		 */

		@Override
		public DiagnosticCenter removeDiagnosticCenter(int id) {
			DiagnosticCenter a=repo.findById(id).get();
			repo.deleteById(id);
			return a;
			
		}
		/*@author :saigeetha
		 * @return :diagnosticCenter
		 * @description :This method gives getlistofappointments to the repository and return daignostic center
		 */

		@Override
		public List<Appointment> getListOfAppointments(String centerName) {
			//List<DiagnosticCenter> a=repo.findAll();
			//List<Appointment> b =new ArrayList<Appointment>();
			/*for(DiagnosticCenter l:a)
			{
				l.
			}
			return a;*/
			
			return null;
			
		}
	}


