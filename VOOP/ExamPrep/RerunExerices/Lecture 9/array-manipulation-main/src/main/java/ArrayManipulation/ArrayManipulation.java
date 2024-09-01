package ArrayManipulation;

import java.util.Arrays;
import java.util.Random;
public class ArrayManipulation {
    public static void main(String[] arg) {
        Random generator = new Random(222);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(100);
        }
        System.out.println("Input:  " + Arrays.toString(array));

        ArrayManipulation arrMani = new ArrayManipulation();
        int[] result = arrMani.evenOdd(array);
        System.out.println("Output: " + Arrays.toString(result));
    }

    public int[] evenOdd(int[] array) {
        int[] tempArray = new int[array.length];
        int oddPos = 0;
        int evenPos = tempArray.length -1;
        for (int number : array) {
            if (number % 2 == 0) {
                tempArray[evenPos] = number;
                evenPos--;
            } else {
                tempArray[oddPos] = number;
                oddPos++;
            }
        }
        System.out.println("evenOdd: " +Arrays.toString(tempArray));
        sort(tempArray, oddPos);
        return tempArray;

    }

    private void sort(int[] array, int splitIndex) {

        throw new UnsupportedOperationException("Not supported yet.");
    }
}

    
