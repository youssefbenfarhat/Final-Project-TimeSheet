package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.service.EntrepriseService;

@RestController
public class EntrepriseRestControlImpl {

	@Autowired
	EntrepriseService entrepriseService;
	
	@PostMapping("/ajouterEntreprise")
	@ResponseBody
	public int ajouterEntreprise(@RequestBody Entreprise entreprise) {
		return entrepriseService.ajouterEntreprise(entreprise);
	}
	
	
	@PostMapping("/ajouterDepartement")
	@ResponseBody
	public int ajouterDepartement(@RequestBody Departement dep) {
		return entrepriseService.ajouterDepartement(dep);
	}
	
	@PostMapping("/affecterDepartementAEntreprise/{depid}/{entrepriseid}")
	@ResponseBody
	void affecterDepartementAEntreprise(@PathVariable("depid") int depid, @PathVariable("entrepriseid") int entrepriseid) {
		entrepriseService.affecterDepartementAEntreprise(depid, entrepriseid);
	}
	
	@GetMapping("/retreiveAllDepartementNamesByEntreprise/{entrepriseid}")
	@ResponseBody
	List<String> getAllDepartementNamesByEntreprise(@PathVariable("entrepriseid")int entrepriseid) {
		return entrepriseService.getAllDepartementNamesByEntreprise(entrepriseid);
	}
}
