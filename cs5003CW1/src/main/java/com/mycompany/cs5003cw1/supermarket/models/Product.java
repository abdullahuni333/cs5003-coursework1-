/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs5003cw1.supermarket.models;

/**
 *
 * @author nadiaabdullahi
 */
public class Product {
    // Attributes
    private int productID;
    private String productName;
    private String productEntryDate;
    private int quantity;
    private ActivityCircularQueue lastFourActivities;
    
// Constructor   
public Product(int productID, String productName, String productEntryDate, int quantity) {
    this.productID = productID;
    this.productName = productName;
    this.productEntryDate = productEntryDate;
    this.quantity = quantity;
    this.lastFourActivities = new ActivityCircularQueue(4);
    
}

/**
 * Returns the product ID.
 * The product ID is fixed and unique for each product.
 * @return productID the unique identifier of the product
 */
public int getProductID() {
    return productID;
}

/**
 * Sets the quantity of the product.
 * Ensures that the quantity cannot be negative.
 * If a negative value is passed, the quantity is not changed and a warning is printed.
 * @param quantity the new quantity to set
 */
public void setQuantity(int quantity) {
    if (quantity >= 0) {
        this.quantity = quantity;
    }else{
        System.out.println("Quantity cannot be negative.");
    }
  
}

/**
 * Returns the current quantity of the product in stock.
 * @return the quantity of the product
 */
public int getQuantity() {
    return quantity;
}

/**
 * Returns the product's Name
 * @return the name
 */
public String getProductName() {
    return productName;
}

/**
 * Sets the product name.
 * Ensures that a value must be entered
 * @param productName the new name to set
 */
public void setProductName(String productName) {
    if (productName != null && !productName.isEmpty()) {
    this.productName = productName;
 } else {
        System.out.println("Product name cannot be empty.");
    }
}

/**
 * Returns the product's entry date.
 * Entry date is fixed for each product
 * @return entry date
 */
public String getProductEntryDate() {
    return productEntryDate;
}

/**
 * Adds new activity to product
 * Updates product quantity based on activity type
 * Only "AddToStock" and "RemoveFromStock" supported
 * Prevents negative stock + stores activity in last-four circular queue
 * @param activity the activity to add
 */
public void addActivity(activityTracker activity) {
    // 1. Null check
    if (activity == null) {
        System.out.println("Activity cannot be null.");
        return;
    }
     //2. Extract values
    String name = activity.get_name();
    int amount = activity.get_Qauntity();
    
    //3. Handle AddToStock
    if (name.equals("AddToStock")) {
        this.quantity = this.quantity + amount;
    }
    
    //4. Handle RemoveFromStock
    else if (name.equals("RemoveFromStock")) {
        if (amount > this.quantity) {
            System.out.println("Not enough stock to remove " + amount);
            return;
        }
        this.quantity = this.quantity - amount;
    }
    
    //5. Error for unknown activity 
    else {
        System.out.println("Unknown activity type: " + name);
        return;
    }
    
    //6. Add to circular queue
    lastFourActivities.enqueue(activity);
}





    }




    

