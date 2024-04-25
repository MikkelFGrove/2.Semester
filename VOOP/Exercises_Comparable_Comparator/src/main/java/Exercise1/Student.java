package Exercise1;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private double grade;

    Student(String name, int age, double grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + " age: " + age + " grade: " + grade;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.age, o.age);
    }

}

