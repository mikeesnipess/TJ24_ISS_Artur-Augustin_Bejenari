package com.example.lab_3jt;

import com.example.lab_3jt.Client;

import java.util.List;

public class VehicleRoutingService {

    public void scheduleDeliveries(List<Client> clients) {
        // In this basic example, we just print the schedule
        System.out.println("Scheduling deliveries...");
        for (Client client : clients) {
            System.out.println("Delivering " + client.getProduct() + " to " + client.getName() +
                    " at (" + client.getX() + ", " + client.getY() + "), available: " +
                    client.getAvailableDays() + ", Time: " + client.getTimeInterval());
        }
    }
}
