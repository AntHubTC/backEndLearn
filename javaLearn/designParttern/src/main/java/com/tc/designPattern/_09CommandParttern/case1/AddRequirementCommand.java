package com.tc.designPattern._09CommandParttern.case1;

/**
 * 增加需求的命令
 */
public class AddRequirementCommand extends Command {
    @Override
    public void execute() {
        // 找到需求组
        super.rg.find();
        // 增加一份需求
        super.rg.add();
        // 给出计划
        super.rg.plan();
    }
}
