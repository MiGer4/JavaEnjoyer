package lab4;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab4.Comment.CommentBuilder;

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
    void buildTest() {
        Comment comment = new Comment.CommentBuilder("Aboba", yTime).customer(customer).product(product).build();

        assertAll(() -> {
            assertEquals(customer, comment.getCustomer());
            assertEquals(product, comment.getProduct());
            assertEquals("Aboba", comment.getText());
            assertEquals(yTime, comment.getCreatedAt());
        });
    }

    @Test
    void buildThrowsAnyExceptionTest() {
        LocalDateTime xTime = LocalDateTime.of(2025, 11, 1, 1, 1, 1);
        CommentBuilder builder = new CommentBuilder("1", xTime)
                .customer(null)
                .product(null);
    
        Exception thrown = assertThrows(
                Exception.class,
                builder::build
        );
    
        assertAll(() -> {
            assertTrue(thrown.getMessage().contains("product cannot be null"));
            assertTrue(thrown.getMessage().contains("customer cannot be null"));
            assertTrue(thrown.getMessage().contains("text must be between 2 and 1000"));
            assertTrue(thrown.getMessage().contains("createdAt must be past or present"));
        } );
    }

}
