package Exercise1;


import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20, 85.5));
        students.add(new Student("Bob", 22, 75.0));
        students.add(new Student("Charlie", 21, 90.0));

        // Sort based on age using Comparable interface
        Collections.sort(students);
        System.out.println("Sorted by age:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sort based on grade using StudentComparator
        Collections.sort(students, new StudentComparator());
        System.out.println("\nSorted by grade:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}