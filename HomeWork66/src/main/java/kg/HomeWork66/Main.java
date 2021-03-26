package kg.HomeWork66;

import kg.HomeWork66.dao.AutoDao;
import kg.HomeWork66.entities.Auto;

public class Main {
    public static void main(String[] args) {
        AutoDao autoDao = new AutoDao();

        autoDao.deleteAll();
        for (int i = 0; i < 10; i++) {
            autoDao.create(new Auto(i + 1, "Auto"+(i + 1)));
        }
        autoDao.getAllAuto().stream().forEach(x -> System.out.println(x));

        System.out.println(autoDao.findById(1));

        autoDao.update(new Auto(1, "inn01"));

        autoDao.delete(1);


    }
}
