package serializer;

import model.Product;

/**
 * The {@code ProductSerializer} class provides methods for serializing a {@code Product} object
 * into JSON and XML formats.
 * <p>
 * This class defines two methods:
 * <ul>
 *     <li>{@link #toJson(Product)}: Serializes the {@code Product} object into a JSON string.</li>
 *     <li>{@link #toXml(Product)}: Serializes the {@code Product} object into an XML string.</li>
 * </ul>
 * </p>
 *
 * @see model.Product
 */
public class ProductSerializer {

    /**
     * Serializes a {@code Product} object to a JSON string.
     *
     * @param product the {@code Product} object to serialize
     * @return a JSON string representing the {@code Product} object
     */
    public static String toJson(Product product) {
        return String.format("{\"product_name\": \"%s\", \"product_price\": %.2f}", product.getName(), product.getPrice());
    }

    /**
     * Serializes a {@code Product} object to an XML string.
     *
     * @param product the {@code Product} object to serialize
     * @return an XML string representing the {@code Product} object
     */
    public static String toXml(Product product) {
        return String.format("<product><product_name>%s</product_name><product_price>%.2f</product_price></product>", product.getName(), product.getPrice());
    }
}
