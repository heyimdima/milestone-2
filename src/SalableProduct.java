/**
 * Salable Product class
 */
public class SalableProduct {
    private String name;
    private String description;
    private double price;
    private int quantity;

    /**
     * Parameterized Constructor for the Salable Product Class
     *
     * @param name        name of the product
     * @param description description of the product
     * @param price       price of the product
     * @param quantity    quantity of the product
     */
    SalableProduct(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Copy-Constructor to make copies of the object to throw into the shopping cart, defined with quantity 1.
     * @param another
     */
    public SalableProduct(SalableProduct another) {
        this.name = another.name;
        this.description = another.description;
        this.price = another.price;
        this.quantity = 1;
    }

    /**
     * Overrides the equal() function to compare the items from the cart to the items in the inventory and manage them
     * @param obj
     * @return true/false
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        final SalableProduct other = (SalableProduct) obj;
        if (!this.name.equals(other.name)) {
            return false;
        }

        return true;
    }

    /**
     * getter for the name of the product
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for the name of the product
     * @param name product's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for the description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter for description
     * @param description describes an item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getter for the price of the item
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * setter for the price of an item
     * @param price how much does an item cost
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * getter for the quantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * setter for the quantity
     * @param quantity how many items are available for purchase
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
