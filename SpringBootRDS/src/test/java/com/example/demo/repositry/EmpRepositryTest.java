package com.example.demo.repositry;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.rds.model.Employee;
import com.example.demo.rds.model.Organization;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmpRepositryTest {
	
	 @Autowired
	    private EmpRepositry employeeRepository;
	 
	 @Autowired
	    private TestEntityManager entityManager;
	 
	 Employee emp=null;
	 
	

	    @Test
	    public void testSaveEmployee() {

	    	emp=new Employee();

			emp.setName("kishore");
			emp.setSal(30000D);
	        employeeRepository.save(emp);
	       
	      Long id = entityManager.persistAndGetId(emp, Long.class);
	        Employee employee2 = employeeRepository.findByName("kishore");
	        assertNotNull(emp);
	        assertNotNull(emp);
	        assertTrue(emp.getName().equals(employee2.getName()));
	    }

}
