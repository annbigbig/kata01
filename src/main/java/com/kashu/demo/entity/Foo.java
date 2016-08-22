package com.kashu.demo.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("cass_foo")
public class Foo {
	@PrimaryKey("id")
	private Long id;
	
	@Column("firstname")
	private String firstname;
	
	@Column("lastname")
	private String lastname;
	
	public Foo(){
		
	}
	
	public Foo(Long id,String firstname,String lastname){
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
