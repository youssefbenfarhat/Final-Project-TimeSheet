package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Timesheet")
public class Timesheet implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String timesheet;
	private Employe employe;
	private Mission mission;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TIMESHEET_DATE_DEBUT")
	private Date date_debut;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TIMESHEET_DATE_FIN")
	private Date date_fin;

	@Column(name="TIMESHEET_IS_VALID")
	private boolean isValid;

	
	private TimesheetPk timesheetPk;
	
	
	public String getTimesheet() {
		return timesheet;
	}


	public void setTimesheet(String timesheet) {
		this.timesheet = timesheet;
	}


	 	 
	
	






	public Date getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}


	public Date getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}


	public boolean getIsValid() {
		return isValid;
	}


	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}


	public Timesheet() {
		super();
	}


	@EmbeddedId
	public TimesheetPk getTimesheetPk() {
		return timesheetPk;
	}


	public void setTimesheetPk(TimesheetPk timesheetPk) {
		this.timesheetPk = timesheetPk;
	}











	@ManyToOne
	@JoinColumn(name="id_mission",referencedColumnName="id",insertable=false,updatable=false)
	public Mission getMission() {
		return mission;
	}
	
	public void setMission(Mission mission) {
		this.mission = mission;
	}


	@ManyToOne
	@JoinColumn(name="id_employe",referencedColumnName="id",insertable=false,updatable=false)
	public Employe getEmploye() {
		return employe;
	}
	
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
	
	
	
	
	
	


	public Timesheet(Mission mission, Employe employe) {
		super();
		this.mission = mission;
		this.employe = employe;
		this.timesheet = timesheet;
		this.timesheetPk=new TimesheetPk(employe.getId(), mission.getId());
	}

	
	

}
