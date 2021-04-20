package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Timesheet;
import tn.esprit.spring.entity.TimesheetPk;

public interface TimesheetRepository extends CrudRepository<Timesheet, TimesheetPk> {

}
