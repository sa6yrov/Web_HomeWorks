package com.company;

public class Main {

    public static void main(String[] args) {
//        Task A
        System.out.println(((Factorial)(num) -> {
            int sum = 1;
            for (int i = 1; i <= num; i++) {
                sum *= i;
            }
            return sum;
        }).calculateFactorial(5));

//        Task B
        System.out.println(((Root)(num, num1) ->{
            double result = 0;
            result =  Math.pow(num1, 1/num);
            return result;
        }).calculateRoot(4, 81));


    }
}
