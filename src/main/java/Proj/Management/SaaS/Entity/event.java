package Proj.Management.SaaS.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Event")
public class event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Id_Event" , unique=true)
	private int idEvent;
	
	@Column(name= "Title")
	private String title;
	
	@Column(name="Theme")
	private String theme;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Nombre_Participants")
	private int nbParticipants;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="Availability")
	private String availability;
	
	
	public event() {
		super();
	}

	public event(String title, String theme, String description, int nbParticipants, String location,
			String availability) {
		super();
		this.title = title;
		this.theme = theme;
		this.description = description;
		this.nbParticipants = nbParticipants;
		this.location = location;
		this.availability = availability;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbParticipants() {
		return nbParticipants;
	}

	public void setNbParticipants(int nbParticipants) {
		this.nbParticipants = nbParticipants;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "event [idEvent=" + idEvent + ", title=" + title + ", theme=" + theme + ", description=" + description
				+ ", nbParticipants=" + nbParticipants + ", location=" + location + ", availability=" + availability
				+ "]";
	}
	
	
	
	
	

}
