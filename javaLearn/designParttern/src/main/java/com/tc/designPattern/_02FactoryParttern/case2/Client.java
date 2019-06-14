package com.tc.designPattern._02FactoryParttern.case2;

/**
 * 现在考虑这样一个实际应用：实现一个导出数据的应用框架，来让客户选择数据的导出方式，并真正执行数据导出。
 *
 *
 * Author:tangc
 * Date:2016/8/9
 * Time:20:44
 * DESCR:
 */
public class Client {
    public static void main(String args[]){
        //创建需要使用的Creator对象
        ExportOperate operate = new ExportDBOperate();
        //调用输出数据的功能方法
        operate.export("测试数据");
    }
}
