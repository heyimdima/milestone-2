/**
 * Armor Class that comes from Salable Product, has SalableProduct properties + damage property
 */
public class Armor extends SalableProduct implements Comparable<SalableProduct>{
    private int defense;

    /**
     * Parameterized Constructor for the Armor class
     * Inherits properties from Salable Product and also adds a property of defense
     * @param name
     * @param description
     * @param price
     * @param quantity
     * @param defense
     */
    Armor(String name, String description, double price, int quantity, int defense) {
        super(name, description, price, quantity);
        this.defense = defense;
    }

    /**
     * Override the compare to function based on the name of the item and alphabetical ordering rules that ignore case
     * @param o the object to be compared.
     * @return comparison
     */
    @Override
    public int compareTo(SalableProduct o) {
        return this.getName().compareTo(o.getName());
    }
}
