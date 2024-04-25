package vop;

public class Rectangle extends AbstractShape{
    public double l1;
    public double l2;

    Rectangle(double l1, double l2){
        this.l1 = l1;
        this.l2 = l2;
    }

    @Override
    public double getArea() {
        return l1 * l2;
    }

    @Override
    public double getCircumference() {
        return 2 * (l1+l2);
    }
}
