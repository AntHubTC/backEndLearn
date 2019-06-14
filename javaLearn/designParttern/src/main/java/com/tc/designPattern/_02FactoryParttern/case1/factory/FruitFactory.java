package com.tc.designPattern._02FactoryParttern.case1.factory;

import com.tc.designPattern._02FactoryParttern.case1.bean.*;

/**
 * 水果工厂
 * Author:tangc
 * Date:2016/6/18
 * Time:12:05
 * DESCR:
 */
public class FruitFactory {
    private FruitFactory(){}

    public static Fruit createFruit(Fruits fruits) throws Exception{
        Fruit fruit = null;
        switch (fruits){
            case APPLE:
                fruit =  new Apple();
                break;
            case WATERMELON:
                fruit = new Watermelon();
                break;
        }
        if(null != fruit){
            System.out.println("工厂创建了一个" + fruit.getName());
        } else {
            throw new Exception("目前还不能制作这个水果!");
        }
        return fruit;
    }
}
