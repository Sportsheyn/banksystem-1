package myproject.database;

import myproject.basic.general.Bankaccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbAccount {

    public static void create(Bankaccount account) {

//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(account);
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        entityManagerFactory.close();


        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        // create session factory

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Bankaccount.class)
                .buildSessionFactory();

         //create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            session.save(account);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }

    public static List<Bankaccount> findAll() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("Select a from Bankaccount a");
        List<Bankaccount> accountList = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return accountList;
    }


    public static void main(String[] args) {
        // für Testzwecke
        Bankaccount account = new Bankaccount("Tom", "Bartel", 1234, 7778);
        DbAccount.create(account);
    }


}
