import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * This class calculates and stores statistics for a list of ChthonicCreature entities.
 * The statistics include the minimum, maximum, average, and standard deviation of the attack powers.
 * It also performs outlier analysis based on the interquartile range (IQR) method.
 */
public class Statistics {
    private double min;
    private double max;
    private double average;
    private double standardDeviation;

    /**
     * Calculates basic statistics (min, max, average, standard deviation) for the attack powers of the given creatures.
     *
     * @param creatures The list of ChthonicCreature objects for which the statistics are calculated.
     */
    public void calculateStatistics(List<ChthonicCreature> creatures) {
        // Collect summary statistics for the attack power
        DoubleSummaryStatistics stats = creatures.stream()
                .collect(Collectors.summarizingDouble(ChthonicCreature::getAttackPower));

        this.min = stats.getMin();
        this.max = stats.getMax();
        this.average = stats.getAverage();

        // Calculate the standard deviation
        double variance = creatures.stream()
                .mapToDouble(c -> Math.pow(c.getAttackPower() - average, 2))
                .average()
                .orElse(0.0);
        this.standardDeviation = Math.sqrt(variance);
    }

    /**
     * Analyzes the attack power of creatures to identify outliers based on the interquartile range (IQR) method.
     * Outliers are defined as values outside of the range [Q1 - 1.5 * IQR, Q3 + 1.5 * IQR].
     *
     * @param creatures The list of ChthonicCreature objects to analyze for outliers.
     * @return A map containing the count of normal data points and outliers.
     */
    public Map<String, Long> analyzeOutliers(List<ChthonicCreature> creatures) {
        List<Integer> sortedAttackPowers = creatures.stream()
                .map(ChthonicCreature::getAttackPower)
                .sorted()
                .collect(Collectors.toList());

        // Calculate the first (Q1) and third (Q3) quartiles
        int q1 = sortedAttackPowers.get(sortedAttackPowers.size() / 4);
        int q3 = sortedAttackPowers.get(3 * sortedAttackPowers.size() / 4);
        int iqr = q3 - q1;

        // Calculate the lower and upper bounds for outliers
        int lowerBound = q1 - (int) (1.5 * iqr);
        int upperBound = q3 + (int) (1.5 * iqr);

        // Partition the creatures into normal and outlier groups based on the bounds
        Map<Boolean, Long> grouped = creatures.stream()
                .collect(Collectors.partitioningBy(
                        c -> c.getAttackPower() >= lowerBound && c.getAttackPower() <= upperBound,
                        Collectors.counting()
                ));

        // Return a map with the counts of normal data and outliers
        return Map.of(
                "data", grouped.get(true),
                "outliers", grouped.get(false)
        );
    }

    /**
     * Provides a collector that can be used to gather statistics while processing a stream of ChthonicCreature objects.
     *
     * @return A collector that gathers statistics.
     */
    public static Collector<ChthonicCreature, ?, Statistics> collector() {
        return Collector.of(
                Statistics::new,
                (stats, creature) -> stats.calculateStatistics(List.of(creature)),
                (left, right) -> {
                    left.calculateStatistics(List.of()); // Merge statistics if needed
                    return left;
                }
        );
    }

    /**
     * Returns a string representation of the calculated statistics.
     *
     * @return A string representing the minimum, maximum, average, and standard deviation of the attack powers.
     */
    @Override
    public String toString() {
        return String.format("Min: %.2f, Max: %.2f, Average: %.2f, Std Dev: %.2f",
                min, max, average, standardDeviation);
    }
}
