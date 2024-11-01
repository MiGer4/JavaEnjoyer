package lab4;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidationException;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

/**
 * The {@code Comment} class represents an accounting record for a specific
 * comment, including details such as the product, customer, replies, and text.
 *
 * <p>
 * The following fields are included:
 * </p>
 * <ul>
 * <li>{@link Product} product - The name of product.</li>
 * <li>{@link Customer} customer - Information about customer.</li>
 * <li>{@link Comment} replies - The link to the comment it links to.</li>
 * <li>{@link String} text - The comment text.</li>
 * <li>{@link LocalDateTime} createdAt - The day and time, when created
 * comment.</li>
 * </ul>
 */
public class Comment {
    @NotNull(message = "product cannot be null")
    private Product product;

    @NotNull(message = "customer cannot be null")
    private Customer customer;

    private Comment replies;

    @NotNull(message = "text cannot be null")
    @Size(min = 2, max = 1000, message = "text must be between 2 and 1000")
    private String text;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "createdAt must be past or present")
    private LocalDateTime createdAt;

    public Comment(Product product, Customer customer, Comment replies, String text, LocalDateTime createdAt) {
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

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
            var comment = new Comment(this.product, this.customer, this.replies, this.text, this.createdAt);
            try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Comment>> violations = validator.validate(comment);
                List<String> validationError = violations.stream().map(v -> "validation error in " + v.getPropertyPath()
                        + ", value `" + v.getInvalidValue() + "` should satisfy condition: " + v.getMessage()).toList();
                if (!violations.isEmpty()) {
                    throw new ValidationException(String.join("\n", validationError));
                }
                return comment;
            }
        }
    }
}
