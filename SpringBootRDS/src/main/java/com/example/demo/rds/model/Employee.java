package com.example.demo.rds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(exclude= {"name","sal"})
@Entity(name="EMP_TB")
@Audited
@AuditTable(value="EMP_TB_AUD")
public class Employee {

	@Id
	@Column(name="id")
	@GeneratedValue(generator="empseq")
	@SequenceGenerator(name="empseq",sequenceName="emp_id_seq",allocationSize=1)
	private Long id;
	@Column(name="ename")
	private String name;
	@Column(name="sal")
	private Double sal;

//	@ManyToOne
//	@JoinColumn(name="EMP_FOREIGN_KEY")
//	private Organization org;
}
