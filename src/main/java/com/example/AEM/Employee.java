package com.example.AEM;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="employee", uniqueConstraints = {@UniqueConstraint(columnNames="email"), @UniqueConstraint(columnNames="employee_code")})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(name="employee_code", nullable=false) private String employeeCode;
  @Column(nullable=false) private String firstName;
  private String lastName;
  @Column(nullable=false) private String email;
  public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getEmployeeCode() {
	return employeeCode;
}
public void setEmployeeCode(String employeeCode) {
	this.employeeCode = employeeCode;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getBankAccount() {
	return bankAccount;
}
public void setBankAccount(String bankAccount) {
	this.bankAccount = bankAccount;
}
public String getBankIfsc() {
	return bankIfsc;
}
public void setBankIfsc(String bankIfsc) {
	this.bankIfsc = bankIfsc;
}
public String getInsuranceProvider() {
	return insuranceProvider;
}
public void setInsuranceProvider(String insuranceProvider) {
	this.insuranceProvider = insuranceProvider;
}
public String getInsuranceNumber() {
	return insuranceNumber;
}
public void setInsuranceNumber(String insuranceNumber) {
	this.insuranceNumber = insuranceNumber;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Double getBaseSalary() {
	return baseSalary;
}
public void setBaseSalary(Double baseSalary) {
	this.baseSalary = baseSalary;
}
@Column(nullable=false) private String password;
  private String bankAccount;
  private String bankIfsc;
  private String insuranceProvider;
  private String insuranceNumber;
  private String role; // EMPLOYEE, MANAGER, HR
  private Double baseSalary;
}
