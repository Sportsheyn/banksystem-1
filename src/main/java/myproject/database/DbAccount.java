package myproject.database;

import myproject.basic.general.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DbAccount {

    public static void create(Account account) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

//
//        // create session factory
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Account.class)
//                .buildSessionFactory();
//
//        // create session
//        Session session = factory.getCurrentSession();
//
//        try {
//
//            // start a transaction
//            session.beginTransaction();
//
//            session.save(account);
//
//            // commit transaction
//            session.getTransaction().commit();
//
//            System.out.println("Done!");
//        }
//        finally {
//            factory.close();
//        }

    }

    public static void read() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("Select a from Account a");
        List<Account> liste = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println(liste.size());
    }

    public static void main(String[] args) {
        DbAccount.read();
    }


}
