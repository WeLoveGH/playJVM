package com.godtrue.jvm;

/**
 * @description： 局部变量表的槽位测试
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test4 {

    /**
     * 对于实例方法，局部变量表的第一个位置保存的是this指针，占用一个内存单元（字）
     * b无法复用a的在槽位，因为a、b在同一作用域
     */
    public void f1(){
        int a = 1;
        int b = 2;
    }

    /**
     * b复用了a的槽位，因为a已结束其生命周期，即b的位置在a的作用域以外
     */
    public void f2(){
        {
            int a = 1;
        }
        int b = 2;
    }

    public static void f3(){
        int a = 1;
        int b = 2;
    }

    /**
     * long和double类型占两个内存单元，其它的都占用1个字节包括对象引用
     */
    public static void f4(){
        int a = 1;
        long b = 2;
    }

    public static void f5(){
        int a = 1;
        double b = 2;
    }

    public static void f6(){
        int a = 1;
        Test4 test = new Test4();
    }

    /**
     * 对象的引用b复用了基本变量a的槽位
     */
    public static void f7(){
        {
            int a = 1;
        }
        Test4 b = new Test4();
    }

    public static void main(String[] args) {
        System.out.println("i am mian");
    }
}

/*

// class version 49.0 (49)
// access flags 0x21
public class com/godtrue/jvm/Test4 {

  // compiled from: Test4.java

  // access flags 0x1
  public <init>()V
   L0
    LINENUMBER 8 L0
    ALOAD 0
    INVOKESPECIAL java/lang/Object.<init> ()V
    RETURN
   L1
    LOCALVARIABLE this Lcom/godtrue/jvm/Test4; L0 L1 0
    MAXSTACK = 1
    MAXLOCALS = 1

  // access flags 0x1
  public f1()V
   L0
    LINENUMBER 15 L0
    ICONST_1
    ISTORE 1
   L1
    LINENUMBER 16 L1
    ICONST_2
    ISTORE 2
   L2
    LINENUMBER 17 L2
    RETURN
   L3
    LOCALVARIABLE this Lcom/godtrue/jvm/Test4; L0 L3 0
    LOCALVARIABLE a I L1 L3 1
    LOCALVARIABLE b I L2 L3 2
    MAXSTACK = 1
    MAXLOCALS = 3

  // access flags 0x1
  public f2()V
   L0
    LINENUMBER 24 L0
    ICONST_1
    ISTORE 1
   L1
    LINENUMBER 26 L1
    ICONST_2
    ISTORE 1
   L2
    LINENUMBER 27 L2
    RETURN
   L3
    LOCALVARIABLE this Lcom/godtrue/jvm/Test4; L0 L3 0
    LOCALVARIABLE b I L2 L3 1
    MAXSTACK = 1
    MAXLOCALS = 2

  // access flags 0x9
  public static f3()V
   L0
    LINENUMBER 30 L0
    ICONST_1
    ISTORE 0
   L1
    LINENUMBER 31 L1
    ICONST_2
    ISTORE 1
   L2
    LINENUMBER 32 L2
    RETURN
   L3
    LOCALVARIABLE a I L1 L3 0
    LOCALVARIABLE b I L2 L3 1
    MAXSTACK = 1
    MAXLOCALS = 2

  // access flags 0x9
  public static f4()V
   L0
    LINENUMBER 38 L0
    ICONST_1
    ISTORE 0
   L1
    LINENUMBER 39 L1
    LDC 2
    LSTORE 1
   L2
    LINENUMBER 40 L2
    RETURN
   L3
    LOCALVARIABLE a I L1 L3 0
    LOCALVARIABLE b J L2 L3 1
    MAXSTACK = 2
    MAXLOCALS = 3

  // access flags 0x9
  public static f5()V
   L0
    LINENUMBER 43 L0
    ICONST_1
    ISTORE 0
   L1
    LINENUMBER 44 L1
    LDC 2.0
    DSTORE 1
   L2
    LINENUMBER 45 L2
    RETURN
   L3
    LOCALVARIABLE a I L1 L3 0
    LOCALVARIABLE b D L2 L3 1
    MAXSTACK = 2
    MAXLOCALS = 3

  // access flags 0x9
  public static f6()V
   L0
    LINENUMBER 48 L0
    ICONST_1
    ISTORE 0
   L1
    LINENUMBER 49 L1
    NEW com/godtrue/jvm/Test4
    DUP
    INVOKESPECIAL com/godtrue/jvm/Test4.<init> ()V
    ASTORE 1
   L2
    LINENUMBER 50 L2
    RETURN
   L3
    LOCALVARIABLE a I L1 L3 0
    LOCALVARIABLE test Lcom/godtrue/jvm/Test4; L2 L3 1
    MAXSTACK = 2
    MAXLOCALS = 2

  // access flags 0x9
  public static f7()V
   L0
    LINENUMBER 57 L0
    ICONST_1
    ISTORE 0
   L1
    LINENUMBER 59 L1
    NEW com/godtrue/jvm/Test4
    DUP
    INVOKESPECIAL com/godtrue/jvm/Test4.<init> ()V
    ASTORE 0
   L2
    LINENUMBER 60 L2
    RETURN
   L3
    LOCALVARIABLE b Lcom/godtrue/jvm/Test4; L2 L3 0
    MAXSTACK = 2
    MAXLOCALS = 1

  // access flags 0x9
  public static main([Ljava/lang/String;)V
   L0
    LINENUMBER 63 L0
    GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
    LDC "i am mian"
    INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
   L1
    LINENUMBER 64 L1
    RETURN
   L2
    LOCALVARIABLE args [Ljava/lang/String; L0 L2 0
    MAXSTACK = 2
    MAXLOCALS = 1
}


 */