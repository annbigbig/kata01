package com.kashu.demo.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.UUID;

@Table("cass_user")
public class User {

    @PrimaryKey("id")
    private UUID id;
    
    @Column("login")
    private String login;
    
    @Column("age")
    private int age;

    public User(){
    	
    }
    
    public User(UUID id, String login, int age) {
        this.id = id;
        this.login = login;
        this.age = age;
    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}