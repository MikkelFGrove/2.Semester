package Exercise3_Solution;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        if (p1.getRating() == p2.getRating()) {
            return p1.getName().compareTo(p2.getName());
        }
        return Double.compare(p2.getRating(), p1.getRating());
    }
}