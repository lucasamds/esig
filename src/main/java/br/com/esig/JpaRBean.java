package br.com.esig;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaRBean {
    //Declarado como estático, visto que será referenciado uma única vez
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory()
    {
        if(entityManagerFactory == null)
        {
            entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.esig.app");
        }
        return entityManagerFactory;
    }

}
