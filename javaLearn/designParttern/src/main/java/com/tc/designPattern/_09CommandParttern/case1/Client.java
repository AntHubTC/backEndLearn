package com.tc.designPattern._09CommandParttern.case1;

public class Client {
    public static void main(String[] args) {
        // 定义我们的接头人
        Invoker xiaosan = new Invoker();
        // 客户要求增加一项需求
        System.out.println("--------------客户增加一项需求--------------");
        // 客户给我们下命令
        Command command = new AddRequirementCommand();
        // 接头人收到命令
        xiaosan.setCommand(command);
        // 接头人执行命令
        xiaosan.action();
        System.out.println("-----------过了几天后----------------");
        System.out.println("--------------客户增又加一项需求--------------");
        // 客户给我们下命令
        command = new DeletePageCommand();
        // 接头人收到命令
        xiaosan.setCommand(command);
        // 接头人执行命令
        xiaosan.action();
    }
}
