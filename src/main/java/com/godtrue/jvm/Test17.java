package com.godtrue.jvm;

/**
 * @description： 先加载父类，再加载子类
 * @author：qianyingjie1
 * @create：2019-11-07
 */
public class Test17 {
    static {
        System.out.println("Test17 init");
    }

    public static void main(String[] args) {
        System.out.println("please use -XX:+TraceClassLoading");
        System.out.println(SonOfJ.i);
    }
}

class J {
    static {
        System.out.println("J init");
    }
}

class SonOfJ extends J{
    public static int i = 2;

    static {
        System.out.println("SonOfJ init");
    }
}

/*

从日志中可以看出，类加载的顺序和类初始化的顺序
1：包含主方法的类
2：先主类后子类

[Loaded com.godtrue.jvm.Test17 from file:/D:/workspace_test/playJVM/target/classes/]

[Loaded sun.launcher.LauncherHelper$FXHelper from C:\Program Files\Java\jdk1.8.0_162\jre\lib\rt.jar]
[Loaded java.lang.Class$MethodArray from C:\Program Files\Java\jdk1.8.0_162\jre\lib\rt.jar]
[Loaded java.lang.Void from C:\Program Files\Java\jdk1.8.0_162\jre\lib\rt.jar]

Test17 init

[Loaded com.godtrue.jvm.J from file:/D:/workspace_test/playJVM/target/classes/]

[Loaded com.godtrue.jvm.SonOfJ from file:/D:/workspace_test/playJVM/target/classes/]

J init

SonOfJ init

2

 */