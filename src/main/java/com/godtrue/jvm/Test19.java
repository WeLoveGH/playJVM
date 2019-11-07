package com.godtrue.jvm;

import java.lang.ref.SoftReference;

/**
 * @description： 软引用
 * @author：qianyingjie1
 * @create：2019-11-07
 */
public class Test19 {
    private int i;

    private String name;

    public Test19(int i,String name){
        super();
        this.i = i;
        this.name = name;
    }

    public Test19(){
        super();
    }

    public String toString(){
        return "Test [i="+i+",name="+name+"}";
    }

    public static void main(String[] args) {
        /**
         * test19 是强引用
         */
        Test19 test19 = new Test19(1,"godtrue");

        /**
         * softReference 是软引用
         */
        SoftReference<Test19> softReference = new SoftReference<Test19>(test19);

        test19 = null;

        System.out.println("1: "+softReference.get());

        System.gc();

        System.out.println("after GC");

        System.out.println("2: "+ softReference.get());

        /**
         * 强引用坚决不回收，哪怕引起了内存溢出，导致JVM不能运行
         */
        byte[] bytes = new byte[100 * 1024 * 1024];

        System.gc();

        /**
         * 不断调整数组的大小，当堆内存的空间比较紧张（快耗尽）时，软引用所指向的对象会被回收，基于此软引用不会引起内存溢出
         */
        System.out.println("3: " + softReference.get());
    }
}

/**
 *
 引用的类型：

 1. 强引用
 在Java 中最常见的就是强引用，把一个对象赋给一个引用变量，这个引用变量就是一个强引
 用。当一个对象被强引用变量引用时，它处于可达状态，它是不可能被垃圾回收机制回收的，即
 使该对象以后永远都不会被用到JVM也不会回收。因此强引用是造成Java内存泄漏的主要原因之
 一。

 2. 软引用
 软引用需要用SoftReference类来实现，对于只有软引用的对象来说，当系统内存足够时它
 不会被回收，当系统内存空间不足时它会被回收。软引用通常用在对内存敏感的程序中。

 3. 弱引用
 弱引用需要用WeakReference类来实现，它比软引用的生存期更短，对于只有弱引用的对象
 来说，只要垃圾回收机制一运行，不管JVM的内存空间是否足够，总会回收该对象占用的内存。


 4. 虚引用
 虚引用需要PhantomReference类来实现，它不能单独使用，必须和引用队列联合使用。虚
 引用的主要作用是跟踪对象被垃圾回收的状态。

 *
 */

/*

1: Test [i=1,name=godtrue}
after GC
2: Test [i=1,name=godtrue}
3: Test [i=1,name=godtrue}

 */