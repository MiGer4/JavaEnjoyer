package lab2.Comparators;

import lab2.Product;

import java.util.Comparator;

public class ProductComparator {

    public static Comparator<Product> byName() {
        return Comparator.comparing(Product::getName);
    }

    public static Comparator<Product> byPrice() {
        return Comparator.comparing(Product::getPrice);
    }
}
