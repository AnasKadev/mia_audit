package com.mia.audit.model.dto;

public class UserDto {
private String firstname;
private String lastname;
private String pwd;
private String role;
private String pilote;
public String getFirstname() {
	return firstname;
}
public String getLastname() {
	return lastname;
}
public String getPwd() {
	return pwd;
}
public String getRole() {
	return role;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public void setRole(String role) {
	this.role = role;
}
public String getPilote() {
	return pilote;
}
public void setPilote(String pilote) {
	this.pilote = pilote;
}
}
