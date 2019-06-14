package com.tc.designPattern._02FactoryParttern.case2;

/**
 * Author:tangc
 * Date:2016/8/9
 * Time:20:27
 * DESCR:
 */
public interface ExportFileApi {
    /**
     * 导出数据
     * @param data
     * @return
     */
    public boolean export(String data);
}
