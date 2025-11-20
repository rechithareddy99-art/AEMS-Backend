package com.example.AEM;

import com.example.AEM.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate; import java.util.*;
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<Attendance> findByEmployeeIdAndAttendDate(Long empId, LocalDate date);
    List<Attendance> findByEmployeeIdAndAttendDateBetween(Long empId, LocalDate start, LocalDate end);
    List<Attendance> findByEmployeeId(Long empId);
}
