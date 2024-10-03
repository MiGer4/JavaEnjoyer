package lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {
    Product product = new Product("Samsung Galaxy A55 5G 8/256GB Lilac", Category.TELEPHONE, "unit", 19899d);

    @BeforeEach
    void BeforeEach() {
        product.addCharacter(new Characters("diagonal", "inch"), "6.6");
        product.addCharacter(new Characters("ram", "GB"), "8");
        product.addCharacter(new Characters("buildInMemory", "GB"), "256");
        product.addCharacter(new Characters("camera", "MegaPixels"), "50");
        product.addCharacter(new Characters("color", "name"), "Lilac");
        product.addCharacter(new Characters("mass", "g"), "213");
    }

    @Test
    void stringRepresentationTest() {
        String exceptedString = "Product{name=Samsung Galaxy A55 5G 8/256GB Lilac, category=TELEPHONE, characters=[{diagonal,inch=6.6}{ram,GB=8}{buildInMemory,GB=256}{camera,MegaPixels=50}{color,name=Lilac}{mass,g=213}], measurementUnit=unit, price=19899.0}";
        assertEquals(product.toString(), exceptedString);
    }
}
