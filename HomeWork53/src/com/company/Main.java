package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        DaysOfWeek monday = new DaysOfWeek("Monday");
        DaysOfWeek tuesday = new DaysOfWeek("Tuesday");
        DaysOfWeek wednesday = new DaysOfWeek("Wednesday");
        DaysOfWeek thursday = new DaysOfWeek("Thursday");
        DaysOfWeek friday = new DaysOfWeek("Friday");
        DaysOfWeek saturday = new DaysOfWeek("Saturday");
        DaysOfWeek sunday = new DaysOfWeek("Sunday");

        DaysOfWeek[] daysOfWeeks = {monday, tuesday, wednesday, thursday, friday, saturday, sunday};

        Random rnd = new Random();
        Map<DaysOfWeek, Integer> daysOfWeekIntegerMap = new LinkedHashMap<>();
        for (int i = 0; i < 7; i++) {
            daysOfWeekIntegerMap.put(daysOfWeeks[i], rnd.nextInt(31 - 1 + 1) + 1);
        }
        System.out.println(daysOfWeekIntegerMap);
        Collection<Integer> collection = daysOfWeekIntegerMap.values();
        System.out.println(collection);
        int mondayCount = 0;
        int tuesdayCount = 0;
        int wednesdayCount = 0;
        int thursdayCount = 0;
        int fridayCount = 0;
        int saturdayCount = 0;
        int sundayCount = 0;
        for (int i = 0; i < 100; i++) {
            int result = daysOfWeekIntegerMap.get(daysOfWeeks[rnd.nextInt(7)]);
            System.out.println(result);
            if(monday.equals(getKey(daysOfWeekIntegerMap, result))) mondayCount++;
            if(tuesday.equals(getKey(daysOfWeekIntegerMap, result))) tuesdayCount++;
            if(wednesday.equals(getKey(daysOfWeekIntegerMap, result))) wednesdayCount++;
            if(thursday.equals(getKey(daysOfWeekIntegerMap, result))) thursdayCount++;
            if(friday.equals(getKey(daysOfWeekIntegerMap, result))) fridayCount++;
            if(saturday.equals(getKey(daysOfWeekIntegerMap, result))) saturdayCount++;
            if(sunday.equals(getKey(daysOfWeekIntegerMap, result))) sundayCount++;
        }
        System.out.println("Monday: " + mondayCount);
        System.out.println("Tuesday: " + tuesdayCount);
        System.out.println("Wednesday: " + wednesdayCount);
        System.out.println("Thursday: " + thursdayCount);
        System.out.println("Friday: " + fridayCount);
        System.out.println("Saturday: " + saturdayCount);
        System.out.println("Sunday: " + sundayCount);
    }


    public static DaysOfWeek getKey(Map<DaysOfWeek, Integer> daysOfWeekIntegerMap, Integer value){
        for (Map.Entry<DaysOfWeek, Integer> entry : daysOfWeekIntegerMap.entrySet()) {
            if(Objects.equals(value, entry.getValue())) return entry.getKey();
        }
        return null;
    }
}
