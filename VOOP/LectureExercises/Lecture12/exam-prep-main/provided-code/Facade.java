package laundry_facade;

import java.util.Random;

public class Facade {
    private int[] intArray;
    private Random random;

    public Facade(){
        random = new Random();

    }

    public int[] fillArray(int size,int max){
        intArray = new int[size];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int)(Math.random()*max)+1;
        }
        return intArray;
    }

    public int sumOfDivisors(int divisor){
        int sum = 0;
        for (int i = 0; i < intArray.length; i++){
            if (intArray[i] % divisor == 0){
                sum += intArray[i];
            }
        }
        return sum;
    }

    public int[] fillUniqueArray(int size, int max){
        intArray = new int[size];
        for (int i = 0; i < intArray.length; i++) {
            boolean flag = false;
            while (flag = false){
                int temp = (int)(Math.random()*max)+1;
                for (int j = 0; i < intArray.length; j++){

                }

            }


            intArray[i] = (int)(Math.random()*max)+1;
        }
    }

    public int[] getIntArray() {
        return intArray;
    }
}
