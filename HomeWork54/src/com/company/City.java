package com.company;

public class City implements Comparable{
    private String name;
    private int code;

    public City(String name, int code) {
        this.name = name;
        this.code = code;
    }



    @Override
    public String toString() {
        return "City: " + name + " | Code: " + code + "\n";
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof City)) return 0;
        City temp = (City)o;
        if(this.code > temp.code) return 1;
        else if(this.code < temp.code) return -1;
        else return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
