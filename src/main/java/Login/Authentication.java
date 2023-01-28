package Login;

import entity.UsersEntity;
import jakarta.persistence.*;
import org.hibernate.Session;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Klasa Authentication zajmuje się autoryzacją user'a oraz lekarza
 */
public class Authentication {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    private final Session session;

    public Authentication() {
        // Komendy do usunięcia niepotrzebnych logów z konsoli
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.SEVERE);

        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        session = entityManager.unwrap(Session.class);
    }

    public UsersEntity authenticate(String login, String password) throws NoResultException {
        Query query = session.createNamedQuery("loginUser", UsersEntity.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        UsersEntity user = (UsersEntity) query.getSingleResult();
        return user;
    }

}
