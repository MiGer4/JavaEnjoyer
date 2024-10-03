package lab1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * The {@code Shopping Cart} class represents an accounting record for a specific
 * shopping cart, including details such as the customer, purchase date, delivery address,
 * and status.
 *
 * <p>
 * The following fields are included:
 * </p>
 * <ul>
 * <li>{@link Customer} customer - Information about customer.</li>
 * <li>{@link LocalDate} purchaseDate - The date of purchase.</li>
 * <li>{@link Address} address - The delivery address.</li>
 * <li>{@link boolean} status - The status: delivered or not.</li>
 * </ul>
 */
public class ShoppingCart {
    private Customer customer;
    private LocalDate purchaseDate;
    private Address address;
    private boolean status;

    public ShoppingCart(Customer customer, LocalDate purchaseDate, Address address, boolean status) {
        this.customer = customer;
        this.purchaseDate = purchaseDate;
        this.address = address;
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ShoppingCart shoppingCart = (ShoppingCart) o;
        return customer.equals(shoppingCart.customer) && purchaseDate.equals(shoppingCart.purchaseDate) &&
                address.equals(shoppingCart.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, purchaseDate, address);
    }

    public String toString() {
        return "ShoppingCart{" +
                "customer=" + customer +
                ", purchaseDate=" + purchaseDate +
                ", address=" + address +
                ", status=" + status +
                "}";
    }
}
