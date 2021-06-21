package Proj.Management.SaaS.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Proj.Management.SaaS.Entity.participant;
import  Proj.Management.SaaS.Service.participantService;

@RestController
public class participantController {
	
	@Autowired
	private participantService participantService;
	
	@CrossOrigin
	
	//GET 
		@GetMapping("/Participant")
		public List<participant> SelectParticipant(){
			return participantService.SelectParticipant();
			
		}
		
	//GET by ID
		@GetMapping("/Participant/{idParticipant}")
		public ResponseEntity<participant> getParticipantById(@PathVariable int idParticipant){	
			return 	participantService.getParticipantById(idParticipant);

		}	

	//DELETE
		@DeleteMapping( "/Participant/{idParticipant}")
		public ResponseEntity<Map<String,Boolean>> deleteParticipant(@PathVariable int idParticipant){
			return participantService.deleteParticipant(idParticipant);
		}
		
		
	//UPDATE
		@PutMapping("/Participant/{idParticipant}")
		public void UpdateParticipant(@PathVariable int idParticipant,@RequestBody participant participant) {
			participantService.UpdateParticipant(idParticipant,participant);
			System.out.println("Participant modifié !");

		}	
		
		
	//ADD
		@PostMapping("/Participant")
		public void AddParticipant(@RequestBody participant participant) {
			participantService.AddParticipant(participant);
			System.out.println("Participant ajouté !");

		}
}
