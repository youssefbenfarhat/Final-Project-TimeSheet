package tn.esprit.spring.service;

import java.util.Date;

import tn.esprit.spring.entity.Mission;

public interface TimesheetService {
	
	public int ajouterMission(Mission mission);
	public void affecterMissionADepartement(int missionid, int depid);
	public void ajouterTimesheet(int missionid, int employeid, Date dateDebut,Date datefin);

}
