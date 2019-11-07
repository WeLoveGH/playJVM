package com.godtrue.jvm;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test1 {

    public static int i1;

    public static int i2 = 0;

    public static Test1 test1 = new Test1();

    public Test1(){
        i1++;
        i2++;
    }

    public static Test1 getInstance(){
        return test1;
    }

    public static void main(String[] args) {
        Test1 test1 = Test1.getInstance();
        System.out.println("test1.i1: "+test1.i1);
        System.out.println("test1.i2: "+test1.i2);
    }
}

/*

test1.i1: 1
test1.i2: 1

如上是 main 方法的打印结果

看着结果还比较正常，不过和他对比的示例就毁三观了

 */

/*

// class version 49.0 (49)
// access flags 0x21
public class com/godtrue/jvm/Test1 {

  // compiled from: Test1.java

  // access flags 0x9
  public static I i1

  // access flags 0x9
  public static I i2

  // access flags 0x9
  public static Lcom/godtrue/jvm/Test1; test1

  // access flags 0x1
  public <init>()V
   L0
    LINENUMBER 16 L0
    ALOAD 0
    INVOKESPECIAL java/lang/Object.<init> ()V
   L1
    LINENUMBER 17 L1
    GETSTATIC com/godtrue/jvm/Test1.i1 : I
    ICONST_1
    IADD
    PUTSTATIC com/godtrue/jvm/Test1.i1 : I
   L2
    LINENUMBER 18 L2
    GETSTATIC com/godtrue/jvm/Test1.i2 : I
    ICONST_1
    IADD
    PUTSTATIC com/godtrue/jvm/Test1.i2 : I
   L3
    LINENUMBER 19 L3
    RETURN
   L4
    LOCALVARIABLE this Lcom/godtrue/jvm/Test1; L0 L4 0
    MAXSTACK = 2
    MAXLOCALS = 1

  // access flags 0x9
  public static getInstance()Lcom/godtrue/jvm/Test1;
   L0
    LINENUMBER 22 L0
    GETSTATIC com/godtrue/jvm/Test1.test1 : Lcom/godtrue/jvm/Test1;
    ARETURN
    MAXSTACK = 1
    MAXLOCALS = 0

  // access flags 0x9
  public static main([Ljava/lang/String;)V
   L0
    LINENUMBER 26 L0
    INVOKESTATIC com/godtrue/jvm/Test1.getInstance ()Lcom/godtrue/jvm/Test1;
    ASTORE 1
   L1
    LINENUMBER 27 L1
    GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
    NEW java/lang/StringBuilder
    DUP
    INVOKESPECIAL java/lang/StringBuilder.<init> ()V
    LDC "test1.i1: "
    INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
    ALOAD 1
    POP
    GETSTATIC com/godtrue/jvm/Test1.i1 : I
    INVOKEVIRTUAL java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
    INVOKEVIRTUAL java/lang/StringBuilder.toString ()Ljava/lang/String;
    INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
   L2
    LINENUMBER 28 L2
    GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
    NEW java/lang/StringBuilder
    DUP
    INVOKESPECIAL java/lang/StringBuilder.<init> ()V
    LDC "test1.i2: "
    INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
    ALOAD 1
    POP
    GETSTATIC com/godtrue/jvm/Test1.i2 : I
    INVOKEVIRTUAL java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
    INVOKEVIRTUAL java/lang/StringBuilder.toString ()Ljava/lang/String;
    INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
   L3
    LINENUMBER 29 L3
    RETURN
   L4
    LOCALVARIABLE args [Ljava/lang/String; L0 L4 0
    LOCALVARIABLE test1 Lcom/godtrue/jvm/Test1; L1 L4 1
    MAXSTACK = 3
    MAXLOCALS = 2

  // access flags 0x8
  static <clinit>()V
   L0
    LINENUMBER 12 L0
    ICONST_0
    PUTSTATIC com/godtrue/jvm/Test1.i2 : I
   L1
    LINENUMBER 14 L1
    NEW com/godtrue/jvm/Test1
    DUP
    INVOKESPECIAL com/godtrue/jvm/Test1.<init> ()V
    PUTSTATIC com/godtrue/jvm/Test1.test1 : Lcom/godtrue/jvm/Test1;
    RETURN
    MAXSTACK = 2
    MAXLOCALS = 0
}


 */