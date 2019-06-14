package com.tc.designPattern._05BuilderParttern.case2;

/**
 * 小Tip： 代码是让人看的，不是写完就完事了，我一直在教育我带的团队成员，Java程
 * 序不是像我们前辈写二进制代码、汇编一样，写完基本就自己能看懂，别人看就跟看天
 * 书一样，现在的高级语言，要像写中文汉字一样，你写的，别人能看懂。
 */
public class Client {
    public static void main(String[] args) {
        Director director = new Director();
        BenzModel aBenzModel = director.getABenzModel();
        aBenzModel.run();
        System.out.println("===================");
        BenzModel bBenzModel = director.getBBenzModel();
        bBenzModel.run();
        System.out.println("===================");
        BMWModel cbmwModel = director.getCBMWModel();
        cbmwModel.run();
        System.out.println("===================");
        BMWModel dbmwModel = director.getDBMWModel();
        dbmwModel.run();
        System.out.println("===================");
    }
}
