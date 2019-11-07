package com.godtrue.jvm;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test14 {

    private static Test14 test14;

    public static void main(String[] args) throws InterruptedException{
        test14 = new Test14();
        System.out.println("1: " + (test14 == null));
        test14 = null;

        System.out.println("2: " + (test14 == null));
        /**
         * GC 时，会调用 finalize() 方法
         */
        System.gc();
        Thread.sleep(1);

        System.out.println("3: " + (test14 == null));
        test14 = null;
        /**
         * 第二次进行 GC ，不会调用 finalize() 方法，因为 finalize() 方法只会被调用一次
         */
        System.gc();
        Thread.sleep(100);

        System.out.println("4: " + (test14 == null));
    }

    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("GC时 会调用 finalize() 方法");
        //对象的“复活”
        test14 = this;
    }
}

/*

1: false
2: true
GC 会调用 finalize() 方法
3: false
4: true

 */