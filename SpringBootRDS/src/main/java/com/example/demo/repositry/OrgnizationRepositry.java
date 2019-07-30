package com.example.demo.repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.rds.model.Organization;

@Repository
public interface OrgnizationRepositry extends CrudRepository<Organization, Long> {

}
