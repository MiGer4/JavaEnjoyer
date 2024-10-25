package lab3;

import lab2.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class XMLSerializerTest {
    Address address1 = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
    Customer customer1 = new Customer("Misha", "Hordei", address1, "+380999516532");
    ShoppingCart shoppingCart1 = new ShoppingCart(customer1, LocalDate.of(2024, 9, 20), address1, true);

    Address address2 = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
    Customer customer2 = new Customer("Misha", "Hordei", address2, "+380999516532");
    ShoppingCart shoppingCart2 = new ShoppingCart(customer2, LocalDate.of(2024, 10, 13), address2, false);

    Address address3 = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
    Customer customer3 = new Customer("Grisha", "Hordei", address3, "+380999516532");
    ShoppingCart shoppingCart3 = new ShoppingCart(customer3, LocalDate.of(2024, 8, 13), address3, false);

    XMLSerializer<ShoppingCart> xmlSerializer = new XMLSerializer<>(ShoppingCart.class);

    List<ShoppingCart> shoppingCarts = List.of(shoppingCart1, shoppingCart2, shoppingCart3);

    @Test
    void fromEntityTest() throws IOException {
        String exString = "<ShoppingCart><customer><firstName>Misha</firstName><lastName>Hordei</lastName><address><country>Ukraine</country><city>Mamaivtsi</city><street>Nothehe</street><number>52</number></address><phone>+380999516532</phone></customer><purchaseDate>2024-09-20</purchaseDate><address><country>Ukraine</country><city>Mamaivtsi</city><street>Nothehe</street><number>52</number></address><status>true</status></ShoppingCart>";
        assertEquals(exString, xmlSerializer.fromEntity(shoppingCart1));
    }

    @Test
    void fromEntityListTest() throws IOException {
        String exString = "<ListN><item><customer><firstName>Misha</firstName><lastName>Hordei</lastName><address><country>Ukraine</country><city>Mamaivtsi</city><street>Nothehe</street><number>52</number></address><phone>+380999516532</phone></customer><purchaseDate>2024-09-20</purchaseDate><address><country>Ukraine</country><city>Mamaivtsi</city><street>Nothehe</street><number>52</number></address><status>true</status></item><item><customer><firstName>Misha</firstName><lastName>Hordei</lastName><address><country>Ukraine</country><city>Mamaivtsi</city><street>Nothehe</street><number>52</number></address><phone>+380999516532</phone></customer><purchaseDate>2024-10-13</purchaseDate><address><country>Ukraine</country><city>Mamaivtsi</city><street>Nothehe</street><number>52</number></address><status>false</status></item><item><customer><firstName>Grisha</firstName><lastName>Hordei</lastName><address><country>Ukraine</country><city>Mamaivtsi</city><street>Nothehe</street><number>52</number></address><phone>+380999516532</phone></customer><purchaseDate>2024-08-13</purchaseDate><address><country>Ukraine</country><city>Mamaivtsi</city><street>Nothehe</street><number>52</number></address><status>false</status></item></ListN>";
        assertEquals(exString, xmlSerializer.fromEntityList(shoppingCarts));
    }

    @Test
    void toEntityTest() throws IOException {
        String string = "<ShoppingCart><customer><firstName>Misha</firstName><lastName>Hordei</lastName><address><country>Ukraine</country><city>Mamaivtsi</city><street>Nothehe</street><number>52</number></address><phone>+380999516532</phone></customer><purchaseDate>2024-09-20</purchaseDate><address><country>Ukraine</country><city>Mamaivtsi</city><street>Nothehe</street><number>52</number></address><status>true</status></ShoppingCart>";
        assertTrue(xmlSerializer.toEntity(string).equals(shoppingCart1));
    }

    @Test
    void toEntityListTest() throws IOException {
        String string = "<ListN><item><customer><firstName>Misha</firstName><lastName>Hordei</lastName><address><country>Ukraine</country><city>Mamaivtsi</city><street>Nothehe</street><number>52</number></address><phone>+380999516532</phone></customer><purchaseDate>2024-09-20</purchaseDate><address><country>Ukraine</country><city>Mamaivtsi</city><street>Nothehe</street><number>52</number></address><status>true</status></item><item><customer><firstName>Misha</firstName><lastName>Hordei</lastName><address><country>Ukraine</country><city>Mamaivtsi</city><street>Nothehe</street><number>52</number></address><phone>+380999516532</phone></customer><purchaseDate>2024-10-13</purchaseDate><address><country>Ukraine</country><city>Mamaivtsi</city><street>Nothehe</street><number>52</number></address><status>false</status></item><item><customer><firstName>Grisha</firstName><lastName>Hordei</lastName><address><country>Ukraine</country><city>Mamaivtsi</city><street>Nothehe</street><number>52</number></address><phone>+380999516532</phone></customer><purchaseDate>2024-08-13</purchaseDate><address><country>Ukraine</country><city>Mamaivtsi</city><street>Nothehe</street><number>52</number></address><status>false</status></item></ListN>";
        List<ShoppingCart> entities = xmlSerializer.toEntityList(string);

        assertAll(() -> {
            assertEquals(entities.get(0), shoppingCart1);
            assertEquals(entities.get(1), shoppingCart2);
            assertEquals(entities.get(2), shoppingCart3);

        });
    }
}
