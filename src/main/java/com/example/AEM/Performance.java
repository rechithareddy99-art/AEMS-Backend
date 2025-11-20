package com.example.AEM;

import jakarta.persistence.*; import lombok.*; import java.time.LocalDateTime;
@Entity @Table(name="performance")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Performance {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  private String title;
  private String description;
  private Integer score;
  @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="employee_id") private Employee employee;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;           // NEW: track last update time
  private String managerFeedback;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public Integer getScore() { return score; }
  public void setScore(Integer score) { this.score = score; }
  public Employee getEmployee() { return employee; }
  public void setEmployee(Employee employee) { this.employee = employee; }
  public LocalDateTime getCreatedAt() { return createdAt; }
  public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
  public LocalDateTime getUpdatedAt() { return updatedAt; }
  public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
  public String getManagerFeedback() { return managerFeedback; }
  public void setManagerFeedback(String managerFeedback) { this.managerFeedback = managerFeedback; }
}
