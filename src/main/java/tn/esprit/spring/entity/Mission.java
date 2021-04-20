package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Mission")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Mission implements Serializable {
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
//		@Column(name="MISSION_ID")
		private long id;
		@Column(name="MISSION_NAME")
		private String name;
		@Column(name="MISSION_DESCRIPTION")
		private String description;
		
		
		
		
		
		public Mission() {
			super();
		}
		





		@OneToMany(cascade = CascadeType.ALL, mappedBy="mission")
		private Set<Timesheet> timesheets;


		
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


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}
		
		
		@ManyToOne
		Departement departement;





		public Set<Timesheet> getTimesheets() {
			return timesheets;
		}


		public void setTimesheets(Set<Timesheet> timesheets) {
			this.timesheets = timesheets;
		}


		public Departement getDepartement() {
			return departement;
		}


		public void setDepartement(Departement departement) {
			this.departement = departement;
		}
		
		
		
		
		
}
