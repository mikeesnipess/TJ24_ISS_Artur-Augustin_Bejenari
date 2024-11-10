package com.example.lab4_jt;

import com.example.lab4_jt.Client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class DatabaseService {

    @PersistenceContext(unitName = "Lab4PU")
    private EntityManager entityManager;

    public List<Client> getClients() {
        String sql = "SELECT c FROM Client c";
        TypedQuery<Client> query = entityManager.createQuery(sql, Client.class);
        return query.getResultList();
    }
}
