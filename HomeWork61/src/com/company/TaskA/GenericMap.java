package com.company.TaskA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GenericMap<T1, T2>{
    private T1 key;
    private T2 val;

    public GenericMap(T1 key, T2 val) {
        this.key = key;
        this.val = val;
    }
    public GenericMap(){}

    public static<T> T getKeyOrVal(T object){
        return object;
    }

    public T1 getKey() {
        return key;
    }

    public void setKey(T1 key) {
        this.key = key;
    }

    public T2 getVal() {
        return val;
    }

    public void setVal(T2 val) {
        this.val = val;
    }
}