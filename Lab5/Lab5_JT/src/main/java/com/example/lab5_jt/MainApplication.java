package com.example.lab5_jt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainApplication {

    public static void main(String[] args) {
        // Set up the EntityManagerFactory and EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        // Create a new client instance
        Client client = new Client("Arturasdadasd", "bej@example.com", "122112233-456-7890", "456 Oak St, Springfield, IL 62702");

        // Initialize the ClientService with the EntityManager
        ClientService clientService = new ClientService(em);

        // Persist the client
        clientService.addClient(client);  // This will persist the client with auto-generated UUID

        // Close the EntityManager and EntityManagerFactory
        em.close();
        emf.close();
    }
}
