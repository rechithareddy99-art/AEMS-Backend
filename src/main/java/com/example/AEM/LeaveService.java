package com.example.AEM;


import org.springframework.stereotype.Service;
import java.time.LocalDateTime; import java.util.List;
@Service
public class LeaveService {
    private final LeaveRepository repo; private final EmployeeRepository empRepo;
    public LeaveService(LeaveRepository repo, EmployeeRepository empRepo){ this.repo=repo; this.empRepo=empRepo; }
    public LeaveRequest submit(Long empId, LeaveRequest lr){
        Employee emp = empRepo.findById(empId).orElseThrow();
        lr.setEmployee(emp); lr.setStatus("PENDING"); lr.setRequestedAt(LocalDateTime.now());
        return repo.save(lr);
    }
    public List<LeaveRequest> pending(){ return repo.findByStatus("PENDING"); }
    public LeaveRequest decide(Long leaveId, String decision, String managerComment){
        LeaveRequest lr = repo.findById(leaveId).orElseThrow();
        lr.setStatus(decision); lr.setManagerComment(managerComment); lr.setDecidedAt(LocalDateTime.now());
        return repo.save(lr);
    }
    public List<LeaveRequest> getByEmployee(Long empId) {
        return repo.findByEmployeeId(empId);
    }

}
