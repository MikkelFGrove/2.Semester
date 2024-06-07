Create a class called **Student** with the following attributes:

    name (String)
    age (int)
    grade (double)

1. Create a constructor for the Student class that initializes all attributes. 
2. Implement getter methods for all attributes. 
3. Override the **toString** method to provide a string representation of the Student object. 
4. Implement the Comparable interface in the Student class so that students can be sorted based on their age in ascending order. 
5. Write a class called **StudentComparator** that implements the Comparator interface. Implement the compare method so that students can be sorted based on their grade in descending order. 
6. A **Main.java** class is already implemented with a main method. The code in the main method is commented out. Please uncomment the code and run **Main.java**.<br>

**Hint**: <br>
* Please pay attention to the access modifiers for variables, constructor and methods.
* Use getter methods in compareTo and compare method implementation.<br>

**The output should look like the following:**

    Sorted by age:
    Student{name='Alice', age=20, grade=85.5}
    Student{name='Charlie', age=21, grade=90.0}
    Student{name='Bob', age=22, grade=75.0}
    
    Sorted by grade:
    Student{name='Charlie', age=21, grade=90.0}
    Student{name='Alice', age=20, grade=85.5}
    Student{name='Bob', age=22, grade=75.0}