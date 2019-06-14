package com.tc.designPattern._04TemplateParttern.case1;

// 模板类
public abstract class AbatractClass {
    // 基本方法
    public abstract void doSomething();
    // 基本方法
    public abstract void doAnything();
    // 模板方法
    public final void templateMedhod() { // 为了防止被人恶意重写，通常会加上final
        /*
            调用基本的方法，完成相关的逻辑。
         */
        this.doAnything();
        this.doSomething();
    }
}
