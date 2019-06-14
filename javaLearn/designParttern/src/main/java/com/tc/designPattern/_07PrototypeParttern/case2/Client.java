package com.tc.designPattern._07PrototypeParttern.case2;

// 浅拷贝测试
public class Client {
    public static void main(String[] args) {
        // 产生一个对象
        Thing thing = new Thing();
        // 设置一个值
        thing.setValue("张三");
        // 拷贝一个对象
        Thing cloneThing = thing.clone();
        cloneThing.setValue("李四");

        /*
            注意，这里打印的是thing。
            结果除了张三，为什么还有李四？
            这就是浅拷贝。新拷贝的对象cloneThing和thing都指向的同一个ArrayList。
         */
        System.out.println(thing.getValue());
    }
}
