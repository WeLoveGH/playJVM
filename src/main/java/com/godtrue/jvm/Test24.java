package com.godtrue.jvm;

/**
 * @description： 打印类的加载器
 * @author：qianyingjie1
 * @create：2019-11-07
 */
public class Test24 {
    public static void main(String[] args) {
        Test24 test24 = new Test24();
        ClassLoader classLoader = test24.getClass().getClassLoader();
        while (classLoader != null){
            System.out.println("ClassLoader is : " + classLoader);
            classLoader = classLoader.getParent();
        }
    }
}

/*

ClassLoader is : sun.misc.Launcher$AppClassLoader@18b4aac2
ClassLoader is : sun.misc.Launcher$ExtClassLoader@14ae5a5

启动类加载器是 null，因为启动类加载器，不是使用 Java 语言编写的，是使用 C/C++ 语言编写的

 */
