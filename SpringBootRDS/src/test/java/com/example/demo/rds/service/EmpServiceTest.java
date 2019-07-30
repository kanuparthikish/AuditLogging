package com.example.demo.rds.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import com.example.demo.rds.model.Employee;
import com.example.demo.rds.model.Organization;
import com.example.demo.repositry.EmpRepositry;

@RunWith(PowerMockRunner.class)
public class EmpServiceTest {
	
	@InjectMocks
	EmpService empService=null;
	
	@Mock
	EmpRepositry empRepositry=null;
	
	Employee emp=null;
	
	Organization org=null;
	
	@Before
	public void setUp()throws Exception
	{
		 emp=new Employee();
		emp.setId(1L);
		emp.setName("kishore");
		emp.setSal(30000D);
		
		org=new Organization();
		org.setName("Infics");
		org.setLoc("Blr");
	}
	
	@After
	public void tearDown()throws Exception
	{
		 emp=null;
		
		org=null;
	}


	@Test
	public void testSaveEmployee() {
		when(empRepositry.save(Mockito.any(Employee.class))).thenReturn(emp);
		assertEquals(emp, empService.saveEmployee(emp));
		verify(empRepositry, times(1)).save(emp);
	}
	

}
