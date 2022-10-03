/**
 * Weapon Class that comes from Salable Product, has SalableProduct properties + damage property
 */
public class Weapon extends SalableProduct {
    private int damage;

    /**
     * Parameterized Constructor for the Weapon class
     * Inherits properties from Salable Product and adds a property of damage
     * @param name
     * @param description
     * @param price
     * @param quantity
     * @param damage
     */
    Weapon(String name, String description, double price, int quantity, int damage) {
        super(name, description, price, quantity);
        this.damage = damage;
    }
}
