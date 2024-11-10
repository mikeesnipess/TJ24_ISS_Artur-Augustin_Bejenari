package com.example.lab5_jt;


import com.example.lab5_jt.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class ClientService {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

    public void addClient(String name, String email) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Client client = new Client(name, email);
        em.persist(client);
        em.getTransaction().commit();
        em.close();
    }

    public Client findClient(Long id) {
        EntityManager em = emf.createEntityManager();
        Client client = em.find(Client.class, id);
        em.close();
        return client;
    }
}
