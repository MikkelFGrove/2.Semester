package Exercise2_Solution;

public class Main {

        public static void main(String[] args) {

                System.out.println("Table of 3 (iterative):");
                iterativeTable(3,1,10);
                System.out.println("\nTable of 3 (recursive):");
                recursiveTable(3,1,10);
            }

            public static void iterativeTable(int multiplier,int start, int end) {
                for (int i = start; i <= end; i++) {
                    System.out.println(multiplier + " x " + i + " = " + (multiplier * i));
                }
            }

    public static void recursiveTable(int multiplier, int start, int end) {
        if (start <= end) {
            System.out.println(multiplier + " x " + start + " = " + (multiplier * start));
            recursiveTable(multiplier, start + 1,end);
        }
    }
}