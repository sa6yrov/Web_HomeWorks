package kg.HomeWork67.dao;

import kg.HomeWork67.entities.Team;
import kg.HomeWork67.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class TeamDao {
    public List<Team> getAllTeamInItalianChamp(String championship){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Team> teams = session.createQuery("select t from Team t where t.getChampionships.get(0).getChampionshipName = :p_chm_name")
                .setParameter("p_chm_name", championship).list();
        session.close();
        System.out.println("Найдено " + teams.size() + "команд");
        return teams;
    }
}
