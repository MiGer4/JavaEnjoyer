package lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CustomerTest {
    Address address = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
    Customer customer = new Customer("Misha", "Hordei", address, "+380999516532");

    @Test
    void stringRepresentationTest() {
        String exceptedString = "Customer{firstName=Misha, lastName=Hordei, address=Address[country=Ukraine, city=Mamaivtsi, street=Nothehe, number=52], phone=+380999516532}";
        assertEquals(customer.toString(), exceptedString);
    }
}
