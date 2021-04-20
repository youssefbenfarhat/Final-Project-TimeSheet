package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Entreprise")
public class Entreprise implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ENTREPRISE_ID")
	private long id;
	@Column(name="ENTREPRISE_NAME")
	private String name;
	
	@Column(name="ENTREPRISE_RAISON_SOCIAL")
	private String raison_social;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="entreprise", fetch=FetchType.EAGER)
	private Set<Departement> Departements;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRaison_social() {
		return raison_social;
	}

	public void setRaison_social(String raison_social) {
		this.raison_social = raison_social;
	}

	public Set<Departement> getDepartements() {
		return Departements;
	}

	public void setDepartements(Set<Departement> departements) {
		Departements = departements;
	}
	
	
}
