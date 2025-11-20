package com.example.AEM;


import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class AuthService {
    private final EmployeeRepository repo;
    public AuthService(EmployeeRepository repo){ this.repo = repo; }
    public Optional<Employee> login(String email, String password){
        return repo.findByEmail(email).filter(e -> e.getPassword().equals(password));
    }
}

