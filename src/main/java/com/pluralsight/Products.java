package com.pluralsight;

public class Products {
private String SKU, productName, department;
private double price;

public Products(String SKU, String productName, double price, String department) {
    this.SKU = SKU;
    this.productName = productName;
    this.price = price;
    this.department = department;
}

    public String getSKU() {
        return SKU;
    }

    public String getProductName() {
        return productName;
    }

    public String getDepartment() {
        return department;
    }

    public double getPrice() {
        return price;
    }
    public String getAll() {
    return String.format("%s | %s | %.2f | %s", SKU, productName, price, department);
    }
}
