package com.example.AEM;

import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService svc; public EmployeeController(EmployeeService svc){ this.svc = svc; }
    @PostMapping public Employee create(@RequestBody Employee e){ return svc.create(e); }
    @GetMapping public List<Employee> all(){ return svc.list(); }
    @GetMapping("/{id}") public Employee get(@PathVariable Long id){ return svc.find(id).orElse(null); }
    @PutMapping("/{id}") public Employee update(@PathVariable Long id, @RequestBody Employee dto){ return svc.updateProfile(id,dto); }
}

