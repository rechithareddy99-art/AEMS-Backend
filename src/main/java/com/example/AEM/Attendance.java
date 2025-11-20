package com.example.AEM;


import jakarta.persistence.*; import lombok.*; import java.time.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity @Table(name="attendance", uniqueConstraints = {@UniqueConstraint(columnNames={"employee_id","attend_date"})})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Attendance {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  private LocalDate attendDate;
  private LocalTime loginTime;
  private LocalTime logoutTime;
  @Column(length=50) private String status;
  @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="employee_id") private Employee employee;
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public LocalDate getAttendDate() {
	return attendDate;
}

public void setAttendDate(LocalDate attendDate) {
	this.attendDate = attendDate;
}

public LocalTime getLogoutTime() {
	return logoutTime;
}

public void setLogoutTime(LocalTime logoutTime) {
	this.logoutTime = logoutTime;
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

//ADD this setter if it doesn't exist
  public void setLoginTime(LocalTime loginTime) {
      this.loginTime = loginTime;
  }

  // and a getter if needed
  public LocalTime getLoginTime() {
      return this.loginTime;
  }

  // .
}
