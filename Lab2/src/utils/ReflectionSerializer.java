package utils;

import annotations.JsonField;
import annotations.XmlField;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides methods for serializing Java objects to JSON and XML formats.
 * It uses reflection to inspect the fields of the objects and annotations to map them to the corresponding format.
 */
public class ReflectionSerializer{

    /**
     * Serializes a Java object to a JSON string.
     * The method uses the {@link JsonField} annotation to map fields to JSON.
     *
     * @param obj the object to serialize
     * @return the JSON representation of the object as a string
     * @throws IllegalAccessException if the field is not accessible
     */
    public static String toJson(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Map<String, Object> jsonMap = new HashMap<>();

        // Loop through the fields of the class and serialize them based on the annotations.JsonField annotation
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                field.setAccessible(true);  // Allows access to private fields
                jsonMap.put(annotation.value(), field.get(obj));
            }
        }

        // Return the JSON string by converting the map to a string and replacing "=" with ":"
        return jsonMap.toString().replace("=", ":");
    }

    /**
     * Serializes a Java object to an XML string.
     * The method uses the {@link XmlField} annotation to map fields to XML tags.
     *
     * @param obj the object to serialize
     * @return the XML representation of the object as a string
     * @throws IllegalAccessException if the field is not accessible
     */
    public static String toXml(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder xmlBuilder = new StringBuilder();

        // Start the XML document with the root element name (class name)
        xmlBuilder.append("<").append(clazz.getSimpleName()).append(">\n");

        // Loop through the fields of the class and serialize them based on the annotations.XmlField annotation
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(XmlField.class)) {
                XmlField annotation = field.getAnnotation(XmlField.class);
                field.setAccessible(true);  // Allows access to private fields
                xmlBuilder.append("  <").append(annotation.value()).append(">")
                        .append(field.get(obj))
                        .append("</").append(annotation.value()).append(">\n");
            }
        }

        // End the XML document with the closing root element
        xmlBuilder.append("</").append(clazz.getSimpleName()).append(">");
        return xmlBuilder.toString();
    }
}
