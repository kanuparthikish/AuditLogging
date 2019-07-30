package com.example.demo.rds.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.rds.model.Employee;
import com.example.demo.rds.service.EmpService;

@RestController
@RequestMapping(value="/RdsEmp")
public class RestRDSEmployeeController {
	
	@Autowired
	EmpService empService;
	
	@GetMapping(value="/{id}")
    public Employee getEmployee(@PathVariable("id") Long eid )
    {
		Employee emp= empService.getEmployee(eid);
		
		return emp;
    }
	@PostMapping
    public ResponseEntity<Object> saveEmploee(@RequestBody Employee emp	)
    {
		
		empService.saveEmployee(emp);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emp.getId()).toUri();
    	return ResponseEntity.created(uri).build();
    }
	
	@PutMapping(value="/{id}")
    public Employee updateEmployee(@PathVariable("id") Long eid,@RequestBody Employee emp)
    {
		Employee empUpdate= empService.updateEmployee(eid, emp);
		return empUpdate;
    }
	@DeleteMapping(value="/{id}")
    public void deleteEmployee(@PathVariable("id") Long eid)
    {
		 empService.deleteEmployee(eid);
    }
	@GetMapping(value="/list")
    public List<Employee> getEmploeeList()
    {
		return empService.ListOfEmployee();
    }
}
