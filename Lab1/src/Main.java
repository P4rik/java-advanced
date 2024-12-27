import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    /**
     * This is the main method that serves as the entry point to the application.
     * It guides the user to input details such as the number and type of entities to exclude,
     * and then processes a list of Chthonic creatures by applying filters, grouping them, and computing statistical data.
     *
     * @param args Command-line arguments (not utilized in this version)
     */
    public static void main(String[] args) {

        // Create a scanner to capture user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the quantity of entities to discard
        System.out.print("Please enter the number of entities to exclude (N): ");
        final int N = scanner.nextInt();
        scanner.nextLine();  // Consume the leftover newline character

        // Prompt the user for the type of entity to be excluded
        System.out.print("Please specify the type of entity to exclude (Vampire, Werewolf, Demon, Spirit, Zombie): ");
        final String type = scanner.nextLine();

        // Prompt the user for the year range to filter by
        System.out.print("Enter the start year for filtering(1500-2000yrs): ");
        final int startYear = scanner.nextInt();
        System.out.print("Enter the end year for filtering(1500-2000yrs): ");
        final int endYear = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        // Close the scanner
        scanner.close();

        // Generate and filter the list of Chthonic entities based on user input
        List<ChthonicCreature> entities = ChthonicCreatureGenerator.generate()
                .gather(new ChthonicGatherer(type, N, 500)) // Apply exclusion criteria
                .toList();

        // Filter entities based on the provided year range and group them by type
        System.out.println("Filtered and grouped entities by type and year: ");
        Map<String, List<ChthonicCreature>> filteredEntities = entities.stream()
                .filter(entity -> {
                    // Retrieve the year of the entity's first recorded appearance
                    int firstAppearanceYear = entity.getFirstMention().getYear();
                    // Check if the entity's appearance year is within the specified range
                    return (firstAppearanceYear >= startYear) && (firstAppearanceYear <= endYear);
                })
                .collect(Collectors.groupingBy(ChthonicCreature::getType));

        // Display the filtered and grouped entities
        System.out.println(filteredEntities + "\n");

        // Calculate and show statistics about the entities
        Statistics statistics = new Statistics();
        statistics.calculateStatistics(entities); // Perform statistical analysis
        System.out.println("Statistics: " + statistics); // Output statistics

        // Perform analysis for outliers and print the results
        Map<String, Long> outliers = statistics.analyzeOutliers(entities);
        System.out.println("Outliers: " + outliers);

    }
}
