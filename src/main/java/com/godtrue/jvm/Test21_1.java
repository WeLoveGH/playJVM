package com.godtrue.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-07
 */
public class Test21_1 extends N_1{
    static Test21_1 test21 = null;

    public static void main(String[] args) throws InterruptedException{
        /**
         * 启动一个幽灵线程
         */
        M_1 m = new M_1();
        m.setDaemon(true);
        m.start();

        test21 = new Test21_1();

        rq = new ReferenceQueue<N_1>();

        PhantomReference<N_1> phantomReference = new PhantomReference<N_1>(test21,rq);

        test21 = null;

        System.out.println("第一次GC");

        System.gc();

        Thread.sleep(10);

        test21 = new Test21_1();

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

class M_1 extends Thread{
    public void run(){
        if(N_1.rq != null){
            try {
                Reference<? extends N_1> reference = N_1.rq.remove();
                if(reference != null){
                    System.out.println("被回收的对象已经被加入到引用队里之中，说明GC清理了本对象 "+reference);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class N_1 {
    public static ReferenceQueue<N_1> rq;
}

/*

第一次GC
当GC的时候，调用finalize()
第二次GC
当GC的时候，调用finalize()
被回收的对象已经被加入到引用队里之中，说明GC清理了本对象 java.lang.ref.PhantomReference@720b76e8

从日志中可以产出
1：当GC的时候，finalize()被调用几次，取决于回收的对应有几个

 */