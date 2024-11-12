package com.example.lab6_jt;

import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Singleton
@Startup
public class ClientOrderService {

    private final Map<UUID, List<OrderItem>> clientOrders = new HashMap<>();

    public void registerOrder(UUID clientId, List<OrderItem> orderItems) {
        clientOrders.put(clientId, orderItems);
    }

    public void printOrders() {
        clientOrders.forEach((clientId, orders) -> {
            System.out.println("Client ID: " + clientId);
            orders.forEach(order -> System.out.println(order));
        });
    }
}
