package tn.esprit.spring.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.entity.Timesheet;
import tn.esprit.spring.entity.TimesheetPk;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
@Service
public class TimesheetServiceImpl implements TimesheetService {
	
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository departementRepository;

	@Override
	public int ajouterMission(Mission mission) {
		return (int) missionRepository.save(mission).getId();
	}

	@Override
	public void affecterMissionADepartement(int missionid, int depid) {

		Mission mission = missionRepository.findById((long) missionid).get();
		Departement departement = departementRepository.findById((long) depid).get();
		if(!ObjectUtils.isEmpty(mission) && !ObjectUtils.isEmpty(departement)) {
			mission.setDepartement(departement);
			missionRepository.save(mission);
		}
		
	}

	@Override
	public void ajouterTimesheet(int missionid, int employeid, Date dateDebut, Date datefin) {
		
		TimesheetPk timesheetPk = new TimesheetPk();
		Timesheet timesheet = new Timesheet();
		timesheetPk.setIdMission((long) missionid);
		timesheetPk.setIdEmploye((long) employeid);
		timesheet.setDate_debut(dateDebut);
		timesheet.setDate_fin(datefin);
		timesheet.setTimesheetPk(timesheetPk);
		timesheet.setIsValid(false);
		timesheetRepository.save(timesheet);
		
		
		
	}

}
