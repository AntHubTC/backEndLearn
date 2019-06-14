package com.tc.designPattern.Facade.case1.module;

import com.tc.designPattern.Facade.case1.config.ConfigManager;
import com.tc.designPattern.Facade.case1.config.ConfigModel;

/**
 * 示意生成表现层的代码
 * Author:tangc
 * Date:2016/6/18
 * Time:15:04
 * DESCR:
 */
public class Presentation implements CodeGenerate {
    public void generate(){
        ConfigModel configData = ConfigManager.getInstance().getConfigData();
        if (configData.isNeedGenPresentation()){
            System.out.println("正在生成表现层代码的文件。");
            //按照要求去生成相应的代码，并保存成文件
            System.out.println("生成表现层代码的文件成功。");
        }
    }
}
