package myproject.database;

import myproject.basic.general.Bank;
import myproject.basic.general.Bankaccount;
import myproject.basic.general.Credit;
import myproject.basic.general.Credits;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DbCredits {

    public static SessionFactory getFactory() {

        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Bank.class)
                .addAnnotatedClass(Bankaccount.class)
                .addAnnotatedClass(Credits.class)
                .addAnnotatedClass(Credit.class)
                .buildSessionFactory();

        return factory;
    }

    public static void create(Credits credits) {

        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Bank bank = session.get(Bank.class, 1);
            bank.addCredits(credits);
            session.save(credits);

            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }
    }

    public static Credits read(int creditsId) {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Credits readCredit = session.get(Credits.class, creditsId);
            session.getTransaction().commit();

            return readCredit;
        }
        finally {
            session.close();
            factory.close();
        }
    }

    public static void update(Credits credits) {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.update(credits);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }

    public static void delete(Credits credits) {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.delete(credits);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }



}
