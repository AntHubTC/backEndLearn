package com.tc.designPattern._09CommandParttern.case1;

public class DeletePageCommand extends Command {
    @Override
    public void execute() {
        // 找到页面组
        super.pg.find();
        // 删除一个页面
        super.pg.delete();
        // 给出计划
        super.pg.plan();
    }
}
