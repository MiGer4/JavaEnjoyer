package lab2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab2.Services.DetailsCartService;

public class DetailsCartServiceTest {
    Product phone = new Product("Samsung Galaxy A55 5G 8/256GB Lilac", Category.TELEPHONE, "unit", 19899d);
    Product earphones = new Product("Air Pods", Category.EARPHONES, "unit", 7399d);

    Address address = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
    Customer customer = new Customer("Misha", "Hordei", address, "+380999516532");

    @BeforeEach
    void beforeEach() {
        phone.addCharacter(new Characters("diagonal", "inch"), "6.6");
        phone.addCharacter(new Characters("ram", "GB"), "8");
        phone.addCharacter(new Characters("buildInMemory", "GB"), "256");
        phone.addCharacter(new Characters("camera", "MegaPixels"), "50");
        phone.addCharacter(new Characters("color", "name"), "Lilac");
        phone.addCharacter(new Characters("mass", "g"), "213");

        earphones.addCharacter(new Characters("color", "name"), "White");
        earphones.addCharacter(new Characters("mass", "g"), "9");
        earphones.addCharacter(new Characters("volume", "dB"), "60");
        earphones.addCharacter(new Characters("autonomy", "h"), "30");
    }

    @Test
    void getTotalProductCostTest() {
        ShoppingCart shoppingCart = new ShoppingCart(customer, LocalDate.of(2024, 9, 20), address, true);
        DetailsCart detailsCart = new DetailsCart(shoppingCart);
        detailsCart.addItem(phone);
        detailsCart.addItem(earphones);

        DetailsCartService detailsCartService = new DetailsCartService(detailsCart);
        assertEquals(27298, detailsCartService.getTotalProductCost());
    }
}
