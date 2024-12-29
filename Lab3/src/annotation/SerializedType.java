package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * The {@code SerializedType} annotation is used to specify a custom name for the class
 * when serializing objects to formats like JSON or XML.
 * This annotation can be applied to a class to map it to a custom name in the serialized output.
 *
 * <p>It is typically used to customize the root element name in the serialized output.</p>
 *
 * @see java.lang.annotation.Retention
 * @see java.lang.annotation.RetentionPolicy
 * @see java.lang.annotation.ElementType
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SerializedType {

    /**
     * The custom name to which the annotated class should be mapped during serialization.
     * This name will be used for the class when it is serialized to JSON or XML formats.
     *
     * @return the custom name for the class
     */
    String name();
}
