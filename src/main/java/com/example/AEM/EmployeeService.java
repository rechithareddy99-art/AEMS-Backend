package com.example.AEM;

import org.springframework.stereotype.Service;
import java.util.List; import java.util.Optional;
@Service
public class EmployeeService {
    private final EmployeeRepository repo;
    public EmployeeService(EmployeeRepository repo){ this.repo = repo; }
    public Employee create(Employee e){ return repo.save(e); }
    public List<Employee> list(){ return repo.findAll(); }
    public Optional<Employee> find(Long id){ return repo.findById(id); }
    public Employee updateProfile(Long id, Employee dto){
        return repo.findById(id).map(ex -> {
            ex.setFirstName(dto.getFirstName()); ex.setLastName(dto.getLastName());
            ex.setBankAccount(dto.getBankAccount()); ex.setBankIfsc(dto.getBankIfsc());
            ex.setInsuranceProvider(dto.getInsuranceProvider()); ex.setInsuranceNumber(dto.getInsuranceNumber());
            ex.setBaseSalary(dto.getBaseSalary());
            return repo.save(ex);
        }).orElseThrow();
    }
}
