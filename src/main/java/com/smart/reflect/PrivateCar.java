package com.smart.reflect;

/**
 * @program: chapter4
 * @description: pcar
 * @author: Jun Wang
 * @create: 2019-03-01 13:37
 */
public class PrivateCar {
    private String color;

    protected void drive()
    {
        System.out.println("drive private car! the color is:" + color);
    }
}
