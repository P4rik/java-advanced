package utils;

import items.Book;
import items.Car;
import items.Person;

import java.lang.reflect.Field;

/**
 * This class provides manual serialization methods for the Person, Book, and Car classes into JSON and XML formats.
 * It uses reflection to access object fields and convert them to string representations.
 */
public class ManualSerializer {

    /**
     * Serializes a Person object to JSON format.
     *
     * @param person the Person object to serialize
     * @return the JSON string representation of the Person object
     * @throws IllegalAccessException if there is an error accessing the fields of the object
     */
    public static String toJson(Person person) throws IllegalAccessException {
        return String.format("{\"name\": \"%s\", \"age\": %d, \"city\": \"%s\"}",
                getFieldValue(person, "name"), getFieldValue(person, "age"), getFieldValue(person, "city"));
    }

    /**
     * Serializes a Person object to XML format.
     *
     * @param person the Person object to serialize
     * @return the XML string representation of the Person object
     * @throws IllegalAccessException if there is an error accessing the fields of the object
     */
    public static String toXml(Person person) throws IllegalAccessException {
        return String.format("<person><name>%s</name><age>%d</age><city>%s</city></person>",
                getFieldValue(person, "name"), getFieldValue(person, "age"), getFieldValue(person, "city"));
    }

    /**
     * Serializes a Book object to JSON format.
     *
     * @param book the Book object to serialize
     * @return the JSON string representation of the Book object
     * @throws IllegalAccessException if there is an error accessing the fields of the object
     */
    public static String toJson(Book book) throws IllegalAccessException {
        return String.format("{\"title\": \"%s\", \"author\": \"%s\", \"year\": %d}",
                getFieldValue(book, "title"), getFieldValue(book, "author"), getFieldValue(book, "year"));
    }

    /**
     * Serializes a Book object to XML format.
     *
     * @param book the Book object to serialize
     * @return the XML string representation of the Book object
     * @throws IllegalAccessException if there is an error accessing the fields of the object
     */
    public static String toXml(Book book) throws IllegalAccessException {
        return String.format("<book><title>%s</title><author>%s</author><year>%d</year></book>",
                getFieldValue(book, "title"), getFieldValue(book, "author"), getFieldValue(book, "year"));
    }

    /**
     * Serializes a Car object to JSON format.
     *
     * @param car the Car object to serialize
     * @return the JSON string representation of the Car object
     * @throws IllegalAccessException if there is an error accessing the fields of the object
     */
    public static String toJson(Car car) throws IllegalAccessException {
        return String.format("{\"model\": \"%s\", \"manufacturer\": \"%s\", \"year\": %d}",
                getFieldValue(car, "model"), getFieldValue(car, "manufacturer"), getFieldValue(car, "year"));
    }

    /**
     * Serializes a Car object to XML format.
     *
     * @param car the Car object to serialize
     * @return the XML string representation of the Car object
     * @throws IllegalAccessException if there is an error accessing the fields of the object
     */
    public static String toXml(Car car) throws IllegalAccessException {
        return String.format("<car><model>%s</model><manufacturer>%s</manufacturer><year>%d</year></car>",
                getFieldValue(car, "model"), getFieldValue(car, "manufacturer"), getFieldValue(car, "year"));
    }

    /**
     * Retrieves the value of a field in an object using reflection.
     *
     * @param obj the object whose field value needs to be retrieved
     * @param fieldName the name of the field
     * @return the value of the field
     * @throws IllegalAccessException if there is an error accessing the field
     */
    private static Object getFieldValue(Object obj, String fieldName) throws IllegalAccessException {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (NoSuchFieldException e) {
            throw new IllegalAccessException("Field " + fieldName + " not found in class " + obj.getClass().getSimpleName());
        }
    }
}
