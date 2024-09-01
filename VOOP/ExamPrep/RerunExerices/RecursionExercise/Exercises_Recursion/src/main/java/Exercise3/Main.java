package Exercise3;

public class Main {

        public static void main(String[] args) {
            System.out.print("Sum (iterative):"+iterativeSum(1,50));
            System.out.print("\nSum (recursive):"+recursiveSum(1,50));
        }

    public static int iterativeSum(int start, int end) {
        int sum=0;
        for(int i=start;i<=end;i++){
            sum+=i;
        }
            return sum;
    }

    public static int recursiveSum(int start, int end) {
        throw new UnsupportedOperationException("Implement Method");
    }
}