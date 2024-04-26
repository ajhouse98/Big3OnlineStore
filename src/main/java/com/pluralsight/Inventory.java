package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public static List<Products> loadInventory() {
        List<Products> inventory = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/main/resources/products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();

            String input = "";


            while ((input = bufferedReader.readLine()) != null) {
                String[] data = input.split("\\|");
                String SKU = (data[0]);
                String productName = data[1];
                double price = Double.parseDouble(data[2]);
                String department = (data[3]);
                Products product = new Products(SKU, productName, price, department);
                inventory.add(product);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        } return inventory;
    }
    public static void DisplayInventory(List<Products> productsList) {
        System.out.println();
        productsList.forEach(products -> {
            System.out.println(products.getAll());
        });
    }
}