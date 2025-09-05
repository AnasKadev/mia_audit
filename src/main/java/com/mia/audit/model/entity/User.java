package com.mia.audit.model.entity;
import java.security.PublicKey;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.mia.audit.model.entity.Role;

@Entity
@Table(schema="mia_audit")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstname;
	private String lastname;
	private String pwd;
	@Enumerated(EnumType.STRING)
	private Role role;
	public User() {}
	public User(Long id, String firstname, String lastname, String pwd, Role role) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.pwd = pwd;
		this.role = role;
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
	public String getPwd() {
		return pwd;
	
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}
