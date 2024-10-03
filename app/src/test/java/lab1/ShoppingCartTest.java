package lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    Address address = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
    Customer customer = new Customer("Misha", "Hordei", address, "+380999516532");
    ShoppingCart shoppingCart = new ShoppingCart(customer, LocalDate.of(2024, 9, 20), address, true);

    @Test
    void stringRepresentationTest() {
        String exceptedString = "ShoppingCart{customer=Customer{firstName=Misha, lastName=Hordei, address=Address[country=Ukraine, city=Mamaivtsi, street=Nothehe, number=52], phone=+380999516532}, purchaseDate=2024-09-20, address=Address[country=Ukraine, city=Mamaivtsi, street=Nothehe, number=52], status=true}";
        assertEquals(shoppingCart.toString(), exceptedString);
    }
}
