package com.example.lab5_jt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.UUID;

public class ClientService {

    private EntityManager em;

    // Constructor to initialize EntityManager
    public ClientService(EntityManager em) {
        this.em = em;
    }

    public void addClient(Client client) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(client);  // Persist the client to the database
            transaction.commit();  // Commit the transaction
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback the transaction on error
            }
            e.printStackTrace();
        }
    }

    public Client findClient(UUID id) {
        return em.find(Client.class, id);  // Retrieve the client by ID
    }

    public void updateClient(Client client) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(client);  // Update the client in the database
            transaction.commit();  // Commit the transaction
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback on error
            }
            e.printStackTrace();
        }
    }

    public void deleteClient(UUID clientId) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Client client = em.find(Client.class, clientId);  // Find client by ID
            if (client != null) {
                em.remove(client);  // Remove the client from the database
            }
            transaction.commit();  // Commit the transaction
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback on error
            }
            e.printStackTrace();
        }
    }

    public Client findClientByName(String name) {
        // Assuming we have a named query or JPQL to find the client by name
        return em.createQuery("SELECT c FROM Client c WHERE c.name = :name", Client.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public List<Client> findAllClients() {
        // Return all clients from the database
        return em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }
}
