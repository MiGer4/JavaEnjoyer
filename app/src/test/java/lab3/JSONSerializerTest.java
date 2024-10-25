package lab3;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import lab2.*;

public class JSONSerializerTest {
    Address address1 = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
    Customer customer1 = new Customer("Misha", "Hordei", address1, "+380999516532");
    ShoppingCart shoppingCart1 = new ShoppingCart(customer1, LocalDate.of(2024, 9, 20), address1, true);

    Address address2 = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
    Customer customer2 = new Customer("Misha", "Hordei", address2, "+380999516532");
    ShoppingCart shoppingCart2 = new ShoppingCart(customer2, LocalDate.of(2024, 10, 13), address2, false);

    Address address3 = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
    Customer customer3 = new Customer("Grisha", "Hordei", address3, "+380999516532");
    ShoppingCart shoppingCart3 = new ShoppingCart(customer3, LocalDate.of(2024, 8, 13), address3, false);

    JSONSerializer<ShoppingCart> jsonSerializer = new JSONSerializer<>(ShoppingCart.class);

    List<ShoppingCart> shoppingCarts = List.of(shoppingCart1, shoppingCart2, shoppingCart3);

    @Test
    void fromEntityTest() throws IOException {
        String exString = "{\"customer\":{\"firstName\":\"Misha\",\"lastName\":\"Hordei\",\"address\":{\"country\":\"Ukraine\",\"city\":\"Mamaivtsi\",\"street\":\"Nothehe\",\"number\":52},\"phone\":\"+380999516532\"},\"purchaseDate\":\"2024-09-20\",\"address\":{\"country\":\"Ukraine\",\"city\":\"Mamaivtsi\",\"street\":\"Nothehe\",\"number\":52},\"status\":true}";
        assertEquals(exString, jsonSerializer.fromEntity(shoppingCart1));
    }

    @Test
    void fromEntityListTest() throws IOException {
        String exString = "[{\"customer\":{\"firstName\":\"Misha\",\"lastName\":\"Hordei\",\"address\":{\"country\":\"Ukraine\",\"city\":\"Mamaivtsi\",\"street\":\"Nothehe\",\"number\":52},\"phone\":\"+380999516532\"},\"purchaseDate\":\"2024-09-20\",\"address\":{\"country\":\"Ukraine\",\"city\":\"Mamaivtsi\",\"street\":\"Nothehe\",\"number\":52},\"status\":true},{\"customer\":{\"firstName\":\"Misha\",\"lastName\":\"Hordei\",\"address\":{\"country\":\"Ukraine\",\"city\":\"Mamaivtsi\",\"street\":\"Nothehe\",\"number\":52},\"phone\":\"+380999516532\"},\"purchaseDate\":\"2024-10-13\",\"address\":{\"country\":\"Ukraine\",\"city\":\"Mamaivtsi\",\"street\":\"Nothehe\",\"number\":52},\"status\":false},{\"customer\":{\"firstName\":\"Grisha\",\"lastName\":\"Hordei\",\"address\":{\"country\":\"Ukraine\",\"city\":\"Mamaivtsi\",\"street\":\"Nothehe\",\"number\":52},\"phone\":\"+380999516532\"},\"purchaseDate\":\"2024-08-13\",\"address\":{\"country\":\"Ukraine\",\"city\":\"Mamaivtsi\",\"street\":\"Nothehe\",\"number\":52},\"status\":false}]";
        assertEquals(exString, jsonSerializer.fromEntityList(shoppingCarts));
    }

    @Test
    void toEntityTest() throws IOException {
        String string = "{\"customer\":{\"firstName\":\"Misha\",\"lastName\":\"Hordei\",\"address\":{\"country\":\"Ukraine\",\"city\":\"Mamaivtsi\",\"street\":\"Nothehe\",\"number\":52},\"phone\":\"+380999516532\"},\"purchaseDate\":\"2024-09-20\",\"address\":{\"country\":\"Ukraine\",\"city\":\"Mamaivtsi\",\"street\":\"Nothehe\",\"number\":52},\"status\":true}";
        assertTrue(jsonSerializer.toEntity(string).equals(shoppingCart1));
    }

    @Test
    void toEntityListTest() throws IOException {
        String string = "[{\"customer\":{\"firstName\":\"Misha\",\"lastName\":\"Hordei\",\"address\":{\"country\":\"Ukraine\",\"city\":\"Mamaivtsi\",\"street\":\"Nothehe\",\"number\":52},\"phone\":\"+380999516532\"},\"purchaseDate\":\"2024-09-20\",\"address\":{\"country\":\"Ukraine\",\"city\":\"Mamaivtsi\",\"street\":\"Nothehe\",\"number\":52},\"status\":true},{\"customer\":{\"firstName\":\"Misha\",\"lastName\":\"Hordei\",\"address\":{\"country\":\"Ukraine\",\"city\":\"Mamaivtsi\",\"street\":\"Nothehe\",\"number\":52},\"phone\":\"+380999516532\"},\"purchaseDate\":\"2024-10-13\",\"address\":{\"country\":\"Ukraine\",\"city\":\"Mamaivtsi\",\"street\":\"Nothehe\",\"number\":52},\"status\":false},{\"customer\":{\"firstName\":\"Grisha\",\"lastName\":\"Hordei\",\"address\":{\"country\":\"Ukraine\",\"city\":\"Mamaivtsi\",\"street\":\"Nothehe\",\"number\":52},\"phone\":\"+380999516532\"},\"purchaseDate\":\"2024-08-13\",\"address\":{\"country\":\"Ukraine\",\"city\":\"Mamaivtsi\",\"street\":\"Nothehe\",\"number\":52},\"status\":false}]";
        List<ShoppingCart> entities = jsonSerializer.toEntityList(string);

        assertAll(() -> {
            assertEquals(entities.get(0), shoppingCart1);
            assertEquals(entities.get(1), shoppingCart2);
            assertEquals(entities.get(2), shoppingCart3);

        });
    }
}
