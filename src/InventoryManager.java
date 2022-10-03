import java.util.ArrayList;

/**
 * Class that manages the inventory, kind of like the backend of the store
 */
public class InventoryManager {

    private ArrayList<SalableProduct> products;

    /**
     * Default Constructor for the Inventory Manager class that initializes ArrayList of the products the initial state of the stock items
     */
    public InventoryManager() {
        products = new ArrayList<SalableProduct>();

        // Hardcoded items in the inventory

        // Products
        this.products.add(new SalableProduct("Sunglasses", "Helps to deal with bright light.", 12.65, 10));
        this.products.add(new SalableProduct("Pencil", "You can draw things with it.", 1.25, 15));
        this.products.add(new SalableProduct("Headphones", "Allows you to listen to music.", 15.75, 5));

        // Weapons
        this.products.add(new Weapon("Katana", "Slices an enemy in the half.", 25.55, 3, 25)); // Weapon 1
        this.products.add(new Weapon("Gun", "Nobody is bulletproof.", 45.30, 5, 55)); // Weapon 2

        // Armor
        this.products.add(new Armor("Wooden Armor", "Armor that is made out of wood.", 15.43, 15, 15)); // Armor 1
        this.products.add(new Armor("Iron Armor", "Armor that is made out of iron.", 26.64, 10, 35)); // Armor 2

        // Health
        this.products.add(new Health("Health", "Fills up your health by 25 point.", 20, 50, 25)); // Health Option
    }

    /**
     * Function that removes items from the stock/inventory given an array of items to remove.
     * This function targets the quantity of the items
     * Method is only triggered after the checkout
     * @param purchasedItems
     */
    public void removeFromInventory(ArrayList<SalableProduct> purchasedItems) {

        for (SalableProduct purchasedItem: purchasedItems) {
            for (SalableProduct inventoryItem: products) {
                if (purchasedItem.equals(inventoryItem)) {
                    inventoryItem.setQuantity(inventoryItem.getQuantity() - purchasedItem.getQuantity());
                }
            }
        }
    }

    /**
     * Getter for the products that are currently in the stock / inventory
     * @return products
     */
    public ArrayList<SalableProduct> getProducts() {
        return products;
    }
}
