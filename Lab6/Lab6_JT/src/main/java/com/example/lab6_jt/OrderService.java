package com.example.lab6_jt;

import jakarta.ejb.Stateful;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OrderService {

    @Inject
    private StockService stockService;

    private Client client;
    private List<OrderItem> orderItems = new ArrayList<>();
    private double totalAmount;

    public void setClient(Client client) {
        this.client = client;
    }

    public void addProductToOrder(Long productId, int quantity, double price) {
        int availableStock = stockService.getStock(productId);
        if (availableStock >= quantity) {
            OrderItem item = new OrderItem(productId, quantity, price);
            orderItems.add(item);
            totalAmount += price * quantity;
        } else {
            throw new IllegalArgumentException("Not enough stock for product " + productId);
        }
    }

    @Transactional
    public void completeOrder() {
        for (OrderItem item : orderItems) {
            stockService.decreaseStock(item.getProductId(), item.getQuantity());
        }
        // Persist the order, associate it with the client, and store it in the database
        System.out.println("Order completed for " + client.getName());
        orderItems.clear();
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
