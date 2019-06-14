package com.tc.designPattern._02FactoryParttern.case2;

/**
 * 具体的创建器实现对象，实现创建导出成数据库备份文件形式的对象
 * Author:tangc
 * Date:2016/8/9
 * Time:20:41
 * DESCR:
 */
public class ExportDBOperate extends ExportOperate {
    @Override
    public ExportFileApi factoryMethod() {
        //创建导出成数据库备份文件形式的对象
        return new ExportDB();
    }
}
