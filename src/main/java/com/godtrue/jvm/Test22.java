package com.godtrue.jvm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-07
 */
public class Test22 extends N {
    static Test22 test22;

    public static void main(String[] args) {
        /**
         * 构建并启动幽灵线程
         */
        M m = new M();
        m.setDaemon(true);
        m.start();

        test22 = new Test22();

        rq = new ReferenceQueue<N>();

        SoftReference<N> softReference = new SoftReference<N>(test22,rq);

        System.out.println("1: gc前 ");
        System.out.println("2: 强引用 " + test22);
        System.out.println("3: 软引用 " + softReference.get());

        test22 = null;

        System.out.println("4: 对象失去强引用 ");
        System.out.println("5: 强引用 " + test22);
        System.out.println("6: 软引用 " + softReference.get());

        System.out.println("7: 第一次GC前");
        System.gc();
        System.out.println("8: 第一次GC后");
        System.out.println("9: 强引用 " + test22);
        System.out.println("10: 软引用 " + softReference.get());

        System.out.println("11：认为制造堆内存紧张，这个需要试验，才能找对点");
        byte[] bytes = new byte[6 * 1024 * 1024];

        System.out.println("12: 第二次GC开始");
        System.gc();
        System.out.println("13: 当堆内存紧张时，会引起软引用的回收（运行时请使用参数：-Xmx10m）");
        System.out.println("14: 第二次GC后");
        System.out.println("15: 强引用 " + test22);
        System.out.println("16: 软引用 " + softReference.get());
    }
}

/*

1: gc前
2: 强引用 com.godtrue.jvm.Test22@14ae5a5
3: 软引用 com.godtrue.jvm.Test22@14ae5a5
4: 对象失去强引用
5: 强引用 null
6: 软引用 com.godtrue.jvm.Test22@14ae5a5
7: 第一次GC前
8: 第一次GC后
9: 强引用 null
10: 软引用 com.godtrue.jvm.Test22@14ae5a5
11：认为制造堆内存紧张
12: 第二次GC开始
13: 当堆内存紧张时，会引起软引用的回收（运行时请使用参数：-Xmx10m）
14: 第二次GC后
15: 强引用 null
16: 软引用 com.godtrue.jvm.Test22@14ae5a5

 */