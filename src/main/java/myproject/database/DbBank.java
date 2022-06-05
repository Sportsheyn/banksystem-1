package myproject.database;

import myproject.basic.general.Bank;
import myproject.basic.general.Bankaccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DbBank {

    public static Bank create() {

        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Bank.class)
                .addAnnotatedClass(Bankaccount.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            Bank readBank = session.get(Bank.class, 1);
            if (readBank != null) {
                session.getTransaction().commit();
                System.out.println("Done!");
                return readBank;
            }

            Bank bank = new Bank();
            session.save(bank);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }

        return null;
    }


    public static Bank read() {

        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Bank.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Bank readBank = session.get(Bank.class, 1);

            // commit transaction
            session.getTransaction().commit();

            return readBank;
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
