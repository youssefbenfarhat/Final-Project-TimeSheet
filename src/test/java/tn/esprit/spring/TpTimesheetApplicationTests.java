package tn.esprit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import java.util.List;

import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.service.EmployeService;

@RunWith(SpringRunner.class)

@SpringBootTest
public class TpTimesheetApplicationTests {
	
	@Autowired
	 EmployeService es;

	
	
	
	@Test
	public void testAjouterEmploye() throws ParseException, java.text.ParseException
	{
		
		
		Employe e = new Employe("Chiheb","Mhamdi","chi08@gmail.com", Role.CHEF_DEPARTEMENT,  true) ;
		Employe employeadded =es.ajouterEmploye(e);
		assertEquals(e.getNom(), employeadded.getNom());
		
	}
	

	@Test
	public void testGetEmploye() throws ParseException, java.text.ParseException
	{
		
		Employe employeadded =es.getEmploye(1);
		assertEquals("Youssef", employeadded.getNom());
		
	}
	
	@Test
	public void testRerieveAllEmployees() throws ParseException, java.text.ParseException
	{
		 List<Employe> emps =es.RerieveAllEmployees();
		
		assertEquals(3, emps.size());
		
	}
	
	@Test
	public void testDeleteEmployee() throws ParseException, java.text.ParseException
	{
		es.DeleteEmployee(8); 
		
		
		
	}
	
	@Test
	public void testUpdateEmployee() throws ParseException, java.text.ParseException
	{
		Employe e = new Employe(7,"Amine","Riahi ","amineop@gmail.com", Role.CHEF_DEPARTEMENT,  true) ;
		Employe employeUpdated=es.UpdateEmployee(e); 
		assertEquals(e.getNom(), employeUpdated.getNom());
		
		
		
		
	}



}
