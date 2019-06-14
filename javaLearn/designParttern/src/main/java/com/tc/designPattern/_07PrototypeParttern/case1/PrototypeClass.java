package com.tc.designPattern._07PrototypeParttern.case1;

import java.io.Serializable;

// 原型类
public class PrototypeClass implements Serializable,Cloneable { // 实现JDK提供的Cloneable类，表示该类是原型可以复制的
    public String prop = "";
    public String getProp() {
        return prop;
    }
    public void setProp(String prop) {
        this.prop = prop;
    }

    // 覆写父类Object的clone方法
    @Override
    protected PrototypeClass clone(){
        PrototypeClass prototypeObj = null;
        try {
            prototypeObj = (PrototypeClass) super.clone();
            // 这是浅拷贝。如果要深拷贝，该类中如果还有其他自定义类的属性，要对该属性.clone然后设置到这个原型对象上。
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototypeObj;
    }
}
