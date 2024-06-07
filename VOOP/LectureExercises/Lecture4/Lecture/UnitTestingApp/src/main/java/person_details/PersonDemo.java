package person_details;

import java.util.ArrayList;
import java.util.Collections;

public class PersonDemo {
    public static void main(String[] args)
    {


        ArrayList<Person> pList=new ArrayList<Person>();
        pList.add(new Person("Ali",112233, 29));
        pList.add(new Person("Rasmus",112234, 20));
        pList.add(new Person("Alizeh",112235, 10));
        Collections.sort(pList, new AgeComparator());

        System.out.println(pList);

    }
}