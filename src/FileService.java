import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * File Service class that is used to load up the initial inventory for the Inventory Manager
 */
public class FileService {
    /**
     * Function to Save Inventory to the JSON File
     * @param fileName
     * @param product
     * @param append
     */
    public void saveToFile(String fileName, SalableProduct product, boolean append) {
        PrintWriter pw;
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file, append);
            pw = new PrintWriter(fw);

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(product);
            pw.println(json);

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read From File Method, reads JSON File and return an array of Salable Products
     * @param fileName
     * @return cars
     */
    public ArrayList<SalableProduct> readFromFile(String fileName) {
        ArrayList<SalableProduct> products = new ArrayList<SalableProduct>();
        try {
            File file = new File(fileName);
            Scanner s = new Scanner(file);

            while (s.hasNext()) {
                boolean isBaseClass = true;
                ObjectMapper objectMapper = new ObjectMapper();
                String json = s.nextLine();
                    SalableProduct product = objectMapper.readValue(json, SalableProduct.class);
                    products.add(product);
            }

            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }
}
