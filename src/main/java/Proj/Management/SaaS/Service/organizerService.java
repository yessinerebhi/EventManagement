package Proj.Management.SaaS.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import Proj.Management.SaaS.Entity.organizer;
import Proj.Management.SaaS.Exception.NoArgumentsFoundException;
import Proj.Management.SaaS.Exception.OrganizerNotFoundException;
import Proj.Management.SaaS.Repository.organizerRepository;
import Proj.Management.SaaS.Exception.EmptyInputException;

@Service
public class organizerService {
	
	@Autowired
	private organizerRepository organizerRepository;
	
	//GET
		public List<organizer> SelectOrganizer(){
			List<organizer> organizers=new ArrayList<>();
			organizerRepository.findAll().forEach(organizers::add);
			if (organizers.isEmpty()) {
				throw new NoArgumentsFoundException("600");
			}
			return organizers;
		}
		
	// GET by ID
		public ResponseEntity<organizer> getOrganizerById(@PathVariable int idOrganizer){
			organizer organizer=organizerRepository.findById(idOrganizer).orElseThrow(() -> new OrganizerNotFoundException("Organizer does not exist :"+idOrganizer));
			return ResponseEntity.ok(organizer);
		}	
		
	//ADD
		public void AddOrganizer(organizer organizer) {
			if(organizer.getFirstNameO().isEmpty() ||organizer.getLastNameO().isEmpty() ||organizer.getTask().isEmpty() ) {
				throw new EmptyInputException("601");}
			organizerRepository.save(organizer);
		}
		
	//UPDATE
		public ResponseEntity<organizer> UpdateOrganizer(int idOrganizer, organizer organizer) {
			organizer existingOrganizer= organizerRepository.findById(idOrganizer).orElseThrow(() -> new OrganizerNotFoundException("Organizer does not exist with cin :"+idOrganizer));
			existingOrganizer.setLastNameO(organizer.getLastNameO());
			existingOrganizer.setFirstNameO(organizer.getFirstNameO());
			existingOrganizer.setRegistrationNumber(organizer.getRegistrationNumber());
			existingOrganizer.setTask(organizer.getTask());
			organizer updatedOrganizer= organizerRepository.save(existingOrganizer);
			return ResponseEntity.ok(updatedOrganizer);
		}
		
		
	//DELETE
		public ResponseEntity<Map<String,Boolean>> deleteOrganizer(@PathVariable int idOrganizer){
			organizer organizer=organizerRepository.findById(idOrganizer).orElseThrow(() -> new OrganizerNotFoundException("Organizer does not exist with cin :"+idOrganizer));
			organizerRepository.delete(organizer);
			Map<String,Boolean> response=new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
		

}
