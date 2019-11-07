package com.godtrue.jvm;

import java.util.Random;

/**
 * @description： 测试类的初始化，首次主动使用类才会对类进行初始化，首次使用类共有七种情况
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test6 {
    public static void main(String[] args) {
        System.out.println("A.i :" + A.i);

        System.out.println("B.i :" + B.i);

        System.out.println("C.i :" + C.i);

        System.out.println("D.i :" + D.i);
    }
}
class A {
    public static int i = 2;

    static {
        i = 100;
    }
}

class B {
    public static int i = new Random().nextInt();

    static {
        i = -1;
    }
}

/**
 * 静态常量，在编译时就知道其值，且保持不变，则会将此常量放入调用类的常量池中，则不会初始化被调用的类
 */
class C {
    public static final int i = 2;

    static {
        System.out.println("ccc");
    }
}

/**
 * 静态常量，在编译时不知道其值，则不会将此常量放入调用类的常量池中，则会初始化被调用的类
 */
class D {
    public static final int i = new Random().nextInt();

    static {
        System.out.println("ddd");
    }
}
