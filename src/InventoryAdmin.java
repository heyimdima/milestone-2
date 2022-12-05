import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class InventoryAdmin {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void clientService(int port, ArrayList<SalableProduct> inventory) throws IOException {
        System.out.println("Waiting for client connection....");

        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();

        System.out.println("Received a client connection on port " + clientSocket.getLocalPort());

        out = new PrintWriter(clientSocket.getOutputStream(), true);

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        ObjectMapper objectMapper = new ObjectMapper();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if (".".equals(inputLine)) {
                System.out.println("Quit signal sent.");
                out.println("Quit");
                break;
            } else if ("R".equals(inputLine)){
                System.out.println("Read signal sent");
                String reply = "";
                for (SalableProduct product: inventory) {
                    String json = objectMapper.writeValueAsString(product);
                    reply += json;
                }
                out.println(reply);
            } else {
                System.out.println("Got a message of: " + inputLine);
                SalableProduct product = objectMapper.readerFor(SalableProduct.class).readValue(inputLine);
                inventory.add(product);
                System.out.println("Added product: " + product);
                out.println("OK");
            }
        }
        System.out.println("Server is done.");
    }

    /**
     * Clean up logic to close all the network connections.
     * @throws IOException Thrown if anything bad happens from the networking classes.
     */
    public void cleanup() throws IOException {
        // close all input and output network buffers and sockets
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
