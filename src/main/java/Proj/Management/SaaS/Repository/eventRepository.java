package Proj.Management.SaaS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Proj.Management.SaaS.Entity.event;

public interface eventRepository extends JpaRepository<event,Integer>{
	 
	

}
