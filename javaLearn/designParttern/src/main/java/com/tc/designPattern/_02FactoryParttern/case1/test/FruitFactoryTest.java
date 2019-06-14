package com.tc.designPattern._02FactoryParttern.case1.test;

import com.tc.designPattern._02FactoryParttern.case1.bean.Fruit;
import com.tc.designPattern._02FactoryParttern.case1.factory.FruitActionInter;
import com.tc.designPattern._02FactoryParttern.case1.bean.Watermelon;
import com.tc.designPattern._02FactoryParttern.case1.factory.FruitFactory;
import com.tc.designPattern._02FactoryParttern.case1.factory.Fruits;

/**
 * 水果工厂测试(简单工厂)
 *
 * Author:tangc
 * Date:2016/6/18
 * Time:14:18
 * DESCR:
 */
public class FruitFactoryTest {
    public static void main(String args[]){
        try {
            Fruit apple = FruitFactory.createFruit(Fruits.APPLE);
            Fruit watermelon = FruitFactory.createFruit(Fruits.WATERMELON);
            FruitActionInter fai = apple;
            fai.eat();
            fai = (Watermelon)watermelon;
            fai.makeSugar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
