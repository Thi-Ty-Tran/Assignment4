/*
 * Name: Thi Ty Tran
 * Date: July 15, 2024
 * File: Product.java
 * Description: The class provides methods to set and get the product's attributes,
 *              with input validation to ensure the data is valid.
 */

import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class Product {
    private String sku;
    private String name;
    private double unitCost;
    private double salePrice;
    private int quantityOnHand;
    private int quantityNeeded;
    private String specialInstructions;

    // Parameterized constructor
    public Product(String sku, String name, double unitCost, double salePrice, int quantity, int quantityNeeded, String specialInstructions) {
        setSku(sku);
        setName(name);
        setUnitCost(unitCost);
        setSalePrice(salePrice);
        setQuantityOnHand(quantity);
        setQuantityNeeded(quantityNeeded);
        setSpecialInstructions(specialInstructions);
    }

    // Getters and setters
    public final String getSku() {
        return sku;
    }

    /**
     * Sets the SKU of the product.
     *
     * @param sku the unique stock keeping unit (SKU) of the product
     * @throws InputMismatchException if the SKU is less than 8 characters long
     */

    // Getter and Setter methods for each private instance variable
    public final void setSku(String sku) {
        if (sku != null && sku.length() >= 8) {
            this.sku = sku;
        } else {
            throw new IllegalArgumentException("SKU must be at least 8 digits long.");
        }
    }

    /**
     * Sets the name of the product.
     *
     * @param name the name of the product
     * @throws IllegalArgumentException if the name is blank
     */
    public final void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
    }

    /**
     * Sets the unit cost of the product.
     *
     * @param unitCost the unit cost of the product
     * @throws IllegalArgumentException if the unit cost is negative
     */
    public final void setUnitCost(double unitCost) {
        if (unitCost >= 0) {
            this.unitCost = unitCost;
        } else {
            throw new IllegalArgumentException("Unit cost must be non-negative.");
        }
    }

    /**
     * Sets the sale price of the product.
     *
     * @param salePrice the sale price of the product
     * @throws IllegalArgumentException if the sale price is negative
     */
    public final void setSalePrice(double salePrice) {
        if (salePrice >= 0) {
            this.salePrice = salePrice;
        } else {
            throw new IllegalArgumentException("Sale price must be non-negative.");
        }
    }

    public final void setQuantityOnHand(int quantityOnHand) {
        if (quantityOnHand >= 0) {
            this.quantityOnHand = quantityOnHand;
        } else {
            throw new IllegalArgumentException("Quantity must be non-negative.");
        }
    }

    /**
     * Sets the current quantity of the product in stock.
     *
     * @param quantityNeeded the current quantity of the product in stock
     * @throws IllegalArgumentException if the quantity is negative
     */
    public final void setQuantityNeeded(int quantityNeeded) {
        if (quantityNeeded >= 0) {
            this.quantityNeeded = quantityNeeded;
        } else {
            throw new IllegalArgumentException("Quantity needed must be non-negative.");
        }
    }

    public final void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    /**
     * Returns a string representation of the `Product` object.
     *
     * @return a string representation of the `Product` object
     */

    // Display function
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return "SKU: " + sku + "\n" +
                "Product Name: " + name + "\n" +
                "Unit Cost: $" + df.format(unitCost) + "\n" +
                "Sale Price: $" + df.format(salePrice) + "\n" +
                "Quantity on hand: " + quantityOnHand + "\n" +
                "Quantity Needed: " + quantityNeeded + "\n" +
                "Special Instructions: " + specialInstructions;
    }
}