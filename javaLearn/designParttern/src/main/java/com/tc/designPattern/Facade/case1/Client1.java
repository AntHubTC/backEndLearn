package com.tc.designPattern.Facade.case1;

import com.tc.designPattern.Facade.case1.module.Business;
import com.tc.designPattern.Facade.case1.module.CodeGenerate;
import com.tc.designPattern.Facade.case1.module.DAO;
import com.tc.designPattern.Facade.case1.module.Presentation;

/**
 * 没有使用外观模式
 * Author:tangc
 * Date:2016/6/18
 * Time:15:34
 * DESCR:
 */
public class Client1 {
    public static void main(String args[]){
        //现在没有配置文件，直接使用默认的配置，通常情况下，三层都应该生成
        //也就是说客户端必须对这些模块都有了解，才能够正确使用它们
        CodeGenerate cg = new Presentation();
        cg.generate();
        cg = new Business();
        cg.generate();
        cg = new DAO();
        cg.generate();

        /*
        仔细查看上面的实现，会发现其中有一个问题：那就是客户端为了使用生成代码的功能，需要与生成代码子系统内部的多个模块交互。
这个对于客户端而言，是个麻烦，使得客户端不能简单地使用生成代码的功能。而且，如果其中的某个模块发生了变化，还可能会引起客户端也要随着变化。
那么如果实现，才能让子系统外部的客户端在使用子系统的时候，既能简单地使用这些子系统内部的模块功能，而又不用客户端去子系统内部的多个模块交互呢？
         */
    }
}
