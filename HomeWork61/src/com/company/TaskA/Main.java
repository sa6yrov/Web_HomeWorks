package com.company.TaskA;


import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        GenericMap<Integer, String> generic = new GenericMap<>();
        generic.setKey(1);
        generic.setVal("Salam");
        System.out.println(GenericMap.getKeyOrVal(generic.getVal()));

    }
}
