package com.company;

import java.util.Random;

public class FootballTeam implements Runnable{
//    private int goals;
//    private int yellowCard;
//    private int inOffside;
//
//    public FootballTeam(int goals, int yellowCard, int inOffside) {
//        this.goals = goals;
//        this.yellowCard = yellowCard;
//        this.inOffside = inOffside;
//    }

    @Override
    public  void run() {
//        System.out.println(Thread.currentThread().getName() + "\n" + "Количество забитых голов: " + goals + "\n" +
//                "Желтые карточки: " + yellowCard + "\n" + "Офсайды: " + inOffside);
        synchronized (this) {
            Random rnd = new Random();
            System.out.println(Thread.currentThread().getName() + "\n" + "Количество забитых голов: " + (Main.goals + rnd.nextInt(15)) +
                    "\n" + "Желтые карточки: " + (Main.yellowCard + rnd.nextInt(15)) + "\n" + "Офсайды: " + (Main.inOffside + rnd.nextInt(15)));
        }
    }
}
