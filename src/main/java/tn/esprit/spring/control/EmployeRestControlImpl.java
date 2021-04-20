package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.service.EmployeService;

@RestController
public class EmployeRestControlImpl {

	
	@Autowired
	EmployeService employeService;
	
	 // Ajouter User : http://localhost:8081/SpringMVC/servlet/ajouterEmploye
//	@PostMapping("/ajouterEmploye")
//	@ResponseBody
//	public int ajouterEmploye(@RequestBody Employe employe) {
//		return employeService.ajouterEmploye(employe);
//	}
	
	@PutMapping("/affecterEmployeADepartement/{employeid}/{depid}")
	@ResponseBody
	public void affecterEmployeADepartement(@PathVariable("employeid") int employeid,@PathVariable("depid") int depid) {
		employeService.affecterEmployeADepartement(employeid, depid);
	}
	
	@PostMapping("/ajouterContrat")
	@ResponseBody
	public int ajouterContrat(@RequestBody Contrat contrat) {
		return employeService.ajouterContrat(contrat);
	}
	
	@PostMapping("/affecterContratAEmploye/{contratid}/{contratid}")
	@ResponseBody
	public void affecterContratAEmploye(@PathVariable("contratid") int contratid,@PathVariable("employeid") int employeid){
		employeService.affecterContratAEmploye(contratid, employeid);
	}
	
	@GetMapping("/retreiveEmployePrenom/{employeid}")
	@ResponseBody
	public String getEpmloyePrenomById(@PathVariable("employeid") int employeid){
		return employeService.getEpmloyePrenomById(employeid);
	}
	
	@GetMapping("/retreiveNombreEmploye")
	@ResponseBody
	public long getNombreEmployeJPQL(){
		return employeService.getNombreEmployeJPQL();
	}
	
	@GetMapping("/retreiveAllEmployeNames")
	@ResponseBody
	public List<String> getAllEmployeNamesJPQL() {
		return employeService.getAllEmployeNamesJPQL();
	}
}
