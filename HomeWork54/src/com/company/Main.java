package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] citiesName = {"Bishkek", "Talas", "Stanbul", "Karakol", "Moscow", "Osh", "Naryn", "Pilo", "Gradu", "Jeda"};
        List<City> cities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            char words = 1;
            cities.add(new City(citiesName[i], i));
        }
        Set<City> hashSetCities = new HashSet<>();
        Set<City> treeSetCities = new TreeSet<>();
        for (int i = 0; i < cities.size(); i++) {
            if(cities.get(i).getCode() % 2 == 0) hashSetCities.add(cities.get(i));
            else treeSetCities.add(cities.get(i));
        }
        System.out.println("HashSet");
        System.out.println(hashSetCities);
        System.out.println("Treeset");
        System.out.println(treeSetCities);
        deletCity(hashSetCities);
        deletCity(treeSetCities);
        System.out.println("HashSet");
        System.out.println(hashSetCities);
        System.out.println("Treeset");
        System.out.println(treeSetCities);
    }
    public static void deletCity(Set<City> cities){
        Iterator<City> cityIterator = cities.iterator();
        while(cityIterator.hasNext()){
            if(cityIterator.next().getName().length() > 5) cityIterator.remove();
        }
    }
}
