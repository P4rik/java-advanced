package model;

import annotation.SerializedField;
import annotation.SerializedType;

/**
 * The {@code Cat} class represents a cat with a name and age.
 * This class is annotated with {@code SerializedType} and {@code SerializedField} to define custom
 * names for the fields during serialization to formats like JSON and XML.
 *
 * <p>The class is annotated with {@code SerializedType} to specify the custom name for the root element during serialization.</p>
 * <p>Each field is annotated with {@code SerializedField} to specify custom names for the fields in the serialized output.</p>
 *
 * @see annotation.SerializedField
 * @see annotation.SerializedType
 */
@SerializedType(name = "cat")
public class Cat {

    @SerializedField(name = "cat_name")
    private String name;

    @SerializedField(name = "cat_age")
    private int age;

    /**
     * Constructs a new {@code Cat} object with the specified name and age.
     *
     * @param name the name of the cat
     * @param age the age of the cat
     */
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Returns the name of the cat.
     *
     * @return the name of the cat
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the age of the cat.
     *
     * @return the age of the cat
     */
    public int getAge() {
        return age;
    }
}
