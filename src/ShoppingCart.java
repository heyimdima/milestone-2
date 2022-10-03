import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for the shopping cart, which is responsible for handling the Salable Product that was selected for purchase
 */
public class ShoppingCart {
    private ArrayList<SalableProduct> selectedProducts;

    /**
     * Default Constructor which initializes an empty array list
     */
    ShoppingCart() {
        selectedProducts = new ArrayList<SalableProduct>();
    }

    /**
     * Function that display the current state of the cart,
     * if cart has items in it, it will show them
     * otherwise it will tell the user that the cart is empty
     */
    public void viewCart() {
        System.out.println("-------CART-------");
        if (selectedProducts.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
            System.out.println("------------------");
        } else {
            for (SalableProduct product : selectedProducts) {
                System.out.println("Name: " + product.getName());
                System.out.println("Quantity: " + product.getQuantity());
                System.out.println("Price: " + product.getPrice() + "$ (per unit)");
                System.out.println("------------------");
            }
            System.out.println("Total: " + getTotal() + "$");
        }

    }

    /**
     * adds a Salable Product that was selected by the user to the cart
     * @param selectedProduct product that is going to be added to the cart
     */
    public void addToCart(SalableProduct selectedProduct) {
        System.out.println("----------------------");
        System.out.println(selectedProduct.getName() + " was added to the cart.");
        System.out.println("----------------------");
        if (selectedProducts.contains(selectedProduct)) {
            for (SalableProduct presentItem : selectedProducts) {
                if (selectedProduct.equals(presentItem)) {
                    presentItem.setQuantity(presentItem.getQuantity() + 1);
                }
            }
        } else
            selectedProducts.add(selectedProduct);
    }

    /**
     * Function that removes all the items from the cart
     */
    public void clearCart() {
        selectedProducts.clear();
        System.out.println("-----------------------------------");
        System.out.println("Cart has been successfully cleared.");
        System.out.println("-----------------------------------");
    }

    /**
     * Function that asks a user to confirm that they want to check out
     * It displays the total of the purchase and thanks the user for purchase
     * <p>
     * IF the user does not confirm the checkout, it will send the user to the main menu
     */
    public ArrayList<SalableProduct> checkout() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------");
        System.out.println("Confirm checkout?");
        System.out.println("> |1| Yes");
        System.out.println("> |2| No");
        System.out.println("------------------");
        System.out.print("Input: ");
        int input = scanner.nextInt();

        if (input == 1) {
            System.out.println("Thank you for your purchase in the total of " + getTotal() + "$");
            System.out.println("------------------");
            return selectedProducts; // Either return the shopping cart
        } else {
            System.out.println("Checkout was cancelled. Going back to the main menu..");
            System.out.println("------------------");
            return null; // OR return a null object so that the inventory knows not to change the stock
        }
    }

    /**
     * function that return the total price for the current items in the cart
     * @return total
     */
    private double getTotal() {
        double total = 0;
        for (SalableProduct product: selectedProducts) {
            total += product.getPrice() * product.getQuantity();
        }

        return total;
    }
}
