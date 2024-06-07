Create a class called **Employee** with the following attributes: 

      name (String)
      department (String)
      salary (double)

1. Create a constructor for the Employee class that initializes all attributes.
2. Implement getter methods for all attributes.
3. Override the **toString** method to provide a string representation of the Employee object.
4. Implement the Comparable interface in the Employee class so that employees can be sorted based on their department in alphabetical order.

   * If two employees belong to the same department, sort them based on their salaries in descending order.

5. Write a class called **EmployeeComparator** that implements the Comparator interface. Implement the compare method so that employees can be sorted based on their salaries in descending order.
6. A **Main.java** class is already implemented with a main method. The code in the main method is commented out. Please uncomment the code and run **Main.java**.

**Hint**: <br>
* Please pay attention to the access modifiers for variables, constructor and methods.
* Use getter methods in compareTo and compare method implementation.<br>

**The output should look like the following:**

      Sorted by department and salary:
      Employee{name='Bob', department='Engineering', salary=75000.0}
      Employee{name='Alice', department='HR', salary=60000.0}
      Employee{name='Charlie', department='HR', salary=55000.0}
      Employee{name='David', department='Marketing', salary=70000.0}
         
      Sorted by salary:
      Employee{name='Bob', department='Engineering', salary=75000.0}
      Employee{name='David', department='Marketing', salary=70000.0}
      Employee{name='Alice', department='HR', salary=60000.0}
      Employee{name='Charlie', department='HR', salary=55000.0}



