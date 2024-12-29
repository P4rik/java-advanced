package model;

import annotation.SerializedField;
import annotation.SerializedType;

/**
 * The {@code User} class represents a user with a name and email.
 * This class is annotated with {@code SerializedType} and {@code SerializedField} to define custom
 * names for the fields during serialization to formats like JSON and XML.
 *
 * <p>The class is annotated with {@code SerializedType} to specify the custom name for the root element during serialization.</p>
 * <p>Each field is annotated with {@code SerializedField} to specify custom names for the fields in the serialized output.</p>
 *
 * @see annotation.SerializedField
 * @see annotation.SerializedType
 */
@SerializedType(name = "model.User")
public class User {

    @SerializedField(name = "user_name")
    private String name;

    @SerializedField(name = "user_email")
    private String email;

    /**
     * Constructs a new {@code User} object with the specified name and email.
     *
     * @param name the name of the user
     * @param email the email of the user
     */
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Returns the name of the user.
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the email of the user.
     *
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }
}
