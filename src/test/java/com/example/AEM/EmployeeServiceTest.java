package com.example.AEM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class EmployeeServiceTest {
	 private EmployeeRepository repo;
	    private EmployeeService service;

	    @BeforeEach
	    void setup() {
	        repo = Mockito.mock(EmployeeRepository.class);
	        service = new EmployeeService(repo);
	    }

	    @Test
	    void testCreateEmployee() {

	        // Given: an employee object to save
	        Employee emp = new Employee();
	        emp.setId(1L);
	        emp.setFirstName("LL");
	        emp.setLastName("LL");
	        emp.setBankAccount("123456");
	        emp.setBankIfsc("IFSC0001");
	        emp.setInsuranceProvider("ABC");
	        emp.setInsuranceNumber("INS12345");
	        emp.setBaseSalary(50000.00);

	        // Mock behavior: repo.save(emp) returns the same employee
	        when(repo.save(emp)).thenReturn(emp);

	        // When: calling the service create method
	        Employee saved = service.create(emp);

	        // Then: validate returned employee
	        assertNotNull(saved);
	        assertEquals(1L, saved.getId());
	        assertEquals("LL", saved.getFirstName());
	        assertEquals("LL", saved.getLastName());
	        assertEquals("123456", saved.getBankAccount());
	        assertEquals("IFSC0001", saved.getBankIfsc());
	        assertEquals("ABC", saved.getInsuranceProvider());
	        assertEquals("INS12345", saved.getInsuranceNumber());
	        assertEquals(50000.00, saved.getBaseSalary());

	        // Verify repo.save() is called exactly once
	        verify(repo, times(1)).save(emp);
	    }
}
