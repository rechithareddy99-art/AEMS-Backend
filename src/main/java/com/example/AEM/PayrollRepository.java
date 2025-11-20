package com.example.AEM;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {

    /**
     * Find payroll record for a specific employee and month (month stored as "YYYY-MM").
     */
    Optional<Payroll> findByEmployeeIdAndMonth(Long employeeId, String month);

    /**
     * Find all payroll records for an employee (useful for history).
     */
    List<Payroll> findByEmployeeId(Long employeeId);

    /**
     * Find all payroll records for a given month (useful for running payroll reports).
     * Example month format: "2025-10"
     */
    List<Payroll> findByMonth(String month);

    /**
     * Convenience: find payroll records for an employee ordered most-recent first.
     */
    List<Payroll> findByEmployeeIdOrderByMonthDesc(Long employeeId);
}
