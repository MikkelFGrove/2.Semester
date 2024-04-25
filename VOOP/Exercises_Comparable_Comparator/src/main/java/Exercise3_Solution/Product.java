package Exercise3_Solution;

public class Product implements Comparable<Product> {
    private String name;
    private double price;
    private double rating;

    public Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", rating=" + rating + "}";
    }

    @Override
    public int compareTo(Product other) {
        if (this.getPrice() == other.getPrice()) {
            return Double.compare(other.getRating(), this.getRating());
        }
        return Double.compare(this.getPrice(), other.getPrice());
    }
}

