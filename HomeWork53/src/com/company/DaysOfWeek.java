package com.company;

public class DaysOfWeek {
    private String name;

    public DaysOfWeek(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return 1;
    }

}
