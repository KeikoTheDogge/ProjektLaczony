package com.example.projektjavafinal;

import entity.DoctorsEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.hibernate.Session;

import javax.xml.crypto.Data;
import java.util.List;

public class showDocSpec{

   final private DatabaseSession databaseSession;

   public showDocSpec(DatabaseSession databaseSession) {
      this.databaseSession = databaseSession;
   }

   public List<DoctorsEntity> specDoctor(String specialization) {
      EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
      EntityManager entityManager = entityManagerFactory.createEntityManager();

      Query query = databaseSession.getSession().createNamedQuery("docSpec",DoctorsEntity.class);
      query.setParameter("specialization", specialization);
      return (List<DoctorsEntity>) query.getResultList();
   }

}

