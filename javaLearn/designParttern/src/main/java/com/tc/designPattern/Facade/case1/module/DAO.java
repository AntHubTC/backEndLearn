package com.tc.designPattern.Facade.case1.module;

import com.tc.designPattern.Facade.case1.config.ConfigManager;
import com.tc.designPattern.Facade.case1.config.ConfigModel;

/**
 * 示意生成数据层的模块
 * Author:tangc
 * Date:2016/6/18
 * Time:15:32
 * DESCR:
 */
public class DAO implements CodeGenerate {
    public void generate() {
        ConfigModel configData = ConfigManager.getInstance().getConfigData();
        if (configData.isNeedGenDao()){
            System.out.println("正在生成数据层代码文件.");
            //生成数据层代码文件代码
            System.out.println("生成数据层代码文件完成.");
        }
    }
}
