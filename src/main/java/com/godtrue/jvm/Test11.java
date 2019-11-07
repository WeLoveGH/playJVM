package com.godtrue.jvm;

/**
 * @description： 测试堆内存的分配情况
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test11 {
    public static void main(String[] args) {
        System.out.println("max memory = " + Runtime.getRuntime().maxMemory()/1024/1024 + "M");
        System.out.println("free memory = " + Runtime.getRuntime().freeMemory()/1024/1024 + "M ，注意，这里的变化");
        System.out.println("total memory = " + Runtime.getRuntime().totalMemory()/1024/1024 + "M");

        byte[] bytes = new byte[10 * 1024 * 1024];
        System.out.println("分配 10M 空间");
        System.out.println("max memory = " + Runtime.getRuntime().maxMemory()/1024/1024 + "M");
        System.out.println("free memory = " + Runtime.getRuntime().freeMemory()/1024/1024 + "M ，注意，这里的变化");
        System.out.println("total memory = " + Runtime.getRuntime().totalMemory()/1024/1024 + "M");


        bytes = new byte[100 * 1024 * 1024];
        System.out.println("分配 100M 空间");
        System.out.println("max memory = " + Runtime.getRuntime().maxMemory()/1024/1024 + "M");
        System.out.println("free memory = " + Runtime.getRuntime().freeMemory()/1024/1024 + "M ，注意，这里的变化");
        System.out.println("total memory = " + Runtime.getRuntime().totalMemory()/1024/1024 + "M");

    }
}
