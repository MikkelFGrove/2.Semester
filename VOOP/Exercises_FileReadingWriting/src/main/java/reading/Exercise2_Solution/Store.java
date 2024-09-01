package reading.Exercise2_Solution;

public class Store {

    private int Id;
    private double area;
    private String property;
    private String type;
    private String status;
    private int number;
    private long revenue;



    public Store(int id, double area, String property, String type, String status, int number, long revenue) {
        Id = id;
        this.area = area;
        this.property = property;
        this.type = type;
        this.status = status;
        this.number = number;
        this.revenue = revenue;
    }

    public int getId() {
        return Id;
    }

    public double getArea() {
        return area;
    }

    public String getProperty() {
        return property;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public int getNumber() {
        return number;
    }

    public long getRevenue() {
        return revenue;
    }

    @Override
    public String toString() {
        return String.format(" %d \t \t %.2f \t \t %s \t \t %s \t \t %s \t \t %d \t \t %d\n", getId(), getArea(), getProperty(), getType(), getStatus(), getNumber(), getRevenue());
    }
}