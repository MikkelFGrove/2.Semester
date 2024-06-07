package vop;

public class Ellipse extends AbstractShape{
    public double r1;
    public double r2;

    Ellipse(double r1, double r2){
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public double getArea() {
        return Math.PI * r1 * r2;
    }

    @Override
    public double getCircumference() {
        return 2 * Math.PI * Math.sqrt(0.5 * (r1 * r1 + r2 * r2));
    }
}
