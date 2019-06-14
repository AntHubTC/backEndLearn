package com.tc.designPattern._02FactoryParttern.case1.bean;

import com.tc.designPattern._02FactoryParttern.case1.factory.FruitActionInter;

/**
 * Author:tangc
 * Date:2016/6/18
 * Time:14:01
 * DESCR:
 */
public class Fruit implements FruitActionInter {
    public String name;
    public String color;
    public int weight;

    @Override
    public void eat() {
        System.out.println("你吃了"+name);
    }

    @Override
    public void makeSugar() {
        System.out.println("你制作了一个"+name+"糖");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
