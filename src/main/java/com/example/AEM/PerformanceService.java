package com.example.AEM;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class PerformanceService {

    private final PerformanceRepository repo;
    private final EmployeeRepository empRepo;

    public PerformanceService(PerformanceRepository repo, EmployeeRepository empRepo) {
        this.repo = repo;
        this.empRepo = empRepo;
    }

    /**
     * Create a new performance entry for the given employee.
     */
    public Performance add(Long empId, Performance p) {
        Employee emp = empRepo.findById(empId).orElseThrow(() -> new IllegalArgumentException("Employee not found: " + empId));
        p.setEmployee(emp);
        LocalDateTime now = LocalDateTime.now();
        p.setCreatedAt(now);
        p.setUpdatedAt(now);
        return repo.save(p);
    }

    /**
     * List performances for an employee (newest first).
     */
    public List<Performance> listByEmployee(Long empId) {
        return repo.findByEmployeeIdOrderByCreatedAtDesc(empId);
    }

    /**
     * Add manager feedback (no score).
     */
    public Performance addManagerFeedback(Long perfId, String feedback) {
        return addManagerFeedback(perfId, feedback, null);
    }

    /**
     * Add manager feedback and optionally set a score.
     */
    public Performance addManagerFeedback(Long perfId, String feedback, Integer score) {
        Performance p = repo.findById(perfId).orElseThrow(() -> new IllegalArgumentException("Performance not found: " + perfId));
        p.setManagerFeedback(feedback);
        if (score != null) p.setScore(score);
        p.setUpdatedAt(LocalDateTime.now());
        return repo.save(p);
    }

    /**
     * Manager: list all performances.
     */
    public List<Performance> listAll() {
        return repo.findAll();
    }
}
