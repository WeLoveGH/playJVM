package com.godtrue.jvm;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test15 {
    private String s;

    public static void main(String[] args) throws InterruptedException{

        System.out.println("please use -XX:+PrintGC\n");

        Test15 test15 = new Test15();

        System.out.println("1: " + (test15.s == null));

        test15.s = new String("111");

        System.out.println("2: " + (test15.s == null));

        test15.s = null;

        System.out.println("3: " + (test15.s == null));

        System.gc();

        Thread.sleep(100);

        System.out.println("4: " + (test15.s == null));
    }

    /**
     * Called by the garbage collector on an object when garbage collection
     * determines that there are no more references to the object.
     * A subclass overrides the {@code finalize} method to dispose of
     * system resources or to perform other cleanup.
     * <p>
     * The general contract of {@code finalize} is that it is invoked
     * if and when the Java&trade; virtual
     * machine has determined that there is no longer any
     * means by which this object can be accessed by any thread that has
     * not yet died, except as a result of an action taken by the
     * finalization of some other object or class which is ready to be
     * finalized. The {@code finalize} method may take any action, including
     * making this object available again to other threads; the usual purpose
     * of {@code finalize}, however, is to perform cleanup actions before
     * the object is irrevocably discarded. For example, the finalize method
     * for an object that represents an input/output connection might perform
     * explicit I/O transactions to break the connection before the object is
     * permanently discarded.
     * <p>
     * The {@code finalize} method of class {@code Object} performs no
     * special action; it simply returns normally. Subclasses of
     * {@code Object} may override this definition.
     * <p>
     * The Java programming language does not guarantee which thread will
     * invoke the {@code finalize} method for any given object. It is
     * guaranteed, however, that the thread that invokes finalize will not
     * be holding any user-visible synchronization locks when finalize is
     * invoked. If an uncaught exception is thrown by the finalize method,
     * the exception is ignored and finalization of that object terminates.
     * <p>
     * After the {@code finalize} method has been invoked for an object, no
     * further action is taken until the Java virtual machine has again
     * determined that there is no longer any means by which this object can
     * be accessed by any thread that has not yet died, including possible
     * actions by other objects or classes which are ready to be finalized,
     * at which point the object may be discarded.
     * <p>
     * The {@code finalize} method is never invoked more than once by a Java
     * virtual machine for any given object.
     * <p>
     * Any exception thrown by the {@code finalize} method causes
     * the finalization of this object to be halted, but is otherwise
     * ignored.
     *
     * @throws Throwable the {@code Exception} raised by this method
     * @see java.lang.ref.WeakReference
     * @see java.lang.ref.PhantomReference
     * @jls 12.6 Finalization of Class Instances
     */

    protected void finalize() throws Throwable{
        super.finalize();

        System.out.println("GC 时，会调用 finalize()");

        /**
         * 对象的“复活”
         */
        s = new String("123");
    }
}

/*

1: true
2: false
3: true
4: true —— 这里打印 true，是不是毁三观，并且 GC 的时候并没有调用 finalize() 方法，这也是这里为 true 的原因

如下是添加了打印 GC 信息的日志，从日志信息中我们可以看到，GC 确实发生了，只是没有调用 finalize() 方法，因为这个方法是定义在 Test15.java这个类中的

1: true
2: false
3: true
[GC (System.gc())  2918K->840K(184832K), 0.0293908 secs]
[Full GC (System.gc())  840K->735K(184832K), 0.0764959 secs]
4: true

 */