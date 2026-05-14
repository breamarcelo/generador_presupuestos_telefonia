package com.budgetsgenerator.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("budgets_generator");

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static void shutdown(){
        if(emf != null && emf.isOpen()){
            emf.close();
        }
    }
}
