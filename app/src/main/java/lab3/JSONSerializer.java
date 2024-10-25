package lab3;

import lab2.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JSONSerializer<T> implements Serialization<T> {
    private final ObjectMapper mapper;
    private final Class<T> clazz;

    public JSONSerializer(Class<T> clazz) {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        this.clazz = clazz;
    }

    @Override
    public T toEntity(String object) throws JsonProcessingException {
        return mapper.readValue(object, clazz);
    }

    @Override
    public List<T> toEntityList(String objectCollection) throws JsonProcessingException {
        return mapper.readValue(objectCollection, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }

    @Override
    public String fromEntity(T object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    @Override
    public String fromEntityList(List<T> objectCollection) throws JsonProcessingException {
        return mapper.writeValueAsString(objectCollection);
    }

    @Override
    public List<T> toEntityListFromFile(String fileName) throws IOException {
        return mapper.readValue(new File(fileName), mapper.getTypeFactory().constructCollectionType(List.class, clazz));
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

        JSONSerializer<ShoppingCart> jsonSerializer = new JSONSerializer<>(ShoppingCart.class);

        try {
            jsonSerializer.fromEntityToFile(shoppingCart1, "output");
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }

    }
}
