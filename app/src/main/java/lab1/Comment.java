package lab1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The {@code Comment} class represents an accounting record for a specific
 * comment, including details such as the product, customer, replies, and text.
 *
 * <p>The following fields are included:</p>
 * <ul>
 *   <li>{@link Product} product - The name of product.</li>
 *   <li>{@link Customer} customer - Information about customer.</li>
 *   <li>{@link Comment} replies - The link to the comment it links to.</li>
 *   <li>{@link String} text - The comment text.</li>
 *   <li>{@link LocalDateTime} createdAt - The day and time, when created comment.</li>
 * </ul>
 */
public class Comment {
    private Product product;
    private Customer customer;
    private Comment replies;
    private String text;
    private LocalDateTime createdAt;

    private Comment(Product product, Customer customer, Comment replies, String text, LocalDateTime createdAt) {
        this.product = product;
        this.customer = customer;
        this.replies = replies;
        this.text = text;
        this.createdAt = createdAt;
    }

    public Product getProduct() {
        return product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Comment getReplies() {
        return replies;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Comment comment = (Comment) o;
        return product.equals(comment.product) && customer.equals(comment.customer)
                && createdAt.equals(comment.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, customer, createdAt);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "product=" + product +
                ", customer=" + customer.getFirstName() + " " + customer.getLastName() +
                ", text=" + text +
                ", createdAt=" + createdAt +
                "}";
    }

    static public class CommentBuilder {
        private Product product;
        private Customer customer;
        private Comment replies;
        private String text;
        private LocalDateTime createdAt;

        public CommentBuilder(String text, LocalDateTime createdAt) {
            this.text = text;
            this.createdAt = createdAt;
        }

        public CommentBuilder product(Product product) {
            this.product = product;
            return this;
        }

        public CommentBuilder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public CommentBuilder replies(Comment replies) {
            this.replies = replies;
            return this;
        }

        public Comment build() {
            return new Comment(this.product, this.customer, this.replies, this.text, this.createdAt);
        }
    }
}
