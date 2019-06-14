package com.tc.designPattern._08MediatorParttern.case1;

/*
    注意：：本例未采用中介者模式，为的是和case2对比
        可以看出 “采购管理”“库存管理”“销售管理”三者之间，每个类都与其他两个类
        产生了关联关系。迪米特法则认为“每个类只和朋友类交流”，这个朋友类并非越多越
        好，朋友类越多，耦合性越大，要想修改一个就得修改一片，这不是面向对象设计所期
        望的，况且这还是仅三个模块的情况，属于比较简单的一个小项目。
        在case2中将改善这种情况。
  */
public class Client {
    public static void main(String[] args) {
        // 采购人员采购电脑
        System.out.println("------采购人员采购电脑--------");
        Purchase purchase = new Purchase();
        purchase.buyIBMcomputer(100);
        // 销售人员销售电脑
        System.out.println("\n------销售人员销售电脑--------");
        Sale sale = new Sale();
        sale.sellIBMComputer(1);
        // 库房管理人员管理库存
        System.out.println("\n------库房管理人员清库处理--------");
        Stock stock = new Stock();
        stock.clearStock();
    }
}
