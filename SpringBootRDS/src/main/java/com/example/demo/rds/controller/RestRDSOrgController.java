package com.example.demo.rds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.rds.model.Organization;
import com.example.demo.rds.service.OrgService;

@RestController
@RequestMapping(value="/RdsOrg")
public class RestRDSOrgController {
	
	@Autowired
	OrgService orgService;
	
	@GetMapping
    public Organization getOrg(@RequestParam("id") Long oid)
    {
		return orgService.getOrganization(oid);
    }
	@PostMapping
    public List<Organization> saveOrg(@RequestBody Organization org	)
    {
	
		orgService.saveOrganization(org);
		return null;
    }
	@PutMapping
    public List<Organization> updateOrg(@RequestParam("id") Long  oid,@RequestBody Organization org)
    {
		return null;
    }
	@DeleteMapping
    public List<Organization> deleteOrg(@RequestParam("id") Long oid)
    {
		return null;
    }
	@GetMapping(value="/list")
    public List<Organization> getOrgList()
    {
		return null;
    }
}
