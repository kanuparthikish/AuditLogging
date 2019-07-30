package com.example.demo.rds.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.rds.model.Employee;
import com.example.demo.repositry.EmpRepositry;

@Service
public class EmpService {
	
	@Autowired
	EmpRepositry empRespositry;
	
	
	
	public Employee saveEmployee(Employee emp)
	{
		
		empRespositry.save(emp);
		
		return emp;
	}
	
	public Employee getEmployee(Long id)
	{
		
		Employee emp=null;
		Optional<Employee> opt=empRespositry.findById(id);
		if(opt!=null)
		{
		emp=opt.get();
		}
		return  emp;
	}

	public Employee updateEmployee(Long id,Employee empUpdate)
	{
		Optional<Employee> opt=empRespositry.findById(id);
		Employee emp=null;
		if(opt!=null)
		{
		 emp=opt.get();
		}
		empUpdate.setId(emp.getId());
		empRespositry.save(empUpdate);
		return  empUpdate;
	}
	
	public void deleteEmployee(Long id)
	{
		empRespositry.deleteById(id);
	}
	
	public List<Employee> ListOfEmployee()
	{
		List<Employee> list = new ArrayList<>();
		empRespositry.findAll().forEach(e -> list.add(e));
		return list;
	}
	
	
}
