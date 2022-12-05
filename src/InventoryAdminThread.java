import java.io.IOException;
import java.util.ArrayList;

public class InventoryAdminThread extends Thread {

    private ArrayList<SalableProduct> inventory;
    public InventoryAdminThread(ArrayList<SalableProduct> inventory) {
        super();
        this.inventory = inventory;
    }

    public void run() {
        InventoryAdmin server = new InventoryAdmin();
        try {
            server.clientService(777, inventory);
            server.cleanup();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}