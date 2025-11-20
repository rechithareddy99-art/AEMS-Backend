package com.example.AEM;

import org.springframework.web.bind.annotation.*; import java.time.YearMonth;
@RestController @RequestMapping("/api/payroll")
public class PayrollController {
    private final PayrollService svc; public PayrollController(PayrollService svc){ this.svc=svc; }
    @PostMapping("/compute") public Payroll compute(@RequestParam Long empId, @RequestParam String month){ YearMonth ym = YearMonth.parse(month); return svc.computeForMonth(empId, ym); }
}
