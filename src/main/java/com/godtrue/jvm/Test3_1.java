package com.godtrue.jvm;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test3_1 {
    private static int count;

    public static void deadLoop(){
        count++;

        deadLoop();
    }

    public static void main(String[] args) {
        try {
            deadLoop();
        }catch (Throwable t){
            System.out.println(" stack deep : "+ count);
            t.printStackTrace();
        }
    }
}

/*

 stack deep : 23487
java.lang.StackOverflowError
	at com.godtrue.jvm.Test3_1.deadLoop(Test3_1.java:14)

 */