package com.mia.audit.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(schema = "mia_audit")
public class ActionPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String auditor;
	@CreationTimestamp
	
	private LocalDateTime opened_date;
	
	private String area;
	
	@Column(columnDefinition = "TEXT")
	private String issue_description;
	
	@Column(columnDefinition = "TEXT")
	private String action_plan;
	
	private String pilot;
	
	private String status;
	
	public ActionPlan() {
	}
	public ActionPlan(Long id, String auditor, LocalDateTime opened_date, String area, String issue_description, String action_plan, String pilot, String status) {
		this.id = id;
		this.auditor = auditor;
		this.opened_date = opened_date;
		this.area = area;
		this.issue_description = issue_description;
		this.action_plan = action_plan;
		this.pilot = pilot;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public LocalDateTime getOpened_date() {
		return opened_date;
	}
	public void setOpened_date(LocalDateTime opened_date) {
		this.opened_date = opened_date;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getIssue_description() {
		return issue_description;
	}
	public void setIssue_description(String issue_description) {
		this.issue_description = issue_description;
	}
	public String getAction_plan() {
		return action_plan;
	}
	public void setAction_plan(String action_plan) {
		this.action_plan = action_plan;
	}
	public String getPilot() {
		return pilot;
	}
	public void setPilot(String pilot) {
		this.pilot = pilot;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
