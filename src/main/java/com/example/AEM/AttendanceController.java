package com.example.AEM;

import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/attendance")
public class AttendanceController {
    private final AttendanceService svc; public AttendanceController(AttendanceService svc){ this.svc=svc; }
    @PostMapping("/mark-in") public Attendance markIn(@RequestParam Long empId){ return svc.markIn(empId); }
    @PostMapping("/mark-out") public Attendance markOut(@RequestParam Long empId){ return svc.markOut(empId); }
    @GetMapping("/employee/{id}") public List<Attendance> byEmployee(@PathVariable Long id){ return svc.getByEmployee(id); }
}
