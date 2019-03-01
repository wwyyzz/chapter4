package com.smart.reflect;

import com.smart.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {

    public static Car initByDefaultConst() throws Throwable {

        //1. 通过类装载器获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader:" + loader);
        System.out.println("parent loader:" + loader.getParent());
        System.out.println("grandparent loader:" + loader.getParent().getParent());

        Class clazz = loader.loadClass("com.smart.Car");

        //2. 获取类的默认构造器对象并通过它实例化Car
        Constructor cons = clazz.getDeclaredConstructor();
        Car car = (Car) cons.newInstance();

        Class clazz2 = car.getClass();
        System.out.println("class2 =" + clazz2);

        //3. 通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "hongqiCA72");

        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "black");

        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);

        return car;

    }

    public static void main(String[] args) throws Throwable{
        Car car = initByDefaultConst();
        car.introduce();
    }
}
