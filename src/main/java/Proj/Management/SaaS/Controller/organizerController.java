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

import Proj.Management.SaaS.Entity.organizer;
import Proj.Management.SaaS.Service.organizerService;

@RestController
public class organizerController {
	
	@Autowired
	private organizerService organizerService;
	
	@CrossOrigin
	
	//GET 
		@GetMapping("/Organizer")
		public List<organizer> SelectOrganizer(){
			return organizerService.SelectOrganizer();
			
		}
		
		
	//GET by ID
		@GetMapping("/Organizer/{idOrganizer}")
		public ResponseEntity<organizer> getOrganizerById(@PathVariable int idOrganizer){	
			return 	organizerService.getOrganizerById(idOrganizer);

		}
		

	//DELETE
		@DeleteMapping( "/Organizer/{idOrganizer}")
		public ResponseEntity<Map<String,Boolean>> deleteOrganizer(@PathVariable int idOrganizer){
			return organizerService.deleteOrganizer(idOrganizer);
		}

		
	//UPDATE
		@PutMapping("/Organizer/{idOrganizer}")
		public void UpdateOrganizer(@PathVariable int idOrganizer,@RequestBody organizer organizer) {
			organizerService.UpdateOrganizer(idOrganizer,organizer);
			System.out.println("Organizer modifié !");

		}
		
		
	//ADD
		@PostMapping("/Organizer")
		public void AddOrganizer(@RequestBody organizer organizer) {
			organizerService.AddOrganizer(organizer);
			System.out.println("Organizer ajouté !");

		}
}
