package com.tc.designPattern._02FactoryParttern.case2;

/**
 * 导出成数据库备份文件形式的对象
 * Author:tangc
 * Date:2016/8/9
 * Time:20:31
 * DESCR:
 */
public class ExportDB implements ExportFileApi {
    public boolean export(String data) {
        //这里简单示意一下，这里需要操作数据库和文件
        System.out.println("导出数据(" + data + ")到数据库备份文件");
        return true;
    }
}
