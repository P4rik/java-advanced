import items.Book;
import items.Car;
import items.Person;
import utils.ReflectionSerializer;
import utils.ManualSerializer;

/**
 * The main class for demonstrating the serialization of objects to JSON and XML formats.
 * It shows the use of reflection-based serialization and compares the time taken with manual serialization.
 */
public class Main {

    /**
     * The entry point of the program.
     * It demonstrates serialization of objects using reflection (via the ReflectionSerializer class) and manually (via the ManualSerializer class).
     *
     * @param args the command line arguments (not used)
     * @throws IllegalAccessException if a field is not accessible during serialization
     */
    public static void main(String[] args) throws IllegalAccessException {
        // Create example objects for serialization
        Person person = new Person("John", 30, "New York");
        Book book = new Book("1984", "George Orwell", 1949);
        Car car = new Car("Model S", "Tesla", 2021);

        // Serialize using reflection
        System.out.println("---- Using Reflection Serializer ----");
        long startReflection = System.nanoTime();
        System.out.println(ReflectionSerializer.toJson(person));
        System.out.println(ReflectionSerializer.toXml(person));
        System.out.println(ReflectionSerializer.toJson(book));
        System.out.println(ReflectionSerializer.toXml(book));
        System.out.println(ReflectionSerializer.toJson(car));
        System.out.println(ReflectionSerializer.toXml(car));
        long endReflection = System.nanoTime();
        System.out.println("Reflection Time: " + (endReflection - startReflection) + " ns");

        // Serialize manually
        System.out.println("---- Using Manual Serializer ----");
        long startManual = System.nanoTime();
        System.out.println(ManualSerializer.toJson(person));
        System.out.println(ManualSerializer.toXml(person));
        System.out.println(ManualSerializer.toJson(book));
        System.out.println(ManualSerializer.toXml(book));
        System.out.println(ManualSerializer.toJson(car));
        System.out.println(ManualSerializer.toXml(car));
        long endManual = System.nanoTime();
        System.out.println("Manual Serialization Time: " + (endManual - startManual) + " ns");
    }
}
