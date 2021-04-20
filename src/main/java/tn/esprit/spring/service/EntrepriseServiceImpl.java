package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
@Service
public class EntrepriseServiceImpl implements EntrepriseService {
	
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	DepartementRepository departementRepository;

	@Override
	public int ajouterEntreprise(Entreprise entreprise) {
		return (int) entrepriseRepository.save(entreprise).getId();
	}

	@Override
	public int ajouterDepartement(Departement dep) {
		Departement departement = departementRepository.save(dep);
		return (int) departement.getId();
	}

	@Override
	public void affecterDepartementAEntreprise(int depid, int entrepriseid) {
		Entreprise entreprise = entrepriseRepository.findById((long) entrepriseid).get();
		Departement departement = departementRepository.findById((long) depid).get();
		if (!ObjectUtils.isEmpty(entreprise) && !ObjectUtils.isEmpty(departement)) {
			departement.setEntreprise(entreprise);
			departementRepository.save(departement);
		}
		
	}

	@Override
	public List<String> getAllDepartementNamesByEntreprise(int entrepriseid) {

		Entreprise entreprise = entrepriseRepository.findById((long) entrepriseid).get();
		List<String> depNames = new ArrayList<>();
		if(!ObjectUtils.isEmpty(entreprise)) {
			for (Departement dep : entreprise.getDepartements()){
				depNames.add(dep.getName());
			}
		}
		return depNames;
	}

}
