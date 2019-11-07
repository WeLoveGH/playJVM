package com.godtrue.jvm;

import java.lang.ref.WeakReference;

/**
 * @description： 弱引用
 * @author：qianyingjie1
 * @create：2019-11-07
 */
public class Test20 {
    public static void main(String[] args) {
        L l = new L();

        WeakReference weakReference = new WeakReference(l);

        l = null;

        System.out.println("1: " + weakReference.get());

        System.gc();

        System.out.println("2: after Gc");

        System.out.println("3: " + weakReference.get());
    }
}

class L {
    private int i;
    private String name;

    public L(int i,String name){
        super();
        this.i = i;
        this.name = name;
    }

    public L(){
        super();
    }
}
/**

 3. 弱引用
 弱引用需要用WeakReference类来实现，它比软引用的生存期更短，对于只有弱引用的对象
 来说，只要垃圾回收机制一运行，不管JVM的内存空间是否足够，总会回收该对象占用的内存。

 */

/*

1: com.godtrue.jvm.L@14ae5a5
2: after Gc
3: null

 */