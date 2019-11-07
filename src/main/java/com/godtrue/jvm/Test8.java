package com.godtrue.jvm;

/**
 * @description： 栈上分配
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test8 {

    private int i;

    private String name;

    public Test8(int i,String name){
        super();
        this.i = i;
        this.name = name;
    }

    public Test8(){
        super();
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();

        for (int i = 0; i <Integer.MAX_VALUE ; i++) {
            new Test8(i,"name"+i);
        }

        long end = System.currentTimeMillis();

        System.out.println("cost time: "+(end-begin));
    }
}

/*

cost time: 116832

通过 VisualVM 观察 Eden 区域不断的被填充和回收，详见 images/Test8.png

 */
