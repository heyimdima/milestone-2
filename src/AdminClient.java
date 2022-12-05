import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class AdminClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;


    public static void main(String[] args) throws IOException, InterruptedException {
        // Create a Client and connect to the remote Server on the specified IP Address and Port
        AdminClient client = new AdminClient();
        client.start("127.0.0.1", 777);

        String response = "C";

        while(!response.equals("Q")) {
            Scanner sc = new Scanner(System.in);

            System.out.println("> |U| Add New Product");
            System.out.println("> |R| Return All Products");
            System.out.println("> |Q| Quit");
            System.out.println();

            response = sc.nextLine();

            switch (response) {
                case "U":
                    client.sendMessage(createNewSalable());
                    break;
                case "R":
                    client.sendRequestForInventory();
                    break;
                case "Q":
                    client.sendMessage(".");
                    break;
                default:
                    System.out.println("Invalid input, try again..");
                    break;
            }
        }
        client.cleanup();
    }

    private static String createNewSalable() throws JsonProcessingException {
        Scanner sc = new Scanner(System.in);

        String productName;
        String productDescription;
        double productPrice;
        int productQuantity;
        int productType;

        System.out.println("Enter the NAME for the product: ");
        productName = sc.nextLine();
        System.out.println("Enter the DESCRIPTION for the product: ");
        productDescription = sc.nextLine();
        System.out.println("Enter the PRICE for the product: ");
        productPrice = sc.nextDouble();
        System.out.println("Enter the QUANTITY for the product: ");
        productQuantity = sc.nextInt();

        System.out.println("Choose product TYPE: ");
        System.out.println("|1| Weapon");
        System.out.println("|2| Armor");
        System.out.println("|3| Health");
        productType = sc.nextInt();

        SalableProduct newProduct = null;

        switch (productType) {
            case 1:
                System.out.println("Enter the DAMAGE amount for the Weapon product: ");
                newProduct = new Weapon(productName, productDescription, productPrice, productQuantity, sc.nextInt());
                break;
            case 2:
                System.out.println("Enter the DEFENSE amount for the Armor product: ");
                newProduct = new Armor(productName, productDescription, productPrice, productQuantity, sc.nextInt());
                break;
            case 3:
                System.out.println("Enter the HEALTH amount for the Health product: ");
                newProduct = new Health(productName, productDescription, productPrice, productQuantity, sc.nextInt());
                break;
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(newProduct);

        return json;
    }

    private void sendRequestForInventory() throws JsonProcessingException, IOException {
        String response;

        response = sendMessage("R"); // come back here !!!!!

        System.out.println("Server response was " + response);
    }

    /**
     * Connect to the remote Server on the specified address and Port
     * @param ip Remote IP Address to connect to
     * @param port Remote POrt to connect to
     * @throws UnknownHostException thrown if network resolution exception
     * @throws IOException thrown if anything bad happens from any of the networking classes
     */
    public void start(String ip, int port) throws UnknownHostException, IOException {
        // connect to the Remote Server on the specified IP address and port
        clientSocket = new Socket(ip, port);

        // create some input and output network buffers to communicate back and forth with the Server
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    /**
     * Send a Message to the Server.
     * @param msg Message to send.
     * @return Response back from the server.
     * @throws IOException Thrown if anything bad happens from any of the networking classes.
     */
    public String sendMessage(String msg) throws IOException {
        // send/print a message to server with a terminating line feed
        out.println(msg);

        // return the response from the server
        return in.readLine();
    }

    /**
     * Cleanup logic to close all the network connections.
     * @throws IOException Thrown if anything bad happens from the networking classes.
     */
    public void cleanup() throws IOException {
        // close all input and output network buffers and sockets
        in.close();
        out.close();
        clientSocket.close();
    }
}
