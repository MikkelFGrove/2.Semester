package recursion;

public class SumOfAllNumbers {

    public static void main(String[] args)
    {
            System.out.println("Iterative Sum="+iterativeSum(50));
            System.out.println("Recursive Sum="+recursiveSum(50));
    }

    /* An iterative method to sum all natural numbers up to a given long. */
        public static long iterativeSum(long number) {
            long sum=0;
            for(int i=1;i<=number;i++){
                sum+=i;
            }
        return sum;

        }

    /* A recursive method to sum all natural numbers up to a given long. */
        public static long recursiveSum(long number) {
            //TODO
           return 0;
        }
    }

