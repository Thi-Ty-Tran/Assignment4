/*
 * Name: Thi Ty Tran
 * Date: July 24, 2024
 * File: Main.java
 * Description: The program is a console-based product management system that allows users to create, edit, delete,
 *              and display regular and perishable products using a menu-driven interface and ArrayList for storage.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    // Stores the list of products
    private static ArrayList<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        // Main program loop
        do {
            // Display the menu options
            displayMenu();
            // Get user's choice
            choice = getIntInput("Enter your choice: ");
            // Perform the selected action
            switch (choice) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    createPerishableProduct();
                    break;
                case 3:
                    editProductBySku();
                    break;
                case 4:
                    deleteProductBySku();
                    break;
                case 5:
                    displayProductBySku();
                    break;
                case 6:
                    displayAllProducts();
                    break;
                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    // Displays the menu options
    private static void displayMenu() {
        System.out.println("\n1) Create Product");
        System.out.println("2) Create Perishable Product");
        System.out.println("3) Edit Product by SKU");
        System.out.println("4) Delete Product by SKU");
        System.out.println("5) Display Product by SKU");
        System.out.println("6) Display all Products");
        System.out.println("7) Exit");
    }

    // Creates a new product
    private static void createProduct() {
        try {
            // Get the product details from the user
            String sku = getStringInput("Enter SKU (at least 8 digits): ");
            String name = getStringInput("Enter product name: ");
            double unitCost = getDoubleInput("Enter unit cost: ");
            double salePrice = getDoubleInput("Enter sale price: ");
            int quantity = getIntInput("Enter quantity on hand: ");
            int quantityNeeded = getIntInput("Enter quantity needed: ");
            String specialInstructions = getStringInput("Enter special instructions: ");

            // Create a new product and add it to the list
            Product product = new Product(sku, name, unitCost, salePrice, quantity, quantityNeeded, specialInstructions);
            products.add(product);
            System.out.println("Product created successfully.");
        } catch (IllegalArgumentException e) {
            // Handle any input validation errors
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Creates a new perishable product
    private static void createPerishableProduct() {
        try {
            // Get the perishable product details from the user
            String sku = getStringInput("Enter SKU (at least 8 digits): ");
            String name = getStringInput("Enter product name: ");
            double unitCost = getDoubleInput("Enter unit cost: ");
            double salePrice = getDoubleInput("Enter sale price: ");
            int quantity = getIntInput("Enter quantity on hand: ");
            int quantityNeeded = getIntInput("Enter quantity needed: ");
            String specialInstructions = getStringInput("Enter special instructions: ");
            Date expiryDate = getDateInput("Enter expiry date (yyyy-MM-dd): ");

            // Create a new perishable product and add it to the list
            PerishableProduct product = new PerishableProduct(sku, name, unitCost, salePrice, quantity, quantityNeeded, specialInstructions, expiryDate);
            products.add(product);
            System.out.println("Perishable product created successfully.");
        } catch (IllegalArgumentException e) {
            // Handle any input validation errors
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Edits an existing product by its SKU
    private static void editProductBySku() {
        // Get the SKU of the product to edit
        String sku = getStringInput("Enter SKU to edit: ");
        // Find the product with the given SKU
        Product product = findProductBySku(sku);
        if (product != null) {
            try {
                // Get the new product details from the user
                product.setName(getStringInput("Enter new name: "));
                product.setUnitCost(getDoubleInput("Enter new unit cost: "));
                product.setSalePrice(getDoubleInput("Enter new sale price: "));
                product.setQuantityOnHand(getIntInput("Enter new quantity on hand: "));
                product.setQuantityNeeded(getIntInput("Enter new quantity needed: "));
                product.setSpecialInstructions(getStringInput("Enter new special instructions: "));

                // If the product is a perishable product, update the expiry date
                if (product instanceof PerishableProduct) {
                    ((PerishableProduct) product).setExpiryDate(getDateInput("Enter new expiry date (yyyy-MM-dd): "));
                }

                System.out.println("Product updated successfully.");
            } catch (IllegalArgumentException e) {
                // Handle any input validation errors
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void deleteProductBySku() {
        String sku = getStringInput("Enter SKU to delete: ");
        Product product = findProductBySku(sku);
        if (product != null) {
            products.remove(product);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Deletes a product by its SKU
    private static void displayProductBySku() {
        // Get the SKU of the product to delete
        String sku = getStringInput("Enter SKU to display: ");
        // Find the product with the given SKU
        Product product = findProductBySku(sku);
        if (product != null) {
            // Remove the product from the list
            System.out.println(product);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Displays all the products
    private static void displayAllProducts() {
        if (products.isEmpty()) {
            // If there are no products, display a message
            System.out.println("No products to display.");
        } else {
            // Display all the products
            for (Product product : products) {
                System.out.println(product);
                System.out.println("--------------------");
            }
        }
    }

    // Finds a product by ít SKU
    private static Product findProductBySku(String sku) {
        for (Product product : products) {
            if (product.getSku().equals(sku)) {
                return product;
            }
        }
        return null;
    }

    // Ge a string input from the user
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    // Get an integer input from the user
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            // Handle invalid integer input
            throw new IllegalArgumentException("Invalid input. Please enter a valid integer.");
        }
    }

    // Get a double input from the user
    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            // Handle invalid double input
            throw new IllegalArgumentException("Invalid input. Please enter a valid number.");
        }
    }

    // Get a date input from the user
    private static Date getDateInput(String prompt) {
        System.out.print(prompt);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(scanner.nextLine().trim());
        } catch (Exception e) {
            // Handle invalid date input
            throw new IllegalArgumentException("Invalid input. Please enter a valid date in the format yyyy-MM-dd.");
        }
    }
}