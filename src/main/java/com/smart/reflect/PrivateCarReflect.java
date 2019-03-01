package com.smart.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: chapter4
 * @description: pcarreflect
 * @author: Jun Wang
 * @create: 2019-03-01 13:39
 */
public class PrivateCarReflect {
    public static void main(String[] args) throws Throwable{
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.smart.reflect.PrivateCar");
        PrivateCar pcar = (PrivateCar)clazz.newInstance();
        Field colorFld = clazz.getDeclaredField("color");

        colorFld.setAccessible(true);
        colorFld.set(pcar,"red");

        Method driveMtd = clazz.getDeclaredMethod("drive");
//        driveMtd.setAccessible(true);
        driveMtd.invoke(pcar);
    }
}
