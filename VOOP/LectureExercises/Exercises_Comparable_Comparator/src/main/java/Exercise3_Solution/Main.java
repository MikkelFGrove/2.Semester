package Exercise3_Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", 15.99, 4.5));
        products.add(new Product("Phone", 299.99, 4.7));
        products.add(new Product("Laptop", 899.99, 4.8));

        // Sort products based on price (ascending) and rating (descending)
        Collections.sort(products);
        System.out.println("Sorted Products (Ascending Order of Price, Descending Order of Rating):");
        for (Product product : products) {
            System.out.println(product);
        }

        // Sort products based on rating (descending) and name (alphabetical)
        Collections.sort(products, new ProductComparator());
        System.out.println("\nSorted Products (Descending Order of Rating, Alphabetical Order of Name):");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}