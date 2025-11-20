package com.example.AEM;

import org.springframework.stereotype.Service; import java.math.BigDecimal; import java.time.*; import java.util.List;
@Service
public class PayrollService {
    private final PayrollRepository payrollRepo; private final EmployeeRepository empRepo; private final AttendanceRepository attendanceRepo;
    public PayrollService(PayrollRepository p, EmployeeRepository e, AttendanceRepository a){ this.payrollRepo=p; this.empRepo=e; this.attendanceRepo=a; }
    public Payroll computeForMonth(Long empId, YearMonth month){
        Employee emp = empRepo.findById(empId).orElseThrow();
        BigDecimal base = BigDecimal.valueOf(emp.getBaseSalary() == null ? 0.0 : emp.getBaseSalary());
        LocalDate start = month.atDay(1); LocalDate end = month.atEndOfMonth();
        List<Attendance> attends = attendanceRepo.findByEmployeeIdAndAttendDateBetween(empId, start, end);
        long present = attends.stream().filter(a -> "PRESENT".equalsIgnoreCase(a.getStatus())).count();
        int days = end.getDayOfMonth();
        long absent = Math.max(0, days - present);
        BigDecimal perDay = days == 0 ? BigDecimal.ZERO : base.divide(BigDecimal.valueOf(days),2,BigDecimal.ROUND_HALF_UP);
        BigDecimal deduction = perDay.multiply(BigDecimal.valueOf(absent));
        BigDecimal net = base.subtract(deduction);
        Payroll p = payrollRepo.findByEmployeeIdAndMonth(empId, month.toString()).orElseGet(() -> { Payroll n=new Payroll(); n.setEmployee(emp); n.setMonth(month.toString()); return n; });
        p.setGross(base); p.setNet(net);
        return payrollRepo.save(p);
    }
}
