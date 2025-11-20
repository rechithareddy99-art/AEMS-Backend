package com.example.AEM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class AuthServiceTest {
	private EmployeeRepository repo; 
    private AuthService authService;

    @BeforeEach
    void setup() {
        repo = Mockito.mock(EmployeeRepository.class);
        authService = new AuthService(repo);
    }

    @Test
    void testSuccessfulLogin() {
        // Given
        Employee emp = new Employee();
        emp.setEmail("sindu@example.com");
        emp.setPassword("pass123");

        when(repo.findByEmail("sindu@example.com"))
                .thenReturn(Optional.of(emp));

        // When
        Optional<Employee> result = authService.login("sindu@example.com", "pass123");

        // Then
        assertTrue(result.isPresent(), "Login should be successful");
        assertEquals("sindu@example.com", result.get().getEmail());
        verify(repo, times(1)).findByEmail("sindu@example.com");
    }

    @Test
    void testLoginWithWrongPassword() {
        // Given
        Employee emp = new Employee();
        emp.setEmail("sindu@example.com");
        emp.setPassword("pass123");

        when(repo.findByEmail("sindu@example.com"))
                .thenReturn(Optional.of(emp));

        // When
        Optional<Employee> result = authService.login("sindu@example.com", "pass12");

        // Then
        assertFalse(result.isPresent(), "Login should fail with wrong password");
    }

    @Test
    void testLoginWhenUserNotFound() {
        // Given
        when(repo.findByEmail("missing@example.com"))
                .thenReturn(Optional.empty());

        // When
        Optional<Employee> result = authService.login("missing@example.com", "pass123");

        // Then
        assertFalse(result.isPresent(), "Login should fail when user does not exist");
    }
}
