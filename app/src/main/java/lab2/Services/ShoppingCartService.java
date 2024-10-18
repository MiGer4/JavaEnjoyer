package lab2.Services;

import lab2.ShoppingCart;
import lab2.Customer;
import lab2.Comparators.ShoppingCartComparator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

@AllArgsConstructor
@Getter
public class ShoppingCartService {
    private List<ShoppingCart> shoppingCarts;

    public List<ShoppingCart> sortByStatus() {
        List<ShoppingCart> mutableShoppingCarts = new ArrayList<>(shoppingCarts);
        Collections.sort(mutableShoppingCarts, ShoppingCartComparator.byStatus());
        return mutableShoppingCarts;
    }

    public List<ShoppingCart> sortByPurchaseDate() {
        List<ShoppingCart> mutableShoppingCarts = new ArrayList<>(shoppingCarts);
        Collections.sort(mutableShoppingCarts, ShoppingCartComparator.byPurchaseDate());
        return mutableShoppingCarts;
    }

    public List<ShoppingCart> getByCustomer(Customer customer) {
        return shoppingCarts.stream().filter(shp -> shp.getCustomer().equals(customer))
            .sorted(ShoppingCartComparator.byPurchaseDate()).toList();
    }
}
