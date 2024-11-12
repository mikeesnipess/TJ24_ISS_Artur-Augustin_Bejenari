package com.example.lab6_jt;

import java.util.UUID;

public class MainApplication {

    private ClientOrderService clientOrderService;
    private StockService stockService;
    private OrderService orderService;

    public static void main(String[] args) {
        MainApplication app = new MainApplication();

        // Manually instantiate the services for local testing
        app.clientOrderService = new ClientOrderService();
        app.stockService = new StockService();
        app.orderService = new OrderService();

        // Initialize client and products
        Client client = new Client("Arturasdadasd", "bej@example.com", "122112233-456-7890", "456 Oak St, Springfield, IL 62702");

        // Add product and create an order
        Long productId = 101L;
        int quantity = 3;
        double price = 15.5;

        try {
            app.orderService.addProductToOrder(productId, quantity, price);
            System.out.println("Product added to the order.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Complete the order
        try {
            app.orderService.completeOrder();
            System.out.println("Order completed successfully.");
        } catch (Exception e) {
            System.err.println("Error completing order: " + e.getMessage());
        }

        // Register and print orders
        UUID clientId = client.getId();
        Order order = new Order(client, app.orderService.getOrderItems(), app.orderService.getTotalAmount());
        app.clientOrderService.registerOrder(clientId, order.getOrderItems());
        app.clientOrderService.printOrders();
    }
}
