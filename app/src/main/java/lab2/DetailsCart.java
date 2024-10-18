package lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code DetailsCart} class represents an accounting record for a specific
 * shopping cart and products, including details such as the shopping cart, and list of products.
 *
 * <p>The following fields are included:</p>
 * <ul>
 *   <li>{@link ShoppingCart} shoppingCart - The shopping cart.</li>
 *   <li>{@link List}<{@link Product}> products - Products of cart.</li>
 * </ul>
 */
public class DetailsCart {
    private ShoppingCart shoppingCart;
    private List<Product> products;

    DetailsCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        products = new ArrayList<>();
    }

    public void addItem(Product product) {
        products.add(product);
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<Product> getGoods() {
        return products;
    }

    @Override
    public String toString() {
        String result = "Details{" +
                shoppingCart.toString() +
                ", Products{";
        int i = 1;
        for (Product product : products) {
            result += i + "." + product;
            i++;
        }
        result += "}}";
        return result;
    }
}
