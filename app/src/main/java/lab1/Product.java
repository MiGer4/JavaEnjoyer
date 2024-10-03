package lab1;

import java.util.Objects;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
/**
 * The {@code Product} class represents an accounting record for a specific
 * product, including details such as the name, category, characteristics, measurement unit, and price.
 *
 * <p>The following fields are included:</p>
 * <ul>
 *   <li>{@link String} name - The name of product.</li>
 *   <li>{@link Category} category - The category of product.</li>
 *   <li>{@link Characteristics} characteristics - The characteristics of product.</li>
 *   <li>{@link String} measurementUnit - The measurement unit of product.</li>
 *   <li>{@link Double} price - The price of product.</li>
 * </ul>
 */
public class Product {
    private String name;
    private Category category;
    private List<Map<Characters, String>> characters;
    private String measurementUnit;
    private Double price;

    public Product(String name, Category category, String measurementUnit, Double price) {
        this.name = name;
        this.category = category;
        this.measurementUnit = measurementUnit;
        this.price = price;
        this.characters = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addCharacter(Characters character, String value) {
        characters.add(Map.of(character, value));
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product good = (Product) o;
        return name.equals(good.name) && category.equals(good.category) &&
                characters.equals(good.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, characters);
    }

    @Override
    public String toString() {
        String strCharacters = "[";
        for (Map<Characters,String> map : characters) {
            strCharacters += map.toString();
        }
        strCharacters += "]";

        return "Product{" +
                "name=" + name +
                ", category=" + category +
                ", characters=" + strCharacters +
                ", measurementUnit=" + measurementUnit +
                ", price=" + price +
                "}";
    }

}
