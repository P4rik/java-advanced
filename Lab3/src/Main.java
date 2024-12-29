import model.Cat;
import model.Product;
import model.User;
import serializer.CatSerializer;
import serializer.ProductSerializer;
import serializer.ReflectionSerializer;
import serializer.UserSerializer;

/**
 * The {@code Main} class demonstrates the usage of different serializers for serializing objects
 * to JSON and XML formats.
 * <p>
 * This class performs serialization of {@link model.Cat}, {@link model.User}, and {@link model.Product}
 * objects using two different serializers: the {@link serializer.ReflectionSerializer} (using reflection)
 * and manual serializers ({@link serializer.CatSerializer}, {@link serializer.UserSerializer},
 * {@link serializer.ProductSerializer}).
 * </p>
 * <p>
 * It also measures and prints the time taken for each serialization approach.
 * </p>
 */
public class Main {

    /**
     * The main method that demonstrates serialization using reflection and manual serializers.
     * It prints the serialized objects and measures the time taken for each approach.
     *
     * @param args the command line arguments (not used)
     * @throws IllegalAccessException if a reflection-based serialization encounters an illegal access
     */
    public static void main(String[] args) throws IllegalAccessException {
        // Create objects to serialize
        Cat cat = new Cat("Whiskers", 3);
        User user = new User("Alice", "alice@example.com");
        Product product = new Product("Laptop", 999.99);

        // Start measuring time for reflection serialization
        long startReflection, endReflection;

        System.out.println("---- Using Reflection Serializer ----");
        startReflection = System.nanoTime();

        // Serialize using ReflectionSerializer
        System.out.println(ReflectionSerializer.toJSON(cat));
        System.out.println(ReflectionSerializer.toJSON(user));
        System.out.println(ReflectionSerializer.toJSON(product));
        System.out.println(ReflectionSerializer.toXML(cat));
        System.out.println(ReflectionSerializer.toXML(user));
        System.out.println(ReflectionSerializer.toXML(product));

        endReflection = System.nanoTime();
        System.out.println("Reflection Time: " + (endReflection - startReflection) + " ns");

        // Start measuring time for manual serialization
        long startManual, endManual;

        System.out.println("---- Using Manual Serializer ----");
        startManual = System.nanoTime();

        // Serialize using manual serializers
        System.out.println(CatSerializer.toJson(cat));
        System.out.println(UserSerializer.toJson(user));
        System.out.println(ProductSerializer.toJson(product));
        System.out.println(CatSerializer.toXml(cat));
        System.out.println(UserSerializer.toXml(user));
        System.out.println(ProductSerializer.toXml(product));

        endManual = System.nanoTime();
        System.out.println("Manual Time: " + (endManual - startManual) + " ns");
    }
}
