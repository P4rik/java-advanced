import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Stream;

/**
 * A generator for creating random instances of ChthonicCreature.
 * The generator produces entities with random names, types, first mention dates, and power levels.
 */
public class ChthonicCreatureGenerator {
    private static final String[] TYPES = {"Vampire", "Werewolf", "Demon", "Spirit", "Zombie"};
    private static final Random RANDOM = new Random();

    /**
     * Generates a stream of randomly created ChthonicCreature instances.
     * Each creature has a random name, type, first mention date, and power level.
     *
     * @return A Stream of ChthonicCreature objects
     */
    public static Stream<ChthonicCreature> generate() {
        return Stream.generate(() -> new ChthonicCreature(
                "Creature" + RANDOM.nextInt(1000), // Random creature name (Creature0-999)
                TYPES[RANDOM.nextInt(TYPES.length)], // Random type chosen from predefined types
                LocalDate.of(1500 + RANDOM.nextInt(500), 1 + RANDOM.nextInt(12), 1 + RANDOM.nextInt(28)), // Random first mention date between 1500 and 1999
                1 + RANDOM.nextInt(100) // Random power level between 1 and 100
        ));
    }
}
