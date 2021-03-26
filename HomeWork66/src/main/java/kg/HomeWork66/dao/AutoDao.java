package kg.HomeWork66.dao;

import kg.HomeWork66.entities.Auto;
import kg.HomeWork66.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class AutoDao {
    public void create(Auto auto){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(auto);
        session.getTransaction().commit();
        session.close();
        System.out.println("Информация об авто была успешно занесена в таблицу");
    }

    public List<Auto> getAllAuto(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Auto> autos = session.createQuery("FROM Auto").list();;
        session.close();
        return autos;
    }

    public Auto findById(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Auto auto = (Auto) session.load(Auto.class, id);
        session.close();
        return auto;
    }

    public void update(Auto auto){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Auto a = (Auto) session.get(Auto.class, auto.getId());
        a.setInn(auto.getInn());
        session.getTransaction().commit();
        session.close();
        System.out.println(a + ": Успешно изменено");

    }

    public void delete(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Auto a = findById(id);
        session.delete(a);
        session.getTransaction().commit();
        session.close();
        System.out.println(a + ": успешно удалено");
    }

    public void deleteAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Auto ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Все записи из таблицы были успешно удалены");
    }
}
