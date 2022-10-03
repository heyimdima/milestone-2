/**
 * Health Class that comes from Salable Product, has SalableProduct properties + amount propery
 */
public class Health extends SalableProduct {
    private int amount;

    /**
     * Parameterized Constructor for the Armor class
     * Inherits properties from Salable Product and also adds a property of amount
     * @param name
     * @param description
     * @param price
     * @param quantity
     * @param amount
     */
    Health(String name, String description, double price, int quantity, int amount) {
        super(name, description, price, quantity);
        this.amount = amount;
    }
}
