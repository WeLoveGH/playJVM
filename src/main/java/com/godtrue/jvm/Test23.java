package com.godtrue.jvm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @description：、
 * @author：qianyingjie1
 * @create：2019-11-07
 */
public class Test23 extends N {
    static Test23 test23;

    public static void main(String[] args) {
        M m = new M();
        m.setDaemon(true);
        m.start();

        test23 = new Test23();

        rq = new ReferenceQueue<N>();

        WeakReference<N> weakReference = new WeakReference<N>(test23,rq);

        System.out.println("1: test23 = " + test23);
        System.out.println("2: weakReference = " + weakReference.get());
        System.out.println("3: 失去强引用后 ");
        test23 = null;
        System.out.println("4: test23 = " + test23);
        System.out.println("5: weakReference = " + weakReference.get());
        System.out.println("6: 进行第一次GC");
        System.gc();
        System.out.println("7: 第一次GC后");
        System.out.println("8: test23 = " + test23);
        System.out.println("9: weakReference = " + weakReference.get());
    }
}

/**
 3. 弱引用
 弱引用需要用WeakReference类来实现，它比软引用的生存期更短，对于只有弱引用的对象
 来说，只要垃圾回收机制一运行，不管JVM的内存空间是否足够，总会回收该对象占用的内存。
 */

/*

1: test23 = com.godtrue.jvm.Test23@14ae5a5
2: weakReference = com.godtrue.jvm.Test23@14ae5a5
3: 失去强引用后
4: test23 = null
5: weakReference = com.godtrue.jvm.Test23@14ae5a5
6: 进行第一次GC
7: 第一次GC后
8: test23 = null
9: weakReference = null

 */
