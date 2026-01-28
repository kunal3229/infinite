package com.example.kunal.executor;

import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ProductPageLoader {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Let's build a complete example: E-commerce Product Page Loader

        String productId = "PROD123";
        Long start  = System.currentTimeMillis();

        // Load all data in Parallel
        CompletableFuture<Product> productFuture = getProductDetails(productId);
        CompletableFuture<List<Review>> reviewsFuture = getReviews(productId);
        CompletableFuture<Inventory> inventoryFuture = getInventory(productId);
        CompletableFuture<List<Product>> recommendationsFuture = getRecommendations(productId);

        // Combined all results
        CompletableFuture<ProductPage> productPage = productFuture.thenCombine(
                reviewsFuture, (product, reviews) -> {
                    product.setReviews(reviews);
                    return product;
                }
        )
                .thenCombine(
                        inventoryFuture, (product, inventory) -> {
                            product.setInventory(inventory);
                            return product;
                        }
                )
                .thenCombine(
                        recommendationsFuture, ProductPage::new
                )
                .exceptionally((exception) -> {
                    System.out.println("Error Loading Page" + exception.getMessage());
                    return new ProductPage();
                });

        ProductPage page = productPage.get();

        long end = System.currentTimeMillis();
        System.out.println("Page loaded in: " + (end - start) + "ms");
        System.out.println(page);

    }

    private static CompletableFuture<Product> getProductDetails(String productId) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1000); // stimulate db calls
            return new Product(productId, "Laptop", 999.9);
        });
    }

    private static CompletableFuture<List<Review>> getReviews(String productId) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1500); // Simulate API call
            return Arrays.asList(
                    new Review("Great product!", 5),
                    new Review("Good value", 4)
            );
        });
    }

    private static CompletableFuture<Inventory> getInventory(String productId) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(800); // Simulate inventory check
            return new Inventory(50, "In Stock");
        });
    }

    private static CompletableFuture<List<Product>> getRecommendations(String productId) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1200); // Simulate ML service
            return Arrays.asList(
                    new Product("PROD124", "Mouse", 29.99),
                    new Product("PROD125", "Keyboard", 79.99)
            );
        });
    }

    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {}
    }
}

// Simple Data Classes
@ToString
class Product {
    String id, name;
    double price;
    List<Review> reviews;
    Inventory inventory;

    Product(){};

    Product(String id, String name, double price){
        this.id = id; this.name = name; this.price = price;
    }

    void setReviews(List<Review> reviews) { this.reviews = reviews; }
    void setInventory(Inventory inventory) { this.inventory = inventory; }

}

@ToString
class Review {
    String text;
    int rating;
    Review(String text, int rating) { this.text = text; this.rating = rating; }
}

@ToString
class Inventory {
    int quantity;
    String status;
    Inventory(int quantity, String status) {
        this.quantity = quantity; this.status = status;
    }
}

@ToString
class ProductPage{
    Product product;
    List<Product> recommendations;
    ProductPage() {}
    ProductPage(Product product, List<Product> recommendations) {
        this.product = product;
        this.recommendations = recommendations;
    }
}
