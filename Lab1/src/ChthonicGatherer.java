import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Gatherer;

/**
 * A custom gatherer that skips a specified number of entities of a certain type
 * while collecting a predefined number of entities in total.
 */
public class ChthonicGatherer implements Gatherer<ChthonicCreature, AtomicInteger, ChthonicCreature> {

    private final String typeToSkip;
    private final int skipCount;
    private int count;  // Keeps track of how many entities have been collected
    private final int total;  // Defines the total number of entities to collect

    /**
     * Constructor to set up the gatherer with the type of entity to skip,
     * the number of entities to skip, and the total number of entities to collect.
     *
     * @param typeToSkip The entity type to be skipped (e.g., "Demon")
     * @param skipCount The number of entities to skip before starting collection
     * @param total The total number of entities to collect
     */
    public ChthonicGatherer(String typeToSkip, int skipCount, int total) {
        this.typeToSkip = typeToSkip;
        this.skipCount = skipCount;
        this.count = 0;
        this.total = total;
    }

    @Override
    public Supplier<AtomicInteger> initializer() {
        // Returns a new AtomicInteger to track how many entities of the specified type have been skipped
        return AtomicInteger::new;
    }

    @Override
    public Integrator<AtomicInteger, ChthonicCreature, ChthonicCreature> integrator() {
        return (state, element, downstream) -> {
            // Skip entities of the specified type if the skip count hasn't been reached
            if (element.getType().equalsIgnoreCase(typeToSkip) && state.get() < skipCount) {
                state.incrementAndGet(); // Increment the skipped count
                return true; // Skip the current element
            } else if (count < total) {
                // Collect the entity if we haven't yet reached the total count
                count += 1;
                return downstream.push(element); // Pass the element to the downstream collector
            }
            return false; // Stop collecting if the total number of entities has been reached
        };
    }

    @Override
    public BinaryOperator<AtomicInteger> combiner() {
        // Return the default combiner for combining results from multiple threads
        return Gatherer.super.combiner();
    }

    @Override
    public BiConsumer<AtomicInteger, Downstream<? super ChthonicCreature>> finisher() {
        // Return the default finisher for the gathering process
        return Gatherer.super.finisher();
    }

    @Override
    public <RR> Gatherer<ChthonicCreature, ?, RR> andThen(Gatherer<? super ChthonicCreature, ?, ? extends RR> that) {
        // Allows chaining an additional gatherer to the current one
        return Gatherer.super.andThen(that);
    }
}
