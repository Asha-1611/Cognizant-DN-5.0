package com.exercise2.search;

public class Main {
    public static void main(String[] args) {

        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shoes", "Fashion"),
            new Product(3, "Phone", "Electronics"),
            new Product(4, "Book", "Education"),
            new Product(5, "Watch", "Accessories")
        };

        // Linear Search
        System.out.println("--- Linear Search ---");
        Product result1 = SearchAlgorithms.linearSearch(products, 3);
        System.out.println(result1 != null ? "Found: " + result1 : "Not found");

        // Sorted array for Binary Search
        Product[] sortedProducts = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shoes", "Fashion"),
            new Product(3, "Phone", "Electronics"),
            new Product(4, "Book", "Education"),
            new Product(5, "Watch", "Accessories")
        };

        // Binary Search
        System.out.println("--- Binary Search ---");
        Product result2 = SearchAlgorithms.binarySearch(sortedProducts, 4);
        System.out.println(result2 != null ? "Found: " + result2 : "Not found");
    }
}