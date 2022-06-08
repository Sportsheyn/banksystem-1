package myproject.database;

import myproject.basic.general.Bank;
import myproject.basic.general.Bankaccount;
import myproject.basic.general.Credit;
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

    public static SessionFactory getFactory() {

        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Bank.class)
                .addAnnotatedClass(Bankaccount.class)
                .addAnnotatedClass(Credit.class)
                .buildSessionFactory();

        return factory;
    }


    public static void create(Bankaccount account) {

        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            Bank bank = session.get(Bank.class, 1);
            bank.addAccount(account);
            session.save(account);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }


    public static void update(Bankaccount account) {

        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.update(account);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }


    public static boolean delete(int accountnumber) {

        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Bankaccount accountToDelete = session.get(Bankaccount.class, accountnumber);
            session.delete(accountToDelete);

            session.getTransaction().commit();
            return true;
        }
        finally {
            session.close();
            factory.close();
        }
    }

    public static Bankaccount read(int accountnumber) {

        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Bankaccount readAccount = session.get(Bankaccount.class, accountnumber);

            session.getTransaction().commit();

            return readAccount;
        }
        finally {
            session.close();
            factory.close();
        }
    }


    public static List<Bankaccount> findAll() {

        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

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

}