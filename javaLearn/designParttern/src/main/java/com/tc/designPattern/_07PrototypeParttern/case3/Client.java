package com.tc.designPattern._07PrototypeParttern.case3;

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
            深拷贝后，arrayList分别是一块空间。
         */
        System.out.println(thing.getValue());
        System.out.println(cloneThing.getValue());
    }
}
