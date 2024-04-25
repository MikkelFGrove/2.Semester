Create a class called **Product** with the following attributes: 

* name (String)
* price (double)
* rating (double)

1. Create a constructor for the Product class that initializes all attributes.
2. Implement getter methods for all attributes.
3. Override the **toString** method to provide a string representation of the Product object.
4. Implement the Comparable interface in the Product class so that products can be sorted based on their price in ascending order. If two products have the same price, sort them based on their rating in descending order.
5. Write a class called **ProductComparator**  that implements the Comparator interface. Implement the compare method so that products can be sorted based on their rating in descending order. If two products have the same rating, sort them based on their name in alphabetical order.
6. Write a class **Main.java** and add a **main** method to test the sorting functionality of both Comparable and Comparator.

   *    Create the following instances of Product and add them to a list.<br>
   
               Product p1= new Product("Book", 15.99, 4.5);
               Product p2= new Product("Phone", 299.99, 4.7);
               Product p3= new Product("Laptop", 899.99, 4.8);

   *    Use Collections.sort method to sort products using Comparable.
   *    Print the sorted list.
   *    Use Collections.sort method with a custom Comparator to sort products.
   *    Print the sorted list.


**Hint**: <br>
* Please pay attention to the access modifiers for variables, constructor and methods.
* Use getter methods in compareTo and compare method implementation.

**The output should look like the following:**

    Sorted Products (Ascending Order of Price, Descending Order of Rating):
    Product{name='Book', price=15.99, rating=4.5}
    Product{name='Phone', price=299.99, rating=4.7}
    Product{name='Laptop', price=899.99, rating=4.8}
    
    Sorted Products (Descending Order of Rating, Alphabetical Order of Name):
    Product{name='Laptop', price=899.99, rating=4.8}
    Product{name='Phone', price=299.99, rating=4.7}
    Product{name='Book', price=15.99, rating=4.5}