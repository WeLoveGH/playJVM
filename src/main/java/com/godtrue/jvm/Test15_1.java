package com.godtrue.jvm;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test15_1 {

    private static Test15_1 test15 = null;

    public static void main(String[] args) throws InterruptedException{

        System.out.println("please use -XX:+PrintGC\n");


        System.out.println("1: " + (test15 == null));

        test15 = new Test15_1();

        System.out.println("2: " + (test15 == null));

        test15 = null;

        System.out.println("3: " + (test15 == null));

        System.gc();

        Thread.sleep(100);

        System.out.println("4: " + (test15 == null));
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
        test15 = new Test15_1();
    }
}

/*

please use -XX:+PrintGC

1: true
2: false
3: true
[GC (System.gc())  3891K->800K(184832K), 0.0227780 secs]
[Full GC (System.gc())  800K->735K(184832K), 0.0243488 secs]
GC 时，会调用 finalize() —— 这里可以看到当 GC 的时候，确实调用了 finalize() 方法，这里需要注意这个 finalize() 方法所属的类是 Test15_1.java
4: false

 */