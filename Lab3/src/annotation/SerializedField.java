package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * The {@code SerializedField} annotation is used to specify the name of a field when serializing an object.
 * This annotation can be applied to fields in order to map the field to a custom name during serialization
 * to formats like JSON or XML.
 *
 * <p>It is used during reflection-based serialization to customize how the field is represented in the serialized output.
 * </p>
 *
 * @see java.lang.annotation.Retention
 * @see java.lang.annotation.RetentionPolicy
 * @see java.lang.annotation.ElementType
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SerializedField {

    /**
     * The name to which the annotated field should be mapped during serialization.
     * This name will be used in the serialized format, such as JSON or XML.
     *
     * @return the custom name for the field
     */
    String name();
}
