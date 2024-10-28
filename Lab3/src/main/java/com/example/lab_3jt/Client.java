package com.example.lab_3jt;

public class Client {
    private String name;
    private int x;
    private int y;
    private String product;
    private String availableDays;
    private String timeInterval;

    public Client(String name, int x, int y, String product, String availableDays, String timeInterval) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.product = product;
        this.availableDays = availableDays;
        this.timeInterval = timeInterval;
    }

    // Getters and setters
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
