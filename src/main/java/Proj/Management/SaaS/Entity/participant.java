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
@Table(name="Participant")
public class participant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_Participant", unique=true)
	private int idParticipant;
	
	@Column(name="Last_Name")
	private String lastNameP;
	
	@Column(name="First_Name")
	private String firstNameP;
	
	@Column(name="Payment_Method")
	private String paymentMethod;

	public participant() {
		super();
	}

	public participant(String lastNameP, String firstNameP, String paymentMethod) {
		super();
		this.lastNameP = lastNameP;
		this.firstNameP = firstNameP;
		this.paymentMethod = paymentMethod;
	}

	public int getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(int idParticipant) {
		this.idParticipant = idParticipant;
	}

	public String getLastNameP() {
		return lastNameP;
	}

	public void setLastNameP(String lastNameP) {
		this.lastNameP = lastNameP;
	}

	public String getFirstNameP() {
		return firstNameP;
	}

	public void setFirstNameP(String firstNameP) {
		this.firstNameP = firstNameP;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "participant [idParticipant=" + idParticipant + ", lastNameP=" + lastNameP + ", firstNameP=" + firstNameP
				+ ", paymentMethod=" + paymentMethod + "]";
	}
	
	
	
	
	
	

}
