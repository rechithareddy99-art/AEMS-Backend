package com.example.AEM;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService auth;

    public AuthController(AuthService auth) {
        this.auth = auth;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        return auth.login(email, password)
                .<ResponseEntity<?>>map(emp -> ResponseEntity.ok(emp))
                .orElseGet(() -> ResponseEntity.status(401).body("Invalid credentials"));
    }
}
