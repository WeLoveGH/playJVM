package com.godtrue.jvm;

import java.io.*;

/**
 * @description： 自定义类加载器
 * @author：qianyingjie1
 * @create：2019-11-07
 */
public class Test27 extends ClassLoader{
    private String name;
    private String classPath;

    private Test27(){
        super();
    }

    public Test27(String name,String classPath){
        super();
        this.name = name;
        this.classPath = classPath;
    }

    public Test27(ClassLoader parentClassLoader,String name,String classPath){
        super(parentClassLoader);
        this.name = name;
        this.classPath = classPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public Class<?> findClass(String classFullName){
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        byte[] bytes = null;

        try {
            inputStream = new FileInputStream(new File(classPath + classFullName + ".class"));
            byteArrayOutputStream = new ByteArrayOutputStream();

            int ch = 0;
            while (-1 != (ch = inputStream.read())){
                byteArrayOutputStream.write(ch);
            }

            bytes = byteArrayOutputStream.toByteArray();

            /**
             * 这里是核心，其他的都是辅助
             * 核心思路如下：
             * 1：通过 Java 字节码文件的路径，获取对应的二进制字节码信息
             * 2：通过调用 ClassLoader 类的 defineClass 方法获取对应类的字节码文件的类对象，注意：是类对象就是 Class 的对象
             */
            return defineClass(classFullName,bytes,0,bytes.length);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(byteArrayOutputStream != null){
                try {
                    byteArrayOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            if(inputStream != null){
                try {
                    inputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    public String toString(){
        return "the define class loader's name is : " + name;
    }

    public static void main(String[] args) throws Exception {
        String classPath1 = "D:\\workspace_test\\playJVM\\src\\main\\java\\com\\godtrue\\jvm\\classFiles\\Test1.class";

        String classPath2 = "com/godtrue/jvm/classFiles/Test1.class";

        Test27 test27_1 = new Test27("loader1",classPath1);
        Test27 test27_2 = new Test27("loader2",classPath2);

        Class<Test1> test1Class = (Class<Test1>) test27_1.loadClass("com.godtrue.jvm.Test1");
        Test1 test1 = test1Class.newInstance();
        System.out.println(test1 + "  " + test1.getClass().getClassLoader());

        Class<Test1> test1Class1 = (Class<Test1>) test27_2.loadClass("com.godtrue.jvm.Test1");
        Test1 test11 = test1Class1.newInstance();
        System.out.println(test11 + "  " + test11.getClass().getClassLoader());
    }
}

/*

com.godtrue.jvm.Test1@14ae5a5  sun.misc.Launcher$AppClassLoader@18b4aac2
com.godtrue.jvm.Test1@7f31245a  sun.misc.Launcher$AppClassLoader@18b4aac2

如上日志，我们可以看到

1：类的加载机制，遵循双亲委派的机制，这里虽然使用的是自定义的类加载器，不过真正启动到类加载功能的还是应用类加载器
2：自定义类加载器，是利用了 ClassLoader 的功能才实现类的加载的

 */