package com.HomeWork56;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sum")
public class ReturnSum {
    Integer sum;

    public ReturnSum(Integer sum) {
        this.sum = sum;
    }
    public ReturnSum(){}

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
