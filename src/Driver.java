import java.util.Arrays;

/**
 * Driver for the Store Front Application by Dmytro Bondar
 * This method initializes the Store Front which kicks off the main loop of the app location.
 * This is my own work.
 */
public class Driver {
    public static void main(String[] args) {
        // Initialize a Store Front, it's constructor will start the main menu loop
//        StoreFront store = new StoreFront();

        // initialize some weapons armors and health
        SalableProduct[] test = new SalableProduct[6];
        test[0] = new Weapon("Katana", "test", 25.55, 3, 25);
        test[1] = new Weapon("Bababa", "test", 25.55, 3, 25);
        test[2] = new Weapon("Tatata", "test", 25.55, 3, 25);
        test[3] = new Armor("Armor", "test", 25.55, 3, 25);
        test[4] = new Armor("barmor", "test", 25.55, 3, 25);
        test[5] = new Health("Health", "test", 25.55, 3, 25);

        // print the unsorted array
        for (SalableProduct product: test) {
            System.out.println(product.getName());
        }

        Arrays.sort(test); // sort the arrays (will use the compare to method)

        System.out.println("-----------------------");

        // print the sorted array
        for (SalableProduct product: test) {
            System.out.println(product.getName());
        }

    }
}