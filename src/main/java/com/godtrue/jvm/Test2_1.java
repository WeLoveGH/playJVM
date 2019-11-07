package com.godtrue.jvm;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test2_1 {

    private static int count;

    public static void deadLoop(){
        count++;
        deadLoop();
    }

    public static void main(String[] args) {
        try {
            deadLoop();
        }catch (Exception e){
            System.out.println("count: "+count);
            e.printStackTrace();
        }
    }
}


/*

Exception in thread "main" java.lang.StackOverflowError
	at com.godtrue.jvm.Test2_1.deadLoop(Test2_1.java:14)

如上是JVM方法栈溢出时的部分日志信息，这是常用的制造JVM方法栈溢出的方法，无限递归调用，注意：这种异常 Exception 是否捕获不了的

 */