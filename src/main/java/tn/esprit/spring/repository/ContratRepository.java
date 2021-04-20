package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Employe;

public interface ContratRepository extends CrudRepository<Contrat, Employe> {

}
