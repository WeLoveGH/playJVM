package com.godtrue.jvm;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test1_1 {

    public static Test1_1 test1 = new Test1_1();

    public static int i1;

    public static int i2 = 0;

    public Test1_1(){
        i1++;
        i2++;
    }

    public static Test1_1 getInstance(){
        return test1;
    }

    public static void main(String[] args) {
        Test1_1 test1 = Test1_1.getInstance();
        System.out.println("test1.i1: "+test1.i1);
        System.out.println("test1.i2: "+test1.i2);
    }
}

/*

test1.i1: 1
test1.i2: 0

如上是 main 方法的打印结果

看结果感觉毁三观了，原因是因为“首次使用类的实例”的时候，才进行类的初始化，而类的初始化是从上到下执行对应的指令的

类的生命周期如下：
1：加载
      将二进制的.class字节码文件从磁盘加载到内存中
2：链接，这一步又分为三小步，分别是验证、准备、解析
      验证二进制.class节码文件是否正确，为其赋默认值，解析二进制.class字节码文件，将它的不同部分放入不同的JVM内存运行时区域，比如：方法区（元空间）
3：初始化
      使用类的创建实例，并且给实例的属性赋予JAVA源码中指定的值
4：使用
      使用类的实例
5：卸载
      卸载类

从 Test1 和 Test1_1 两个类的字节码可以比较清晰的看出他们的初始化方法是不一样的，这也是导致打印的内容毁三观的原因

 */

/*

// class version 49.0 (49)
// access flags 0x21
public class com/godtrue/jvm/Test1_1 {

  // compiled from: Test1_1.java

  // access flags 0x9
  public static Lcom/godtrue/jvm/Test1_1; test1

  // access flags 0x9
  public static I i1

  // access flags 0x9
  public static I i2

  // access flags 0x1
  public <init>()V
   L0
    LINENUMBER 16 L0
    ALOAD 0
    INVOKESPECIAL java/lang/Object.<init> ()V
   L1
    LINENUMBER 17 L1
    GETSTATIC com/godtrue/jvm/Test1_1.i1 : I
    ICONST_1
    IADD
    PUTSTATIC com/godtrue/jvm/Test1_1.i1 : I
   L2
    LINENUMBER 18 L2
    GETSTATIC com/godtrue/jvm/Test1_1.i2 : I
    ICONST_1
    IADD
    PUTSTATIC com/godtrue/jvm/Test1_1.i2 : I
   L3
    LINENUMBER 19 L3
    RETURN
   L4
    LOCALVARIABLE this Lcom/godtrue/jvm/Test1_1; L0 L4 0
    MAXSTACK = 2
    MAXLOCALS = 1

  // access flags 0x9
  public static getInstance()Lcom/godtrue/jvm/Test1_1;
   L0
    LINENUMBER 22 L0
    GETSTATIC com/godtrue/jvm/Test1_1.test1 : Lcom/godtrue/jvm/Test1_1;
    ARETURN
    MAXSTACK = 1
    MAXLOCALS = 0

  // access flags 0x9
  public static main([Ljava/lang/String;)V
   L0
    LINENUMBER 26 L0
    INVOKESTATIC com/godtrue/jvm/Test1_1.getInstance ()Lcom/godtrue/jvm/Test1_1;
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
    GETSTATIC com/godtrue/jvm/Test1_1.i1 : I
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
    GETSTATIC com/godtrue/jvm/Test1_1.i2 : I
    INVOKEVIRTUAL java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
    INVOKEVIRTUAL java/lang/StringBuilder.toString ()Ljava/lang/String;
    INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
   L3
    LINENUMBER 29 L3
    RETURN
   L4
    LOCALVARIABLE args [Ljava/lang/String; L0 L4 0
    LOCALVARIABLE test1 Lcom/godtrue/jvm/Test1_1; L1 L4 1
    MAXSTACK = 3
    MAXLOCALS = 2

  // access flags 0x8
  static <clinit>()V
   L0
    LINENUMBER 10 L0
    NEW com/godtrue/jvm/Test1_1
    DUP
    INVOKESPECIAL com/godtrue/jvm/Test1_1.<init> ()V
    PUTSTATIC com/godtrue/jvm/Test1_1.test1 : Lcom/godtrue/jvm/Test1_1;
   L1
    LINENUMBER 14 L1
    ICONST_0
    PUTSTATIC com/godtrue/jvm/Test1_1.i2 : I
    RETURN
    MAXSTACK = 2
    MAXLOCALS = 0
}


 */