package kg.HomeWork67;

import kg.HomeWork67.entities.Championship;
import kg.HomeWork67.entities.Country;
import kg.HomeWork67.entities.SportType;
import kg.HomeWork67.entities.Team;
import kg.HomeWork67.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Country country1 = new Country("Kyrgyzstan");
        Country country2 = new Country("Kazakhstan");
        create(country1);
        create(country2);

        SportType sportType1 = new SportType("Football");
        SportType sportType2 = new SportType("Volleyball");

        create(sportType1);
        create(sportType2);

        Team team1 = new Team("Kazakhstan national football team", "/main/resources/logo/Kazakhstan.jpg", "http://kff.kz", sportType1);
        Team team2 = new Team("Kyrgyzstan national football Team", "/main/resources/logo/Kyrgyzstan.jpg", "http://ffkr.kg", sportType1);
        Team team3 = new Team("Kazakhstan national volleyball team", "/main/resources/logo/KazakhstanV.png", "http://kvf.kz", sportType2);
        Team team4 = new Team("Kyrgyzstan national volleyball team", "/main/resources/logo/KyrgyzV.png", "http://kkas.kg", sportType2);

        create(team1);
        create(team2);
        create(team3);
        create(team4);

        Championship championship1 = new Championship(country1, "Kazakhstan Football Championship", sportType1);
        Championship championship2 = new Championship(country2, "Kyrgyzstan Football Championship", sportType1);
        Championship championship3 = new Championship(country1, "Kazakhstan Volleyball Championship", sportType2);
        Championship championship4 = new Championship(country2, "Kyrgyzstan Volleyball Championship", sportType2);

        create(championship1);
        create(championship2);
        create(championship3);
        create(championship4);
    }


    public static <T> void create(T t){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(t);
        session.getTransaction().commit();
        session.close();
        System.out.println("Саздали запись успешно");
    }
}
