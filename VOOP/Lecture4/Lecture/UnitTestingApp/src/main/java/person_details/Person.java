package person_details;

public class Person {
    private String name;
    private int cpr;
    private int age;

    public Person(String name, int cpr, int age) {
        this.name = name;
        this.cpr = cpr;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    @Override
    public String toString()
    {
        return "Name="+name+", Cpr="+cpr+", Age="+age+"\n";
    }

}
