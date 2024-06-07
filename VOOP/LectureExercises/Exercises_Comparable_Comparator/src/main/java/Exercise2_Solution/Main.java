package Exercise2_Solution;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR", 60000));
        employees.add(new Employee("Bob", "Engineering", 75000));
        employees.add(new Employee("Charlie", "HR", 55000));
        employees.add(new Employee("David", "Marketing", 70000));

        // Sort based on department and salary using Comparable interface
        Collections.sort(employees);
        System.out.println("Sorted by department and salary:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Sort based on salary using EmployeeComparator
        Collections.sort(employees, new EmployeeComparator());
        System.out.println("\nSorted by salary:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}