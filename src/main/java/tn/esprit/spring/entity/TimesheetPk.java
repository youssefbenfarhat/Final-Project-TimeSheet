package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class TimesheetPk implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idEmploye;
	private Long idMission;
	public TimesheetPk() {
		super();
	}
	@Column(name="id_employe")
	public Long getIdEmploye() {
		return idEmploye;
	}
	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}
	@Column(name="id_mission")
	public Long getIdMission() {
		return idMission;
	}
	public void setIdMission(Long idMission) {
		this.idMission = idMission;
	}
	
	
	public TimesheetPk(Long idEmploye, Long idMission) {
		super();
		this.idEmploye = idEmploye;
		this.idMission = idMission;
	}

	
	
	
	
}
