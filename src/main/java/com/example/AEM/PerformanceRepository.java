package com.example.AEM;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {

    /**
     * List all performance entries for an employee.
     */
    List<Performance> findByEmployeeId(Long employeeId);

    /**
     * List performance entries for an employee ordered by creation time (newest first).
     */
    List<Performance> findByEmployeeIdOrderByCreatedAtDesc(Long employeeId);

    /**
     * Find performance entries with at least the given score (useful for reporting).
     */
    List<Performance> findByScoreGreaterThanEqual(Integer score);

    /**
     * Example explicit JPQL query (equivalent to findByEmployeeIdOrderByCreatedAtDesc).
     * You can keep this if you prefer JPQL; otherwise the derived query above is enough.
     */
    @Query("SELECT p FROM Performance p WHERE p.employee.id = :empId ORDER BY p.createdAt DESC")
    List<Performance> findForEmployeeOrdered(@Param("empId") Long empId);

    /**
     * Combined filter helper (employee + minimum score).
     */
    List<Performance> findByEmployeeIdAndScoreGreaterThanEqual(Long employeeId, Integer score);
}
