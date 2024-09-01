package Exercise1_Solution;

public class Main {

    public static void main(String[] args) {

            System.out.println("Even numbers from 1 to 10 (iterative):");
            iterativeEven(1,10);
            System.out.println("\nEven numbers from 1 to 10 (recursive):");
            recursiveEven(1,10);
        }

        public static void iterativeEven(int start, int end) {
            for (int i = start; i <= end; i++) {
                if(i%2==0)
                    System.out.print(i + " ");
            }
        }
    public static void recursiveEven(int start, int end) {
        if (start <= end) {
            if (start % 2 == 0) {
                System.out.print(start + " ");
            }
            recursiveEven(start + 1,end);
        }
    }
}
