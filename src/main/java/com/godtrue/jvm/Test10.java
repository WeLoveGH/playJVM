package com.godtrue.jvm;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @description： 测试方法区
 * @author：qianyingjie1
 * @create：2019-11-06
 */
public class Test10 {
    public static void main(String[] args) {
        int count = 0;
        try {
            for (int i = 0; i <Integer.MAX_VALUE; i++) {

                HashMap<String,Object> propertyMap = new HashMap<String, Object>();

                propertyMap.put("i1",Class.forName("java.lang.Integer"));
                propertyMap.put("l1",Class.forName("java.lang.Long"));
                propertyMap.put("s1",Class.forName("java.lang.String"));
                propertyMap.put("b1",Class.forName("java.lang.Byte"));
                propertyMap.put("c1",Class.forName("java.lang.Character"));
                propertyMap.put("bo1",Class.forName("java.lang.Boolean"));

                System.out.println("i "+ i +" create bean " + new CglibBean(propertyMap));
            }
        }catch (Exception e){
            System.out.println("总共创建："+count);
            e.printStackTrace();
        }
    }
}

class CglibBean{
    public Object object = null;

    public BeanMap beanMap = null;

    public CglibBean(){
        super();
    }

    public CglibBean(Map propertyMap){
        this.object = generateBean(propertyMap);
        this.beanMap = BeanMap.create(this.object);
    }

    public void setValue(String property,Object value){
        beanMap.put(property,value);
    }

    public Object getValue(String property){
        return beanMap.get(property);
    }

    private Object generateBean(Map propertyMap){

        BeanGenerator generator = new BeanGenerator();

        Set keySet = propertyMap.keySet();
        for(Iterator i = keySet.iterator();i.hasNext();){
            String key = (String)i.next();
            generator.addProperty(key,(Class)propertyMap.get(key));
        }
        return generator.create();
    }
}

/*

类信息在加载进JVM后都会放入方法区，利用CGLib，不断的动态生产.class字节码文件，放入方法区

通过观察 VisualVM 可以看到 Metaspace 的使用量在不断的增长

 */