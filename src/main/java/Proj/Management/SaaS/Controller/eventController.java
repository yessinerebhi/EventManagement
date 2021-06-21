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

import Proj.Management.SaaS.Entity.event;
import Proj.Management.SaaS.Service.eventService;

@RestController
public class eventController {
	
	@Autowired
	private eventService  eventService;

	//GET 
	@GetMapping("/Event")
	public List<event> SelectEvent(){
		return eventService.SelectEvent();
		
	}
	
	//GET by ID
		@GetMapping("/Event/{idEvent}")
		public ResponseEntity<event> getEventById(@PathVariable int idEvent){	
			return 	eventService.getEventById(idEvent);

		}
		
		
	//DELETE
		@DeleteMapping( "/Event/{idEvent}")
		public ResponseEntity<Map<String,Boolean>> deleteEvent(@PathVariable int idEvent){
			return eventService.deleteEvent(idEvent);
		}
		
		
	//UPDATE
		@PutMapping("/Event/{idEvent}")
		public void UpdateEvent(@PathVariable int idEvent,@RequestBody event event) {
			eventService.UpdateEvent(idEvent,event);
			System.out.println("Event modifié !");

		}
		
		
	//ADD	
	@PostMapping("/Event")
		public void AddEvent(@RequestBody event event) {
			eventService.AddEvent(event);
			System.out.println("Event ajouté !");

		}
	
	

}
