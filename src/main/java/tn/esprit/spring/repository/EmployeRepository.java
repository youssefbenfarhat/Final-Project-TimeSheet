package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Employe;

public interface EmployeRepository extends CrudRepository<Employe, Long> {
	
	@Query("select count(e) from Employe e" )
	long getNombreEmployeJPQL();
	
	@Query("select e.nom from Employe e")
	List<String> getAllEmployeNamesJPQL();
}
