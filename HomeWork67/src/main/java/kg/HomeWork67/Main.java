package kg.HomeWork67;

import kg.HomeWork67.dao.ChampionshipDao;
import kg.HomeWork67.dao.TeamDao;
import kg.HomeWork67.entities.Championship;
import kg.HomeWork67.entities.Country;
import kg.HomeWork67.entities.SportType;
import kg.HomeWork67.entities.Team;
import kg.HomeWork67.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Country country1 = new Country("Spain");
        Country country2 = new Country("Italy");
        create(country1);
        create(country2);

        SportType sportType1 = new SportType("Football");
        SportType sportType2 = new SportType("Volleyball");

        create(sportType1);
        create(sportType2);

        Championship spanishChampionshipF = new Championship(country1, "Football Championship of Spain", sportType1);
        Championship italianChampionshipF = new Championship(country2, "Football Championship of Italy", sportType1);
        Championship italianChampionshipV = new Championship(country2, "Volleyball Championship of Italy", sportType2);


        create(spanishChampionshipF);
        create(italianChampionshipF);
        create(italianChampionshipV);

        Team team1 = new Team("Barcelona", "/main/resources/logo/Kazakhstan.jpg", "https://www.fcbarcelona.com/", sportType1);
        Team team2 = new Team("Real Madrid", "/main/resources/logo/Kyrgyzstan.jpg", "https://www.realmadrid.com/", sportType1);
        Team team3 = new Team("Atletico Madrid", "/main/resources/logo/KazakhstanV.png", "https://www.atleticodemadrid.com/", sportType1);
        Team team4 = new Team("Juventus", "/main/resources/logo/KyrgyzV.png", "http://www.juventus.com/", sportType1);
        Team team5 = new Team("Pallavolo Molfetta", "/main/resources/logo/KazakhstanV.png", "http://www.pallavolomolfetta.it/", sportType2 );

        List<Championship> championshipsForSpanishTeamsF = new ArrayList<>();
        championshipsForSpanishTeamsF.add(spanishChampionshipF);
        team1.setChampionships(championshipsForSpanishTeamsF);
        team2.setChampionships(championshipsForSpanishTeamsF);
        team3.setChampionships(championshipsForSpanishTeamsF);

        List<Championship> championshipsForItalianTeamsF = new ArrayList<>();
        championshipsForItalianTeamsF.add(italianChampionshipF);
        team4.setChampionships(championshipsForItalianTeamsF);

        List<Championship> championshipsForItalianTeamsV = new ArrayList<>();
        championshipsForItalianTeamsV.add(italianChampionshipV);
        team5.setChampionships(championshipsForItalianTeamsV);

        create(team1);
        create(team2);
        create(team3);
        create(team4);
        create(team5);

        ChampionshipDao championshipDao = new ChampionshipDao();
        System.out.println(championshipDao.getChampionships(italianChampionshipF.getChampionshipName()).get(0).getCountry().getName());
        System.out.println(championshipDao.getChampionships(italianChampionshipF.getChampionshipName()).get(0).getSportType().getType());
        for (Team t : championshipDao.getChampionships(italianChampionshipF.getChampionshipName()).get(0).getTeams()) {
            System.out.println(t.getName());
        }
        System.err.println("-----------------------Stream---------------------");
        List<Championship> championships = championshipDao.getChampionships(italianChampionshipF.getChampionshipName());
        championships.stream().map(
                x -> x.getCountry().getName() + " | " + x.getSportType().getType() + " | "
                        + x.getTeams().stream().map(n -> n.getName())).forEach(x -> System.out.println(x));

    }


    public static <T> void create(T t){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(t);
        session.getTransaction().commit();
        session.close();
        System.out.println("Создали запись успешно");
    }
}
