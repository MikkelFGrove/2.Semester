package Exercise2_Solution;

public class Employee implements Comparable<Employee> {
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee other) {
        // Compare based on department and salary
        if (this.getDepartment().equals(other.getDepartment())) {
            return Double.compare(other.getSalary(), this.getSalary()); // Sort by salary in descending order
        } else {
            return this.getDepartment().compareTo(other.getDepartment()); // Sort by department name in alphabetical order
        }
    }
}
