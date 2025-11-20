package com.example.AEM;

import jakarta.persistence.*; import lombok.*; import java.time.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity @Table(name="leave_request")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LeaveRequest {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  private LocalDate startDate;
  private LocalDate endDate;
  private String reason;
  @Column(length=20) private String status; // PENDING, APPROVED, REJECTED
  @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="employee_id") private Employee employee;
  private LocalDateTime requestedAt;
  private LocalDateTime decidedAt;
  public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public LocalDate getStartDate() {
	return startDate;
}
public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
}
public LocalDate getEndDate() {
	return endDate;
}
public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
public LocalDateTime getRequestedAt() {
	return requestedAt;
}
public void setRequestedAt(LocalDateTime requestedAt) {
	this.requestedAt = requestedAt;
}
public LocalDateTime getDecidedAt() {
	return decidedAt;
}
public void setDecidedAt(LocalDateTime decidedAt) {
	this.decidedAt = decidedAt;
}
public String getManagerComment() {
	return managerComment;
}
public void setManagerComment(String managerComment) {
	this.managerComment = managerComment;
}
private String managerComment;
}
