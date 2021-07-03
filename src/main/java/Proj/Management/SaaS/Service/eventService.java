package Proj.Management.SaaS.Service;

import Proj.Management.SaaS.Entity.event;
import Proj.Management.SaaS.Exception.EventNotFoundException;
import Proj.Management.SaaS.Exception.NoArgumentsFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import Proj.Management.SaaS.Repository.eventRepository;
import Proj.Management.SaaS.Exception.EmptyInputException;

import java.util.List;
import java.util.Map;

@Service
public class eventService {
	
	@Autowired
	private eventRepository eventRepository;
	
	//GET
	public List<event> SelectEvent(){
		List<event> events=new ArrayList<>();
		eventRepository.findAll().forEach(events::add);
		if(events.isEmpty()) {
			throw new NoArgumentsFoundException("600");
		}
		return events;
	}
	
	// GET by ID
		public ResponseEntity<event> getEventById(@PathVariable int idEvent){
			event event=eventRepository.findById(idEvent).orElseThrow(() -> new EventNotFoundException("Event does not exist :"+idEvent));
			return ResponseEntity.ok(event);
		}

	//ADD
	public void AddEvent(event event) {
			if(event.getTitle().isEmpty() ||event.getLocation().isEmpty() ) {
				throw new EmptyInputException("601");}
			eventRepository.save(event);
		}
	
	//UPDATE
	public ResponseEntity<event> UpdateEvent(int idEvent, event event){
		event existingEvent=eventRepository.findById(idEvent).orElseThrow(() -> new EventNotFoundException("Event does not exist :"+idEvent));
		existingEvent.setTitle(event.getTitle());
		existingEvent.setTheme(event.getTheme());
		existingEvent.setDescription(event.getDescription());
		existingEvent.setNbParticipants(event.getNbParticipants());
		existingEvent.setLocation(event.getLocation());
		existingEvent.setAvailability(event.getAvailability());
		event updatedEvent= eventRepository.save(existingEvent);
		return ResponseEntity.ok(updatedEvent);
	}
	
	//DELETE
	public ResponseEntity<Map<String,Boolean>> deleteEvent(@PathVariable int idEvent){
		event event=eventRepository.findById(idEvent).orElseThrow(()-> new EventNotFoundException("Event does not exist :"+idEvent));
		eventRepository.delete(event);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	

}
