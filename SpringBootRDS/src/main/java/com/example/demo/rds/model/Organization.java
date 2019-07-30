package com.example.demo.rds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude= {"name","loc"})
@Entity(name="ORG_TB")
@Audited
@AuditTable(value="ORG_TB_AUD")
public class Organization {
	
	@Id
	@Column(name="ORG_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="org_id_seq")
	@SequenceGenerator(name="org_id_seq",sequenceName="org_id_seq",allocationSize=1) 
	Long oid;
	@Column(name="org_name")
	String name;
	@Column(name="loc")
	String loc;

}
