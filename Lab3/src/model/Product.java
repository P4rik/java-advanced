package model;

import annotation.SerializedField;
import annotation.SerializedType;

/**
 * The {@code Product} class represents a product with a name and price.
 * This class is annotated with {@code SerializedType} and {@code SerializedField} to define custom
 * names for the fields during serialization to formats like JSON and XML.
 *
 * <p>The class is annotated with {@code SerializedType} to specify the custom name for the root element during serialization.</p>
 * <p>Each field is annotated with {@code SerializedField} to specify custom names for the fields in the serialized output.</p>
 *
 * @see annotation.SerializedField
 * @see annotation.SerializedType
 */
@SerializedType(name = "model.Product")
public class Product {

    @SerializedField(name = "product_name")
    private String name;

    @SerializedField(name = "product_price")
    private double price;

    /**
     * Constructs a new {@code Product} object with the specified name and price.
     *
     * @param name the name of the product
     * @param price the price of the product
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the name of the product.
     *
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the product.
     *
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }
}
