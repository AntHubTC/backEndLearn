package com.tc.designPattern.Facade.case1.facade;

import com.tc.designPattern.Facade.case1.module.Business;
import com.tc.designPattern.Facade.case1.module.CodeGenerate;
import com.tc.designPattern.Facade.case1.module.DAO;
import com.tc.designPattern.Facade.case1.module.Presentation;

/**
 * Author:tangc
 * Date:2016/6/18
 * Time:16:35
 * DESCR:
 */
public class GenCodeFacade implements CodeGenerate{
    /**
     * 客户端需要的，一个简单的调用代码生成的功能
     */
    public void generate() {
        CodeGenerate cg = null;

        //生成持久层
        cg = new Presentation();
        cg.generate();

        //生成业务层
        cg = new Business();
        cg.generate();

        //生成dao层
        cg = new DAO();
        cg.generate();
    }
}
