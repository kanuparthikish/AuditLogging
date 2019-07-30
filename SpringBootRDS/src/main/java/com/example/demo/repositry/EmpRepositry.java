package com.example.demo.repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.rds.model.Employee;

@Repository
public interface EmpRepositry  extends CrudRepository<Employee, Long>{

	public Employee  findByName(String name);

}
