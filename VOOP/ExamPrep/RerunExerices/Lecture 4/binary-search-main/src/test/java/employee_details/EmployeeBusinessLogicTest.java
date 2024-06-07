package employee_details;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeBusinessLogicTest {

    @Test
    void calculateYearlySalary() {
        Employee employee = new Employee("John", 8000,25);
        EmployeeBusinessLogic eb = new EmployeeBusinessLogic();
        assertEquals(96000,eb.calculateYearlySalary(employee));
    }

    @Test
    void calculateAppraisal() {
        Employee employee = new Employee("John", 8000,25);
        EmployeeBusinessLogic eb = new EmployeeBusinessLogic();

        if(employee.getMonthlySalary() < 10000){
            assertEquals(500,eb.calculateAppraisal(employee));
        }else{
            assertEquals(1000,eb.calculateAppraisal(employee));
        }


    }
}