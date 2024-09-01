package tourism_info;

import java.util.Set;
import java.util.TreeSet;

public class Tourism implements Comparable<Tourism>{
    private String name;
    private String code;
    private int year;
    private double value;

    public Tourism(String name, String code, int year, double value){
        this.name = name;
        this.code = code;
        this.year = year;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

   @Override
    public String toString() {
        return String.format("%s \t \t %s \t \t %d \t \t %.2f\n",getName(),getCode(),getYear(),getValue());
    }

    @Override
    public int compareTo(Tourism o) {
        if (value > o.getValue()){
            return 1;
        } else if (value < o.getValue()) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
//        Exercise 3a
        System.out.println("Sorting based on Value");
        Set<Tourism> tourism1 = new TreeSet();
        tourism1.add(new Tourism("Canada","CAN",2007,17962000000.0));
        tourism1.add(new Tourism("Afghanistan","AFG",2017,16000000.0));
        tourism1.add(new Tourism("Morocco","MAR",2018,9520000000.0));
        System.out.println(tourism1);

//        Exercise 3b
        System.out.println("Sorting based on Year");
        Set<Tourism> tourism2 = new TreeSet(new YearComparator());
        tourism2.addAll(tourism1);
        System.out.println(tourism2);

        System.out.println("Sorting based on Name Length");
        Set<Tourism> tourism3 = new TreeSet(new NameLengthComparator());
        tourism3.addAll(tourism1);
        System.out.println(tourism3);
    }

}
