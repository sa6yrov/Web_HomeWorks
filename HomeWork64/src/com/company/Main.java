package com.company;

import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(i + 1, "Value" + (i + 1));
        }
        Set<Integer> keys = hashMap.keySet();
//        System.out.println(keys);

        //1
        keys.stream().filter(x -> x > 5).forEach(x -> System.out.print(hashMap.get(x) + " "));
        System.out.println();

//        keys.stream().filter(x -> x % 3 == 0).forEach(x -> System.out.print(hashMap.get(x) + ", "));
//        System.out.println();
        //2
        Stream<HashMap.Entry<Integer, String>> stream1 = hashMap.entrySet().stream();
        Optional<String> optional1 = stream1.filter(x -> x.getKey() % 3 == 0).map(x -> x.getValue()).reduce((value, combined) -> value + ", " + combined);
        System.out.println(optional1.get());

        //3
        Stream<HashMap.Entry<Integer, String>> stream2 = hashMap.entrySet().stream();
        Optional<Integer> optional2 = stream2.filter(x -> x.getValue().length() > 5).map(x -> x.getKey()).reduce((value, combined) -> value * combined);
        System.out.println(optional2.get());

    }

}
