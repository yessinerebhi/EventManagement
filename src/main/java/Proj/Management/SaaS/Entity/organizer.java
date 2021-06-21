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
@Table(name="Organizer")
public class organizer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Organizer", unique=true)
	private int idOrganizer;
	
	@Column(name="Last_Name")
	private String lastNameO;
	
	@Column(name="First_Name")
	private String firstNameO;
	
	@Column(name="Registration_Number")
	private int registrationNumber;
	
	@Column(name="Task")
	private String task;

	public organizer() {
		super();
	}

	public organizer(String lastNameO, String firstNameO, int registrationNumber, String task) {
		super();
		this.lastNameO = lastNameO;
		this.firstNameO = firstNameO;
		this.registrationNumber = registrationNumber;
		this.task = task;
	}

	public int getIdOrganizer() {
		return idOrganizer;
	}

	public void setIdOrganizer(int idOrganizer) {
		this.idOrganizer = idOrganizer;
	}

	public String getLastNameO() {
		return lastNameO;
	}

	public void setLastNameO(String lastNameO) {
		this.lastNameO = lastNameO;
	}

	public String getFirstNameO() {
		return firstNameO;
	}

	public void setFirstNameO(String firstNameO) {
		this.firstNameO = firstNameO;
	}

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "organizer [idOrganizer=" + idOrganizer + ", lastNameO=" + lastNameO + ", firstNameO=" + firstNameO
				+ ", registrationNumber=" + registrationNumber + ", task=" + task + "]";
	}
	
	
	
	
	
}
