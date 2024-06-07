package tutorialspoint_3;

public class PCFixed {
    public static void main(String args[]) {
        
        Q q = new Q();

        new Producer(q);
        new Consumer(q);

    }
}

