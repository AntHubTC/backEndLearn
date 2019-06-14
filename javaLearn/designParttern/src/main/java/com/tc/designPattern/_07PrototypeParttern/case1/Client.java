package com.tc.designPattern._07PrototypeParttern.case1;

// 原型模式
public class Client {

    public static final long test1 () {
        System.out.println("=====test1开始=====");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50000000; i++) {
            PrototypeClass cloneObj = new PrototypeClass();
            cloneObj.setProp(String.valueOf(i));
            String prop = cloneObj.getProp();
            // do something
        }
        long end = System.currentTimeMillis();
        long total = end - start;
        System.out.println("=====test1结束=====");
        System.out.println("耗时"+ total);
        return total;
    }

    public static final long test2 () {
        PrototypeClass prototypeObj = new PrototypeClass();
        System.out.println("=====test2开始=====");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50000000; i++) {
            PrototypeClass cloneObj = prototypeObj.clone();
            cloneObj.setProp(String.valueOf(i));
            String prop = cloneObj.getProp();
            // do something
        }
        long end = System.currentTimeMillis();
        long total = end - start;
        System.out.println("=====test2结束=====");
        System.out.println("耗时"+ total);
        return total;
    }

    public static void main(String[] args) {
        int len = 5;
        long total1 = 0;
        long total2 = 0;
        for (int i = 0; i < len; i++) {
            total1 += test1();
            total2 += test2();
        }
        System.out.println("test1平均耗时:" + (total1/len));
        System.out.println("test2平均耗时:" + (total2/len));
        /*
            test1平均耗时:1991
            test2平均耗时:2325
         */
        /**
         * 注意：：按照<<设计模式之禅>>中所说的实现了Cloneable的原型模式类通过克隆会比
         * 一般类创建快，但是实际证明反而比直接new慢，这有可能现在的虚拟机已经优化了，
         * 当时该书作者当时那版虚拟机结果不一样。
         */
    }
}
