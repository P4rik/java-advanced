package items;

import annotations.JsonField;
import annotations.XmlField;
/**
 * Represents a items.Person with a name, age, and city.
 * This class uses annotations to map the fields to JSON and XML formats.
 */
public class Person {

    /**
     * The name of the person.
     * Mapped to the JSON field "name" and XML field "Name".
     */
    @JsonField("name")
    @XmlField("Name")
    private String name;

    /**
     * The age of the person.
     * Mapped to the JSON field "age" and XML field "Age".
     */
    @JsonField("age")
    @XmlField("Age")
    private int age;

    /**
     * The city where the person lives.
     * Mapped to the JSON field "city" and XML field "City".
     */
    @JsonField("city")
    @XmlField("City")
    private String city;

    /**
     * Constructs a new items.Person object with the specified name, age, and city.
     *
     * @param name the name of the person
     * @param age the age of the person
     * @param city the city where the person lives
     */
    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    // Getters and setters can be added here if needed for serialization or other purposes
}
