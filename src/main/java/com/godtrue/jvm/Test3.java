package com.godtrue.jvm;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test3 {
    private static int count;

    public static void deadLoop(byte b1,short s1,int i1,char c1,long l1,float f1,double d1,boolean bo1){
        byte b2 = 1;
        short s2 = 1;
        int i2 = 1;
        char c2 = 'a';
        long l2 = 1;
        float f2 = 1f;
        double d2 = 1d;
        boolean bo2 = true;

        count++;

        deadLoop(b1,s1,i1,c1,l1,f1,d1,bo1);
    }

    public static void main(String[] args) {
        try {
            deadLoop((byte)1,(short)1,1,'a',1,1f,1d,true);
        }catch (Throwable t){
            System.out.println(" stack deep : "+ count);
            t.printStackTrace();
        }
    }
}

/*

 stack deep : 4187
java.lang.StackOverflowError
	at com.godtrue.jvm.Test3.deadLoop(Test3.java:12)


从打印的栈深度可以看到：

在Java栈大小相同的情况下，方法的参数或者局部变量越多，嵌套调用的栈深度就会越浅，
因为JVM方法栈是由栈帧组成，而栈帧是由方法内的局部变量、方法入口地址、方法出口地址等组成的

在方法调用是，会有一个栈帧被压入JVM方法栈中，而方法的参数和局部变量会被保存在栈帧的局部变量表中，
当参数或局部变量增加时，局部变量表就会变大，在JVM栈大小不变的情况下，可嵌套调用的层级（栈深度）就会变小

 */
