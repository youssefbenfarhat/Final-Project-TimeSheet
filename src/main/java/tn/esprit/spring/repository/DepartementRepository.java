package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Departement;

public interface DepartementRepository extends CrudRepository<Departement, Long> {

}