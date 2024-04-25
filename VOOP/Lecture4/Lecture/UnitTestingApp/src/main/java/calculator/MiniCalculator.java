package calculator;

public class MiniCalculator {

    private int x;
    private int y;

    public MiniCalculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int add(int x, int y)

    {
        return x+y;
    }

    public static int multiply(int x, int y)
    {
            return x*y;
    }

    public static int subtract(int x, int y)
    {
        if (x < y) {
            throw new IllegalArgumentException("X should be greater than y");
        }
        else
            return x-y;
    }
}
