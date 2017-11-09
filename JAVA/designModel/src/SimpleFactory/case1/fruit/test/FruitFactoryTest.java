package SimpleFactory.case1.fruit.test;

import SimpleFactory.case1.fruit.bean.Fruit;
import SimpleFactory.case1.fruit.bean.FruitActionInter;
import SimpleFactory.case1.fruit.bean.Watermelon;
import SimpleFactory.case1.fruit.factory.FruitFactory;
import SimpleFactory.case1.fruit.factory.Fruits;

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
