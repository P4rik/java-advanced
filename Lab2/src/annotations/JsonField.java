package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to map a Java field to a corresponding field in JSON format.
 * The value of the annotation specifies the name of the field in the JSON representation.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JsonField {

    /**
     * The name of the field in the JSON representation.
     *
     * @return the field name as a string
     */
    String value();
}
