package com.tc.designPattern._02FactoryParttern.case4;

import java.util.HashMap;
import java.util.Map;

/**
 *  工厂方法模式扩展：延迟加载的工厂类
 */
public class ProductFactory {
    private static final Map<String, Product> productMap = new HashMap<>();

    public static synchronized Product createProduct(String type) throws Exception {
        Product product = null;
        if (productMap.containsKey(type)) {
            product = productMap.get(type);
        } else {
            if ("Product1".equals(type)) {
                product = new ProductType1();
            } else if ("Product2".equals(type)) {
                product = new ProductType2();
            }
        }
        return product;
    }
}
