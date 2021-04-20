package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Contrat")
public class Contrat extends Employe implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue (strategy = GenerationType.IDENTITY)
//	@Column(name="CONTRAT_ID")
//	private long id;
	@Column(name="CONTRAT_REFERENCE")
	private String reference;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CONTRAT_DATE_DEBUT")
	private Date date_debut;
	
	@Column(name="CONTRAT_TYPE_CONTRAT")
	private String name;
	
	@Column(name="CONTRAT_SALAIRE")
	private float salaire;
	
	@OneToOne(mappedBy="contrat")
	private Employe employe;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
	
}
