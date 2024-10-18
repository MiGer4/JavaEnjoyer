package lab2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import lab2.Services.ShoppingCartService;

public class ShoppingCartServiceTest {
    Address address1 = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
    Customer customer1 = new Customer("Misha", "Hordei", address1, "+380999516532");
    ShoppingCart shoppingCart1 = new ShoppingCart(customer1, LocalDate.of(2024, 9, 20), address1, true);

    Address address2 = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
    Customer customer2 = new Customer("Misha", "Hordei", address2, "+380999516532");
    ShoppingCart shoppingCart2 = new ShoppingCart(customer2, LocalDate.of(2024, 10, 13), address2, false);

    Address address3 = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
    Customer customer3 = new Customer("Grisha", "Hordei", address3, "+380999516532");
    ShoppingCart shoppingCart3 = new ShoppingCart(customer3, LocalDate.of(2024, 8, 13), address3, false);

    List<ShoppingCart> shoppingCarts = List.of(shoppingCart1, shoppingCart2, shoppingCart3);

    ShoppingCartService shoppingCartService = new ShoppingCartService(shoppingCarts);

    @Test
    void sortByStatusTest() {
        List<ShoppingCart> sortedCarts = shoppingCartService.sortByStatus();
        assertAll(() -> {
            assertTrue(shoppingCart2.equals(sortedCarts.get(0)));
            assertTrue(shoppingCart3.equals(sortedCarts.get(1)));
            assertTrue(shoppingCart1.equals(sortedCarts.get(2)));
        });
    }

    @Test
    void sortByPurchaseDateTest() {
        List<ShoppingCart> sortedCarts = shoppingCartService.sortByPurchaseDate();
        assertAll(() -> {
            assertTrue(shoppingCart3.equals(sortedCarts.get(0)));
            assertTrue(shoppingCart1.equals(sortedCarts.get(1)));
            assertTrue(shoppingCart2.equals(sortedCarts.get(2)));
        });
    }

    @Test
    void getByCustomerTest() {
        List<ShoppingCart> filteredCarts = shoppingCartService.getByCustomer(customer1);
        assertAll(() -> {
            assertEquals(2, filteredCarts.size());
            assertTrue(shoppingCart1.equals(filteredCarts.get(0)));
            assertTrue(shoppingCart2.equals(filteredCarts.get(1)));
        });
    }
}
