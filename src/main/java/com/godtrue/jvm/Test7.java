package com.godtrue.jvm;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test7 {
    static {
        System.out.println("init Test7");
    }

    public static void main(String[] args) {
        System.out.println("F.i: "+F.i);
    }
}

class E {
    public static int i = 1;

    static {
        System.out.println("init E");
    }
}

class F extends E{
    public static int i = 2;

    static {
        System.out.println("init F");
    }
}

/*

init Test7
init E
init F
F.i: 2

从打印的日志可以看到：
1：含有主函数的类是主动使用类，会进行初始化
2：使用某个类的静态属性也是主动使用类，会进行初始化
3：初始化子类之前，会先初始化父类

 */