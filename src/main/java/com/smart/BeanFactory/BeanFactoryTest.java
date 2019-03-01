package com.smart.BeanFactory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import com.smart.Car;
//import org.testng.annotations.*;
//import static org.testng.Assert.*;

public class BeanFactoryTest {

    public static void getBean() throws Throwable{
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res =resolver.getResource("classpath:beans.xml");
        System.out.println(res.getURL());

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);

        System.out.println("init BeanFactory");

        Car car = factory.getBean("car", Car.class);
        System.out.println("car bean is ready for use!");
        car.introduce();
    }

    public static void main(String[] args){
        try {
            getBean();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
