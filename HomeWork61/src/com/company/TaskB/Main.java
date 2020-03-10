package com.company.TaskB;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Array");
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(2);
        summationNums(integerArrayList);

        ArrayList<Double> doubleArrayList = new ArrayList<>();
        doubleArrayList.add(1.3);
        doubleArrayList.add(2.0);
        summationNums(doubleArrayList);

        ArrayList<Float> floatArrayList = new ArrayList<>();
        floatArrayList.add(1.3f);
        floatArrayList.add(1.2f);
        summationNums(floatArrayList);
        System.out.println("Linked");
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.add(1);
        integerLinkedList.add(5);
        summationNums(integerLinkedList);

        LinkedList<Double> doubleLinkedList = new LinkedList<>();
        doubleLinkedList.add(1.2);
        doubleLinkedList.add(1.39);
        summationNums(doubleLinkedList);
        System.out.println("Set");
        HashSet<Integer> integerHashSet = new HashSet<>();
        integerHashSet.add(1);
        integerHashSet.add(9);
        summationNums(integerHashSet);

        System.out.println("Average");
        Integer[] ints = {1,2,4,6};
        System.out.println(averageSum(ints));

        Double[] doubles = {1.3, 2.4, 5.3};
        System.out.println(averageSum(doubles));

        Float[] floats = {1.3f, 1.2f, 1.9f};
        System.out.println(averageSum(floats));
    }
    public static void summationNums(Collection<? extends Number> numbers){
        Number sum = 0;
        for (Number n : numbers) {
            sum = sum.doubleValue() + n.doubleValue();
        }
        System.out.println(sum);
    }
    public static <T extends Number> double averageSum(T[] array){
        double sum = 0;
        for (T t: array) {
            sum += t.doubleValue();
        }
        return sum / array.length;
    }
}
