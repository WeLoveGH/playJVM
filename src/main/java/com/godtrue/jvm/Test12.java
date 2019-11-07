package com.godtrue.jvm;

/**
 * @description： 新生代堆空间的使用
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test12 {
    public static void main(String[] args) {
        byte[] bytes = null;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            bytes = new byte[100 * 1024 * 1024];
        }
    }
}

/*

通过 VisualVM 观察一下，现象非常明显，Eden区的空间不断填充和释放

 */