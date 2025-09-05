package com.mia.audit.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "mia_audit")
public class Pilot {
@Id	
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String departement;
@OneToMany
@JoinColumn(name="user_id")
private List<User> users;
public Pilot() {
}
public Pilot(Long id, String departement, List<User> users) {
	this.id = id;
	this.departement = departement;
	this.users = users;
}
public Long getId() {
	return id;
}

public String getDepartement() {
	return departement;
}
public void setDepartement(String departement) {
	this.departement = departement;
}
public List<User> getUsers() {
	return users;
}
public void setUsers(List<User> users) {
	this.users = users;
}
}