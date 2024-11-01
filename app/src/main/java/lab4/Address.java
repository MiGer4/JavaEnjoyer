package lab4;

/**
 * The {@code Address} record represents an accounting record for an address,
 * including details such as the country, city, street and number.
 */
public record Address(String country, String city, String street, int number) {

}
