package myproject.database;

import myproject.basic.general.Account;

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

    public static List<Account> findAll() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("Select a from Account a");
        List<Account> accountList = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return accountList;
    }


    public static void main(String[] args) {
        // für Testzwecke
        Account account = new Account("Tom", "Bartel", 1234, 7777);
        DbAccount.create(account);
    }


}
