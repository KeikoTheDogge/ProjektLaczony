package com.example.projektjavafinal;

import org.hibernate.Session;
import jakarta.persistence.*;
import org.hibernate.Transaction;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class DatabaseSession {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private Session session;

    public void openSession() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        session = entityManager.unwrap(Session.class);

        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.SEVERE);
    }

    public Session getSession() {
        return session;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void saveObject(Object entityObject) {
        session.save(entityObject);
    }

    public void deleteObject(Object entityObject) {
        Transaction transaction = session.beginTransaction();
        session.remove(entityObject);
        transaction.commit();
    }

    public void closeSession() {
        session.close();
        entityManager.close();
        entityManagerFactory.close();
    }
}
