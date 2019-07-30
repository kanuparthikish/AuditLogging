package com.example.demo.rds.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.rds.model.Employee;
import com.example.demo.rds.service.EmpService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(PowerMockRunner.class)
public class RestRDSEmployeeControllerTest {
	
	@InjectMocks 
	RestRDSEmployeeController restRDSEmployeeController=null;

	
	MockMvc mockMVC=null;
	Employee emp=null;
	

	@Mock 
	EmpService empService;
	
	
	
	ObjectMapper om =null;
	@Before
	public void setUp()throws Exception
	{
		
		mockMVC = MockMvcBuilders.standaloneSetup(restRDSEmployeeController)
	                .build();
		om = new ObjectMapper();
		 emp=new Employee();
		emp.setId(1L);
		emp.setName("kishore");
		emp.setSal(30000D);
	}


	@Test
	public void  testGetEmployee() throws Exception
	{
		Mockito. when(empService.getEmployee(Mockito.anyLong())).thenReturn(emp);
		MvcResult result=mockMVC.perform(get("/RdsEmp/{id}",1).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Employee employee = om.readValue(resultContent, Employee.class);
		assertTrue(employee.getName().equals("kishore"));
	}

	@Test
	public void testSaveEmployee() throws Exception{
		Mockito.when(empService.saveEmployee(Mockito.any(Employee.class))).thenReturn(emp);
		String jsonRequest = om.writeValueAsString(emp);
		MvcResult result=mockMVC.perform(post("/RdsEmp").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated()).andReturn();
		MockHttpServletResponse response=result.getResponse();
		System.out.println(" response.getHeader(HttpHeaders.LOCATION)"+response.getHeader(HttpHeaders.LOCATION));
		assertEquals("http://localhost/RdsEmp/1",
				response.getHeader(HttpHeaders.LOCATION));
	
	}
	
	@Test
	public void testUpdateEmployee() throws Exception{
		
		Mockito.when(empService.updateEmployee(Mockito.anyLong(),Mockito.any(Employee.class))).thenReturn(emp);
		String jsonRequest = om.writeValueAsString(emp);
		MvcResult result=mockMVC.perform(put("/RdsEmp/{id}","1").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Employee employee = om.readValue(resultContent, Employee.class);
		assertTrue(employee.getName().equals("kishore"));
	
	}
	
	@Test
	public void testDeleteEmployee() throws Exception {
	   	    doNothing().when(empService).deleteEmployee(Mockito.anyLong());
	   	 mockMVC.perform(
	            delete("/RdsEmp/{id}", "1"))
	            .andExpect(status().isOk());
	  
	    verify(empService, times(1)).deleteEmployee(Mockito.anyLong());
	
	}
	
}

