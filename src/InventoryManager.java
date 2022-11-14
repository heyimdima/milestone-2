import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that manages the inventory, kind of like the backend of the store
 */
public class InventoryManager {
    FileService fileService;
    private ArrayList<SalableProduct> products;

    /**
     * Default Constructor for the Inventory Manager class that initializes ArrayList of the products the initial state of the stock items
     * Also sorts the ArrayList by name first, price second in descending order
     */
    public InventoryManager() {
        // Initialize a File Service
        fileService = new FileService();
        // initialize the inventory from the JSON File
        products = fileService.readFromFile("inventory.json");

        Collections.sort(products, ((o1, o2) -> {
            int rc = o1.getName().compareTo(o2.getName());
            if (rc == 0) {
                rc = Double.compare(o1.getPrice(), o2.getPrice());
            }
            return rc; // you can return -rc to get the ascending order
        }));
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
     * Function that removes one product from the inventory manager
     * @param selectedItem
     */
    public void removeFromInventory(SalableProduct selectedItem) {
        for (SalableProduct product: products) {
            if (selectedItem.equals(product))
                product.setQuantity(product.getQuantity() - selectedItem.getQuantity());
        }
    }

    /**
     * Function that return the quantity of items back from the shopping cart, when it is cleared
     * @param selectedItems
     */
    public void returnToInventory(ArrayList<SalableProduct> selectedItems) {
        for (SalableProduct selectedItem: selectedItems) {
            for (SalableProduct inventoryItem: products) {
                if (selectedItem.equals(inventoryItem)) {
                    inventoryItem.setQuantity(inventoryItem.getQuantity() + selectedItem.getQuantity());
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
