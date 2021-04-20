package tn.esprit.spring.control;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.service.TimesheetService;

@RestController
public class TimesheetRestControlImpl {

	
	@Autowired
	TimesheetService timesheetService;
	
	@PostMapping("/ajouterMission")
	@ResponseBody
	public int ajouterMission(@RequestBody Mission mission) {
		return timesheetService.ajouterMission(mission);
	}
	
	@PutMapping("/affecterMissionADepartement/{missionid}/{depid}")
	@ResponseBody
	public void affecterMissionADepartement(@PathVariable("missionid") int missionid, @PathVariable("depid") int depid) {
		timesheetService.affecterMissionADepartement(missionid, depid);
	}
	
	@PostMapping("/ajouterTimesheet/{missionid}/{employeid}/{datedebut}/{datefin}")
	@ResponseBody
	public void ajouterTimesheet(@PathVariable ("missionid") int missionid,@PathVariable("employeid") int employeid,@PathVariable("datedebut") Date dateDebut,@PathVariable("datefin")Date datefin){
		timesheetService.ajouterTimesheet(missionid, employeid, dateDebut, datefin);
	}
}
