package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Employe;

public interface EmployeService {
	
	public Employe ajouterEmploye(Employe employe);
//	@Modifying
//	@Query(value = "INSERT INTO employe_employe_dep (employe_id, employe_dep_departement_id) VALUES (:employeid, :depid)", nativeQuery = true)
	public void affecterEmployeADepartement(int employeid, int depid);
	public int ajouterContrat(Contrat contrat);
	public void affecterContratAEmploye(int contratid, int employeid);
	public String getEpmloyePrenomById(int employeid);
	public long getNombreEmployeJPQL();
	public List<String> getAllEmployeNamesJPQL();
	Employe getEmploye(long id);
	List<Employe> RerieveAllEmployees();
	void DeleteEmployee(long id);
	Employe UpdateEmployee(Employe emp);

}
