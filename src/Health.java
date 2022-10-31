/**
 * Health Class that comes from Salable Product, has SalableProduct properties + amount propery
 */
public class Health extends SalableProduct implements Comparable<SalableProduct>{
    private int amount;

    /**
     * Default Constructor
     */
    Health() {
        super();
        this.amount = 0;
    }

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

    /**
     * Getter for amount of health
     * @return amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Setter for the amount of health
     * @param amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
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
