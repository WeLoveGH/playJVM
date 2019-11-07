package com.godtrue.jvm;

import java.lang.ref.SoftReference;

/**
 * @description： 软引用
 * @author：qianyingjie1
 * @create：2019-11-07
 */
public class Test19_1 {

    private int i;

    private String name;

    public Test19_1(int i, String name){
        super();
        this.i = i;
        this.name = name;
    }

    public Test19_1(){
        super();
    }

    public String toString(){
        return "Test [i="+i+",name="+name+"}";
    }

    public static void main(String[] args) {

        System.out.println("please use -Xms2000m -Xmx2000m -XX:+PrintGC");

        /**
         * test19 是强引用
         */
        Byte[] bytes = new Byte[100 * 1024 * 1024];

        /**
         * softReference 是软引用
         */
        SoftReference<Byte[]> softReference = new SoftReference<Byte[]>(bytes);

        bytes = null;

        System.out.println("1: "+softReference.get());

        System.gc();

        System.out.println("after GC");

        System.out.println("2: "+ softReference.get());

        /**
         * 强引用坚决不回收，哪怕引起了内存溢出，导致JVM不能运行
         */
        byte[] bytes2 = new byte[1300 * 1024 * 1024];

        System.gc();

        /**
         * 不断调整数组的大小，当堆内存的空间比较紧张（快耗尽）时，软引用所指向的对象会被回收，基于此软引用不会引起内存溢出
         */
        System.out.println("3: " + softReference.get());
    }
}

/**

 2. 软引用
 软引用需要用SoftReference类来实现，对于只有软引用的对象来说，当系统内存足够时它
 不会被回收，当系统内存空间不足时它会被回收。软引用通常用在对内存敏感的程序中。

 */

/*

1: [Ljava.lang.Byte;@14ae5a5
[GC (System.gc())  430100K->410448K(1963008K), 0.5948351 secs]
[Full GC (System.gc())  410448K->410335K(1963008K), 0.3963827 secs]
after GC
2: [Ljava.lang.Byte;@14ae5a5
[GC (Allocation Failure)  420341K->410367K(1963008K), 0.0040567 secs]
[GC (Allocation Failure)  410367K->410367K(1963008K), 0.0039169 secs]
[Full GC (Allocation Failure)  410367K->410330K(1963008K), 0.3184867 secs]
[GC (Allocation Failure)  410330K->410330K(1963008K), 0.0040182 secs]
[Full GC (Allocation Failure)  410330K->712K(1963008K), 0.0226515 secs]
[GC (System.gc())  1342162K->1331912K(1963008K), 0.0046114 secs]
[Full GC (System.gc())  1331912K->1331912K(1963008K), 0.3418532 secs]
3: null ——注意，这里软引用，在堆内存空间紧张的时候，确实被回收了


 */