package com.godtrue.jvm;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test7_1 {
    static {
        System.out.println("init Test7_1");
    }

    public static void main(String[] args) {
        System.out.println("F_1.i: "+F_1.i);
    }
}

class E_1 {
    public static int i = 1;

    static {
        System.out.println("init E_1");
    }
}

class F_1 extends E_1{
    public static final int i = 2;

    static {
        System.out.println("init F_1");
    }
}

/*

init Test7_1
F_1.i: 2

从打印的日志可以看到：
静态常量，如果在编译时值能确定，则会直接放入调用类的常量池中，被调用类好像不存在一样，不会进行初始化

 */