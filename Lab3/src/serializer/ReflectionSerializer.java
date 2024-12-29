package serializer;

import annotation.SerializedField;
import annotation.SerializedType;

import java.lang.reflect.Field;

/**
 * The {@code ReflectionSerializer} class provides methods for serializing objects to JSON and XML formats
 * using reflection.
 * <p>
 * This class supports serializing objects into JSON and XML by inspecting their fields using Java reflection.
 * It requires the classes to be annotated with {@link annotation.SerializedType} and their fields with
 * {@link annotation.SerializedField} annotations.
 * </p>
 */
public class ReflectionSerializer {

    /**
     * Serializes an object to JSON format using reflection.
     *
     * @param obj the object to serialize
     * @return the JSON representation of the object
     * @throws IllegalAccessException if the reflection-based serialization encounters an illegal access
     */
    public static String toJSON(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        if (!clazz.isAnnotationPresent(SerializedType.class)) {
            throw new IllegalArgumentException("Class must be annotated with @SerializedType");
        }

        StringBuilder json = new StringBuilder("{");
        SerializedType root = clazz.getAnnotation(SerializedType.class);
        json.append(String.format("\"%s\": {", root.name())); // Use name from @SerializedType

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(SerializedField.class)) {
                field.setAccessible(true);
                SerializedField annotation = field.getAnnotation(SerializedField.class);
                String key = annotation.name();
                Object value = field.get(obj);
                json.append(String.format("\"%s\": \"%s\",", key, value));
            }
        }
        if (json.charAt(json.length() - 1) == ',') {
            json.deleteCharAt(json.length() - 1);
        }
        json.append("}}"); // Close the object and root element
        return json.toString();
    }

    /**
     * Serializes an object to XML format using reflection.
     *
     * @param obj the object to serialize
     * @return the XML representation of the object
     * @throws IllegalAccessException if the reflection-based serialization encounters an illegal access
     */
    public static String toXML(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        if (!clazz.isAnnotationPresent(SerializedType.class)) {
            throw new IllegalArgumentException("Class must be annotated with @SerializedType");
        }

        StringBuilder xml = new StringBuilder();
        SerializedType root = clazz.getAnnotation(SerializedType.class);
        xml.append("<").append(root.name()).append(">"); // Use name from @SerializedType

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(SerializedField.class)) {
                field.setAccessible(true);
                SerializedField annotation = field.getAnnotation(SerializedField.class);
                String tag = annotation.name();
                Object value = field.get(obj);
                xml.append(String.format("<%s>%s</%s>", tag, value, tag));
            }
        }
        xml.append("</").append(root.name()).append(">"); // Close the root element
        return xml.toString();
    }
}
