package com.godtrue.jvm;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-07
 */
public class Test25 {
    public static void main(String[] args) throws Exception{
        /**
         * 获取系统加载器，系统加载器又叫应用加载器
         */
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        /**
         * 加载某一个类，参数是类的全路径名
         * 类加载就是将 .class 文件从硬盘上加载到内存中，并生成该类的的Class对象，这里仅是加载而已，并不会对类进行初始化
         */
        Class<O> oClass = (Class<O>)classLoader.loadClass("com.godtrue.jvm.O");

        O o = oClass.newInstance();
        System.out.println("o is : " + o);
        System.out.println("classLoader is : " + classLoader);

        Class<O> oClass2 = (Class<O>)Class.forName("com.godtrue.jvm.O");
        O o2= oClass2.newInstance();
        System.out.println("o2 is : " + o2);
    }
}

class O {
    static {
        System.out.println("O init");
    }
}

/*

O init
o is : com.godtrue.jvm.O@14ae5a5
classLoader is : sun.misc.Launcher$AppClassLoader@18b4aac2
o2 is : com.godtrue.jvm.O@7f31245a

 */