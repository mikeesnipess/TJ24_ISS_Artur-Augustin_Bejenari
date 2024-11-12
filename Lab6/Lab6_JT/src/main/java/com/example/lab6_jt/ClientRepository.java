package com.example.lab6_jt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public class ClientRepository {

    private EntityManager entityManager;

    public void setEntityManager(EntityManager em) {
        this.entityManager = em;
    }

    @Transactional
    public void addClient(Client client) {
        // Check if a client with the same email already exists
        Client existingClient = findClientByEmail(client.getEmail());
            // If no client with the same email exists, proceed with insert
            entityManager.persist(client);
    }

    public Client findClient(UUID id) {
        return entityManager.find(Client.class, id);
    }

    public List<Client> findAllClients() {
        return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }

    public Client findClientByEmail(String email) {
        return entityManager.createQuery("SELECT c FROM Client c WHERE c.email = :email", Client.class)
                .setParameter("email", email)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    public Client findClientByName(String name) {
        try {
            return entityManager.createQuery("SELECT c FROM Client c WHERE c.name = :name", Client.class)
                    .setParameter("name", name)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // or handle accordingly if no result is found
        }
    }


    @Transactional
    public void updateClient(Client client) {
        entityManager.merge(client);
    }

    @Transactional
    public void deleteClient(UUID id) {
        Client client = findClient(id);
        if (client != null) {
            entityManager.remove(client);
        }
    }
}
