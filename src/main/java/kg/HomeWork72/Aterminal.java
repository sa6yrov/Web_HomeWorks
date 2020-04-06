package kg.HomeWork72;

import java.util.stream.Stream;

public class Aterminal {
    public static void main(String[] args) {
        checkMoney(getCorrectAtm());

    }

    public static String checkMoney(int[] array){
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 100) a++;
            if(array[i] == 200) b ++;
            if(array[i] == 500) c ++;
            if(array[i] == 1000) d ++;
        }
        if(a == 5 && b == 5 && c == 5 && d == 5) return "OK";
        if(a / (b + c + d) >= 2 || b / (a + c + d) >= 2 || c / (a + b + d) >= 2 || d / (a + b + c) >= 2) return "Перекос";
        if(a < 5 || b < 5 || c < 5 || d < 5) return "Мало купюр, надо пополнить";
        return "Fail";
    }

    public static int[] getCorrectAtm(){
        int[] atm = new int[20];
        for (int i = 0; i < atm.length; i++) {
            if(i < 5) atm[i] = 100;
            else if(i < 10) atm[i] = 200;
            else if(i < 15) atm[i] = 500;
            else atm[i] = 1000;
        }
        return atm;
    }

    public static int[] getIncorrectAtm(){
        int[] atm = new int[20];
        for (int i = 0; i < atm.length; i++) {
            if(i < 14) atm[i] = 100;
            else if(i < 16) atm[i] = 200;
            else if(i < 18) atm[i] = 500;
            else atm[i] = 1000;
        }
        return atm;
    }

    public static int[] getIncorrectAtm2(){
        int[] atm = new int[20];
        for (int i = 0; i < atm.length; i++) {
            if(i < 4) atm[i] = 100;
            else if(i < 10) atm[i] = 200;
            else if(i < 15) atm[i] = 500;
            else atm[i] = 1000;
        }
        return atm;
    }
}
