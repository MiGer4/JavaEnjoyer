package lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommentTest {
    Address address = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
    Customer customer = new Customer("Misha", "Hordei", address, "+380999516532");
    Product product = new Product("Samsung Galaxy A55 5G 8/256GB Lilac", Category.TELEPHONE, "unit", 19899d);

    LocalDateTime yTime = LocalDateTime.now();

    @BeforeEach
    void beforeEach() {
        product.addCharacter(new Characters("diagonal", "inch"), "6.6");
        product.addCharacter(new Characters("ram", "GB"), "8");
        product.addCharacter(new Characters("buildInMemory", "GB"), "256");
        product.addCharacter(new Characters("camera", "MegaPixels"), "50");
        product.addCharacter(new Characters("color", "name"), "Lilac");
        product.addCharacter(new Characters("mass", "g"), "213");
    }

    @Test
    void stringRepresentationTest() {
        Comment comment = new Comment.CommentBuilder("Aboba", yTime).customer(customer).product(product).build();
        String exceptedString = "Comment{product=Product{name=Samsung Galaxy A55 5G 8/256GB Lilac, category=TELEPHONE, characters=[{diagonal,inch=6.6}{ram,GB=8}{buildInMemory,GB=256}{camera,MegaPixels=50}{color,name=Lilac}{mass,g=213}], measurementUnit=unit, price=19899.0}, customer=Misha Hordei, text=Aboba, createdAt="
                + yTime + "}";

        assertEquals(comment.toString(), exceptedString);
    }
}
