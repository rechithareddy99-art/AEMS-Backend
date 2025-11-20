package com.example.AEM;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveRequest, Long> {

    // All leave requests for a given employee
    List<LeaveRequest> findByEmployeeId(Long employeeId);

    // Leave requests by status (e.g., "PENDING", "APPROVED", "REJECTED")
    List<LeaveRequest> findByStatus(String status);

    // All leave requests for an employee with a particular status
    List<LeaveRequest> findByEmployeeIdAndStatus(Long employeeId, String status);

    // Find leaves for an employee that overlap a given date range
    List<LeaveRequest> findByEmployeeIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Long employeeId, LocalDate endDate, LocalDate startDate);

    // Convenience: find pending leaves (optional, you can also call findByStatus("PENDING"))
    default List<LeaveRequest> findPendingLeaves() {
        return findByStatus("PENDING");
    }
}
