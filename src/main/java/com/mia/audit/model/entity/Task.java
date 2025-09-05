package com.mia.audit.model.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema="mia_audit")
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name="user_id")
  private User user;
  @ManyToOne
  @JoinColumn(name="Form_id")
  private DefaultForm form;
  private LocalDateTime createdAt=LocalDateTime.now();
  
public Task() {
	// TODO Auto-generated constructor stub
}
public Task(Long id, User user, DefaultForm form) {
	super();
	this.id = id;
	this.user = user;
	this.form = form;
}

  public Long getId() {
	return id;
  }
  public void setId(Long id) {
	this.id = id;
  }
  public User getUser() {
	return user;
  }
  public void setUser(User user) {
	this.user = user;
  }
  public DefaultForm getForm() {
	return form;
  }
  public void setForm(DefaultForm form) {
	this.form = form;
  }
  public LocalDateTime getCreatedAt() {
	return createdAt;
  }
  public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
  }
}