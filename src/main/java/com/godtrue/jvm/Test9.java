package com.godtrue.jvm;

/**
 * @description： 测试大对象
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test9 {
    private static final byte[] bytes = new byte[1 * 1024 * 1024 * 1024];
    public static void main(String[] args) {
        for (int i = 0; i <Integer.MAX_VALUE ; i++) {
            System.out.println("bytes: "+ bytes);
        }
    }
}

/*

private static final byte[] bytes = new byte[2 * 1024 * 1024 * 1024];

java.lang.ExceptionInInitializerError
Caused by: java.lang.NegativeArraySizeException
	at com.godtrue.jvm.Test9.<clinit>(Test9.java:9)
Exception in thread "main"

通过 VisualVM 观察 Eden 区域不断的被填充和回收，大对象会被直接放入老年代，详见 images/Test9.png


 */