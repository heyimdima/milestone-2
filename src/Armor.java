/**
 * Armor Class that comes from Salable Product, has SalableProduct properties + damage property
 */
public class Armor extends SalableProduct {
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
}
