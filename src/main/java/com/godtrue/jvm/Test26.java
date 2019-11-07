package com.godtrue.jvm;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-07
 */
public class Test26 {
    public static void main(String[] args) throws Exception{
        Class  klass = Class.forName("java.lang.String");
        System.out.println(klass.getClassLoader());

        klass = Class.forName("com.godtrue.jvm.Test26");
        System.out.println(klass.getClassLoader());
    }
}

/*

null —— 根类记载器不允许外界获取，根类加载器没有父加载器，不继承ClassLoader类，该类有C++语言编写非java编写
sun.misc.Launcher$AppClassLoader@18b4aac2 —— 应用类加载器

 */