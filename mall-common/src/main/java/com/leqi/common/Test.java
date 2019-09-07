package com.leqi.common;

import java.util.HashMap;

/**
 * @author lwep
 * @dareTime 2019/9/6 19:14
 */
public class Test {
    public static void main(String[] args) {
        HashMap<Object ,Object> map1 = new HashMap<>();
        map1.put(1,2);
        map1.put(1,2);
        HashMap<Object ,Object> map2 = new HashMap<>();
        map2.put(1,2);
        map2.put(1,2);
        System.out.println(map1.equals(map2));
    }
}
