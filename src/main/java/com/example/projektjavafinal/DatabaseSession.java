package com.example.projektjavafinal;

import org.hibernate.Session;
import jakarta.persistence.*;


public class DatabaseSession {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private Session session;

    public void openSession() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        session = entityManager.unwrap(Session.class);
    }

    public void saveObject(Object entityObject) {
        session.save(entityObject);
    }

    public void closeSession() {
        session.close();
        entityManager.close();
        entityManagerFactory.close();
    }
}
