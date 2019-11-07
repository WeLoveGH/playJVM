package com.godtrue.jvm;

import java.util.Random;

/**
 * @description： 类的初始化
 * @author：qianyingjie1
 * @create：2019-11-07
 */
public class Test16 {
    public static void main(String[] args) {
        System.out.println("G.i: " + G.i);
        System.out.println("H.i: " + H.i);
        System.out.println("I.i: " + I.i);
    }
}

/**
 * 对类的首次使用（比如：调用类的静态变量），会导致类的初始化
 */
class G {
    public static int i = 1;

    static {
        System.out.println("     G init");
    }
}

/**
 * 对类的首次使用，如果使用的类的编译常量
 * （编译时能确定常量值的常量，会将此常量的值直接放入调用类的常量池中，此时调用类和被调用类就没有了任何关系，即使将被调用类的字节码文件删除也没事）
 * 则不会导致类的初始化
 */
class H {
    public static final int i = 2;

    static {
        System.out.println("     H init");
    }
}

/**
 * 对类的首次使用，如果使用的类的运行时常量
 * （编译时不能确定常量的值，只有在运行时才能确定）
 * 则会导致类的初始化
 */
class I {
    public static final int i = new Random().nextInt();

    static {
        System.out.println("     I init");
    }
}
