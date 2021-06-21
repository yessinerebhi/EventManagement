package Proj.Management.SaaS.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import Proj.Management.SaaS.Entity.participant;
import Proj.Management.SaaS.Repository.participantRepository;
import Proj.Management.SaaS.Exception.NoArgumentsFoundException;
import Proj.Management.SaaS.Exception.ParticipantNotFoundException;
import Proj.Management.SaaS.Exception.EmptyInputException;

@Service
public class participantService {
	
	@Autowired
	private participantRepository participantRepository;
	
	
	//GET
		public List<participant> SelectParticipant(){
			List<participant> participants=new ArrayList<>();
			participantRepository.findAll().forEach(participants::add);
			if (participants.isEmpty()) {
				throw new NoArgumentsFoundException("600");
			}
			return participants;
		}
	
	// GET by ID
		public ResponseEntity<participant> getParticipantById(@PathVariable int idParticipant){
			participant participant=participantRepository.findById(idParticipant).orElseThrow(() -> new ParticipantNotFoundException("Participant does not exist :"+idParticipant));
			return ResponseEntity.ok(participant);
		}
		
	//ADD
		public void AddParticipant(participant participant) {
			if(participant.getLastNameP().isEmpty() ||participant.getFirstNameP().isEmpty() ) {
				throw new EmptyInputException("601");}
			participantRepository.save(participant);
		}

	//UPDATE
		public ResponseEntity<participant> UpdateParticipant(int idParticipant, participant participant) {
			participant existingParticipant= participantRepository.findById(idParticipant).orElseThrow(() -> new ParticipantNotFoundException("Participant does not exist :"+idParticipant));
			existingParticipant.setLastNameP(participant.getLastNameP());
			existingParticipant.setFirstNameP(participant.getFirstNameP());
			existingParticipant.setPaymentMethod(participant.getPaymentMethod());
			participant updatedParticipant= participantRepository.save(existingParticipant);
			return ResponseEntity.ok(updatedParticipant);
		}
		
	//DELETE
		public ResponseEntity<Map<String,Boolean>> deleteParticipant(@PathVariable int idParticipant){
			participant participant=participantRepository.findById(idParticipant).orElseThrow(() -> new ParticipantNotFoundException("Participant does not exist :"+idParticipant));
			participantRepository.delete(participant);
			Map<String,Boolean> response=new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
		
}
