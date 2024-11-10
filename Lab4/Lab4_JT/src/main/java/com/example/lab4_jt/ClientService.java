package com.example.lab4_jt;

import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import javax.sql.DataSource;
import java.util.List;

public class ClientService {

    @Resource(lookup = "jdbc/jndiDataSource")
    private DataSource dataSource;

    @PersistenceContext(unitName = "Lab4PU")
    private EntityManager entityManager;

    @Transactional
    public List<Client> getAllClients() {
        return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }
}
