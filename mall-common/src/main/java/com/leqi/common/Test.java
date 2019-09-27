package com.leqi.common;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author lwep
 * @dareTime 2019/9/6 19:14
 */
public class Test {
    //static int x=10;
    //static { x+=5;}

    public static void main(String args[]) {
        int array[] = {1, 1, 2, 3, 3, 3, 4, 5, 5, 6, 6, 8};
 
        TreeSet<Integer> tree = new TreeSet<>();

        for(int i = 0;i<array.length;i++){
            tree.add(array[i]);
        }
             System.out.println(tree);
    }


}
