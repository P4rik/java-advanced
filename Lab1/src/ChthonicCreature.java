import java.time.LocalDate;

/**
 * Represents a Chthonic Creature with a name, type, first mention date, and attack power.
 * This class is used to store information about entities of the Chthonic world.
 */
public class ChthonicCreature {
    private String name;
    private String type;
    private LocalDate firstMention;
    private int attackPower;

    /**
     * Constructor to create a ChthonicCreature instance.
     *
     * @param name The name of the creature
     * @param type The type of the creature (e.g., Vampire, Werewolf, etc.)
     * @param firstMention The date when the creature was first mentioned
     * @param attackPower The attack power of the creature
     */
    public ChthonicCreature(String name, String type, LocalDate firstMention, int attackPower) {
        this.name = name;
        this.type = type;
        this.firstMention = firstMention;
        this.attackPower = attackPower;
    }

    /**
     * Gets the name of the creature.
     *
     * @return The name of the creature
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the type of the creature.
     *
     * @return The type of the creature (e.g., Vampire, Werewolf, etc.)
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the first mention date of the creature.
     *
     * @return The date when the creature was first mentioned
     */
    public LocalDate getFirstMention() {
        return firstMention;
    }

    /**
     * Gets the attack power of the creature.
     *
     * @return The attack power of the creature
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Returns a string representation of the ChthonicCreature.
     *
     * @return A string in the format: ChthonicCreature{name='name', type='type', firstMention=date, attackPower=power}
     */
    @Override
    public String toString() {
        return String.format(
                "ChthonicCreature{name='%s', type='%s', firstMention=%s, attackPower=%d}",
                name, type, firstMention, attackPower
        );
    }
}
