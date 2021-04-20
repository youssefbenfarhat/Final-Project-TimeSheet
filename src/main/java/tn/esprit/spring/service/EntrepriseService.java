package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Entreprise;

public interface EntrepriseService {
	
	public int ajouterEntreprise(Entreprise entreprise);
	public int ajouterDepartement(Departement dep);
	void affecterDepartementAEntreprise(int depid, int entrepriseid);
	List<String> getAllDepartementNamesByEntreprise(int entrepriseid);
	
	

}
