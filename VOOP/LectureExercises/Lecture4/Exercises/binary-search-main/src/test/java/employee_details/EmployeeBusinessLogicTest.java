package employee_details;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class EmployeeBusinessLogicTest {

    @BeforeEach
    void setUp() {
        Employee employee=new Employee("John", 8000, 25);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateYearlySalary() {
        Employee employee=new Employee("John", 8000, 25);
        EmployeeBusinessLogic bl = new EmployeeBusinessLogic();
        assertEquals(96000, bl.calculateYearlySalary(employee));
    }

    @Test
    void calculateAppraisal() {
        Employee employee=new Employee("John", 8000, 25);
        EmployeeBusinessLogic bl = new EmployeeBusinessLogic();
        assertEquals(500, bl.calculateAppraisal(employee));
    }
}