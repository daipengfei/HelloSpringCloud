package com.hello.spring.reflection;

import java.util.ArrayList;

/**
 * Created by daipengfei
 * on 2017/7/18.
 */
public class Size {
    private int x;
    private int y;
    private int z;
//    private S s = new S();
//    private int w;
//    private String s;

    public static void main(String [] args) throws IllegalAccessException {
        System.out.println(ObjectSizeFetcher.fullSizeOf(new S()));
        ClassIntrospector classIntrospector = new ClassIntrospector();
        long deepSize = classIntrospector.introspect(new S()).getDeepSize();
        System.out.println(deepSize);
    }

    private static class S{
       private char[] x = new char[0];
       private int y;
    }

}
