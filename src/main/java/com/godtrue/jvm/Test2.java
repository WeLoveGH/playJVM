package com.godtrue.jvm;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test2 {

    private static int count;

    public static void deadLoop(){
        count++;
        deadLoop();
    }

    public static void main(String[] args) {
        try {
            deadLoop();
        }catch (Throwable t){
            System.out.println("count: "+count);
            t.printStackTrace();
        }
    }
}


/*

count: 22183
java.lang.StackOverflowError
	at com.godtrue.jvm.Test2.deadLoop(Test2.java:14)

如上是JVM方法栈溢出时的部分日志信息，这是常用的制造JVM方法栈溢出的方法，无限递归调用，注意：这种异常 Throwable 可以捕获

 */