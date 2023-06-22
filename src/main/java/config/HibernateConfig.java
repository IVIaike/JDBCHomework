package config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateConfig {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        }
        return entityManagerFactory.createEntityManager();
    }
}
