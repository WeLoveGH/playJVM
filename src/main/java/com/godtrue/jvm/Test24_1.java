package com.godtrue.jvm;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-07
 */
public class Test24_1 {
    public static void main(String[] args) {
        ClassLoader classLoader = Test24_1.class.getClassLoader();
        System.out.println("1: classLoader = " + classLoader);
        System.out.println("2: classLoader.getParent() = " + classLoader.getParent());
        System.out.println("3: classLoader.getParent().getParent() = " + classLoader.getParent().getParent());
        System.out.println("4: classLoader.getParent().getParent().getParent() = " + classLoader.getParent().getParent().getParent());
    }
}

/*

1：类加载器，大的分类有两个，一个是JDK提供的类加载器，有三个：启动类加载器、扩展类加载器、应用类加载器，另外一类就是自定义的类加载器
2：类加载的原理遵循双亲委派机制

如日志所示，这是JDK提供的类加载器

1: classLoader = sun.misc.Launcher$AppClassLoader@18b4aac2
2: classLoader.getParent() = sun.misc.Launcher$ExtClassLoader@14ae5a5
3: classLoader.getParent().getParent() = null
Exception in thread "main" java.lang.NullPointerException
	at com.godtrue.jvm.Test24_1.main(Test24_1.java:14)

 */