package tn.esprit.spring.service;


import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Employe;

import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
@Service
public class EmployeServiceImpl implements EmployeService {
	
	
	private static final Logger l =LogManager.getLogger(EmployeServiceImpl.class) ;
	
	
	
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository departementRepository;
	@Autowired
	ContratRepository contratRepository;

	@Override
	public Employe ajouterEmploye(Employe employe) {
		
		Employe emp = null ;
		try {
			 emp = employeRepository.save(employe);
			l.info("Employe ajouté");
			
		}
		catch (Exception e)
		{
		l.error("Erreur lors de l'ajout de l'employe");
		
		}
		return emp;
	
	}
	
	@Override
	public Employe getEmploye (long id) {
		
		Employe emp = null ;
		try {
			if (employeRepository.findById( id).isPresent())
			{
				
			
			 emp = employeRepository.findById( id).get();
			l.info("Employe trouvé");

			}
		}
		catch (Exception e)
		{
		l.error("Employé n'existe pas ");
		
		}
		return emp;
	
	}
	
	@Override
	public List<Employe> rerieveAllEmployees () {
		
		List<Employe> employes=  null ;
		
		try {
			
			employes= (List<Employe>) employeRepository.findAll();
		}
		catch (Exception e)
		{
		l.error("Pas d'employe ");
		
		}
		return employes;
	
	}
	
	@Override
	public void deleteEmployee (long id) {
		
		
		
		try {
			
			
			if (getEmploye(id) !=null)
			{
				employeRepository.deleteById(id);
				l.info("Employe supprimé ");
			}
			
			
			
		}
		catch (Exception e)
		{
		l.error("Erreur lors de la suppression de l 'employe ");
		
		}
	}
	@Override
	public Employe updateEmployee (Employe emp) {
		
		
		
		try {
			
			if (employeRepository.findById(emp.getId()).isPresent())
			{
				emp=employeRepository.findById(emp.getId()).get();
				employeRepository.save(emp);
				l.info("emloye modifié ");
				return emp ;
			}
			
		}
		catch (Exception e)
		{
		l.error("erreur lors de la modification  ");
		
		}
		return null; 
	}

	@Override
	public void affecterEmployeADepartement(int employeid, int depid) {
		Employe employe = employeRepository.findById((long) employeid).get();
		Departement departement = departementRepository.findById((long) depid).get();
		if(!ObjectUtils.isEmpty(employe) && !ObjectUtils.isEmpty(departement)) {
			employe.getEmployeDep().add(departement);
		}
		employeRepository.save(employe);
		
	}

	@Override
	public int ajouterContrat(Contrat contrat) {
		return (int) contratRepository.save(contrat).getId();
	}

	@Override
	public void affecterContratAEmploye(int contratid, int employeid) {
		Employe employe = employeRepository.findById((long) employeid).get();
		Contrat contrat = contratRepository.findById(employe).get();
		if(!ObjectUtils.isEmpty(employe) && !ObjectUtils.isEmpty(contrat)) {
			employe.setContrat(contrat);
			employeRepository.save(employe);
		}
		
	}

	@Override
	public String getEpmloyePrenomById(int employeid) {
		return employeRepository.findById((long) employeid).get().getPrenom();
	}

	@Override
	public long getNombreEmployeJPQL() {
		return employeRepository.getNombreEmployeJPQL();
	}

	@Override
	public List<String> getAllEmployeNamesJPQL() {
		return employeRepository.getAllEmployeNamesJPQL();
	}



}
