package com.example.lab6_jt;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems;

    private double totalAmount;

    // Default constructor
    public Order() {}

    // Constructor with parameters
    public Order(Client client, List<OrderItem> orderItems, double totalAmount) {
        this.client = client;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
    }

    // Getters and setters for the properties
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
