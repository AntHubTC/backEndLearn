package com.tc.designPattern._02FactoryParttern.case2;

/**
 * 实现导出数据的业务功能对象
 * Author:tangc
 * Date:2016/8/9
 * Time:20:33
 * DESCR:
 */
public abstract class ExportOperate {

    /**
     * 导出文件
     * @param data
     * @return
     */
    public boolean export(String data){
        //使用工厂方法
        ExportFileApi api = factoryMethod();
        return api.export(data);
    }

    /**
     * 工厂方法，创建导出的文件对象的接口对象
     * @return 导出的文件对象的接口对象
     */
    public abstract ExportFileApi factoryMethod();
}
