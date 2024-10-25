package lab3;

import lab2.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class YAMLSerializer<T> implements Serialization<T> {
    private final YAMLMapper mapper;
    private final Class<T> clazz;

    public YAMLSerializer(Class<T> clazz) {
        mapper = new YAMLMapper();
        mapper.registerModule(new JavaTimeModule());
        this.clazz = clazz;
    }

    @Override
    public T toEntity(String object) throws IOException {
        return mapper.readValue(object, clazz);
    }

    @Override
    public List<T> toEntityList(String objectCollection) throws IOException {
        return mapper.readValue(objectCollection, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }

    @Override
    public String fromEntity(T object) throws IOException {
        return mapper.writeValueAsString(object);
    }

    @Override
    public String fromEntityList(List<T> objectCollection) throws IOException {
        return mapper.writeValueAsString(objectCollection);
    }

    @Override
    public List<T> toEntityListFromFile(String fileName) throws IOException {
        return mapper.readValue(new File(fileName), new TypeReference<List<T>>() {
        });
    }

    @Override
    public void fromEntityToFile(T object, String fileName) throws IOException {
        mapper.writeValue(new File(fileName), object);
    }

    @Override
    public void fromEntityListToFile(List<T> objectCollection, String fileName) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), objectCollection);
    }

    public static void main(String[] args) {
        Address address1 = new Address("Ukraine", "Mamaivtsi", "Nothehe", 52);
        Customer customer1 = new Customer("Misha", "Hordei", address1, "+380999516532");
        ShoppingCart shoppingCart1 = new ShoppingCart(customer1, LocalDate.of(2024, 9, 20), address1, true);

        YAMLSerializer<ShoppingCart> yamlSerializer = new YAMLSerializer<>(ShoppingCart.class);

        try {
            yamlSerializer.fromEntityToFile(shoppingCart1, "output");
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }

    }
}
