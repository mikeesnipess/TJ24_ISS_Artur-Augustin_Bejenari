package com.example.lab6_jt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Optional;

public class ProductService {

    @PersistenceContext
    private EntityManager entityManager;

    // Method to find a product by ID
    public Optional<Product> getProductById(Long productId) {
        Product product = entityManager.find(Product.class, productId);
        return Optional.ofNullable(product);
    }

    // Method to get the stock of a product by its ID
    public int getStock(Long productId) {
        Optional<Product> product = getProductById(productId);
        return product.map(Product::getStockQuantity).orElse(0);
    }

    // Method to decrease the stock of a product by a specific quantity
    @Transactional
    public void decreaseStock(Long productId, int quantity) {
        Optional<Product> product = getProductById(productId);
        if (product.isPresent()) {
            Product p = product.get();
            int currentStock = p.getStockQuantity();
            if (currentStock >= quantity) {
                p.setStockQuantity(currentStock - quantity);
                entityManager.merge(p); // Save the updated product back to the database
            } else {
                throw new IllegalArgumentException("Not enough stock for product " + productId);
            }
        } else {
            throw new IllegalArgumentException("Product with ID " + productId + " not found");
        }
    }

    // Method to add a new product
    @Transactional
    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    // Method to update an existing product
    @Transactional
    public void updateProduct(Product product) {
        entityManager.merge(product);
    }
}
