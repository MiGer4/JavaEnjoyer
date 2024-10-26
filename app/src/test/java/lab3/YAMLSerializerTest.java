package lab3;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.io.IOException;

import lab2.*;

public class YAMLSerializerTest {
    Address address1 = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
    Customer customer1 = new Customer("Misha", "Hordei", address1, "+380999516532");
    ShoppingCart shoppingCart1 = new ShoppingCart(customer1, LocalDate.of(2024, 9, 20), address1, true);

    Address address2 = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
    Customer customer2 = new Customer("Misha", "Hordei", address2, "+380999516532");
    ShoppingCart shoppingCart2 = new ShoppingCart(customer2, LocalDate.of(2024, 10, 13), address2, false);

    Address address3 = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
    Customer customer3 = new Customer("Grisha", "Hordei", address3, "+380999516532");
    ShoppingCart shoppingCart3 = new ShoppingCart(customer3, LocalDate.of(2024, 8, 13), address3, false);

    YAMLSerializer<ShoppingCart> yamlSerializer = new YAMLSerializer<>(ShoppingCart.class);

    List<ShoppingCart> shoppingCarts = List.of(shoppingCart1, shoppingCart2, shoppingCart3);

    @Test
    void fromEntityTest() throws IOException {
        String exString = "---\n" + //
                        "customer:\n" + //
                        "  firstName: \"Misha\"\n" + //
                        "  lastName: \"Hordei\"\n" + //
                        "  address:\n" + //
                        "    country: \"Ukraine\"\n" + //
                        "    city: \"Mamaivtsi\"\n" + //
                        "    street: \"Nothehe\"\n" + //
                        "    number: 52\n" + //
                        "  phone: \"+380999516532\"\n" + //
                        "purchaseDate: \"2024-09-20\"\n" + //
                        "address:\n" + //
                        "  country: \"Ukraine\"\n" + //
                        "  city: \"Mamaivtsi\"\n" + //
                        "  street: \"Nothehe\"\n" + //
                        "  number: 52\n" + //
                        "status: true\n";
                        assertEquals(exString,  yamlSerializer.fromEntity(shoppingCart1));
    }

    @Test
    void fromEntityListTest() throws IOException {
        String exString = "---\n" + //
                        "- customer:\n" + //
                        "    firstName: \"Misha\"\n" + //
                        "    lastName: \"Hordei\"\n" + //
                        "    address:\n" + //
                        "      country: \"Ukraine\"\n" + //
                        "      city: \"Mamaivtsi\"\n" + //
                        "      street: \"Nothehe\"\n" + //
                        "      number: 52\n" + //
                        "    phone: \"+380999516532\"\n" + //
                        "  purchaseDate: \"2024-09-20\"\n" + //
                        "  address:\n" + //
                        "    country: \"Ukraine\"\n" + //
                        "    city: \"Mamaivtsi\"\n" + //
                        "    street: \"Nothehe\"\n" + //
                        "    number: 52\n" + //
                        "  status: true\n" + //
                        "- customer:\n" + //
                        "    firstName: \"Misha\"\n" + //
                        "    lastName: \"Hordei\"\n" + //
                        "    address:\n" + //
                        "      country: \"Ukraine\"\n" + //
                        "      city: \"Mamaivtsi\"\n" + //
                        "      street: \"Nothehe\"\n" + //
                        "      number: 52\n" + //
                        "    phone: \"+380999516532\"\n" + //
                        "  purchaseDate: \"2024-10-13\"\n" + //
                        "  address:\n" + //
                        "    country: \"Ukraine\"\n" + //
                        "    city: \"Mamaivtsi\"\n" + //
                        "    street: \"Nothehe\"\n" + //
                        "    number: 52\n" + //
                        "  status: false\n" + //
                        "- customer:\n" + //
                        "    firstName: \"Grisha\"\n" + //
                        "    lastName: \"Hordei\"\n" + //
                        "    address:\n" + //
                        "      country: \"Ukraine\"\n" + //
                        "      city: \"Mamaivtsi\"\n" + //
                        "      street: \"Nothehe\"\n" + //
                        "      number: 52\n" + //
                        "    phone: \"+380999516532\"\n" + //
                        "  purchaseDate: \"2024-08-13\"\n" + //
                        "  address:\n" + //
                        "    country: \"Ukraine\"\n" + //
                        "    city: \"Mamaivtsi\"\n" + //
                        "    street: \"Nothehe\"\n" + //
                        "    number: 52\n" + //
                        "  status: false\n";
        assertEquals(exString, yamlSerializer.fromEntityList(shoppingCarts));
    }

