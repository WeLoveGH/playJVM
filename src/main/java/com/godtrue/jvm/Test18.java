package com.godtrue.jvm;

/**
 * @description： 第一次使用类的静态变量或方法时，当该类中确实存在时，才会导致该类被加载
 * @author：qianyingjie1
 * @create：2019-11-07
 */
public class Test18 {
    public static void main(String[] args) {
        System.out.println("K.i: " + K.i);
        /**
         * 访问的静态变量或静态方法没有在子类中定义，所以，不会导致子类的初始化
         */
        K.f1();
    }
}

class K {
    public static int i = 1;

    static {
        System.out.println("K init");
    }

    public static void f1(){
        System.out.println("K f1()");
    }
}

class SonOfK extends K {
    static {
        System.out.println("SonOfK init");
    }
}

/*

[Loaded com.godtrue.jvm.Test18 from file:/D:/workspace_test/playJVM/target/classes/]

[Loaded sun.launcher.LauncherHelper$FXHelper from C:\Program Files\Java\jdk1.8.0_162\jre\lib\rt.jar]
[Loaded java.lang.Class$MethodArray from C:\Program Files\Java\jdk1.8.0_162\jre\lib\rt.jar]
[Loaded java.lang.Void from C:\Program Files\Java\jdk1.8.0_162\jre\lib\rt.jar]

[Loaded com.godtrue.jvm.K from file:/D:/workspace_test/playJVM/target/classes/]

K init
K.i: 1
K f1()

 */