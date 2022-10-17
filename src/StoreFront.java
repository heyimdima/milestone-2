import java.util.Scanner;

/**
 * Store Front Class that has an inventory, shopping cart, and available products.
 */
public class StoreFront {
    private InventoryManager inventory;
    private ShoppingCart shoppingCart;

    /**
     * Default Constructor for the Store Front Class
     * Initializes the available products and calls the main menu function that starts the main loop of the app
     */
    StoreFront() {
        inventory = new InventoryManager();
        shoppingCart = new ShoppingCart();
        greetingMessage();
        mainMenu();
    }

    /**
     * Helper method to output the Welcome Message to the console before the mainMenu loop kicks off
     */
    private void greetingMessage() {
        System.out.println("|--------------------------------------------------------------------|");
        System.out.println("|Welcome to my Store Front, interact with the menu to purchase items.|");
        System.out.println("|--------------------------------------------------------------------|");
    }

    /**
     * main menu loop that is the main user interface of this application
     */
    public void mainMenu() {
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("-----Main Menu-----");
            System.out.println("> |1| View Products");
            System.out.println("> |2| View Cart");
            System.out.println("> |3| Clear Cart");
            System.out.println("> |4| Checkout");
            System.out.println("> |5| Exit Store");
            System.out.println("-------------------");
            System.out.print("Input: ");

            int input = sc.nextInt();

            switch (input) {
                case 1: // View Products
                    displayProducts();
                    purchaseMenu();
                    break;
                case 2: // View Cart
                    shoppingCart.viewCart();
                    break;
                case 3: // Clear Cart
                    inventory.returnToInventory(shoppingCart.getCartItems());
                    shoppingCart.clearCart();
                    break;
                case 4: // Checkout
                    inventory.removeFromInventory(shoppingCart.checkout());
                    break;
                case 5: // Exit Store
                    System.exit(0);
                default: // Default Case (if the user input the wrong number)
                    System.out.println("This input is not recognizable. Try again..");
                    break;
            }
        }
    }

    /**
     * function that displays all the products available for purchase
     */
    public void displayProducts() {
        System.out.println("-----PRODUCTS-----");
        for (SalableProduct product : inventory.getProducts()) {
            System.out.println("> Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice() + "$ (per unit)");
            System.out.println("------------------");
        }
    }

    /**
     * function that triggers a purchase menu where the user is asked
     * whether they would like to purchase an item
     */
    public void purchaseMenu() {
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("-----------------------------------");
            System.out.println("Would you like to purchase an item?");
            System.out.println("> |1| Yes");
            System.out.println("> |2| No (Back to the Main Menu)");
            System.out.println("-----------------------------------");
            System.out.print("Input: ");

            int input = sc.nextInt();

            if (input == 1) {
                productSelectionMenu();
            }
            break;
        }
    }

    /**
     * Product Selection Menu that lets a user decide which item they want to purchase
     */
    public void productSelectionMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.println("Which product would you like to purchase?");
        for (SalableProduct item: inventory.getProducts()) {
            System.out.println("> |" + inventory.getProducts().indexOf(item) + "| " + item.getName());
        }
        System.out.println("-----------------------------------");
        System.out.print("Input: ");
        int input = sc.nextInt();

        SalableProduct selectedItem = new SalableProduct(inventory.getProducts().get(input));

        inventory.removeFromInventory(selectedItem);
        shoppingCart.addToCart(selectedItem);
    }

}
