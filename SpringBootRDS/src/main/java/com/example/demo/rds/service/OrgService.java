package com.example.demo.rds.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.rds.model.Organization;
import com.example.demo.repositry.OrgnizationRepositry;

@Service
public class OrgService {
	@Autowired
	OrgnizationRepositry orgnizationRepositry;
	
	public Organization getOrganization(Long id)
	{
		Optional <Organization> opt =orgnizationRepositry.findById(id);
		Organization org=opt.get();
		System.out.println(org.getOid());
		System.out.println(org.getName());
		System.out.println(org.getLoc());
		return org;
	}
	public void saveOrganization(Organization org)
	{
		System.out.println(org.getOid());
		System.out.println(org.getName());
		System.out.println(org.getLoc());
		orgnizationRepositry.save(org);
		System.out.println(org.getOid());
		System.out.println(org.getName());
		System.out.println(org.getLoc());
	}
	public void updateOrganization(Organization org)
	{
		
	}
	public void deleteOrganization(Organization org)
	{
		
	}

}
