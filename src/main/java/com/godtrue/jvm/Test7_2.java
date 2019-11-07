package com.godtrue.jvm;

import java.util.Random;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test7_2 {
    static {
        System.out.println("init Test7_2");
    }

    public static void main(String[] args) {
        System.out.println("F_2.i: "+F_2.i);
    }
}

class E_2 {
    public static int i = 1;

    static {
        System.out.println("init E_2");
    }
}

class F_2 extends E_2{
    public static final int i = new Random().nextInt();

    static {
        System.out.println("init F_2");
    }
}

/*

init Test7_2
init E_2
init F_2
F_2.i: 1212178022

从打印的日志可以看到：
静态常量，如果在编译时值不能确定，则不会直接放入调用类的常量池中，被调用类会进行初始化

 */