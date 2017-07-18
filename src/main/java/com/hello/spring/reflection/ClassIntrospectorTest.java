package com.hello.spring.reflection;

/**
 * Created by daipengfei
 * on 2017/7/18.
 */
public class ClassIntrospectorTest {
    public static void main(String[] args) throws IllegalAccessException {
        final ClassIntrospector ci = new ClassIntrospector();
        System.out.println(ci.introspect(new String()).getDeepSize());
    }

    private static class ObjectA {
        String str ;  // 4
        int i1; // 4
        byte b1; // 1
        byte b2; // 1
        int i2;  // 4
        ObjectB obj; //4
        byte b3;  // 1
    }

    private static class ObjectB {

    }

    private static class ObjectC {
        ObjectD[] array = new ObjectD[2];
    }

    private static class ObjectD {
        int value;
    }
}
