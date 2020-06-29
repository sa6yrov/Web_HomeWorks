package com.company;

import java.util.Random;

public class Main {
    static int goals = 0;
    static int yellowCard = 0;
    static int inOffside = 0;

    public static void main(String[] args) {
        Random rnd = new Random();
//        Thread team1 = new Thread(new FootballTeam(rnd.nextInt(15), rnd.nextInt(15), rnd.nextInt(15)), "Team 1");
//        Thread team2 = new Thread(new FootballTeam(rnd.nextInt(15), rnd.nextInt(15), rnd.nextInt(15)), "Team 2");
        Thread team1 = new Thread(new FootballTeam(), "Team 1");
        Thread team2 = new Thread(new FootballTeam(), "Team 2");
        team1.start();

        team2.start();
    }
}
