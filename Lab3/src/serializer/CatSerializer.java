package serializer;

import model.Cat;

/**
 * The {@code CatSerializer} class provides methods for serializing a {@code Cat} object
 * into JSON and XML formats.
 * <p>
 * This class defines two methods:
 * <ul>
 *     <li>{@link #toJson(Cat)}: Serializes the {@code Cat} object into a JSON string.</li>
 *     <li>{@link #toXml(Cat)}: Serializes the {@code Cat} object into an XML string.</li>
 * </ul>
 * </p>
 *
 * @see model.Cat
 */
public class CatSerializer {

    /**
     * Serializes a {@code Cat} object to a JSON string.
     *
     * @param cat the {@code Cat} object to serialize
     * @return a JSON string representing the {@code Cat} object
     */
    public static String toJson(Cat cat) {
        return String.format("{\"cat_name\": \"%s\", \"cat_age\": %d}", cat.getName(), cat.getAge());
    }

    /**
     * Serializes a {@code Cat} object to an XML string.
     *
     * @param cat the {@code Cat} object to serialize
     * @return an XML string representing the {@code Cat} object
     */
    public static String toXml(Cat cat) {
        return String.format("<cat><cat_name>%s</cat_name><cat_age>%d</cat_age></cat>", cat.getName(), cat.getAge());
    }
}
