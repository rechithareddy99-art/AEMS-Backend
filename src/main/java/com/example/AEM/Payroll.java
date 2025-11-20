package com.example.AEM;

import jakarta.persistence.*; import lombok.*; import java.math.BigDecimal;
@Entity @Table(name="payroll")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Payroll {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="employee_id") private Employee employee;
  private String month; // YYYY-MM
  @Column(precision=10, scale=2) private BigDecimal gross;
  @Column(precision=10, scale=2) private BigDecimal net;
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
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}
public BigDecimal getGross() {
	return gross;
}
public void setGross(BigDecimal gross) {
	this.gross = gross;
}
public BigDecimal getNet() {
	return net;
}
public void setNet(BigDecimal net) {
	this.net = net;
}
}

