package com.SpringSecurityDemo.entity;



import jakarta.persistence.*;

@Entity
@Table(name="crud")

public class User {
	private String name;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public User() {
		
	}
	
	

}

