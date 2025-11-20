package com.example.AEM;


import org.springframework.stereotype.Service;
import java.time.*; import java.util.List;
@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepo;
    private final EmployeeRepository employeeRepo;
    public AttendanceService(AttendanceRepository a, EmployeeRepository e){ this.attendanceRepo=a; this.employeeRepo=e; }
    public Attendance markIn(Long empId){
        Employee emp = employeeRepo.findById(empId).orElseThrow();
        LocalDate today = LocalDate.now();
        Attendance a = attendanceRepo.findByEmployeeIdAndAttendDate(empId, today).orElseGet(() -> {
            Attendance n = new Attendance(); n.setEmployee(emp); n.setAttendDate(today); return n;
        });
        a.setLoginTime(LocalTime.now()); a.setStatus("PRESENT");
        return attendanceRepo.save(a);
    }
    public Attendance markOut(Long empId){
        Attendance a = attendanceRepo.findByEmployeeIdAndAttendDate(empId, LocalDate.now()).orElseThrow();
        a.setLogoutTime(LocalTime.now());
        return attendanceRepo.save(a);
    }
    public List<Attendance> getByEmployee(Long empId){ return attendanceRepo.findByEmployeeId(empId); }
}

