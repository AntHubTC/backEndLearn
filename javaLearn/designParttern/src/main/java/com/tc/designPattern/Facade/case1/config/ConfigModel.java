package com.tc.designPattern.Facade.case1.config;

/**
 * 示意配置描述的数据Model，真实的配置数据会很多
 * Author:tangc
 * Date:2016/6/18
 * Time:14:55
 * DESCR:
 */
public class ConfigModel {
    /**
     * 是否需要生成表现层，默认true
     */
    private boolean needGenPresentation = true;
    /**
     * 是否需要生成逻辑层，默认true
     */
    private boolean needGenBusiness = true;
    /**
     * 是否需要生成dao，默认true
     */
    private boolean needGenDao = true;

    public boolean isNeedGenPresentation() {
        return needGenPresentation;
    }

    public void setNeedGenPresentation(boolean needGenPresentation) {
        this.needGenPresentation = needGenPresentation;
    }

    public boolean isNeedGenBusiness() {
        return needGenBusiness;
    }

    public void setNeedGenBusiness(boolean needGenBusiness) {
        this.needGenBusiness = needGenBusiness;
    }

    public boolean isNeedGenDao() {
        return needGenDao;
    }

    public void setNeedGenDao(boolean needGenDao) {
        this.needGenDao = needGenDao;
    }
}
