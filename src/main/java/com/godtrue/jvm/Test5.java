package com.godtrue.jvm;

/**
 * @description： 被局部变量表引用的对象不会被垃圾回收
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test5 {

    /**
     * 堆中的数组对象有一个强引用来指向它，所以不会被回收
     */
    public void f1(){
        byte[] bytes = new byte[6 * 1024 * 1024];
        System.gc();
    }

    /**
     * 当数组失去引用，数组对象会被垃圾回收
     */
    public void f2(){
        byte[] bytes = new byte[6 * 1024 * 1024];
        bytes = null;
        System.gc();
    }

    /**
     * 虽然在垃圾回收的时候已经超出了 bytes 的作用域，但是 bytes 仍然在局部变量表中并指向了一个数组对象，所以数组对象不会被回收
     */
    public void f3(){
        {
            byte[] bytes = new byte[6 * 1024 * 1024];
        }
        System.gc();
    }

    /**
     * 变量 i 复用了 bytes 的槽位，所以 bytes 在局部变量表中被销毁，数组失去了引用，固被回收
     */
    public void f4(){
        {
            byte[] bytes = new byte[6 * 1024 * 1023];
        }
        int i = 1;
        System.gc();
    }

    /**
     * 在 f1() 方法中，虽然数组对象没有被销毁，但是随着 f1() 方法的调用结束，他所对应的栈桢已经在Java栈中弹出，该栈的局部变量表已不存在，所以数组对象会被回收
     */
    public void f5(){
        f1();
        System.gc();
    }

    public static void main(String[] args) {
        System.out.println("please use -XX:+PrintGC\n");
        /*

[GC (System.gc())  9062K->7008K(184832K), 0.0176809 secs]
[Full GC (System.gc())  7008K->6875K(184832K), 0.0188783 secs]

         */
        //new Test5().f1();

        /*

[GC (System.gc())  9062K->792K(184832K), 0.0032664 secs]
[Full GC (System.gc())  792K->731K(184832K), 0.0137725 secs]

         */
        //new Test5().f2();

        /*

[GC (System.gc())  9062K->6936K(184832K), 0.0091248 secs]
[Full GC (System.gc())  6936K->6875K(184832K), 0.0079419 secs]

         */

        //new Test5().f3();

        /*

[GC (System.gc())  9056K->792K(184832K), 0.0141921 secs]
[Full GC (System.gc())  792K->731K(184832K), 0.0201082 secs]

         */
        //new Test5().f4();

        /*

[GC (System.gc())  9062K->6968K(184832K), 0.0099446 secs]
[Full GC (System.gc())  6968K->6875K(184832K), 0.0234409 secs]
[GC (System.gc())  6875K->6875K(184832K), 0.0005641 secs]
[Full GC (System.gc())  6875K->731K(184832K), 0.0070332 secs]

         */
        new Test5().f5();
    }
}
