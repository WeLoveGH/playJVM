package com.godtrue.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @description： 弄出一个 OOM 玩一下，其实非常好弄，不用循环，直接弄一个大对象就行
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test13 {
    public static void main(String[] args) {
        List<Byte[]> list = new ArrayList<Byte[]>();
        for (int i = 0; i <Integer.MAX_VALUE ; i++) {
            list.add(new Byte[1 * 1024 * 1024]);
        }
    }
}

/*

Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at com.godtrue.jvm.Test13.main(Test13.java:15)

 */