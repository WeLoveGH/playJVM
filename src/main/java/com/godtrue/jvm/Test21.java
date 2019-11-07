package com.godtrue.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * @description： 虚引用
 * @author：qianyingjie1
 * @create：2019-11-07
 */
public class Test21 extends N{
    static Test21 test21 = null;

    public static void main(String[] args) throws InterruptedException{
        /**
         * 启动一个幽灵线程
         */
        M m = new M();
        m.setDaemon(true);
        m.start();

        test21 = new Test21();

        rq = new ReferenceQueue<N>();

        PhantomReference<N> phantomReference = new PhantomReference<N>(test21,rq);

        test21 = null;

        System.out.println("第一次GC");

        System.gc();

        Thread.sleep(10);

        test21 = null;

        System.out.println("第二次GC");

        System.gc();

        Thread.sleep(10);
    }

    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("当GC的时候，调用finalize()");
        test21 = this;
    }
}

class M extends Thread{
    public void run(){
        if(N.rq != null){
            try {
                Reference<? extends N> reference = N.rq.remove();
                if(reference != null){
                    System.out.println("被回收的对象已经被加入到引用队里之中，说明GC清理了本对象 "+reference);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class N {
    public static ReferenceQueue<N> rq;
}

/**

 4. 虚引用
 虚引用需要PhantomReference类来实现，它不能单独使用，必须和引用队列联合使用。
 虚引用的主要作用是，跟踪对象被垃圾回收的状态。
 虚引用是所有引用里面最弱的一个，跟没有引用几乎一样

 */

/*

第一次GC
当GC的时候，调用finalize()
第二次GC
被回收的对象已经被加入到引用队里之中，说明GC清理了本对象

第二次GC没有调用finalize()方法说明对应的对应的已经被清除

 */