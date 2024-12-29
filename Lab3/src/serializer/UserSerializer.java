package serializer;

import model.User;

/**
 * The {@code UserSerializer} class provides methods for serializing a {@link model.User} object
 * to JSON and XML formats.
 * <p>
 * This class contains two static methods: one for serializing a {@code User} object to JSON and
 * another for serializing the same object to XML.
 * </p>
 */
public class UserSerializer {

    /**
     * Serializes a {@code User} object to JSON format.
     *
     * @param user the {@code User} object to serialize
     * @return the JSON representation of the {@code User} object
     */
    public static String toJson(User user) {
        return String.format("{\"user_name\": \"%s\", \"user_email\": \"%s\"}", user.getName(), user.getEmail());
    }

    /**
     * Serializes a {@code User} object to XML format.
     *
     * @param user the {@code User} object to serialize
     * @return the XML representation of the {@code User} object
     */
    public static String toXml(User user) {
        return String.format("<user><user_name>%s</user_name><user_email>%s</user_email></user>", user.getName(), user.getEmail());
    }
}
