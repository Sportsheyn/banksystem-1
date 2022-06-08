package myproject.database;

import myproject.basic.general.Bank;
import myproject.basic.general.Bankaccount;
import myproject.basic.general.Credit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DbCredit {

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

    public static Credit read(int creditid) {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Credit readCredit = session.get(Credit.class, creditid);

            session.getTransaction().commit();

            return readCredit;
        }
        finally {
            session.close();
            factory.close();
        }
    }

    public static void update(Credit credit) {

        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            //Bank bank = session.get(Bank.class, 1);
            //credit.setBank(bank);

            session.update(credit);

            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }
    }

}
