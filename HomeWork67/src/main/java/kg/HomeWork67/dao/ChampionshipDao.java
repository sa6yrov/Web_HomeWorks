package kg.HomeWork67.dao;

import kg.HomeWork67.entities.Championship;
import kg.HomeWork67.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ChampionshipDao {
    public List<Championship> getChampionships(String championshipName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Championship> championships = session.createQuery("select c from Championship c where c.championshipName = :p_chm_name")
                .setParameter("p_chm_name", championshipName).list();
        return championships;
    }
}
