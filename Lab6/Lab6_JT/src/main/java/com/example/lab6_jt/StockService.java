package com.example.lab6_jt;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Stateless
public class StockService {

    @PersistenceContext
    private EntityManager entityManager;

    // Get current stock for a product
    public int getStock(Long productId) {
        Product product = entityManager.find(Product.class, productId);
        return product != null ? product.getStockQuantity() : 0;
    }

    // Decrease stock after order
    @Transactional
    public void decreaseStock(Long productId, int quantity) {
        Product product = entityManager.find(Product.class, productId);
        if (product != null && product.getStockQuantity() >= quantity) {
            product.setStockQuantity(product.getStockQuantity() - quantity);
            entityManager.merge(product);
        } else {
            throw new IllegalArgumentException("Not enough stock for product " + productId);
        }
    }
}
