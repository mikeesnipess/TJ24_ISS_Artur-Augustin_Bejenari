package com.example.lab_3jt;

import com.example.lab_3jt.Client;
import com.example.lab_3jt.VehicleRoutingService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ClientBean implements Serializable {
    private List<Client> clients = new ArrayList<>();
    private VehicleRoutingService routingService = new VehicleRoutingService();

    private String name;
    private int x;
    private int y;
    private String product;
    private String availableDays;
    private String timeInterval;

    public void addClient() {
        Client newClient = new Client(name, x, y, product, availableDays, timeInterval);
        clients.add(newClient);
        clearForm();
    }

    public void generateSchedule() {
        routingService.scheduleDeliveries(clients);
    }

    private void clearForm() {
        name = "";
        x = 0;
        y = 0;
        product = "";
        availableDays = "";
        timeInterval = "";
    }

    // Getters and Setters for form fields and client list
    public List<Client> getClients() { return clients; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }

    public String getAvailableDays() { return availableDays; }
    public void setAvailableDays(String availableDays) { this.availableDays = availableDays; }

    public String getTimeInterval() { return timeInterval; }
    public void setTimeInterval(String timeInterval) { this.timeInterval = timeInterval; }
}
