package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Employe")
public class Employe implements Serializable{
	
	private static final long serialVersionUID = 1L;
		Role role;
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)

		private long id;
		@Column(name="EMPLOYE_PRENOM")
		private String prenom;
		@Column(name="EMPLOYE_NOM")
		private String nom;
		
		@Column(name="EMPLOYE_EMAIL")
		private String email;
		
		@Column(name="EMPLOYE_isActif")
		private boolean isactif;
		
		@Column(name="EMPLOYE_ROLE")
		@Enumerated(EnumType.ORDINAL)
		public Role getRole() {
			return role;
		}
		//bonjour
		public void setRole(Role role) {
			this.role = role;
		}
		
		
		
		public Employe(String nom,String prenom,String email, Role role,  boolean isactif) {
			super();
			this.role = role;
			this.prenom = prenom;
			this.nom = nom;
			this.email = email;
			this.isactif = isactif;
		}
		public Employe(long id,String nom,String prenom,String email, Role role,  boolean isactif) {
			super();
			this.id=id; 
			this.role = role;
			this.prenom = prenom;
			this.nom = nom;
			this.email = email;
			this.isactif = isactif;
		}

		public Employe() {
			super();
		}




		@OneToOne
		private Contrat contrat;
		
		@ManyToMany(cascade  = CascadeType.ALL)
		private Set<Departement> employeDep;
		

		
		
		@OneToMany(mappedBy="employe")
		private Set<Timesheet> timesheets;



		public long getId() {
			return id;
		}




		public void setId(long id) {
			this.id = id;
		}




		@Override
		public String toString() {
			return "Employe [role=" + role + ", id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email
					+ ", isactif=" + isactif + ", contrat=" + contrat + ", employeDep=" + employeDep + ", timesheets="
					+ timesheets + "]";
		}

		public String getPrenom() {
			return prenom;
		}




		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}




		public String getNom() {
			return nom;
		}




		public void setNom(String nom) {
			this.nom = nom;
		}




		public String getEmail() {
			return email;
		}




		public void setEmail(String email) {
			this.email = email;
		}




		public boolean getIsactif() {
			return isactif;
		}




		public void setIsactif(Boolean isactif) {
			this.isactif = isactif;
		}




		public Contrat getContrat() {
			return contrat;
		}




		public void setContrat(Contrat contrat) {
			this.contrat = contrat;
		}




		public Set<Departement> getEmployeDep() {
			return employeDep;
		}




		public void setEmployeDep(Set<Departement> employeDep) {
			this.employeDep = employeDep;
		}



		
		
		
		
		
		
	

}
