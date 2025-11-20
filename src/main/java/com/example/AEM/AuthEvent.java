package com.example.AEM;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="auth_event")
public class AuthEvent {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
  @ManyToOne @JoinColumn(name="employee_id") private Employee employee;
  @Column(nullable = false)
  private String eventType; // LOGIN or LOGOUT


  private LocalDateTime eventTime;


  private String ipAddress;
  // getters/setters


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public Employee getEmployee() {
	return employee;
}


public void setEmployee(Employee employee) {
	this.employee = employee;
}


public String getEventType() {
	return eventType;
}


public void setEventType(String eventType) {
	this.eventType = eventType;
}


public LocalDateTime getEventTime() {
	return eventTime;
}


public void setEventTime(LocalDateTime eventTime) {
	this.eventTime = eventTime;
}


public String getIpAddress() {
	return ipAddress;
}


public void setIpAddress(String ipAddress) {
	this.ipAddress = ipAddress;
}
}
