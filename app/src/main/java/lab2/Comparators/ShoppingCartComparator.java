package lab2.Comparators;

import lab2.ShoppingCart;

import java.util.Comparator;

public class ShoppingCartComparator {
    public static Comparator<ShoppingCart> byPurchaseDate() {
        return Comparator.comparing(ShoppingCart::getPurchaseDate);
    }

    public static Comparator<ShoppingCart> byStatus() {
        return Comparator.comparing(ShoppingCart::getStatus).thenComparing(byPurchaseDate().reversed());
    }
}
