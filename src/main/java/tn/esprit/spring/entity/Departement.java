package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Departement")
public class Departement implements Serializable {
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name="DEPARTEMENT_ID")
		private long id;
		@Column(name="DEPARTEMENT_NAME")
		private String name;
		
		
		@ManyToMany(mappedBy="employeDep", cascade = CascadeType.ALL)
		private Set<Employe> employes;
		
		@ManyToOne
		Entreprise entreprise;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
		private Set<Mission> missions;

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

		public Set<Employe> getEmployes() {
			return employes;
		}

		public void setEmployes(Set<Employe> employes) {
			this.employes = employes;
		}

		public Entreprise getEntreprise() {
			return entreprise;
		}

		public void setEntreprise(Entreprise entreprise) {
			this.entreprise = entreprise;
		}

		public Set<Mission> getMissions() {
			return missions;
		}

		public void setMissions(Set<Mission> missions) {
			this.missions = missions;
		}

		@Override
		public String toString() {
			return "Departement [id=" + id + ", name=" + name + ", employes=" + employes + ", entreprise=" + entreprise
					+ ", missions=" + missions + "]";
		}
		
		
		
	}


