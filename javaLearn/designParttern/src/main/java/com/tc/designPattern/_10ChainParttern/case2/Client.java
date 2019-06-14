package com.tc.designPattern._10ChainParttern.case2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 此case1没有用责任链模式
 * 这段
 代码有以下几个问题：
 ● 职责界定不清晰
 对女儿提出的请示，应该在父亲类中做出决定，父亲有责任、有义务处理女儿的请示，
 因此Father类应该是知道女儿的请求自己处理，而不是在Client类中进行组装出来，也就是说
 原本应该是父亲这个类做的事情抛给了其他类进行处理，不应该是这样的。
 ● 代码臃肿
 我们在Client类中写了if...else的判断条件，而且能随着能处理该类型的请示人员越
 多，if...else的判断就越多，想想看，臃肿的条件判断还怎么有可读性？！
 ● 耦合过重
 这是什么意思呢，我们要根据Women的type来决定使用IHandler的那个实现类来处理请
 求。有一个问题是：如果IHandler的实现类继续扩展怎么办？修改Client类？与开闭原则违背
 了！
 ● 异常情况欠考虑
 妻子只能向丈夫请示吗？如果妻子（比如一个现代女性穿越到古代了，不懂什么“三从
 四德”）向自己的父亲请示了，父亲应该做何处理？我们的程序上可没有体现出来，逻辑失
 败了！
 */
public class Client {
    public static void main(String[] args) {
        // 随机挑选几个女性
        Random rnd = new Random();
        List<IWomen> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(new Women(rnd.nextInt(4), "我要出去逛街"));
        }

        /*
            在实际应用中，一般会有一个封装类对责任模式进行封装，也就是替代Client类，直接
返回链中的第一个处理者，具体链的设置不需要高层次模块关系，这样，更简化了高层次模
块的调用，减少模块间的耦合，提高系统的灵活性
         */
        // 定义三个请示对象
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();

        father.setNext(husband);
        husband.setNext(son);

        for (IWomen women : arrayList) {
            father.handleMessage(women);
        }
    }
}
