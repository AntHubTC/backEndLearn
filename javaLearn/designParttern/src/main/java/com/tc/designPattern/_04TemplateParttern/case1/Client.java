package com.tc.designPattern._04TemplateParttern.case1;

/**
 *  模板方法模式
 */
public class Client {
    public static void main(String[] args) {
        AbatractClass c1 = new ConcreteClass1();
        AbatractClass c2 = new ConcreteClass2();

        c1.templateMedhod();
        c2.templateMedhod();
    }
}
