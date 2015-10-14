package centreIT.DAO;

import centreIT.HibernateUtil;
import centreIT.WeatherObject;
import org.hibernate.Session;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherDAO {

    public static void add(WeatherObject weatherObject){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(weatherObject);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static List getAll(){
        Session session = null;
        List weathers = new ArrayList<WeatherObject>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            weathers = session.createCriteria(WeatherObject.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return weathers;
    }
}
