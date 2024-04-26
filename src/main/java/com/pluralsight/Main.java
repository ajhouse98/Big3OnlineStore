package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Cart userCart = new Cart();

        while (true) {
            List<Products> inventory = Inventory.loadInventory();
            System.out.println(""" 
                    1. Display Products
                    2. Display Cart
                    3. Exit
                    """);
            System.out.print("Please choose one of the following: ");
            int choice = userInput.nextInt();
            userInput.nextLine();

            if (choice == 1) {
                Inventory.DisplayInventory(inventory);
                DisplayTwo(userInput, inventory, userCart);
            } else if (choice == 2) {
                System.out.println("Cart");
                userCart.displayCart();
            } else if (choice == 3) {
                System.exit(0);
            } else {
                System.out.println("Invalid input, please try again \n");
            }
        }
    }

    public static void DisplayTwo(Scanner userInput, List<Products> inventory, Cart userCart) {
        List<Products> filterItems = new ArrayList<>();
        while (true) {
            System.out.print("""
                                    
                    1. Search
                    2. Add
                    3. Go Back
                    
                    Please enter:\s """);
            int options = userInput.nextInt();
            userInput.nextLine();

            if (options == 1) {
                System.out.print("Please type what product do you want to search? ");
                String searchName = userInput.nextLine();

                for(Products product : inventory) {
                    if (product.getProductName().toLowerCase().contains(searchName.toLowerCase())) {
                        filterItems.add(product);
                    }
                } Inventory.DisplayInventory(filterItems);


            } else if (options == 2) {
                System.out.println("Add it to cart (Y or N)?: ");
                String yesorNO = userInput.nextLine();

                switch (yesorNO) {
                    case "Y", "y" :
                        userCart.addToCart(filterItems);
                        break;
                    case "N", "n" :
                        break;
                }

            } else if (options == 3) {
                break;
            }
        }
    }
}
