package com.example.AEM;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    private final LeaveService svc;

    public LeaveController(LeaveService svc) {
        this.svc = svc;
    }

    @PostMapping("/submit")
    public LeaveRequest submit(@RequestParam Long empId, @RequestBody LeaveRequest lr) {
        return svc.submit(empId, lr);
    }

    @GetMapping("/pending")
    public List<LeaveRequest> pending() {
        return svc.pending();
    }

    @PostMapping("/decide")
    public LeaveRequest decide(@RequestParam Long leaveId,
                               @RequestParam String decision,
                               @RequestParam(required = false) String comment) {
        return svc.decide(leaveId, decision, comment);
    }

    @GetMapping("/employee/{id}")
    public List<LeaveRequest> byEmployee(@PathVariable Long id) {
        return svc.getByEmployee(id);
    }
}

