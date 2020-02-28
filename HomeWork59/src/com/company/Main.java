package com.company;

public class Main {
    static int num = 10;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Num: " + num);
        System.out.println("Поток умножения: " + (num *= 2));
        Thread.sleep(1000);

        Thread t2 = new Thread(new MyThread(num /= 2));
        System.out.print("Поток деления: ");
        t2.start();
        Thread.sleep(1000);

        Thread t3 = new Thread(new MyThread(num += 2));
        System.out.print("Поток прибавления: ");
        t3.start();
        Thread.sleep(1000);

        Thread t4 = new Thread(new MyThread(num -= 2));
        System.out.print("Поток вычитания: ");
        t4.start();
    }
}
class MyThread implements Runnable {
    private int num;

    public MyThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(num);

    }
}