    @Test
    void toEntityTest() throws IOException {
        String string = "---\r\n" + //
                        "customer:\r\n" + //
                        "  firstName: \"Misha\"\r\n" + //
                        "  lastName: \"Hordei\"\r\n" + //
                        "  address:\r\n" + //
                        "    country: \"Ukraine\"\r\n" + //
                        "    city: \"Mamaivtsi\"\r\n" + //
                        "    street: \"Nothehe\"\r\n" + //
                        "    number: 52\r\n" + //
                        "  phone: \"+380999516532\"\r\n" + //
                        "purchaseDate: \"2024-09-20\"\r\n" + //
                        "address:\r\n" + //
                        "  country: \"Ukraine\"\r\n" + //
                        "  city: \"Mamaivtsi\"\r\n" + //
                        "  street: \"Nothehe\"\r\n" + //
                        "  number: 52\r\n" + //
                        "status: true\r\n";
        assertTrue(yamlSerializer.toEntity(string).equals(shoppingCart1));
    }

    @Test
    void toEntityListTest() throws IOException {
        String string = "---\r\n" + //
                        "- customer:\r\n" + //
                        "    firstName: \"Misha\"\n" + //
                        "    lastName: \"Hordei\"\n" + //
                        "    address:\n" + //
                        "      country: \"Ukraine\"\n" + //
                        "      city: \"Mamaivtsi\"\n" + //
                        "      street: \"Nothehe\"\n" + //
                        "      number: 52\n" + //
                        "    phone: \"+380999516532\"\n" + //
                        "  purchaseDate: \"2024-09-20\"\n" + //
                        "  address:\n" + //
                        "    country: \"Ukraine\"\n" + //
                        "    city: \"Mamaivtsi\"\n" + //
                        "    street: \"Nothehe\"\n" + //
                        "    number: 52\n" + //
                        "  status: true\n" + //
                        "- customer:\n" + //
                        "    firstName: \"Misha\"\n" + //
                        "    lastName: \"Hordei\"\n" + //
                        "    address:\n" + //
                        "      country: \"Ukraine\"\n" + //
                        "      city: \"Mamaivtsi\"\n" + //
                        "      street: \"Nothehe\"\n" + //
                        "      number: 52\n" + //
                        "    phone: \"+380999516532\"\n" + //
                        "  purchaseDate: \"2024-10-13\"\n" + //
                        "  address:\n" + //
                        "    country: \"Ukraine\"\n" + //
                        "    city: \"Mamaivtsi\"\n" + //
                        "    street: \"Nothehe\"\n" + //
                        "    number: 52\n" + //
                        "  status: false\n" + //
                        "- customer:\n" + //
                        "    firstName: \"Grisha\"\n" + //
                        "    lastName: \"Hordei\"\n" + //
                        "    address:\n" + //
                        "      country: \"Ukraine\"\n" + //
                        "      city: \"Mamaivtsi\"\n" + //
                        "      street: \"Nothehe\"\n" + //
                        "      number: 52\n" + //
                        "    phone: \"+380999516532\"\n" + //
                        "  purchaseDate: \"2024-08-13\"\n" + //
                        "  address:\n" + //
                        "    country: \"Ukraine\"\n" + //
                        "    city: \"Mamaivtsi\"\n" + //
                        "    street: \"Nothehe\"\n" + //
                        "    number: 52\n" + //
                        "  status: false\n";
        List<ShoppingCart> entities = yamlSerializer.toEntityList(string);

        assertAll(() -> {
            assertEquals(entities.get(0), shoppingCart1);
            assertEquals(entities.get(1), shoppingCart2);
            assertEquals(entities.get(2), shoppingCart3);

        });
    }
}
