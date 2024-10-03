package lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DetailsCartTest {
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
    void stringRepresentationTest() {
        ShoppingCart shoppingCart = new ShoppingCart(customer, LocalDate.of(2024, 9, 20), address, true);
        DetailsCart detailsCart = new DetailsCart(shoppingCart);
        detailsCart.addItem(phone);
        detailsCart.addItem(earphones);

        String exceptedString = "Details{ShoppingCart{customer=Customer{firstName=Misha, lastName=Hordei, address=Address[country=Ukraine, city=Mamaivtsi, street=Nothehe, number=52], phone=+380999516532}, purchaseDate=2024-09-20, address=Address[country=Ukraine, city=Mamaivtsi, street=Nothehe, number=52], status=true}, Products{1.Product{name=Samsung Galaxy A55 5G 8/256GB Lilac, category=TELEPHONE, characters=[{diagonal,inch=6.6}{ram,GB=8}{buildInMemory,GB=256}{camera,MegaPixels=50}{color,name=Lilac}{mass,g=213}], measurementUnit=unit, price=19899.0}2.Product{name=Air Pods, category=EARPHONES, characters=[{color,name=White}{mass,g=9}{volume,dB=60}{autonomy,h=30}], measurementUnit=unit, price=7399.0}}}";

        assertEquals(detailsCart.toString(), exceptedString);
    }
}
